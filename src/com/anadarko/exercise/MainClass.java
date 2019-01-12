package com.anadarko.exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainClass {

	public static final String path = System.getProperty("user.dir") + "/src/com/anadarco/exercice/resources/input.txt";

	public static List<Readings> all_readings = new ArrayList<Readings>();

	public static void main(String[] args) 
	{
		Calculation cal = new Calculation();
		ReadFile read = new ReadFile();
		SortReadings sort= new SortReadings();
		
		List<Readings> all_readings = read.populate_readings(path);
		Collections.sort(all_readings, sort.comparator());
		cal.do_calculations(all_readings);
	}
}
