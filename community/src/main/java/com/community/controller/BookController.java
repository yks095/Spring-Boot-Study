package com.community.controller;

import com.community.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public String getBookList(Model model)  {
        model.addAttribute("bookList", bookService.getBookList());  // 프로퍼티(bookList)

        return "book";  // 뷰의 이름
    }

    @GetMapping("/books2")
    public String getInteger(Model model)  {
        model.addAttribute("bookList3", bookService.getInteger());  // 프로퍼티(bookList)

        return "book";  // 뷰의 이름
    }
}
