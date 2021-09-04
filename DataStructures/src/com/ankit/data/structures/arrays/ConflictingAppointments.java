package com.ankit.data.structures.arrays;

import java.util.Arrays;

/**
 * Given an array of intervals representing ‘N’ appointments, find out if a
 * person can attend all the appointments.
 * 
 * @author ankit
 *
 */
public class ConflictingAppointments {

	/*
	 * Runtime Complexity: O(nlogn)
	 * 
	 * The runtime taken by the below program is O(nlogn) + O(n). The first taken
	 * for sorting the array and second for the loop. Asymptotically, which is equal
	 * to O(nlogn).
	 * 
	 * Space Complexity: O(n) - taken by the sort method.
	 */
	public static boolean canAttendAllAppointments(Interval[] intervals) {
		Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
		Interval lastInterval = intervals[0];
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i].start < lastInterval.end)
				return false;
			else
				lastInterval = intervals[i];
		}
		return true;
	}

	public static void main(String[] args) {
		Interval[] intervals = { new Interval(1, 4), new Interval(2, 5), new Interval(7, 9) };
		boolean result = ConflictingAppointments.canAttendAllAppointments(intervals);
		System.out.println("Can attend all appointments: " + result);

		Interval[] intervals1 = { new Interval(6, 7), new Interval(2, 4), new Interval(8, 12) };
		result = ConflictingAppointments.canAttendAllAppointments(intervals1);
		System.out.println("Can attend all appointments: " + result);

		Interval[] intervals2 = { new Interval(4, 5), new Interval(2, 3), new Interval(3, 6) };
		result = ConflictingAppointments.canAttendAllAppointments(intervals2);
		System.out.println("Can attend all appointments: " + result);
	}

}

class Interval {
	int start;
	int end;

	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}

}