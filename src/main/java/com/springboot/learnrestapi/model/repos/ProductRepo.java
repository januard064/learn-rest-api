package com.springboot.learnrestapi.model.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springboot.learnrestapi.model.entities.Product;

public interface ProductRepo extends CrudRepository<Product, Long> {
	
//	custom function defenition yang gak ada dari CrudRepository
	
	//	derived query function -> spring data tau nama fungsi kita dan membuat query on the fly
	List<Product> findByNameContains(String name);
}
