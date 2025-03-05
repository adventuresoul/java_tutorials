package com.spring.project2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
IoC (Inversion of Control) is a design principle in which the control of object creation and dependency management is given to the Spring framework instead of being handled manually by the programmer.
Instead of writing new ClassName() to create objects, Spring creates and manages objects (beans) for you.
 */

/*
A Bean is an object that Spring creates and manages inside the Spring container (ApplicationContext).
Beans are created from classes annotated with @Component, @Service, or @Repository.
You can fetch a bean using context.getBean(ClassName.class).
 */

@SpringBootApplication
public class Project2Application {

	public static void main(String[] args) {
		var context = SpringApplication.run(Project2Application.class, args);
		Alien obj = context.getBean(Alien.class);	// you can't AutoWire here because, Spring doesn't manage obj you create using new keyword or obj inside static methods
		obj.codeAndRun();
		// singleton design pattern by default, creates only one object, even though you don't create obj, by default it'll create one obj and keep
		Alien obj2 = context.getBean(Alien.class);
		System.out.println(obj == obj2);

		// to make it create multiple object on each invocations, follow prototype design pattern, annotate @Scope("prototype")  to Alien class
	}

}
