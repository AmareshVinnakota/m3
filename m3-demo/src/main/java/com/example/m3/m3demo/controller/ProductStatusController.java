package com.example.m3.m3demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.m3.m3demo.entity.ProductStatus;
import com.example.m3.m3demo.service.ProducStatusService;

import javassist.tools.rmi.ObjectNotFoundException;


@RestController
public class ProductStatusController {

	@Autowired
	private ProducStatusService producService;
	
	
	@GetMapping("/GetSoldStatus/{id}")
	public ProductStatus getRecord(@PathVariable Long id) throws ObjectNotFoundException {

		ProducStatusService productStatusServic;
		return producService.getRecordService(id);
		
		
	}
	
	@GetMapping("/UpdateStatus/{id}")
	public ProductStatus updateRecord(@PathVariable Long id) throws ObjectNotFoundException {
		
		return producService.updateService(id);
	}

}

