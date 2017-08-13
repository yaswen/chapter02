package com.ysw.chapter02.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ysw.chapter02.pojos.OrderItem;
import com.ysw.chapter02.util.HibernateUtils;

public class OrderItemDao {
	public static void addOrderItem(OrderItem orderitem){
		Session session = HibernateUtils.getSession();//获取Session对象
		Transaction trans = session.beginTransaction();//开启事务
		session.save(orderitem);//保存对象
		trans.commit();//提交事务
		HibernateUtils.closeSession();//关闭Session
	}
}
