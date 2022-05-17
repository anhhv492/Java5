package com.example.demo.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Nationalized;

@Entity
@Table
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	@Nationalized
	private String name;
	@Column
	private BigDecimal price;
	@Column
	private Date prDate;
	@Column
	private ProductType type;
	public Product() {
	}
	
	public Product(Long id, String name, BigDecimal price, Date prDate, ProductType type) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.prDate = prDate;
		this.type = type;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Date getPrDate() {
		return prDate;
	}
	public void setPrDate(Date prDate) {
		this.prDate = prDate;
	}
	public ProductType getType() {
		return type;
	}
	public void setType(ProductType type) {
		this.type = type;
	}
	
}
