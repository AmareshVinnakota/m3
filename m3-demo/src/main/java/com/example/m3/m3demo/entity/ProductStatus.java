package com.example.m3.m3demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductStatus {

	@Id
	private Long pid;
	private String pname;
	private Long price;
	private Boolean sold;
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Boolean getSold() {
		return sold;
	}
	public void setSold(Boolean sold) {
		this.sold = sold;
	}
	public ProductStatus() {
		super();
	}
	public ProductStatus(Long pid, String pname, Long price, Boolean sold) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.sold = sold;
	}
	
		
}
