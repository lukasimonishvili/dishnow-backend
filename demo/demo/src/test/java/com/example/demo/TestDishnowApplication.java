package com.example.demo;

import org.springframework.boot.SpringApplication;

public class TestDishnowApplication {

	public static void main(String[] args) {
		SpringApplication.from(DishnowApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
