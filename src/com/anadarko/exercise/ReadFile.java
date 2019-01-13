package com.anadarko.exercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

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
		assign_data_to_object(readings_array);
	}

	private static void assign_data_to_object(String[] readings_array) {
		InputReadings reading = new InputReadings();
		reading.setPlatform_name(readings_array[0]);
		reading.setReading_send_time(Long.valueOf(readings_array[1]));
		reading.setReading_receive_time(Long.valueOf(readings_array[2]));
		reading.setNumber_of_sensors(Integer.valueOf(readings_array[4]));
		reading.setReading_value(Integer.valueOf(readings_array[4]));
		all_readings.add(reading);
	}

}
