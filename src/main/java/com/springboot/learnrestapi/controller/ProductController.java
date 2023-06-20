package com.springboot.learnrestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.learnrestapi.dto.ResponseData;
import com.springboot.learnrestapi.model.entities.Product;
import com.springboot.learnrestapi.services.ProductService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;

//	@PostMapping
//	public Product create(@Valid @RequestBody Product product, Errors errors) {
//		if (errors.hasErrors()) {
//			for (ObjectError error : errors.getAllErrors()) {
//				System.out.println("val = " + error.getDefaultMessage());
//			}
//			throw new RuntimeException("Validation Error");
//		}
//		return productService.save(product);
//	}

	@PostMapping
	public ResponseEntity<ResponseData<Product>> create(@Valid @RequestBody Product product, Errors errors) {

		ResponseData<Product> responseData = new ResponseData<>();

		if (errors.hasErrors()) {
			for (ObjectError error : errors.getAllErrors()) {
				responseData.getMessages().add(error.getDefaultMessage());
			}
			responseData.setStatus(false);
			responseData.setPayload(null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);

		}
		responseData.setStatus(true);
		responseData.setPayload(productService.save(product));
		return ResponseEntity.ok(responseData);
	}

	@GetMapping
	public Iterable<Product> findAll() {
		return productService.findAll();
	}

	@GetMapping("/{id}")
	public Product findOne(@PathVariable("id") Long id) {
		return productService.findOne(id);
	}

	@PutMapping
	public Product update(@RequestBody Product product) {
		return productService.save(product);
	}

	@DeleteMapping("/{id}")
	public void removeOne(@PathVariable("id") Long id) {
		productService.removeOne(id);
	}

}
