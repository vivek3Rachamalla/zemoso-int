package com.library.bootLibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class})
public class BootLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootLibraryApplication.class, args);
	}

}
