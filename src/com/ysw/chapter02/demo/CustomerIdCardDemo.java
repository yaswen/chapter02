package com.ysw.chapter02.demo;

import java.util.Date;
import java.util.Set;

import com.ysw.chapter02.dao.OrderDao;
import com.ysw.chapter02.dao.CustomerDao;
import com.ysw.chapter02.dao.IdCardDao;
import com.ysw.chapter02.pojos.Order;
import com.ysw.chapter02.pojos.Customer;
import com.ysw.chapter02.pojos.IdCard;

public class CustomerIdCardDemo {
	public static void main(String[] args){
		
		//addCustomerIdCard();
		getIdCard();
	}
	private static void addCustomerIdCard(){
		System.out.println("-----添加1条IdCard记录-----");
		//实例化一个客户信息对象
		IdCard idCard = new IdCard("210724");
		//调用客户数据访问类CustomerDao中的addCustomer()方法将customer对象数据保存到数据库中
		IdCardDao.addIdCard(idCard);
		
		System.out.println("-----添加1条Customer记录-----");
		//创建1个Customer对象
		Customer customer=new Customer("shiwen","100xunP","shanghai",idCard);
		
		//调用客户数据访问类CustomerDao中的addCustomer()方法将customer对象数据保存到数据库中
		CustomerDao.addCustomer(customer);
		
	}
	private static void getIdCard(){
		//根据id获取IdCard对象
		IdCard idCard = IdCardDao.getIdCard("402881e95d92dd24015d92dd25ba0000");
		//获取Customer
		Customer customer=idCard.getCustomer();
		//打印相关信息
			System.out.println("身份证"+idCard.getCardNo()+"的顾客信息如下：");
		
			System.out.println("ID:"+customer.getId()+",");
			System.out.println("姓名:"+customer.getUserName()+",");
			System.out.println("密码:"+customer.getPwd());
			System.out.println();
		
	}
}
