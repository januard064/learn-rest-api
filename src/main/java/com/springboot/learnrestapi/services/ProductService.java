package com.springboot.learnrestapi.services;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.learnrestapi.model.entities.Product;
import com.springboot.learnrestapi.model.repos.ProductRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepo productRepo;

	public Product save(Product product) {
		return productRepo.save(product);
//		save merupakan fungsi dari class SpringData yang diturunkan ke interface productRepo yang akan otomatis detect 
//		jika terdapat id yang sama pada database maka akan update jika belum ada makan create baru
	}

	public Product findOne(Long id) {

		Optional<Product> product = productRepo.findById(id);

		if (!product.isPresent()) {
			return null;
		}

		return product.get();
	}

	public Iterable<Product> findAll() {
		return productRepo.findAll();
	}

	public void removeOne(Long id) {
		productRepo.deleteById(id);
	}

	public List<Product> findByName(String name) {
		return productRepo.findByNameContains(name);
	}

}
