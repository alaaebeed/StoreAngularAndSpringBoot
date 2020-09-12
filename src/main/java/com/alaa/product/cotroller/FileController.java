package com.alaa.product.cotroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.alaa.product.entity.ProductEntity;
import com.alaa.product.exception.IdException;
import com.alaa.product.productRepo.ProductRepo;
import com.alaa.product.service.FileStorageService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:4200")

public class FileController {

	private static final Logger logger = LoggerFactory.getLogger(FileController.class);

	@Autowired
	private FileStorageService fileStorageService;
	@Autowired
	ProductRepo productRepo;

	@PostMapping("/addproduct")
	public ProductEntity uploadFile2(@RequestParam("file") MultipartFile file
		,ProductEntity reponse	) {
		String fileName = fileStorageService.storeFile(file);
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/downloadFile/")
				.path(fileName).toUriString();
		reponse.setFileDownloadUri(fileDownloadUri);
		return productRepo.save(reponse);
	}

	  @GetMapping("/products")
	  @CrossOrigin("http://localhost:4200")
	  public List<ProductEntity> getAllProducts() {
	  return productRepo.findAll();

	  }
	  


	  @GetMapping("/products/{id}")
	    public ProductEntity getProducteById(@PathVariable(value = "id") Long id) throws IdException {
	        return productRepo.findById(id)
	                .orElseThrow(() -> new RuntimeException("Product Id Not Found " + id));
	    }
	  
	    @GetMapping("/downloadFile/{fileName:.+}")
	    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
	        // Load file as Resource
	        Resource resource = fileStorageService.loadFileAsResource(fileName);

	        // Try to determine file's content type
	        String contentType = null;
	        try {
	            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
	        } catch (IOException ex) {
	            logger.info("Could not determine file type.");
	        }

	        // Fallback to the default content type if type could not be determined
	        if (contentType == null) {
	            contentType = "application/octet-stream";
	        }

	        return ResponseEntity.ok()
	                .contentType(MediaType.parseMediaType(contentType))
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
	                .body(resource);
	    }
	  
	 
	    }

