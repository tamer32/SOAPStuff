package com.dnd.soap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = DndSoapApplication.class)
public class DndSoapApplication {

  public static void main(String[] args) {
    SpringApplication.run(DndSoapApplication.class);
  }
}
