package com.web.jpa.webjpa.serviceimpl;

import com.web.jpa.webjpa.entity.Book;
import com.web.jpa.webjpa.exception.CustomException;
import com.web.jpa.webjpa.repository.BookRepository;
import com.web.jpa.webjpa.service.BookService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final Logger log = LogManager.getLogger(BookServiceImpl.class);
    private final BookRepository bookRepository;

    private final EntityManager entityManager;

    public BookServiceImpl(BookRepository bookRepository, EntityManager entityManager) {
        this.bookRepository = bookRepository;
        this.entityManager = entityManager;
    }

    @Override
    public ResponseEntity<Book> addNewBook(Book book) {

        if(book == null || book.getId() != null) {
            log.error("Invalid Book Details Book : {}", book);
            throw new CustomException(HttpStatus.BAD_REQUEST, "Invalid Book Details");
        }
        Book newBook = bookRepository.save(book);
        log.info("New Book Added : {}", newBook);
        return ResponseEntity.ok(newBook);
    }

    @Override
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> bookList = bookRepository.findAll();
        if(bookList.size() == 0) {
            log.error("No Book Details Found : {}", bookList);
            throw new CustomException(HttpStatus.NOT_FOUND, "No Book Details Found");
        }
        log.info("All Books: {}", bookList);
        return ResponseEntity.ok(bookList);
    }

    @Override
    public ResponseEntity<Book> getBookById(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);

        if(optionalBook.isPresent()) {
            log.info("Book Detail : {}", optionalBook.get());
            return ResponseEntity.ok(optionalBook.get());
        }

        log.error("No Book Details Found for Book Id: {}", id);
        throw new CustomException(HttpStatus.NOT_FOUND, "Book Details not Found!!!");
    }

    @Override
    public ResponseEntity<Book> updateBookById(Long id, Book book) {

        if(id == null || book == null || !id.equals(book.getId())) {
            log.error("Book Details Mismatch : {}", book);
            throw new CustomException(HttpStatus.BAD_REQUEST, "Book Details Mismatch");
        }
        log.info("Book Detail Updated successfully");
        return ResponseEntity.ok(bookRepository.save(book));
    }

    @Override
    public ResponseEntity<?> deleteBookById(Long id) {
        boolean bookExist = bookRepository.existsById(id);

        if(bookExist) {
            log.info("Book Records for Book Id {} is Deleted Successfully..", id);
            bookRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        log.warn("No book record Found for Id : {}", id);
        throw new CustomException(HttpStatus.NOT_FOUND, "No book record Found");
    }

    @Override
    public List<Book> getAllBooksIdLessThan5(Long id) {

//        String sql = "SELECT * FROM book WHERE id < 5";
//        Query query = entityManager.createNativeQuery(sql, Book.class);
//
//        List<Book> bookList = query.getResultList();


        List<Book> bookList = bookRepository.getAllBooksWhoseIdLessThan(id);

        if(bookList.size() == 0) {
            log.error("No Book Details Found : {}", bookList);
            throw new CustomException(HttpStatus.NOT_FOUND, "No Book Details Found");
        }
        log.info("All Books: {}", bookList);
        return bookList;
    }

    @Override
    public List<Book> getBooksByBookName(String bookName) {
        List<Book> bookList = bookRepository.getBooksByBookName(bookName);
        if(bookList.size() == 0) {
            log.error("No Book Details Found : {}", bookList);
            throw new CustomException(HttpStatus.NOT_FOUND, "No Book Details Found");
        }
        log.info("All Books: {}", bookList);
        return bookList;
    }
}
