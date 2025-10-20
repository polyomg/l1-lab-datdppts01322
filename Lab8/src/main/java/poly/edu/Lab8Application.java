package poly.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync
@EnableScheduling
public class Lab8Application {
    public static void main(String[] args) {
        SpringApplication.run(Lab8Application.class, args);
        System.out.println("✅ Mail Service started...");
    }
}

