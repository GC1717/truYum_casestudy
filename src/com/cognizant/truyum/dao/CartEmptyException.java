package com.cognizant.truyum.dao;

@SuppressWarnings("serial")
public class CartEmptyException extends Exception{

	CartEmptyException(){
		super();
		System.out.println("cart is empty");
	}
}
