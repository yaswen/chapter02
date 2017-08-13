package com.ysw.chapter02.action;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ClickNumAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	public String execute(){
		ActionContext ctx=ActionContext.getContext();
		Integer num = (Integer)ctx.getApplication().get("num");
			if(num == null){
				num =1;
				}else{
					num++;
				}
			ctx.getApplication().put("num",num);
			return SUCCESS;
			
	}
}
