package com.kowshik.bookstore.repository;

import java.util.List;

import com.kowshik.bookstore.model.Books;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface BooksRepository extends JpaRepository<Books , Long>{
    
    @Query(value = "SELECT * FROM books WHERE email = ?1", nativeQuery = true)
    List<Books> getbyemail(String email);

    @Query(value="SELECT * FROM books WHERE books_available>0",nativeQuery = true)
    List<Books> findAllonAvailablity();
}
