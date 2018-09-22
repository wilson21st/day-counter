package com.wilson.daycounter.date;

import lombok.Getter;

@Getter
public class MyDate implements Comparable<MyDate> {

	private int year;
	private int month;
	private int day;

	public MyDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	/**
	 * Increment one day.
	 * 
	 * @return a new date after increment.
	 */
	public MyDate increment() {
		MyDate newDate = new MyDate(year, month, day);
		if (++newDate.day > getDaysOfMonth(newDate.month, isLeapYear(newDate.year))) {
			// reset to the first day of the month
			newDate.day = 1;
			if (++newDate.month > 12) {
				// reset to the first month of the year
				newDate.month = 1;
				++newDate.year;
			}
		}
		return newDate;
	}

	/**
	 * Compare this date to the specified date.
	 * 
	 * @param date the date to be compared
	 * @return a negative integer, zero, or a positive integer as this date is less
	 *         than, equal to, or greater than the specified date
	 */
	public int compareTo(MyDate date) {
		if (year != date.year)
			return year - date.year;
		else if (month != date.month)
			return month - date.month;
		else if (day != date.day)
			return day - date.day;
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + day;
		result = prime * result + month;
		result = prime * result + year;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyDate other = (MyDate) obj;
		if (day != other.day)
			return false;
		if (month != other.month)
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	/**
	 * Check if the year is a leap year:
	 * <p>
	 * Every year that is exactly divisible by four is a leap year, except for years
	 * that are exactly divisible by 100, but these centurial years are leap years
	 * if they are exactly divisible by 400
	 * 
	 * @param year
	 * @return boolean
	 */
	private boolean isLeapYear(int year) {
		if (year % 4 != 0)
			return false;
		else if (year % 100 != 0)
			return true;
		else if (year % 400 != 0)
			return false;
		else
			return true;
	}

	private int getDaysOfMonth(int month, boolean isLeapYear) {
		switch (month) {
		case 2:
			return isLeapYear ? 29 : 28;
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;
		default:
			return 31;
		}
	}
}
