package com.daniel.model;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @Column(length = 20)
    String id;    

    @Column(length = 20, nullable = false)
    String name;

    @Column(length = 20, nullable = false)
    String password;
    
    @Column(length = 20)
    String email;    
    
    User(){}
    
    public User(final String id, final String name, final String password, final String email)
    {
    	this.setId(id);
    	this.setName(name);
    	this.setPassword(password);
    	this.setEmail(email);
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + "]";
	}
}



