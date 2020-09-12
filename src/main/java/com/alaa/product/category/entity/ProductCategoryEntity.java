package com.alaa.product.category.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.alaa.product.entity.ProductEntity;


@Entity
public class ProductCategoryEntity {
	@Id
	@GeneratedValue
	private int id;
	private String category;
	private String iconUrl ;
	
	@OneToMany(cascade=CascadeType.ALL , mappedBy="ProductCategory")
	private Set<ProductEntity> products ;
	
	public ProductCategoryEntity() {
		
	}

	public ProductCategoryEntity(String category) {
	
		this.category = category;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductEntity> products) {
		this.products = products;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	@Override
	public String toString() {
		return "ProductCategoryEntity [id=" + id + ", category=" + category + ", iconUrl=" + iconUrl + ", products="
				+ products + "]";
	}

	
	
	
	
	
}
