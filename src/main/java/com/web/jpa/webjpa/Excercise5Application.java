package com.web.jpa.webjpa;

import com.web.jpa.webjpa.entity.Book;
import com.web.jpa.webjpa.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class Excercise5Application implements CommandLineRunner {

	@Autowired
	private Environment environment;

	@Autowired
	private BookRepository bookRepository;

	@Value("${default.message}")
	private String defaultMessage;

	public static void main(String[] args) {
		SpringApplication.run(Excercise5Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Current Active Profiles : ");

		for (String profile : environment.getActiveProfiles()) {
			System.out.println(profile);
		}

		System.out.println(Arrays.toString(environment.getDefaultProfiles()));

		System.out.println("Message : "+ defaultMessage);


		saveDummyBookRecords();
	}

	//Private Methods
	private void saveDummyBookRecords() {

		Book book1 = new Book("101","Java");
		Book book2 = new Book("102","C");
		Book book3 = new Book("103","C++");
		Book book4 = new Book("104","DS");
		Book book5 = new Book("105","Python");

		List<Book> books = new ArrayList<>();
		books.add(book1);
		books.add(book2);
		books.add(book3);
		books.add(book4);
		books.add(book5);
		bookRepository.saveAll(books);
		System.out.println("Default Books Save Successfully...");
	}
}
