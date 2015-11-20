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

		// ����һ�����ö���
		Configuration config = new Configuration().configure();
		config.addClass(Students.class);
		config.addClass(Users.class);
		// ��������ע�����
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(config.getProperties());
		ServiceRegistry registry = builder.build();
		// �����Ự��������
		// sessionFactory =config.buildSessionFactory(registry);
		// //�����Ự����
		// session=sessionFactory.openSession();
		// //��������
		// transaction=session.beginTransaction();
		// Students s=new Students("20151111","������","nan",new Date(),"�䵱");
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
		// �����Ự��������
		SessionFactory sessionFactory = config.buildSessionFactory(registry);
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Students s1 = new Students("S0000001", "xxx", "��", new Date(), "wudang");
		Students s2 = new Students("S0000002", "yyy", "��", new Date(), "wudang");
		Students s3 = new Students("S0000003", "zzz", "��", new Date(), "wudang");
		session.save(s1);
		session.save(s2);
		session.save(s3);

		tx.commit();
		sessionFactory.close();
	}

}
