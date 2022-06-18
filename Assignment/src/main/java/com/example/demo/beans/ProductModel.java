package com.example.demo.beans;

import java.util.Date;

import com.example.demo.entity.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {
	private int id;
	private int price;
	private String img;
	private String size;
	private String color;
	private int count;
	private String name;
	private Date createdDate;	
	private Category category;
	
}
