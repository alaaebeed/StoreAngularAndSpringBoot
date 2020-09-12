package com.alaa.product.banner.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.alaa.product.banner.entity.ProductBannerEntity;
import com.alaa.product.banner.repo.ProductBannerRepo;
import com.alaa.product.category.entity.ProductCategoryEntity;
import com.alaa.product.category.repo.CategoryRepo;
import com.alaa.product.cotroller.FileController;
import com.alaa.product.service.FileStorageService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:4200")
public class ProductBannerController {
	
	private static final Logger logger = LoggerFactory.getLogger(FileController.class);
	@Autowired
	private FileStorageService fileStorageService;
	@Autowired
	ProductBannerRepo productBannerRepo;
	
	@PostMapping("/addBanner")
	public ProductBannerEntity uploadFile2(@RequestParam("file") MultipartFile file
			,ProductBannerEntity reponse	) {
			String fileName = fileStorageService.storeFile(file);
			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
					.path("/downloadFile/")
					.path(fileName).toUriString();
			reponse.setBannerUrl(fileDownloadUri);
			return productBannerRepo.save(reponse);
		}
	
	  @GetMapping("/getBanner")
	  @CrossOrigin("http://localhost:4200")
	  public List<ProductBannerEntity> getAllProducts() {
	  return productBannerRepo.findAll();

	  }


}
