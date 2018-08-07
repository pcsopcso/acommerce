package com.daniel.model;

import javax.persistence.*;

@Entity
@Table(name = "Product")
public class Product {

    @Id
    @Column(nullable = false)
    Long id;    

    @Column(length = 50, nullable = false)
    String productname;

	@Column(nullable = false)
    Long price;
    
	@Column(length = 200)
    String description;
	
	Product(){}
    
    public Product(final Long id, final String productname, final Long price, final String description)
    {
    	this.setId(id);
    	this.setProductname(productname);
    	this.setPrice(price);
    	this.setDescription(description);
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}
	
	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}
    
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", productname=" + productname + ", price=" + price + ", description=" + description + "]";
	}
}



