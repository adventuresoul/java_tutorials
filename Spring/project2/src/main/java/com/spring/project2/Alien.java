package com.spring.SpringFrame;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component  // should be annotated if class wants to be a bean, if annotated, it'll create bean when app runs(singleton by default)
class Laptop {
    Laptop() {
        System.out.println("Laptop constructor");
    }
    public void compile() {
        System.out.println("Compiling");
    }
}

@Component
//@Scope("prototype")  // This makes it a prototype bean
public class Alien {
    // @Autowired
    // public Alien(Laptop laptop) {  // ✅ Constructor Injection
    //     this.laptop = laptop;
    // }
    /*
     * @Autowired is an annotation in Spring that automatically injects dependencies (i.e., objects) 
     * into a class without needing to create them manually using new.
     */
    @Autowired
    Laptop sys1;    //Field Injection
    public void codeAndRun() {    
        sys1.compile();
        System.out.println("I'm coding");
    }
}
