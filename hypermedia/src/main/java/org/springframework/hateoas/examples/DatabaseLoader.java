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

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author Daniel
 */
@Component
class DatabaseLoader {

	/*@Bean
	CommandLineRunner initDatabase(EmployeeRepository employeeRepository, ManagerRepository managerRepository) {
		return args -> {*/
			/*
			 * Gather Gandalf's team
			 */
	/*
			Manager daniel = managerRepository.save(new Manager("Daniel"));

			Employee mavel1 = employeeRepository.save(new Employee("토니 스타크", "아이언맨", daniel));
			Employee mavel2 = employeeRepository.save(new Employee("브루스 배너", "헐크", daniel));
			Employee mavel3 = employeeRepository.save(new Employee("스콧", "앤트맨", daniel));


			daniel.setEmployees(Arrays.asList(mavel1, mavel2,mavel3));
			managerRepository.save(daniel);

			/*
			 * Put together Saruman's team
			 */
	/*
			Manager catain = managerRepository.save(new Manager("Catain America"));

			Employee mavel4 = employeeRepository.save(new Employee("토르", "천둥의신", catain));
			Employee mavel5 = employeeRepository.save(new Employee("나타샤", "블랙위도우", catain));
			Employee mavel6 = employeeRepository.save(new Employee("클린트 바튼", "호크아이", catain));

			catain.setEmployees(Arrays.asList(mavel4, mavel5, mavel6));

			managerRepository.save(catain);
		};
	}
	*/
	@Bean
    CommandLineRunner runner(EmployeeRepository employeeRepository, ManagerRepository managerRepository) {
        return args -> {
        	Manager daniel = managerRepository.save(new Manager("Daniel"));
            Arrays.asList(
                    new Employee("토니 스타크", "아이언맨", daniel),
                    new Employee("브루스 배너", "헐크", daniel),
                    new Employee("스콧", "앤트맨", daniel)
            )
            .forEach(account -> employeeRepository.save(account));
            employeeRepository.findAll().forEach(System.out::println);
            managerRepository.save(daniel);
            
        	Manager catain = managerRepository.save(new Manager("Catain America"));
        	Arrays.asList(
                    new Employee("토르", "천둥의신", catain),
                    new Employee("나타샤", "블랙위도우", catain),
                    new Employee("클린트 바튼", "호크아이", catain)
            )
        	.forEach(account -> employeeRepository.save(account));
            employeeRepository.findAll().forEach(System.out::println);
            managerRepository.save(catain);
        };
    }
}
