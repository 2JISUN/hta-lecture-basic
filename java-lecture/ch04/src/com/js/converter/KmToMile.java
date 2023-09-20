package com.js.converter;

public class KmToMile extends Converter {
	KmToMile(double ratio){
		this.ratio = ratio;
		
	}

	@Override
	public double convert(double src) {

		return src / ratio;
	}

	@Override
	public String destString() {

		return "km";
	}

	@Override
	public String srcString() {

		return "mile";
	}

	public static void main(String[] args) {
		new KmToMile(1.6).run();
	}


}
