package com.keyce.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.keyce.demo.model.UserModel;

public interface UserRepository extends CrudRepository<UserModel,Long> {
	
	public List<UserModel> findByName(String name);

}
