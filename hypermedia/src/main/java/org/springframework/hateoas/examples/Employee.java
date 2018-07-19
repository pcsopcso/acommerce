/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.hateoas.examples;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.springframework.hateoas.Identifiable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Daniel
 */
@Data
@Entity
@NoArgsConstructor
class Employee implements Identifiable<Long> {

	@Id @GeneratedValue
	private Long id;


	private String name;
	private String role;

	/**
	 * To break the recursive, bi-directional relationship, don't serialize {@literal manager}.
	 */
	//@JsonIgnore
	@OneToOne
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY) 
	private Manager manager;
	
	protected Employee() {}
	
	Employee(String name, String role, Manager manager) {

		this.setName(name);
		this.setRole(role);
		this.manager = manager;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Long getId() {
		return this.id;
	}
	public Optional<Long> getOptionalId() {
		return Optional.ofNullable(this.id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
