package com.project.service;

import java.math.BigInteger;
import org.springframework.http.ResponseEntity;
import com.project.entities.Users;

public interface UserService {

	public ResponseEntity<Users> createUser(Users newUser);
	public Users updateUser(Users newUser);
	public String deleteUser(BigInteger UserId);
	public Iterable<Users> displayAllUser();
	public ResponseEntity<Users> findUserById(BigInteger userId);
}

