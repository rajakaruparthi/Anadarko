package com.anadarko.exercice.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import org.junit.jupiter.api.Test;
import com.anadarko.exercise.Calculation;
import com.anadarko.exercise.OutputReadings;
import com.anadarko.exercise.InputReadings;

class TestCalculation {

	List<InputReadings> dataset_1 = new ArrayList<InputReadings>();
	List<InputReadings> dataset_2 = new ArrayList<InputReadings>();
	List<InputReadings> dataset_3 = new ArrayList<InputReadings>();

	public TestCalculation() {
		InputReadings r1 = new InputReadings("ABCD", 1000, 2000, 3, -90);
		InputReadings r2 = new InputReadings("ABCD", 1500, 3000, 67, 94);
		InputReadings r3 = new InputReadings("ABCD", 1000, 4000, 42, 907);
		InputReadings r4 = new InputReadings("ABCF", 1000, 2000, 42, 907);
		dataset_1.addAll(Arrays.asList(r1, r2, r3));
		dataset_2.add(r4);
		dataset_3.addAll(Arrays.asList(r1, r2, r3, r4));
	}

	@Test
	public void calculate_avg_gap() {
		Calculation cal = new Calculation();
		List<OutputReadings> do_Calculations = cal.do_calculations(dataset_1);
		assertEquals("ABCD", do_Calculations.get(0).getPlatform_name());
		assertEquals("00:00:33:20", do_Calculations.get(0).getTotal_gap_time());
		assertEquals("00:00:16:40", do_Calculations.get(0).getAvg_gap_time());
		assertEquals(-90, do_Calculations.get(0).getMin_value());
		assertEquals("00:00:50:00", do_Calculations.get(0).getMax_flight_time());
	}

	@Test
	public void for_single_reading() {
		Calculation cal = new Calculation();
		List<OutputReadings> do_Calculations = cal.do_calculations(dataset_2);
		assertEquals("ABCF", do_Calculations.get(0).getPlatform_name());
		assertEquals("0", do_Calculations.get(0).getTotal_gap_time());
		assertEquals("0", do_Calculations.get(0).getAvg_gap_time());
		assertEquals(907, do_Calculations.get(0).getMin_value());
		assertEquals("00:00:16:40", do_Calculations.get(0).getMax_flight_time());
	}

	@Test
	public void dataset_3() {
		Calculation cal = new Calculation();
		Object[] expected = { "ABCD", "00:00:33:20", "00:00:16:40", -90, "00:00:50:00", "ABCF", "0", "0", 907,
				"00:00:16:40" };
		List<OutputReadings> do_Calculations = cal.do_calculations(dataset_3);
		convert_to_array(do_Calculations);
		Object[] actual = convert_to_array(do_Calculations);
		assertArrayEquals(actual, expected);
	}

	private Object[] convert_to_array(List<OutputReadings> do_Calculations) {
		List<Object> actual = new ArrayList<Object>();
		do_Calculations.forEach(new Consumer<OutputReadings>() {
			@Override
			public void accept(OutputReadings each_reading) {
				actual.add(each_reading.getPlatform_name());
				actual.add(each_reading.getTotal_gap_time());
				actual.add(each_reading.getAvg_gap_time());
				actual.add(each_reading.getMin_value());
				actual.add(each_reading.getMax_flight_time());
			}
		});
		return actual.toArray();
	}

}
