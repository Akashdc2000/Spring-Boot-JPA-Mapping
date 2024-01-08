package com.web.jpa.webjpa.controller;


import com.web.jpa.webjpa.entity.Book;
import com.web.jpa.webjpa.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    private final Logger log = LoggerFactory.getLogger(BookController.class);

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/book")
    public ResponseEntity<Book> addNewBook(@RequestBody Book book) {
        log.info("Post Request comes to the Controller : api/book - Body {}",book);
        return bookService.addNewBook(book);
    }

    @GetMapping("/book")
    public ResponseEntity<List<Book>> getAllBooks() {
        log.info("Get Request comes to the Controller : api/book");
        return bookService.getAllBooks();
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBookByBookId(@PathVariable Long id) {
        log.info("Get Request comes to controller : api/book/{}",id);
        return bookService.getBookById(id);
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<Book> updateBookById(@PathVariable Long id, @RequestBody Book book) {
        log.info("Put Request comes to controller : api/book/{}",id);
        return bookService.updateBookById(id, book);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<?> deleteBookById(@PathVariable Long id) {
        log.info("Delete Request comes to controller : api/book/{}",id);
        return bookService.deleteBookById(id);
    }

    @GetMapping("/book/id-less-than/{id}")
    public List<Book> getAllBooksIdLessThan5(@PathVariable Long id) {
        return bookService.getAllBooksIdLessThan5(id);
    }

    @GetMapping("/book/name/{bookName}")
    public List<Book> getBooksByBookName(@PathVariable String bookName) {
        return bookService.getBooksByBookName(bookName);
    }


}
