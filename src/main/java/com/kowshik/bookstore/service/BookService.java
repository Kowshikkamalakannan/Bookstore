package com.kowshik.bookstore.service;

import java.util.List;

import com.kowshik.bookstore.model.Books;
import com.kowshik.bookstore.model.myCollection;

import org.springframework.stereotype.Service;



@Service
public interface BookService {
    void saveBooks(Books book);
    List<Books> getAll(String email);
    List<myCollection> getAllUserBooks(String userEmail);
    List<myCollection> getUsersData(String selleremail);
    List<Books> getallbooks();
    Books getBooksById(long id);
    void deleteBooksById(long id);
    void saveBookforuser(Books book);
    Books getallbooksbyid(Long product_id);
}
