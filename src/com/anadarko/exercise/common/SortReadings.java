package com.anadarko.exercise.common;

import java.util.Comparator;

import com.anadarko.exercise.model.InputReadings;

public class SortReadings {

	public Comparator<InputReadings> comparator() {
		Comparator<InputReadings> comparator = new Comparator<InputReadings>() {
			@Override
			public int compare(InputReadings r1, InputReadings r2) {
				return compareStrings(r1.getPlatform_name(), r2.getPlatform_name());
			}
		};
		return comparator;
	}

	public static int compareStrings(String a, String b) {
		int compare = a.compareTo(b);
		if (compare < 0) {
			return -1;
		} else if (compare > 0) {
			return 1;
		}
		return compare;
	}

}
