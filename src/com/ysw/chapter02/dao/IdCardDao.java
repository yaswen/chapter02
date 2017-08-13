package com.ysw.chapter02.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ysw.chapter02.pojos.Customer;
import com.ysw.chapter02.pojos.IdCard;
import com.ysw.chapter02.util.HibernateUtils;

public class IdCardDao {
	public static void addIdCard(IdCard idCard) {
		Session session = HibernateUtils.getSession();// 获取Session对象
		Transaction trans = session.beginTransaction();// 开启事务
		session.save(idCard);// 保存对象
		trans.commit();// 提交事务
		HibernateUtils.closeSession();// 关闭Session
	}

	// *根据id获取idCard*/
	public static IdCard getIdCard(String id) {
		//获取Session对象
		Session session = HibernateUtils.getSession();
		//根据id获取IdCard对象
		IdCard idCard =(IdCard)session.get(IdCard.class, id);
		return idCard;
	}
}
