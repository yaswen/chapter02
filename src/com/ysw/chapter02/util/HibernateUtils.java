package com.ysw.chapter02.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateUtils {
	private static String CONFIG_FILE_LOCATION ="/hibernate.cfg.xml";
	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	private static Configuration configuration = new Configuration();
	private static StandardServiceRegistryBuilder standardServiceRegistryBuilder =
			new StandardServiceRegistryBuilder();
	private static SessionFactory sessionFactory;
	private static String configFile = CONFIG_FILE_LOCATION;
	/*静态代码块创建SessionFactory*/
	static{
		try{
			configuration.configure(configFile);
			//Hibernate4.3创建SessionFactory的方式
			standardServiceRegistryBuilder.applySettings(configuration.getProperties());
			sessionFactory =configuration.buildSessionFactory(standardServiceRegistryBuilder.build());
			
		}catch(Exception e){
			System.err.println("% % % % Error Creating SessionFactory % % % %");
			e.printStackTrace();
		}
	}
	
	private HibernateUtils(){
	}
	/*
	 * 返回ThreadLocal中的session实例
	 */
	public static Session getSession() throws HibernateException{
		Session session = (Session) threadLocal.get();
		if(session == null || !session.isOpen()){
			if(sessionFactory == null){
				rebuildSessionFactory();
			}
			session=(sessionFactory!=null)?sessionFactory.openSession():null;
			threadLocal.set(session);
		}
		return session;
	}
	/*
	 * 返回Hibernate的SessionFactory
	 */
	public static void rebuildSessionFactory(){
		try{
			configuration.configure(configFile);
			sessionFactory=configuration.buildSessionFactory(standardServiceRegistryBuilder.build());
		}catch(Exception e){
			System.err.println("% % % % Error Creating SessionFactory % % % %");
			e.printStackTrace();
		}
	}
	/*
	 * 关闭Session实例并且把ThreadLocal中的副本清除
	 */
	public static void closeSession() throws HibernateException{
		Session session = (Session) threadLocal.get();
		threadLocal.set(null);
		if(session!=null){
			session.close();
		}
	}
	/*
	 * 返回SessionFactory
	 */
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	public static void setConfigFile(String configFile){
		HibernateUtils.configFile=configFile;
		sessionFactory=null;
	}
	public static Configuration getConfiguration(){
		return configuration;
	}
}
//上述代码提供了获取SessionFactory，获取Session和关闭Session等操作的静态方法。
//该工具类定义后，Hibernate应用中只需直接调用该类中的相应方法即可。