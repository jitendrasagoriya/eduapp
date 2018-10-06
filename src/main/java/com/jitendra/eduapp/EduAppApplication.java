package com.jitendra.eduapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.jitendra.eduapp.filestorage.FileStorageProperties;

/**
 * @author jitendra sagoriya
 *
 */
@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class EduAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EduAppApplication.class, args);
	}
}
