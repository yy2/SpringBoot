package com.yy2.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//docker container ls -a //list all containers
//docker start demo-postgress
//docker exec -it demo-postgress //bin//sh
//psql -U postgres
@SpringBootApplication
public class DemoForSpringBootFullStackApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoForSpringBootFullStackApplication.class, args);
	}

}
