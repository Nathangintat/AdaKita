package com.springboot.adakita.adakita;

import com.springboot.adakita.adakita.entity.User;
import com.springboot.adakita.adakita.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class AdakitaApplication {
	public static void main(String[] args) {
		SpringApplication.run(AdakitaApplication.class, args);
    }
}
