package ru.mewory.quizui;

import com.vaadin.flow.spring.annotation.EnableVaadin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class QuizuiApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(QuizuiApplication.class, args);
	}
}
