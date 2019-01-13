package com.anadarko.exercise;

public class InputReadings {

	// Platform name],[Reading send time in Epoch Time],[Reading receive time in
	// Epoch Time],[Number of sensors with the same reading],[Reading value]
	private String platform_name;
	private long reading_send_time;
	private long reading_receive_time;
	private int number_of_sensors;
	private int reading_value;
	
	public InputReadings(String platform_name, long reading_send_time, long reading_receive_time, int number_of_sensors,
			int reading_value) {
		super();
		this.platform_name = platform_name;
		this.reading_send_time = reading_send_time;
		this.reading_receive_time = reading_receive_time;
		this.number_of_sensors = number_of_sensors;
		this.reading_value = reading_value;
	}
	
	public InputReadings() {
	}

	public String getPlatform_name() {
		return platform_name;
	}

	public void setPlatform_name(String platform_name) {
		this.platform_name = platform_name;
	}

	public long getReading_send_time() {
		return reading_send_time;
	}

	public void setReading_send_time(long reading_send_time) {
		this.reading_send_time = reading_send_time;
	}

	public long getReading_receive_time() {
		return reading_receive_time;
	}

	public void setReading_receive_time(long reading_receive_time) {
		this.reading_receive_time = reading_receive_time;
	}

	public int getNumber_of_sensors() {
		return number_of_sensors;
	}

	public void setNumber_of_sensors(int number_of_sensors) {
		this.number_of_sensors = number_of_sensors;
	}

	public int getReading_value() {
		return reading_value;
	}

	public void setReading_value(int reading_value) {
		this.reading_value = reading_value;
	}

}
