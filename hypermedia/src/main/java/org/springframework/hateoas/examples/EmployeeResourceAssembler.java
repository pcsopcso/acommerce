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

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.SimpleIdentifiableResourceAssembler;
import org.springframework.stereotype.Component;

/**
 * @author Daniel
 */
@Component
class EmployeeResourceAssembler extends SimpleIdentifiableResourceAssembler<Employee> {

	EmployeeResourceAssembler() {
		super(EmployeeController.class);
	}

	/**
	 * Define links to add to every {@link Resource}.
	 *
	 * @param resource
	 */
	@Override
	protected void addLinks(Resource<Employee> resource) {

		/**
		 * Add some custom links to the default ones provided.
		 *
		 * NOTE: To replace default links, don't invoke {@literal super.addLinks()}.
		 */
		super.addLinks(resource);

		resource.getContent().getId()
			.ifPresent(id -> {
				// Add additional links
				resource.add(linkTo(methodOn(ManagerController.class).findManager(id)).withRel("manager"));
				resource.add(linkTo(methodOn(EmployeeController.class).findDetailedEmployee(id)).withRel("detailed"));
			});
	}

	/**
	 * Define links to add to {@link Resources} collection.
	 *
	 * @param resources
	 */
	@Override
	protected void addLinks(Resources<Resource<Employee>> resources) {
		
		super.addLinks(resources);

		resources.add(linkTo(methodOn(EmployeeController.class).findAllDetailedEmployees()).withRel("detailedEmployees"));
		resources.add(linkTo(methodOn(ManagerController.class).findAll()).withRel("managers"));
		resources.add(linkTo(methodOn(RootController.class).root()).withRel("root"));
	}
}
