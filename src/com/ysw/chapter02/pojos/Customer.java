package com.ysw.chapter02.pojos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Customer implements Serializable{
	private String id;
	private String userName;
	private String pwd;
	private String address;
	/*订单集合orders*/
	private Set<Order> orders=new HashSet<Order>(0);
	/*增加身份证对象*/
	private IdCard idCard;
	
	public IdCard getIdCard() {
		return idCard;
	}
	public void setIdCard(IdCard idCard) {
		this.idCard = idCard;
	}
	public Set<Order> getOrders(){
		return orders;
	}
	public void setOrders(Set<Order> orders){
		this.orders=orders;
	}
	public Customer(){
		super();
	}
	public Customer(String userName,String pwd,String address){
		this.userName=userName;
		this.pwd=pwd;
		this.address=address;
	}
	/**带IDCard构造类*/
	public Customer(String userName,String pwd,String address,IdCard idCard){
		this.userName=userName;
		this.pwd=pwd;
		this.address=address;
		this.idCard=idCard;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
