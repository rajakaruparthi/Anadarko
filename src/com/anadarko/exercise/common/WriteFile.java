package com.anadarko.exercise.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import com.anadarko.exercise.model.OutputReadings;

public class WriteFile extends com.anadarko.exercise.common.File{

	public void writeToCsv(List<OutputReadings> output_readings, String output_filename) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new File(output_filename));
			StringBuilder sb = new StringBuilder();
			sb.append("Platform name, Total Gap Time, Average Gap Time, Min Value, Max Flight Time \n");
			for (OutputReadings outputReading : output_readings) {
				sb.append(outputReading.getPlatform_name() + "," + outputReading.getTotal_gap_time() + ","
						+ outputReading.getAvg_gap_time() + "," + outputReading.getMin_value() + ","
						+ outputReading.getMax_flight_time() + "\n");
			}
			writer.write(sb.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Finished writing");
			writer.close();
		}
	}

}
