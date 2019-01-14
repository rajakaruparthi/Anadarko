package com.anadarko.exercise.common;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.anadarko.exercise.model.InputReadings;

public class ReadFile extends File {

	// Platform name],[Reading send time in Epoch Time],[Reading receive time in
	// Epoch Time],[Number of sensors with the same reading],[Reading value]

	static List<InputReadings> all_readings = new ArrayList<InputReadings>();

	public List<InputReadings> populate_readings(String path) {
		try {
			try (BufferedReader r = Files.newBufferedReader(Paths.get(path))) {
				r.lines().forEach(each -> populate(each));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return all_readings;
	}

	private static void populate(String each_reading) {
		String[] readings_array = each_reading.split(",");
		all_readings.add(
				new InputReadings(readings_array[0], Long.valueOf(readings_array[1]), Long.valueOf(readings_array[2]),
						Integer.valueOf(readings_array[3]), Integer.valueOf(readings_array[4])));
	}
}
