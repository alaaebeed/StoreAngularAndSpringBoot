package com.alaa.product.category.controller;

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

import com.alaa.product.category.entity.ProductCategoryEntity;
import com.alaa.product.category.repo.CategoryRepo;
import com.alaa.product.cotroller.FileController;
import com.alaa.product.entity.ProductEntity;
import com.alaa.product.productRepo.ProductRepo;
import com.alaa.product.service.FileStorageService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:4200")
public class ProductCategoryController {
	
	private static final Logger logger = LoggerFactory.getLogger(FileController.class);

	@Autowired
	private FileStorageService fileStorageService;
	@Autowired
	CategoryRepo categoryRepo;
	
	@PostMapping("/addCategory")
	public ProductCategoryEntity uploadFile2(@RequestParam("file") MultipartFile file
		,ProductCategoryEntity reponse	) {
		String fileName = fileStorageService.storeFile(file);
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/downloadFile/")
				.path(fileName).toUriString();
		reponse.setIconUrl(fileDownloadUri);
		return categoryRepo.save(reponse);
	}
	
	  @GetMapping("/productscategory")
	  @CrossOrigin("http://localhost:4200")
	  public List<ProductCategoryEntity> getAllProducts() {
	  return categoryRepo.findAll();

	  }
	
}
