package com.kowshik.bookstore.model;
// import java.util.ArrayList;
// import java.util.Collection;

// import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// import javax.persistence.JoinColumn;
// import javax.persistence.JoinTable;
// import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Entity
@Table(name="books")
public class Books {
    
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="Author")
    private String bookName;

    @Column(name="BookTitle")
    private String authorName;

    @Column(name="Category")
    private String category;

    @Column(name="email")
    private String email;

    @Column(name="Books_Available")
    private String count;

    private String quantity;


    // @ManyToMany(cascade = CascadeType.ALL)
    // @JoinTable(name="myCollection",
    // joinColumns = @JoinColumn(name="Books_id"),
    // inverseJoinColumns = @JoinColumn(name="User_id")
    // )
    // private Collection<User> users=new ArrayList<>();


    
    public Books() {
    }

    public Books(long id) {
        super();
        this.id = id;
        
    }
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
    public void setEmail(String email) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        this.email = authentication.getName();
    }
    public String getCount() {
        return count;
    }
    public void setCount(String count) {
        this.count = count;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    public String getSellerEmail() {
        return email;
    }
    public void setSellerEmail(String email) {
        this.email=email;
    }

    
    

    // public Collection<User> getUsers() {
    //     return users;
    // }

    // public void setUsers(Collection<User> users) {
    //     this.users = users;
    // }
    
    
    
}
