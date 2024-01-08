package com.web.jpa.webjpa.service;

import com.web.jpa.webjpa.entity.Book;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookService {

    ResponseEntity<Book> addNewBook(Book book);

    ResponseEntity<List<Book>> getAllBooks();

    ResponseEntity<Book> getBookById(Long id);

    ResponseEntity<Book> updateBookById(Long id, Book book);

    ResponseEntity<?> deleteBookById(Long id);

    List<Book> getAllBooksIdLessThan5(Long id);

    List<Book> getBooksByBookName(String bookName);
}
