package com.ysw.chapter02.pojos;

public class IdCard {
	/*主键ID*/
	private String id;
	/*身份证编号*/
	private String cardNo;
	private Customer customer=new Customer();
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public IdCard(){
		super();
	}
	public IdCard(String cardNo){
		this.cardNo=cardNo;
	}
	
}
