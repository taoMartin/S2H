package entity;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

public class TestStudents1 {
	// private SessionFactory sessionFactory;
	// private Session session;
	// private Transaction transaction;
	@Test
	public void testSchemaExport() {

		// 创建一个配置对象
		Configuration config = new Configuration().configure();
		config.addClass(Students.class);
		config.addClass(Users.class);
		// 创建服务注册对象
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(config.getProperties());
		ServiceRegistry registry = builder.build();
		// 创建会话工厂对象
		// sessionFactory =config.buildSessionFactory(registry);
		// //创建会话对象
		// session=sessionFactory.openSession();
		// //开启事务
		// transaction=session.beginTransaction();
		// Students s=new Students("20151111","张三丰","nan",new Date(),"武当");
		//
		// session.save(s);
		// transaction.commit();
		// MetadataImplementor metadata = (MetadataImplementor) new
		// MetadataSources( registry ).buildMetadata();
		// new SchemaExport(metadata).create(true, true);

	}

	@Test
	public void testSaveStudents() {
		Configuration config = new Configuration().configure();
		config.addClass(Students.class);
		config.addClass(Users.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(config.getProperties());
		StandardServiceRegistryImpl registry = (StandardServiceRegistryImpl) builder.build();
		// 创建会话工厂对象
		SessionFactory sessionFactory = config.buildSessionFactory(registry);
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Students s1 = new Students("S0000001", "xxx", "男", new Date(), "wudang");
		Students s2 = new Students("S0000002", "yyy", "男", new Date(), "wudang");
		Students s3 = new Students("S0000003", "zzz", "男", new Date(), "wudang");
		session.save(s1);
		session.save(s2);
		session.save(s3);

		tx.commit();
		sessionFactory.close();
	}

}
