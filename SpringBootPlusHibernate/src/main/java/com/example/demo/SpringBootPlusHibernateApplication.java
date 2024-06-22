package com.example.demo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.example.entity.Teacher;

@SpringBootApplication
//@EntityScan("com.example.entity")
public class SpringBootPlusHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPlusHibernateApplication.class, args);
		
		SessionFactory factory= new Configuration()
				               .configure("hibernate.cfg.xml")
				               .addAnnotatedClass(Teacher.class).buildSessionFactory();
		
		Session session=factory.openSession();
		
		try {
			
			Teacher thr=new Teacher();
			thr.setId(12);
			thr.setFirstname("ayush");
			thr.setLastname("goyal");
			thr.setSid(6);
			session.beginTransaction();
			session.save(thr);
			session.getTransaction().commit();
			
		}
		finally {
			session.close();
		}
		
	}

}
