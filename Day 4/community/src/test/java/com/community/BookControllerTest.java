package com.community;

import com.community.controller.BookController;
import com.community.domain.Book;
import com.community.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import static org.hamcrest.Matchers.contains;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BookService bookService;

    @Test
    public void Book_MVC_테스트() throws Exception {
        Book book = new Book("Spring Boot Book", LocalDateTime.now());
        Integer a = new Integer(1);
        given(bookService.getBookList()).willReturn(Collections.singletonList(book));
        given(bookService.getInteger()).willReturn(Collections.singletonList(a));


        mvc.perform(get("/books"))
                .andExpect(status().isOk())
                .andExpect(view().name("book")) //뷰 이름이 book인지?
                .andExpect(model().attributeExists("bookList")) // 모델의 bookList가 존재하는지?
                .andExpect(model().attribute("bookList", contains(book)));  // 프로퍼티가 Book의 객체를 포함하는지

        mvc.perform(get("/books2"))
                .andExpect(status().isOk())
                .andExpect(view().name("book"))
                .andExpect(model().attributeExists("bookList3"))
                .andExpect(model().attribute("bookList3", contains(a)));

    }


}
