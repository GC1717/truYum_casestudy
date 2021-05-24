package com.cognizant.truyum.dao;

import java.util.ArrayList;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImplTest {
	public static void main(String[] args) 
	{
		testAddCartItem();
		testGetAllCartItems();
		testRemoveCartItem();
		
	}
	public static void testAddCartItem()
	{
		CartDao cartDao = new CartDaoSqlImpl();
		cartDao.addCartItem((long)1, (long) 1);
		cartDao.addCartItem((long)1, (long) 3);
		try
		{
			ArrayList<MenuItem> cartList = cartDao.getAllCartItems((long)1);
			System.out.println("Adding to cart");
			
			for (MenuItem i: cartList) {
				 System.out.println(i.toString());
			}
			
		}
		catch(CartEmptyException e)
		{
			e.printStackTrace();
		}
		
	}
	public static void testGetAllCartItems()
	{
		CartDao cartDao = new CartDaoSqlImpl();
		try
		{
		 ArrayList<MenuItem> cartItems = cartDao.getAllCartItems((long)1);
		 System.out.println("testing cart");
		 for(MenuItem i:cartItems)
		 {
			 System.out.println(i.toString());
		 }
		}
		catch(CartEmptyException e)
		{
			e.printStackTrace();
		}
		
	}
	public static void testRemoveCartItem() 
	{
		CartDao cartDao = new CartDaoSqlImpl();
		cartDao.removeCartItem((long)1,(long)3);
		try
		{
			ArrayList<MenuItem> cartLefts = cartDao.getAllCartItems((long)1); 
			if(cartLefts.isEmpty())
			{
				throw new CartEmptyException();
			}
			else
			{
				for(MenuItem i:cartLefts)
				{
					System.out.println(i.toString());
				}
			}
		}
		catch(CartEmptyException e)
		{
			e.printStackTrace();
		}
	}
	
	
}