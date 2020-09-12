package com.alaa.product.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import com.alaa.product.category.entity.ProductCategoryEntity;

import lombok.Data;

@Entity
@Data
public class ProductEntity {
	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne
	@JoinColumn(name="category_id" , nullable=false )
	private ProductCategoryEntity ProductCategory ;
	
	private String fileDownloadUri;
	private String productName ;
	private float productPrice ;
	private String productDesc ;
	private int productStock ;
	
	
	
	
	public ProductEntity() {
	}

	
	
	
	public ProductEntity(ProductCategoryEntity ProductCategory, String fileDownloadUri, String productName,
			float productPrice, String productDesc, int productStock) {
		this.ProductCategory = ProductCategory;
		this.fileDownloadUri = fileDownloadUri;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDesc = productDesc;
		this.productStock = productStock;
	}


	

	public String getProductCategory() {
		return ProductCategory.getCategory();
	}


	public void setProductCategory(ProductCategoryEntity ProductCategory) {
		this.ProductCategory = ProductCategory;
	}




	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFileDownloadUri() {
		return fileDownloadUri;
	}

	public void setFileDownloadUri(String fileDownloadUri) {
		this.fileDownloadUri = fileDownloadUri;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public int getProductStock() {
		return productStock;
	}

	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}


	


	

}
