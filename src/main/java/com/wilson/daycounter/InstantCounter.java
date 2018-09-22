package com.wilson.daycounter;

import com.wilson.daycounter.date.MyDate;

public class InstantCounter {

	private final MyDate date1;
	private final MyDate date2;

	public InstantCounter(MyDate date1, MyDate date2) {
		this.date1 = date1;
		this.date2 = date2;
	}

	public int getDiffInDays() {
		int days1 = getDays(date1);
		int days2 = getDays(date2);
		int days = Math.abs(days1 - days2);
		return days == 0 ? 0 : days - 1;
	}

	/**
	 * Convert from the Gregorian Calendar to the Julian Day Number. In order to
	 * adapt the leap years, January and February are counted as the end of the
	 * previous year.
	 */
	private int getDays(MyDate date) {

		int year = date.getYear();
		int month = date.getMonth();
		int day = date.getDay();

		// if the month is 1 or 2, then add 12 to the month and subtract 1 from the year
		if (month == 1 || month == 2) {
			month += 12;
			year -= 1;
		}

		// 365*year + year/4 - year/100 + year/400 + date + (153*month+8)/5
		return 365 * year + floor(year / 4d) - floor(year / 100d) + day + floor((153 * month + 8) / 5d);
	}

	private int floor(double d) {
		return (int) Math.round(Math.floor(d));
	}
}
