package com.anadarko.exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainClass {

	public static final String path = System.getProperty("user.dir") + "/src/com/anadarco/exercice/resources/input.txt";

	public static List<InputReadings> all_readings = new ArrayList<InputReadings>();

	public static void main(String[] args) 
	{
		Calculation cal = new Calculation();
		ReadFile read = new ReadFile();
		SortReadings sort= new SortReadings();
		WriteToCSV write = new WriteToCSV();
		List<InputReadings> all_readings = read.populate_readings(path);
		Collections.sort(all_readings, sort.comparator());
		List<OutputReadings> output_readings = cal.do_calculations(all_readings);
		write.writeToCsv(output_readings);
	}
}
