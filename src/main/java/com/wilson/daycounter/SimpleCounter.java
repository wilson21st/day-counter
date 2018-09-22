package com.wilson.daycounter;

import com.wilson.daycounter.date.MyDate;

public class SimpleCounter {

	private final MyDate date1;
	private final MyDate date2;

	public SimpleCounter(MyDate date1, MyDate date2) {
		this.date1 = date1;
		this.date2 = date2;
	}

	public int getDiffInDays() {
		return date1.compareTo(date2) < 0 ? count(date1, date2) : count(date2, date1);
	}

	/**
	 * Count days from start date day by day.
	 */
	private int count(MyDate start, MyDate end) {
		int days = 0;
		while (!start.equals(end)) {
			start = start.increment();
			days++;
		}
		return days == 0 ? 0 : days - 1;
	}
}
