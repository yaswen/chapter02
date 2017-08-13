package com.ysw.chapter02.pojos;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class Order implements Serializable{
	private String id;			//定义ID变量
	private String orderNo;		//定义订单编号
	private Date date;			//定义下单时间
	private Customer customer;	//定义客户类型变量
	private Set<OrderItem> orderitems;//商品集合
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Set<OrderItem> getOrderitems() {
		return orderitems;
	}
	public void setOrderitems(Set<OrderItem> orderitems) {
		this.orderitems = orderitems;
	}
	//默认构造方法
	public Order(){
		super();
	}
	//带参数的构造方法
	public Order(String orderNo,Date date,Customer customer){
		super();
		this.orderNo = orderNo;
		this.date=date;
		this.customer=customer;
	}
	
}
