package com.product;

public class User {
	
	public static void main(String[] args) {
		
		ProductDao dao = new ProductDao();
		
		Product p = new Product();
		
		p.setId(1);
		p.setName("Pen");
		p.setPrice(10);
		p.setQuantity(10);
		
		dao.insertProduct(p);
	}

}
