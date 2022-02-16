package com.kowshik.bookstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="my_collection")
public class myCollection {
    
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="book_id")
    private Long book_id;
    
    @Column(name="user_email")
    private String email;

    @Column(name="book_name")
    private String bookname;

    @Column(name="book_quantity")
    private String quantity_bought;
    
    @Column(name="Seller_email")
    private String Selleremail;

    @Column(name="Purchase_date")
    private String date;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBook_id() {
        return book_id;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getQuantity_bought() {
        return quantity_bought;
    }

    public void setQuantity_bought(String quantity_bought) {
        this.quantity_bought = quantity_bought;
    }

    public String getSelleremail() {
        return Selleremail;
    }

    public void setSelleremail(String selleremail) {
        Selleremail = selleremail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    


    
    
}
