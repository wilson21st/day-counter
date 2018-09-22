package com.wilson.daycounter.date;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Random;

import org.junit.jupiter.api.Test;

import com.wilson.daycounter.date.MyDate;

public class MyDateTest {

	@Test
	public void testIncrement() {

		Random random = new Random();

		// test 1000 times
		for (int i = 0; i < 1000; i++) {

			int inc = random.nextInt(30000);
			int year = random.nextInt(2999) + 1;
			int month = random.nextInt(12) + 1;
			int day = random.nextInt(YearMonth.of(year, month).lengthOfMonth()) + 1;

			MyDate myDate1 = new MyDate(year, month, day);
			LocalDate localDate = LocalDate.of(myDate1.getYear(), myDate1.getMonth(), myDate1.getDay()).plusDays(inc);
			MyDate myDate2 = new MyDate(localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth());

			for (int j = 0; j < inc; j++) {
				myDate1 = myDate1.increment();
			}
			assertEquals(myDate1.compareTo(myDate2), 0);
		}
	}
}
