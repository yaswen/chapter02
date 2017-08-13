package com.ysw.chapter02.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ysw.chapter02.pojos.Customer;
import com.ysw.chapter02.pojos.Order;
import com.ysw.chapter02.util.HibernateUtils;
public class CustomerDao {
	public static void addCustomer(Customer customer){
		Session session = HibernateUtils.getSession();//获取Session对象
		Transaction trans = session.beginTransaction();//开启事务
		session.save(customer);//保存对象
		trans.commit();//提交事务
		HibernateUtils.closeSession();//关闭Session
	}
	//*获取客户*/
	public static Customer getCustomer(String id){
		//获取Session对象
		Session session = HibernateUtils.getSession();
		//根据id获取Customer对象
		Customer customer=(Customer)session.get(Customer.class, id);
		return customer;
	}
}
