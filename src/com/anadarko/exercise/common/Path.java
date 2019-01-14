package com.anadarko.exercise.common;

public class Path {
	
	private final String path = System.getProperty("user.dir") + "/src/com/anadarko/exercice/resources/input.txt";

	public String getPath() {
		return path;
	}
}
