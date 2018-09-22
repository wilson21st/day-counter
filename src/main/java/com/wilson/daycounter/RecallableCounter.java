package com.wilson.daycounter;

import java.util.HashMap;
import java.util.Map;

import com.wilson.daycounter.date.MyDate;

public class RecallableCounter {

	private final MyDate date1;
	private final MyDate date2;

	/**
	 * Each date is mapped to the number of days counted from 01/01/1901.
	 */
	private static final Map<MyDate, Integer> map = new HashMap<>();

	/**
	 * Initialize the static map for dates from 01/01/1901 to 31/01/2999.
	 */
	static {
		MyDate start = new MyDate(1901, 1, 1);
		MyDate end = new MyDate(2999, 12, 31);
		int days = 0;
		do {
			// Keep the days in map
			map.put(start, days);
			start = start.increment();
			days++;
		} while (!start.equals(end));
		map.put(start, days);
	}

	public RecallableCounter(MyDate date1, MyDate date2) {
		this.date1 = date1;
		this.date2 = date2;
	}

	public int getDiffInDays() {
		int days = Math.abs(map.get(date1) - map.get(date2));
		return days == 0 ? 0 : days - 1;
	}
}
