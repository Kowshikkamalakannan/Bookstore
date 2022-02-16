package com.kowshik.bookstore.repository;

import java.util.List;

import javax.transaction.Transactional;

import com.kowshik.bookstore.model.myCollection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface myCollectionRepo extends JpaRepository<myCollection,Long>{

    @Transactional
    @Modifying
    @Query(value="insert into my_collection(book_id,book_name,book_quantity,seller_email,Purchase_date,user_email) values(:book_id,:book_name,:book_quantity,:Selleremail,:Purchase_date,:user_email)",nativeQuery = true)
    void saveToCollection(@Param("book_id") Long product_id,@Param("book_name") String bookname,@Param("book_quantity") String quantity,@Param("Selleremail")String Selleremail,@Param("Purchase_date") String Date,@Param("user_email") String email_user);
    
    @Query(value = "SELECT * FROM my_collection WHERE user_email = ?1", nativeQuery = true)
    List<myCollection> getalluserbooks(String useremail);


    @Query(value = "SELECT * FROM my_collection WHERE seller_email = ?1", nativeQuery = true)
    List<myCollection> getAllUsersDatabyEmail(String selleremail);
}
