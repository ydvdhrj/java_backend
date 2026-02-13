package com.assignmenrt_mokito_13fab;

public class PriceService {

	private final DiscountRepository discountRepository;
	
	PriceService(DiscountRepository disc){
		discountRepository = disc;
	}
	
	public double calculateFinalPrice(double price, String productCode) {
		double discount = discountRepository.getDiscountPercentage(productCode);
		
		return price-(price*discount/100);
	}
}
