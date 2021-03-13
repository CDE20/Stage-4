package com.example.microservices.spring.learn.springLearnuser.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
	
	private static int usersCount = 3;
	
	static {
		User u1 = new User(1,"ABC",new Date());
		User u2 = new User(2,"EFG",new Date());
		User u3 = new User(3,"HIJ",new Date());
		users.add(u1);
		users.add(u2);
		users.add(u3);
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User findById(int id) {
		for(User u : users) {
			if(u.getId()==id) {
				return u;
			}
		}
		return null;
	}
	
	public User save(User user) {
		if (user.getId() == 0) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}
	
	public User deleteById(int id) {
		Iterator<User> itr = users.iterator();
		User u=null;
		while(itr.hasNext()) {
			u=itr.next();
			if(u.getId()==id) {
				itr.remove();
			}
		}
		return u;
	}

}
