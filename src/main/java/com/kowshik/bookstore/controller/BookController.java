package com.kowshik.bookstore.controller;
import com.kowshik.bookstore.model.Books;
import com.kowshik.bookstore.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class BookController {

        @Autowired
        BookService bookservice;
        //Admin
        //Admin Home
        @GetMapping("/home")
        public String Home(@ModelAttribute("book") Books book)
        {
            return "home";
        }
        //Add Books
        @GetMapping("/addBooks")
        public String addBooks(Model model)
        {
            Books books=new Books();
            model.addAttribute("books", books);
            return("NewBooks");
        }
        //Save Books to DB
        @PostMapping("/saveBook")
        public String savemybook(@ModelAttribute("books") Books books)
        {
            bookservice.saveBooks(books);
            return "redirect:/home";
        }
        //Show Books
        @GetMapping("/ShowCollections")
        public String viewBooks(Model model)
        {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String Username=authentication.getName();
            model.addAttribute("collections", bookservice.getAll(Username));
            return "ViewCollections";
        }
        //Update Books
        @GetMapping("/UpdateBook/{id}")
        public String showupdateBooksForm(@PathVariable (value = "id")long id,Model model)
        {
            Books book=bookservice.getBooksById(id);
            model.addAttribute("books", book);
            return "updateBook";
        }
        //Delete Books
        @GetMapping("/deleteBook/{id}")
        public String deleteBooks(@PathVariable (value = "id")long id)
        {
            this.bookservice.deleteBooksById(id);
            return "redirect:/home";
        }
        //List Users purchased
        @GetMapping("/ListUsersData")
        public String listusers(Model model)
        {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String email_Seller=authentication.getName();
            model.addAttribute("Usersdata", bookservice.getUsersData(email_Seller));
            return "UserHistory";
        }



        //USER
        //User Home
        @GetMapping("/userHome")
        public String userhome()
        {
            return "userHome";
        }
        //List Books
        @GetMapping("/BuyBooks")
        public String buybooks(Model model)
        {
            model.addAttribute("collections", bookservice.getallbooks());
  
            return "buybooks";
        }
        //BuyBook page 
        @GetMapping("/BuyBook/{id}")
        public String userbuybook(@PathVariable(value="id")long product_id,Model model)
        {
            Books book=bookservice.getallbooksbyid(product_id);
            model.addAttribute("mybooks",book);
            return "BuyBookPage"; 

        }
        //Save Books bought to mycollection
        @PostMapping("/saveBoughtBooks")
        public String saveBought(@ModelAttribute("mybooks")Books book)
        {
            bookservice.saveBookforuser(book);
            return "/userHome";
        }
        //Display My collection
        @GetMapping("/myCollections")
        public String mybooks(Model model)
        {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String Useremail=authentication.getName();
            model.addAttribute("userCollections", bookservice.getAllUserBooks(Useremail));
            return "userCollections";
        }


    
}
