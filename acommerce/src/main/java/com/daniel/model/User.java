package com.daniel.model;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @Column(length = 20)
    String username;    

    @Column(length = 20, nullable = false)
    String name;

    @Column(length = 20, nullable = false)
    String password;
    
    @Column(length = 20)
    String email;
    
    @Column
    int enabled;
    
	User(){}
    
    public User(final String username, final String name, final String password, final String email, int enabled)
    {
    	this.setUsername(username);
    	this.setName(name);
    	this.setPassword(password);
    	this.setEmail(email);
    	this.setEnabled(enabled);
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
	
    public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	
	@Override
	public String toString() {
		return "Customer [username=" + username + ", name=" + name + ", password=" + password + ", email=" + email + ", enabled=" + enabled + "]";
	}
}



