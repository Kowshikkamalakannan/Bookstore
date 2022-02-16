package com.kowshik.bookstore.service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import com.kowshik.bookstore.model.Books;
import com.kowshik.bookstore.model.myCollection;
import com.kowshik.bookstore.repository.BooksRepository;
import com.kowshik.bookstore.repository.myCollectionRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BooksRepository bookRepository;

    @Autowired
    myCollectionRepo myrepo;



    @Override
    public void saveBooks(Books books) {
        this.bookRepository.save(books);
    }

    @Override
    public List<Books> getAll(String email) {
        return bookRepository.getbyemail(email);
    }

    @Override
    public Books getBooksById(long id) {
        Optional<Books> optional=bookRepository.findById(id);
        Books book=null;
        if(optional.isPresent())
        {
            book=optional.get();
        }else
        {
            throw new RuntimeException("Book not found for id: "+id);
        }
        return book;
    }

    @Override
    public void deleteBooksById(long id) {
        bookRepository.deleteById(id);
        
    }

    @Override
    public List<Books> getallbooks() {
        
        return this.bookRepository.findAllonAvailablity(); 
    }

    @Override
    public void saveBookforuser(Books book) {
        Long product_id=book.getId();
        String bookname=book.getBookName();
        String quantity=book.getQuantity();
        String Seller_email=book.getSellerEmail();
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        String Date = localDate.format(formatter);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email_user = authentication.getName();
        Optional<Books> bk=this.bookRepository.findById(product_id);
        Books book1=bk.get();
        String quantity_available=book1.getCount();
        if(Integer.parseInt(quantity)<=Integer.parseInt(quantity_available))
        {
            this.myrepo.saveToCollection(product_id,bookname,quantity,Seller_email,Date,email_user);
            
            String diff_quantity=Integer.toString(Integer.parseInt(quantity_available) - Integer.parseInt(quantity));
            book1.setCount(diff_quantity);
            saveBooks(book1);
        }
        else{
            System.out.print("###########################################Quantity Exceed####################################################################");
        }
        
        
    }
    @Override
    public Books getallbooksbyid(Long product_id) {
        Optional<Books> opt=bookRepository.findById(product_id);
        Books mycollection=opt.get(); 
        return mycollection;
    }

    @Override
    public List<myCollection> getAllUserBooks(String userEmail) {
        return this.myrepo.getalluserbooks(userEmail);
    }

    @Override
    public List<myCollection> getUsersData(String selleremail) {
        return myrepo.getAllUsersDatabyEmail(selleremail);
    }

    
}
