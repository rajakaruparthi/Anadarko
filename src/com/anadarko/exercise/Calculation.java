package com.anadarko.exercise;

import java.util.ArrayList;
import java.util.List;

public class Calculation {

	List<OutputReading> final_output_readings;

	public List<OutputReading> do_calculations(List<Readings> all_readings) {

		final_output_readings = new ArrayList<OutputReading>();
		int count = 0;
		int min_value = 0;
		long diff = 0;
		long total_gap = 0;
		long max_flight_time = 0;

		for (int i = 0; i < all_readings.size(); i++) {
			Readings reading1 = all_readings.get(i);
			Readings reading2 = (i < (all_readings.size() - 1) ? all_readings.get(i + 1) : new Readings());
			System.out.println(reading1.getPlatform_name().equals(reading2.getPlatform_name()));
			if (reading1.getPlatform_name().equals(reading2.getPlatform_name())) {
				count++;
				/* ------------------ calculate total gap ------------------------ */
				diff = reading2.getReading_receive_time() - reading1.getReading_receive_time();
				total_gap = diff + total_gap;

				/* ------------------ calculate minimum value ------------------------ */
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
				OutputReading populate_output_readings;
				// If we have only one record of a particular platform
				if (count == 0) {
					total_gap = 0;
					min_value = reading1.getReading_value();
					max_flight_time = reading1.getReading_receive_time() - reading1.getReading_send_time();
					populate_output_readings = populate_output_readings(reading1.getPlatform_name(), "0", "0", min_value,
							convert_epoch_to_time(max_flight_time));
				} else {
					populate_output_readings = populate_output_readings(reading2.getPlatform_name(), convert_epoch_to_time(total_gap),
							convert_epoch_to_time(count > 0 ? total_gap / count : total_gap), min_value,
							convert_epoch_to_time(max_flight_time));
				}
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

	private OutputReading populate_output_readings(String platform_name, String total_gap_time, String avg_gap_time, int min_value,
			String max_flight_time) {
		OutputReading outputReading = new OutputReading();
		outputReading.setAvg_gap_time(avg_gap_time);
		outputReading.setPlatform_name(platform_name);
		outputReading.setTotal_gap_time(total_gap_time);
		outputReading.setMin_value(min_value);
		outputReading.setMax_flight_time(max_flight_time);
		System.out
				.println(platform_name + ", " + total_gap_time + ", " + avg_gap_time + ", " + min_value + ", " + max_flight_time);
		return outputReading;
	}

	public String convert_epoch_to_time(long epoch_time) {
		long sec = epoch_time % 60;
		long minutes = epoch_time % 3600 / 60;
		long hours = epoch_time % 86400 / 3600;
		long days = epoch_time / 86400;
		return days + ":" + hours + ":" + minutes + ":" + sec;
	}

}
