package project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SmartParkingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartParkingSystemApplication.class, args);
	}

}
