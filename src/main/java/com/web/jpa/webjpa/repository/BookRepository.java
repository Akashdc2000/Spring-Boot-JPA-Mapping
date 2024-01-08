package com.web.jpa.webjpa.repository;

import com.web.jpa.webjpa.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "SELECT * FROM book WHERE id < 5", nativeQuery = true)
    List<Book> getAllBooksWhoseIdLessThan5();

}
