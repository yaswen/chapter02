package com.ysw.chapter02.action;

import com.opensymphony.xwork2.ActionSupport;
public class ProductAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int productId;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String edit(){
		System.out.println("编辑商品"+productId);
		return "edit";
	}
	
	public String del(){
		System.out.println("删除商品"+productId);
		return "del";
	}
}
