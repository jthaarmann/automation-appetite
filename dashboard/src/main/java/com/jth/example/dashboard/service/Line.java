package com.jth.example.dashboard.service;

import java.math.BigDecimal;

public class Line {

	private Point a;
	private Point b;
	
	public Line(Point a, Point b) {
		this.a = a;
		this.b = b;
	}
	
	public BigDecimal computeSlope() {
		if (a == null || b == null) return null;
		BigDecimal rise = BigDecimal.valueOf(b.getY()).subtract(BigDecimal.valueOf(a.getY()));
		BigDecimal run = BigDecimal.valueOf(b.getX()).subtract(BigDecimal.valueOf(a.getX()));
		return rise.divide(run);
	}

	public Point getA() {
		return a;
	}

	public void setA(Point a) {
		this.a = a;
	}

	public Point getB() {
		return b;
	}

	public void setB(Point b) {
		this.b = b;
	}
	
}
