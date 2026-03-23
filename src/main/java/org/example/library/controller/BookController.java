package org.example.library.controller;

import org.example.library.entity.Book;
import org.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", service.getAllBooks());
        return "books";
    }

    @PostMapping("/add")
    public String addBook(@RequestParam String title) {

        Book b = new Book();
        b.setTitle(title);
        b.setAvailable(true);

        service.saveBook(b);

        return "redirect:/books";
    }
}