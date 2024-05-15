package cultureMedia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.context.annotation.Configuration;


@Configuration
@EnableAutoConfiguration

public class AplicationRunner {

	public static void main(String[] args) {
			SpringApplication.run(AplicationRunner.class, args);
	}

}
