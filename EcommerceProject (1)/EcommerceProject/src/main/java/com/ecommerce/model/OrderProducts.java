package com.ecommerce.model;



import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="order_products")
public class OrderProducts {
	
	@EmbeddedId
	@JsonIgnore
	private OrderProductPK orderProductPK;
	private int quantity;
	private int price;
	
	//@ManyToOne
	//private Orders order;
	
	
	
	public OrderProducts() {
		super();
		}

	public OrderProducts(OrderProductPK orderProductPK, int quantity, int price) {
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
