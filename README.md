# Simple store project 

## full stack using angular in frontend and springboot in backend :

### note : you should change app id and secrent id if you will use OAUTH 


Run this project by this command : `mvn clean spring-boot:run`

Scroll down for screen shots 

## Project Features :

**1- Add Banners** 

**2- Add categories and icons **

**3- Add products with images , desc , price **

**4- Add Products to cart **

**5-check out**

## APIs :


> POST /api/v1/addproduct

### request body 

1- file -> type file 
2- productName 
3- productPrice
4- productDesc
5- productStock


> GET  /api/v1/products

> GET api/v1/products/{id}

> GET api/v1/products/downloadFile/{fileName:.+}

> POST  api/v1/addBanner

### request body 

1- file -> file 
2- url

> GET  api/v1/getBanner

> POST  api/v1/addCategory

### request body 

1- file -> file 
2- name

> GET  api/v1/productscategory


# Screen Shots 

![alt text](https://i.ibb.co/CKskbGY/index.jpg)
![alt text](https://i.ibb.co/VY0h1WL/index2.jpg)
![alt text](https://i.ibb.co/c3Ps94Q/index3.jpg)


## Further Updates 

# fix bugs in cart 
# add jwt 
# add API's for delete and update and secure it 
# create API for order 
# create user profile 


