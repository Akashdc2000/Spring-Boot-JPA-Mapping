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

		List<Book> bookList = bookRepository.findByBookName("java");
		System.out.println(bookList);
		bookList = bookRepository.findByBookNameIgnoreCase("jAvA");
		System.out.println(bookList);
		bookList = bookRepository.findByBookId("101");
		System.out.println(bookList);
	}

	//Private Methods
	private void saveDummyBookRecords() {

		Book book1 = new Book("101","Java", "book1@gmail.com");
		Book book2 = new Book("102","C", "book2@gmail.com");
		Book book3 = new Book("103","C++", "book3@gmail.com");
		Book book4 = new Book("104","DS", "book4@gmail.com");
		Book book5 = new Book("105","Python", "book5@gmail.com");

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
