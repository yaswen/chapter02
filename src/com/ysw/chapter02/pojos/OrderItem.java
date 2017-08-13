package com.ysw.chapter02.pojos;

import java.util.Date;

public class OrderItem {
	private Integer id;
	private Order order;
	private Product product;
	private Integer quantity;
	private Double purchasePrice;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	//默认构造方法
		public OrderItem(){
			super();
	}
	//带参数的构造方法
	public OrderItem(Order order,Product product,Integer quantity,Double purchasePrice){
		super();
		this.order=order;
		this.product=product;
		this.quantity=quantity;
		this.purchasePrice=purchasePrice;
	}
	
}
