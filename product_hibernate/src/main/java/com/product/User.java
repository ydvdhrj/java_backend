package com.product;

public class User {
	
	public static void main(String[] args) {
		
		ProductDao dao = new ProductDao();
		
		Product p = new Product();
		
		p.setId(4);
		p.setName("rubber");
		p.setPrice(5);
		p.setQuantity(0);
		
		dao.insertProduct(p);
	}

}
