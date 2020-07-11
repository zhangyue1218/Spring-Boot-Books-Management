package com.luna.demo.web;


import com.luna.demo.domain.Book;
import com.luna.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public String list(){
        return "books";
    }

    @GetMapping("/books/{id}")
    public String detail(@PathVariable long id, Model model) {
        Book book = bookService.findOne(id);
        if (book.getName() == null ) {
            book = new Book();
        }
        model.addAttribute("book", book);
        return "book";
    }


}
