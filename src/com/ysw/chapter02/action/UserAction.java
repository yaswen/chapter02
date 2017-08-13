package com.ysw.chapter02.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction  extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String userName;
	private String address;
	private String telephone;
	private String email;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String execute() throws Exception{
		if (userName.equals("shiwen")) {
            ActionContext.getContext().getSession().put("user", userName);
            return "success";
        }else{
            return "error";
        }
	}
/**	
 * 	public void validate(){
		if(this.userName.equals("1")){
			this.addFieldError("userName", "手机号不能为空");
			System.out.println("用户名为空");
		}
	}
*/
}
