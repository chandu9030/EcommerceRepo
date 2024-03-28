package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.dto.OrderProductsDTO;
import com.ecommerce.model.OrderProducts;

public interface OrderProductsRepository  extends JpaRepository<OrderProducts,Integer> {

	void save(OrderProductsDTO order);
}