package com.ecommerce.dto;

import com.ecommerce.model.OrderProductPK;

public class OrderProductsDTO {

	private OrderProductPK orderProductPK;
	private int quantity;
	private int price;
	
	public OrderProductsDTO() {
		
	}

	public OrderProductsDTO(OrderProductPK orderProductPK, int quantity, int price) {
		super();
		this.orderProductPK = orderProductPK;
		this.quantity = quantity;
		this.price = price;
	}

	public OrderProductPK getOrderProductPK() {
		return orderProductPK;
	}

	public void setOrderProductPK(OrderProductPK orderProductPK) {
		this.orderProductPK = orderProductPK;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
	

}
