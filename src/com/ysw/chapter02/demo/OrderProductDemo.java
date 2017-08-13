package com.ysw.chapter02.demo;

import java.util.Date;
import java.util.Set;

import com.ysw.chapter02.dao.OrderDao;
import com.ysw.chapter02.dao.OrderItemDao;
import com.ysw.chapter02.dao.ProductDao;
import com.ysw.chapter02.dao.CustomerDao;
import com.ysw.chapter02.dao.IdCardDao;
import com.ysw.chapter02.pojos.Order;
import com.ysw.chapter02.pojos.OrderItem;
import com.ysw.chapter02.pojos.Product;
import com.ysw.chapter02.pojos.Customer;
import com.ysw.chapter02.pojos.IdCard;

public class OrderProductDemo {
	public static void main(String[] args){
		
		//addOrderCustomer();
		getProduct();
	}
	private static void addOrderCustomer(){
		System.out.println("-----添加1条IdCard记录-----");
		//实例化一个客户信息对象
		IdCard idCard = new IdCard("666666");
		//调用客户数据访问类CustomerDao中的addCustomer()方法将customer对象数据保存到数据库中
		IdCardDao.addIdCard(idCard);
		
		
		System.out.println("-----添加1条Customer记录-----");
		//实例化一个客户信息对象
		Customer customer = new Customer("Kenyon","k-mart","New York",idCard);
		//调用客户数据访问类CustomerDao中的addCustomer()方法将customer对象数据保存到数据库中
		CustomerDao.addCustomer(customer);
		
		System.out.println("-----添加2条Order记录-----");
		//创建两个Order对象
		Order order1=new Order("10",new Date(),customer);
		Order order2=new Order("11",new Date(),customer);
		//调用客户数据访问类OrderDao中的addOrder()方法将order1/order2对象数据保存到数据库中
		OrderDao.addOrder(order1);
		OrderDao.addOrder(order2);
		System.out.println("-----添加2条Product记录-----");
		//创建两个Product对象
		Product product1=new Product("Shoes",100.0,"高跟");
		Product product2=new Product("Hair",50.0,"假发");
		//调用客户数据访问类ProductDao中的addProduct()方法将product1/product2对象数据保存到数据库中
		ProductDao.addProduct(product1);
		ProductDao.addProduct(product2);
		System.out.println("-----添加2条OrderItem记录-----");
		//创建两个OrderItem对象
		OrderItem orderitem1=new OrderItem(order1,product1,20,100.0);
		OrderItem orderitem2=new OrderItem(order2,product2,10,25.99);
		//调用客户数据访问类OrderDao中的addOrder()方法将order1/order2对象数据保存到数据库中
		OrderItemDao.addOrderItem(orderitem1);
		OrderItemDao.addOrderItem(orderitem2);
		
		
	}
	private static void getProduct(){
		//根据id获取Order对象
		Order order=OrderDao.getOrder("402881e95db76898015db7689a6b0002");
		//获取OrderItem集合
		Set<OrderItem> orderitems=order.getOrderitems();
		//打印相关信息
		System.out.println("订单"+order.getCustomer().getUserName()+"的订单产品如下：");
		for(OrderItem orderitem:orderitems){
			Product product=orderitem.getProduct();
			System.out.println("名称:"+product.getName()+",");
			System.out.println("描述:"+product.getDescription()+",");
			System.out.println("下单日期:"+order.getDate());
			System.out.println();
		}
	}
}
