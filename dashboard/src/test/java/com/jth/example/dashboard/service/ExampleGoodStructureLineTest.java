package com.jth.example.dashboard.service;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.jth.example.dashboard.service.Line;
import com.jth.example.dashboard.service.Point;

public class ExampleGoodStructureLineTest {

	@Test
	public void testComputeSlope_failForOneReason() {
		//bad structure - violates "single assert per test"
		Point a = new Point(0,0);
		Point b = new Point(1,1);
		Line line = new Line(a,b);
		BigDecimal actual = line.computeSlope();
		assertEquals(1.0, actual.doubleValue(), 0.0);
		line.setA(null);
		actual = line.computeSlope();
		assertEquals(null, actual);
	}

	@Test
	public void testComputeSlope_returnsSlope_GoodStructure() {
		//given
		Point a = new Point(0,0);
		Point b = new Point(1,1);
		Line line = new Line(a,b);
		
		//when
		BigDecimal actual = line.computeSlope();

		//then
		assertEquals(1.0, actual.doubleValue(), 0.0);
	}
	
	@Test
	public void testComputeSlope_nullPoint_returnsNull() {
		//given
		Point a = null;
		Point b = new Point(1,1);
		Line line = new Line(a,b);

		//when
		BigDecimal actual = line.computeSlope();

		//then
		assertEquals(null, actual);
	}
}
