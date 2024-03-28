package com.ecommerce.model;

import java.io.Serializable;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class OrderProductPK implements Serializable {
	
	/*@JsonBackReference
	@ManyToOne(fetch =FetchType.LAZY)
	@MapsId("orderId")
	@JoinColumn(name = "orderId")
	private Orders order;
	@ManyToOne(fetch =FetchType.LAZY)
	@MapsId("productId")
	@JoinColumn(name = "productId")
	private Product product;*/
	
	private int orderId;
	private int productId;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}

}
