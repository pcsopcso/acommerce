package com.daniel.model;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @Column(length = 40)
    String id;    

    @Column(length = 40, nullable = false)
    String name;

    @Column(length = 40, nullable = false)
    String password;

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
}



