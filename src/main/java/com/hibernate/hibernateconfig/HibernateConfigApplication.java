package com.hibernate.hibernateconfig;

import com.hibernate.hibernateconfig.dao.UserDao;
import com.hibernate.hibernateconfig.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class HibernateConfigApplication implements CommandLineRunner {

	@Autowired
	private UserDao userDao;

	public static void main(String[] args) {
		SpringApplication.run(HibernateConfigApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		User user = getUser();
		System.out.println("TEST");
		userDao.createUser(user);
	}

	private User getUser(){
		User user = new User();
		user.setFirstName("Satya");
		user.setLastName("Awasthi");
		user.setDate(new Date());
		return user;
	}
}
