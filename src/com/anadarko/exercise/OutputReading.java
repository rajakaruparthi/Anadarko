package com.anadarko.exercise;

public class OutputReading {

	// ABCD,00:33:20,00:16:40,-90,00:50:00
	// Platform name, Total Gap Time, Average Gap Time, Min Value, Max Flight Time

	private String platform_name;
	private String total_gap_time;
	private String avg_gap_time;
	private int min_value;
	private String max_flight_time;
	
	public OutputReading() {
	}
	
	public OutputReading(String platform_name, String total_gap_time, String avg_gap_time, int min_value,
			String max_flight_time) {
		this.platform_name = platform_name;
		this.total_gap_time = total_gap_time;
		this.avg_gap_time = avg_gap_time;
		this.min_value = min_value;
		this.max_flight_time = max_flight_time;
	}

	public String getPlatform_name() {
		return platform_name;
	}

	public void setPlatform_name(String platform_name) {
		this.platform_name = platform_name;
	}

	public String getTotal_gap_time() {
		return total_gap_time;
	}

	public void setTotal_gap_time(String total_gap_time) {
		this.total_gap_time = total_gap_time;
	}

	public String getAvg_gap_time() {
		return avg_gap_time;
	}

	public void setAvg_gap_time(String avg_gap_time) {
		this.avg_gap_time = avg_gap_time;
	}

	public int getMin_value() {
		return min_value;
	}

	public void setMin_value(int min_value) {
		this.min_value = min_value;
	}

	public String getMax_flight_time() {
		return max_flight_time;
	}

	public void setMax_flight_time(String max_flight_time) {
		this.max_flight_time = max_flight_time;
	}

}
