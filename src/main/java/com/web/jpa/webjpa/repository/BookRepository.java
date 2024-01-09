package com.web.jpa.webjpa.repository;

import com.web.jpa.webjpa.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {


    //Native Query : Simple SQL Query (Similar to SQL Query)
    @Query(value = "SELECT * FROM book WHERE id < :maxId", nativeQuery = true)
    List<Book> getAllBooksWhoseIdLessThan(@Param("maxId") Long maxId);


    //JPQL Query : Java Persistence Query Language
    @Query("SELECT b FROM Book b WHERE LOWER(b.bookName) = LOWER(:bookName)")
    List<Book> getBooksByBookName(@Param("bookName") String bookName);


    //Custom finder methods in JPA

    List<Book> findByBookName(String bookName);

    List<Book> findByBookNameIgnoreCase(String bookName);

    List<Book> findByBookId(String bookId);








}
