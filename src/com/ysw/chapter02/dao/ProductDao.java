package com.ysw.chapter02.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;


import com.ysw.chapter02.pojos.Product;
import com.ysw.chapter02.util.HibernateUtils;

public class ProductDao {
	public static void addProduct(Product product){
		Session session = HibernateUtils.getSession();//获取Session对象
		Transaction trans = session.beginTransaction();//开启事务
		session.save(product);//保存对象
		trans.commit();//提交事务
		HibernateUtils.closeSession();//关闭Session
	}
}
