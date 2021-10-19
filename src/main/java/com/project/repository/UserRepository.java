package com.project.repository;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import com.project.entities.Users;

public interface UserRepository extends CrudRepository<Users, BigInteger>{

}
