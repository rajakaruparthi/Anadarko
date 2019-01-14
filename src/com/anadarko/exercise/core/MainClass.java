package com.anadarko.exercise.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.anadarko.exercise.common.Path;
import com.anadarko.exercise.common.ReadFile;
import com.anadarko.exercise.common.SortReadings;
import com.anadarko.exercise.common.WriteFile;
import com.anadarko.exercise.model.InputReadings;
import com.anadarko.exercise.model.OutputReadings;

public class MainClass {

	public static List<InputReadings> all_readings = new ArrayList<InputReadings>();

	public static void main(String[] args) 
	{
		ReadFile read = new ReadFile();
		List<InputReadings> all_readings = read.populate_readings(new Path().getPath());
		
		SortReadings sort= new SortReadings();
		Collections.sort(all_readings, sort.comparator());
		
		Calculation cal = new Calculation();
		List<OutputReadings> output_readings = cal.do_calculations(all_readings);
		
		WriteFile write = new WriteFile();
		String output_filename = "output_readings.csv";
		write.writeToCsv(output_readings, output_filename);
	}
}
