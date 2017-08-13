package com.ysw.chapter02.pojos;

import java.util.Date;
import java.util.Set;

public class Product {
	private Integer id;
	private String name;
	private Double price;
	private String description;
	private Set<OrderItem> orderitems;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<OrderItem> getOrderitems() {
		return orderitems;
	}
	public void setOrderitems(Set<OrderItem> orderitems) {
		this.orderitems = orderitems;
	}
	//默认构造方法
	public Product(){
		super();
	}
	//带参数的构造方法
	public Product(String name,Double price,String description){
		super();
		this.name = name;
		this.price=price;
		this.description=description;
	}
	
}
