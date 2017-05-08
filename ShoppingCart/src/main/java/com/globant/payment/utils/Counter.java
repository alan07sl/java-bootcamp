package com.globant.payment.utils;

public class Counter {

	private static Integer counter = 0;

	public static Integer getNext() {
		counter = counter + 1;
		return counter;
	};

}
