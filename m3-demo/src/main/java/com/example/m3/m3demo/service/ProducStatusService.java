package com.example.m3.m3demo.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.m3.m3demo.entity.Product;
import com.example.m3.m3demo.entity.ProductStatus;

import com.example.m3.m3demo.repository.ProductStatusRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ProducStatusService {

	private static final String PRODUCT_SERVICE="productService";
	@Autowired
	private ProductStatusRepository productStatusRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@CircuitBreaker(name =PRODUCT_SERVICE,fallbackMethod = "productfallback" )
	public ProductStatus getRecordService(Long id) throws ObjectNotFoundException {
		// TODO Auto-generated method stub
		Product pr = restTemplate.getForObject(
		          "http://127.0.0.1:9001/GetProductInfo/1",
		          Product.class);
		
		if(pr==null) {
			throw new ObjectNotFoundException(null);
		}
		else {
			ProductStatus pk=new ProductStatus(pr.getPid(),pr.getPname(),pr.getPrice(),false);
			

			return productStatusRepository.save(pk);
			
		}
		
		
	}
	

	@CircuitBreaker(name =PRODUCT_SERVICE,fallbackMethod = "productfallback2" )
	public ProductStatus updateService(Long id) throws ObjectNotFoundException {
		// TODO Auto-generated method stub
			
		Product pr = restTemplate.getForObject(
		          "http://127.0.0.1:9001/GetProductInfo/1",
		          Product.class);
			if(pr==null) {
				throw new ObjectNotFoundException(null);
			}
			else {
				ProductStatus pk=new ProductStatus(pr.getPid(),pr.getPname(),pr.getPrice(),true);
				

				return productStatusRepository.save(pk);
				
			}
			
			
			
			}

	@CircuitBreaker(name =PRODUCT_SERVICE,fallbackMethod = "productfallback1" )
	public List<ProductStatus> getAll() {
		// TODO Auto-generated method stub
		return productStatusRepository.findAll();
	}

	
	public ProductStatus productfallback(Exception e) {
		return new ProductStatus();
	}
	public  List<ProductStatus> productfallback1(Exception e) {
		return Arrays.asList(new ProductStatus());
	}
	public ProductStatus productfallback2(Long id,Exception e) {
		return new ProductStatus();
	}
}
