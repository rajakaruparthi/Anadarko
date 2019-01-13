package com.anadarco.exercice.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import org.junit.jupiter.api.Test;
import com.anadarko.exercise.Calculation;
import com.anadarko.exercise.OutputReading;
import com.anadarko.exercise.Readings;

class TestCalculation {

	List<Readings> dataset_1 = new ArrayList<Readings>();
	List<Readings> dataset_2 = new ArrayList<Readings>();
	List<Readings> dataset_3 =  new ArrayList<Readings>();

	Readings r1 = new Readings("ABCD", 1000, 2000, 3, -90);
	Readings r2 = new Readings("ABCD", 1500, 3000, 67, 94);
	Readings r3 = new Readings("ABCD", 1000, 4000, 42, 907);
	Readings r4 = new Readings("ABCF", 1000, 2000, 42, 907);

	public TestCalculation() {
		dataset_1.addAll(Arrays.asList(r1, r2, r3));
		dataset_2.add(r4);
		dataset_3.addAll(Arrays.asList(r1, r2, r3, r4));
	}

	@Test
	public void calculate_avg_gap() {
		Calculation cal = new Calculation();
		List<OutputReading> do_Calculations = cal.do_calculations(dataset_1);
		assertEquals("ABCD", do_Calculations.get(0).getPlatform_name());
		assertEquals("00:00:33:20", do_Calculations.get(0).getTotal_gap_time());
		assertEquals("00:00:16:40", do_Calculations.get(0).getAvg_gap_time());
		assertEquals(-90, do_Calculations.get(0).getMin_value());
		assertEquals("00:00:50:00", do_Calculations.get(0).getMax_flight_time());
	}
	
	@Test
	public void for_single_reading() {
		Calculation cal = new Calculation();
		List<OutputReading> do_Calculations = cal.do_calculations(dataset_2);
		assertEquals("ABCF", do_Calculations.get(0).getPlatform_name());
		assertEquals("0", do_Calculations.get(0).getTotal_gap_time());
		assertEquals("0", do_Calculations.get(0).getAvg_gap_time());
		assertEquals(907, do_Calculations.get(0).getMin_value());
		assertEquals("00:00:16:40", do_Calculations.get(0).getMax_flight_time());
	}
	
	@Test
	public void dataset_3() {
		Calculation cal = new Calculation();
		Object[] expected = {"ABCD", "00:00:33:20", "00:00:16:40", -90, "00:00:50:00", "ABCF", "0", "0", 907, "00:00:16:40"};
		List<OutputReading> do_Calculations = cal.do_calculations(dataset_3);
		convert_to_array(do_Calculations);
		Object[] actual = convert_to_array(do_Calculations);
		assertArrayEquals(actual,expected);
//		for (int i = 0; i < expected.length; i++) {
//			System.out.println(expected[i] + "---"+actual[i]);
//		}
	}

	private Object[] convert_to_array(List<OutputReading> do_Calculations) {
		List<Object> actual = new ArrayList<Object>();
		do_Calculations.forEach(new Consumer<OutputReading>() {
			@Override
			public void accept(OutputReading each_reading) {
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
