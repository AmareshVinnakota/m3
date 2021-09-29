package com.example.m3.m3demo.entity;

public class Product {
	
	private Long pid;
	private String pname;
	private Long price;

	public Product() {
		super();
	}

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

	public Product(Long pid, String pname, Long price) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
	}
	

	
	
}
