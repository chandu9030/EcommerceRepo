package com.ecommerce.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.CustomerDTO;
import com.ecommerce.dto.OrdersDTO;
import com.ecommerce.dto.PaymentDTO;
import com.ecommerce.dto.ShipperDTO;
import com.ecommerce.model.Customer;
import com.ecommerce.model.Orders;
import com.ecommerce.model.Payment;
import com.ecommerce.model.Shipper;
import com.ecommerce.repository.CustomerRepository;
import com.ecommerce.repository.OrderProductsRepository;
import com.ecommerce.repository.OrdersRepository;
import com.ecommerce.repository.PaymentRepository;
import com.ecommerce.repository.ShipperRepository;

@Service
public class OrdersServiceImpl implements OrdersService {
	
	
	@Autowired
	private OrdersRepository ordersrepository;
	
	@Autowired
	private OrderProductsRepository orderProductsrepository;
	
	@Autowired
	private CustomerRepository customerrepository;
	
	@Autowired
	private PaymentRepository paymentrepository;
	
	@Autowired
	private ShipperRepository shipperrepository;
	
	private CustomerServiceImpl custImpl;
	private ShipperServiceImpl shipperImpl;
	private PaymentServiceImpl paymentImpl;
	

	@Override
	public OrdersDTO createOrders(OrdersDTO ordersDto) {
		 Orders orders=new Orders();
		
		orders.setInvoiceNumber(ordersDto.getInvoiceNumber());
		orders.setShipDate(ordersDto.getShipDate());
		if(ordersDto.getOrderDate()==null)
			ordersDto.setOrderDate(LocalDate.now());
		orders.setOrderDate(ordersDto.getOrderDate());
		orders.setTransactionStatus(ordersDto.getTransactionStatus());
		
		Customer customer1=customerrepository.findById(ordersDto.getCustomer().getCustomerId()).get();
		orders.setCustomer(customer1);
		
		Payment payment = paymentrepository.findById(ordersDto.getPayment().getPaymentId()).get();
		orders.setPayment(payment);
		
		Shipper shipper = shipperrepository.findById(ordersDto.getShipper().getShipperId()).get();
		orders.setShipper(shipper);
		
		orders.setOrderProducts(ordersDto.getOrderProducts());
		orders = ordersrepository.save(orders);
		orders.setOrderId(ordersDto.getOrderId());
		
		 return ordersDto;
	}

	@Override
	public List<OrdersDTO> getOrders() {
		Iterable<Orders> orders=ordersrepository.findAll();
		List<OrdersDTO> orders2=new ArrayList<>();
		orders.forEach(t -> {
			OrdersDTO cat=new OrdersDTO();
			cat.setOrderId(t.getOrderId());
			cat.setInvoiceNumber(t.getInvoiceNumber());
			cat.setOrderDate(t.getOrderDate());
			cat.setShipDate(t.getShipDate());
			cat.setTransactionStatus(t.getTransactionStatus());
			CustomerDTO customer1=custImpl.getCustomerByID(t.getCustomer().getCustomerId());
			cat.setCustomer(customer1);
			
			PaymentDTO payment = paymentImpl.getPaymentByID(t.getPayment().getPaymentId());
			cat.setPayment(payment);
			
			ShipperDTO shipper = shipperImpl.getShipperByID(t.getShipper().getShipperId());
			cat.setShipper(shipper);
			cat.setOrderProducts(t.getOrderProducts());
			
			orders2.add(cat);
		});
		return orders2;
	}

	@Override
	public OrdersDTO getOrdersByID(int ordersid) {
		
		Orders orders = ordersrepository.findById(ordersid).get();
		OrdersDTO ordersDto = new OrdersDTO();
		ordersDto.setOrderId(orders.getOrderId());
		ordersDto.setInvoiceNumber(orders.getInvoiceNumber());
		ordersDto.setShipDate(orders.getShipDate());
		ordersDto.setOrderDate(orders.getOrderDate());
		ordersDto.setTransactionStatus(orders.getTransactionStatus());
		CustomerDTO customer1=custImpl.getCustomerByID(orders.getCustomer().getCustomerId());
		ordersDto.setCustomer(customer1);
		
		PaymentDTO payment = paymentImpl.getPaymentByID(orders.getPayment().getPaymentId());
		ordersDto.setPayment(payment);
		
		ShipperDTO shipper = shipperImpl.getShipperByID(orders.getShipper().getShipperId());
		ordersDto.setShipper(shipper);
		ordersDto.setOrderProducts(orders.getOrderProducts());
	   
		return ordersDto;
	}


	@Override
	public OrdersDTO updateOrders(OrdersDTO ordersDto) {
		Orders orders=new Orders();
		orders.setOrderId(ordersDto.getOrderId());
		orders.setInvoiceNumber(ordersDto.getInvoiceNumber());
		orders.setShipDate(ordersDto.getShipDate());
		if(ordersDto.getOrderDate()==null)
			ordersDto.setOrderDate(LocalDate.now());
		orders.setOrderDate(ordersDto.getOrderDate());
		orders.setTransactionStatus(ordersDto.getTransactionStatus());
		Customer customer1=customerrepository.findById(ordersDto.getCustomer().getCustomerId()).get();
		orders.setCustomer(customer1);
		
		Payment payment = paymentrepository.findById(ordersDto.getPayment().getPaymentId()).get();
		orders.setPayment(payment);
		
		Shipper shipper = shipperrepository.findById(ordersDto.getShipper().getShipperId()).get();
		orders.setShipper(shipper);
		orders.setOrderProducts(ordersDto.getOrderProducts());
		orders = ordersrepository.save(orders);
		orders.setOrderId(ordersDto.getOrderId());
		 return ordersDto;	
	}

	@Override
	public void deleteOrders(int ordersid) {
		// TODO Auto-generated method stub
		
	}
	
	
		

}
