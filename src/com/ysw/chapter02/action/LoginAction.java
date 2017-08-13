package com.ysw.chapter02.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 调用业务逻辑方法，控制业务流程
	 */
	public String execute(){
		/**System.out.println("-- --登录的用户信息-- --");
		System.out.println("用户名："+ userName);
		System.out.println("密码："+ password);
		*/
		if(userName.startsWith("shiwen")&&password.length()>=6){
			//返回成功页面
			return "ok";
		}else{
			//返回失败页面
			return "error";
		}
	}
	public void validate(){
		if(this.userName == null || this.userName.equals("")){
			this.addFieldError("userName", "用户名不能为空");
			System.out.println("用户名为空");
		}
	}
}
