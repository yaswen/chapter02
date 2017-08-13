package com.ysw.chapter02.demo;

import java.util.Date;
import java.util.Set;

import com.ysw.chapter02.dao.OrderDao;
import com.ysw.chapter02.dao.CustomerDao;
import com.ysw.chapter02.dao.IdCardDao;
import com.ysw.chapter02.pojos.Order;
import com.ysw.chapter02.pojos.Customer;
import com.ysw.chapter02.pojos.IdCard;

public class OrderCustomerDemo {
	public static void main(String[] args){
		
		//addOrderCustomer();
		//getCustomer();
		addCustomerWithCascade();
	}
	private static void addOrderCustomer(){
		System.out.println("-----添加1条Customer记录-----");
		//实例化一个客户信息对象
		Customer customer = new Customer("zhangsanfeng","1234567","上海市");
		//调用客户数据访问类CustomerDao中的addCustomer()方法将customer对象数据保存到数据库中
		CustomerDao.addCustomer(customer);
		
		System.out.println("-----添加2条Order记录-----");
		//创建两个Order对象
		Order order1=new Order("3",new Date(),customer);
		Order order2=new Order("4",new Date(),customer);
		//调用客户数据访问类OrderDao中的addOrder()方法将order1/order2对象数据保存到数据库中
		OrderDao.addOrder(order1);
		OrderDao.addOrder(order2);
	}
	private static void getCustomer(){
		//根据id获取Customer对象
		Customer customer = CustomerDao.getCustomer("402881e95d75050b015d750521f60000");
		//获取Order集合
		Set<Order> orders=customer.getOrders();
		//打印相关信息
		System.out.println("客户"+customer.getUserName()+"的订单如下：");
		for(Order order:orders){
			System.out.println("ID:"+order.getId()+",");
			System.out.println("订单编号:"+order.getOrderNo()+",");
			System.out.println("下单日期:"+order.getDate());
			System.out.println();
		}
	}
	private static void addCustomerWithCascade(){
		IdCard idCard = new IdCard("276600");
		//调用客户数据访问类CustomerDao中的addCustomer()方法将customer对象数据保存到数据库中
		IdCardDao.addIdCard(idCard);
		//实例化一个客户信息对象
		Customer customer=new Customer("max","0803","嵊泗",idCard);
		//实例化一个订单信息对象
		Order order1=new Order("57",new Date(),customer);
		//建立关联关系，实现级联保存
		customer.getOrders().add(order1);
		//order对象必须关联customer对象，inverse才起作用
		order1.setCustomer(customer);
		System.out.println("------级联保存客户和订单------");
		//调用客户数据访问类CustomerDao中的addCustomer()方法将customer对象数据保存到数据库中
		CustomerDao.addCustomer(customer);
	}
}