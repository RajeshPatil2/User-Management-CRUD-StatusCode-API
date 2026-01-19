package com.example.statuscode.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.statuscode.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> 
{
	System.out.println("Repo");
}
