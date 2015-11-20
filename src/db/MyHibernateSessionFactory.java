package db;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class MyHibernateSessionFactory {

	private static SessionFactory sessionFactory;
	//构造方法私有，保证单例模式
	private MyHibernateSessionFactory(){
		
	}
	
	//公有的静态方法获取对象
	public static SessionFactory getSessionFactory(){
		if(sessionFactory==null){
			Configuration config=new Configuration().configure();
			ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
			sessionFactory=config.buildSessionFactory(serviceRegistry);
			return sessionFactory;
		}else{
			return sessionFactory;
		}
	}
}
