package com.ysw.chapter02.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ysw.chapter02.pojos.Customer;
import com.ysw.chapter02.pojos.Order;
import com.ysw.chapter02.util.HibernateUtils;

public class OrderDao {
	public static void addOrder(Order order){
		Session session = HibernateUtils.getSession();//获取Session对象
		Transaction trans = session.beginTransaction();//开启事务
		session.save(order);//保存对象
		trans.commit();//提交事务
		HibernateUtils.closeSession();//关闭Session
	}
	//*获取订单*/
		public static Order getOrder(String id){
			//获取Session对象
			Session session = HibernateUtils.getSession();
			//根据id获取Customer对象
			Order order=(Order)session.get(Order.class, id);
			return order;
		}
}
