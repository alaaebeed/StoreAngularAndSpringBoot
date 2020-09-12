package com.alaa.product.banner.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ProductBannerEntity {
	
	@Id
	@GeneratedValue
	int id ; 
	String bannerLink ;
	String bannerUrl ;
	
	
	public ProductBannerEntity() {
		
	}

	public ProductBannerEntity(String bannerLink, String bannerUrl) {
		
		this.bannerLink = bannerLink;
		this.bannerUrl = bannerUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBannerLink() {
		return bannerLink;
	}

	public void setBannerLink(String bannerLink) {
		this.bannerLink = bannerLink;
	}

	public String getBannerUrl() {
		return bannerUrl;
	}

	public void setBannerUrl(String bannerUrl) {
		this.bannerUrl = bannerUrl;
	}

	@Override
	public String toString() {
		return "ProductBannerEntity [id=" + id + ", bannerLink=" + bannerLink + ", bannerUrl=" + bannerUrl + "]";
	}
	
	
	
	

}
