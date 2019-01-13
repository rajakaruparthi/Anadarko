package com.anadarko.exercise;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class WriteToCSV {

	public void writeToCsv(List<OutputReadings> output_readings) {
		PrintWriter writer;
		try {
			writer = new PrintWriter(new File("output.csv"));
			StringBuilder sb = new StringBuilder();
			sb.append("Platform name, Total Gap Time, Average Gap Time, Min Value, Max Flight Time \n");
			for (OutputReadings outputReading : output_readings) {
				sb.append(outputReading.getPlatform_name() + "," + outputReading.getTotal_gap_time() + ","
						+ outputReading.getAvg_gap_time() + "," + outputReading.getMin_value() + ","
						+ outputReading.getMax_flight_time()+"\n");
			}
			writer.write(sb.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {

		}
	}

}
