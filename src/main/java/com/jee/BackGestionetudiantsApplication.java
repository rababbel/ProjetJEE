package com.jee;

import com.jee.Utils.UtilMethodes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.io.File;

@SpringBootApplication
public class BackGestionetudiantsApplication {

    public static void main(String[] args) {
        new File(UtilMethodes.uploadDir).mkdir();
        SpringApplication.run(BackGestionetudiantsApplication.class, args);
    }

}
