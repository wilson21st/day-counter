package com.wilson.daycounter;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.wilson.daycounter.date.MyDate;

import lombok.SneakyThrows;

public class App {

	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static final int REPEAT = 500000;

	public static void main(String[] args) {

		if (args.length != 2) {
			System.out.println("Must have 2 arguments!");
			return;
		}

		try {
			// Use LocalDate to validate the inputs
			LocalDate localDate1 = LocalDate.parse(args[0], DATE_FORMATTER);
			LocalDate localDate2 = LocalDate.parse(args[1], DATE_FORMATTER);

			// Construct my dates
			MyDate myDate1 = new MyDate(localDate1.getYear(), localDate1.getMonthValue(), localDate1.getDayOfMonth());
			MyDate myDate2 = new MyDate(localDate2.getYear(), localDate2.getMonthValue(), localDate2.getDayOfMonth());

			// Solution1:
			RepeatAndPrint("Solution1", new SimpleCounter(myDate1, myDate2));

			// Solution2:
			RepeatAndPrint("Solution2", new RecallableCounter(myDate1, myDate2));

			// Solution3:
			RepeatAndPrint("Solution3", new InstantCounter(myDate1, myDate2));

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			System.out.println("Both dates must be in 'dd/MM/yyyy' format.");
		}
	}

	@SneakyThrows
	private static void RepeatAndPrint(String name, Object counter) {
		int days = -1;
		Method method = counter.getClass().getDeclaredMethod("getDiffInDays");
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < REPEAT; i++) {
			days = (int) method.invoke(counter);
		}
		long time = System.currentTimeMillis() - startTime;
		System.out.println(String.format("%s: Days=%d, Time=%d(ms)", name, days, time));
	}
}
