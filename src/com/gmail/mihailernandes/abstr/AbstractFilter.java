package com.gmail.mihailernandes.abstr;

public abstract class AbstractFilter {
	
	private double red;
	private double green;
	private double blue;
	
	protected AbstractFilter() {}
	
	protected AbstractFilter(final double red, final double green, final double blue) {
		super();
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	protected double getRed() {
		return red;
	}

	protected void setRed(double red) {
		this.red = red;
	}

	protected double getGreen() {
		return green;
	}

	protected void setGreen(double green) {
		this.green = green;
	}

	protected double getBlue() {
		return blue;
	}

	protected void setBlue(double blue) {
		this.blue = blue;
	}

	public abstract void filter(String path);
}
