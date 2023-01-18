package com.group.model.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, String>{
	
	public User getUserByUserNameAndUserPassword(String username,String password);
	
}
