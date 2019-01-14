package com.anadarko.exercise;

import java.util.ArrayList;
import java.util.List;
import com.anadarko.exercise.model.InputReadings;
import com.anadarko.exercise.model.OutputReadings;

public class Calculation {

	List<OutputReadings> final_output_readings;

	public List<OutputReadings> do_calculations(List<InputReadings> all_readings) {

		final_output_readings = new ArrayList<OutputReadings>();
		int count = 0;
		int min_value = 0;
		long diff = 0;
		long total_gap = 0;
		long max_flight_time = 0;

		for (int i = 0; i < all_readings.size(); i++) {
			InputReadings reading1 = all_readings.get(i);
			InputReadings reading2 = (i < (all_readings.size() - 1) ? all_readings.get(i + 1) : new InputReadings());

			if (reading1.getPlatform_name().equals(reading2.getPlatform_name())) {
				count++;
				/* ------------------ calculate total gap -------------------------------- */
				diff = reading2.getReading_receive_time() - reading1.getReading_receive_time();
				total_gap = diff + total_gap;

				/* ------------------ calculate minimum value ---------------------------- */
				if (reading1.getReading_value() < min_value) {
					min_value = reading1.getReading_value();
				}
				if (reading2.getReading_value() < min_value) {
					min_value = reading2.getReading_value();
				}

				/* ------------------ calculate maximum flight time------------------------ */
				long flight_time_reading1 = reading1.getReading_receive_time() - reading1.getReading_send_time();
				long flight_time_reading2 = reading2.getReading_receive_time() - reading2.getReading_send_time();

				if (flight_time_reading1 > max_flight_time) {
					max_flight_time = flight_time_reading1;
				}
				if (flight_time_reading2 > max_flight_time) {
					max_flight_time = flight_time_reading2;
				}
			} else {
				OutputReadings populate_output_readings;
				// If we have only one record of a particular platform
				if (count == 0) {
					total_gap = 0;
					min_value = reading1.getReading_value();
					max_flight_time = reading1.getReading_receive_time() - reading1.getReading_send_time();
					populate_output_readings = new OutputReadings(reading1.getPlatform_name(), "0", "0", min_value,
							convert_epoch_to_time(max_flight_time));
				} else {
					populate_output_readings = new OutputReadings(reading1.getPlatform_name(),
							convert_epoch_to_time(total_gap),
							convert_epoch_to_time(count > 0 ? total_gap / count : total_gap), min_value,
							convert_epoch_to_time(max_flight_time));
				}
				System.out.println(populate_output_readings.getPlatform_name() + "--" + count);
				final_output_readings.add(populate_output_readings);
				count = 0;
				min_value = 0;
				diff = 0;
				total_gap = 0;
				max_flight_time = 0;
			}
		}

		return final_output_readings;
	}

	public String convert_epoch_to_time(long epoch_time) {
		long sec = epoch_time % 60;
		long minutes = epoch_time % 3600 / 60;
		long hours = epoch_time % 86400 / 3600;
		long days = epoch_time / 86400;
		return (days == 0 ? "" : parseTime(days) + ":") + parseTime(hours) + ":" + parseTime(minutes) + ":"
				+ parseTime(sec);
	}

	public String parseTime(long input) {
		System.out.println(input < 10 ? "0" + input : Long.toString(input));
		return input < 10 ? "0" + input : Long.toString(input);
	}

}
