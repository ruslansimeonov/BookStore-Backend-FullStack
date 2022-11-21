package com.AltenAcadamy.Ruslan.bookStore.controller;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AltenAcadamy.Ruslan.bookStore.dto.BookDto;
import com.AltenAcadamy.Ruslan.bookStore.service.BookService;

@RestController
@RequestMapping("api/v1/books")
public class BookController
{
    @Autowired
    private BookService bookService;
    @GetMapping()
    public ResponseEntity<List<BookDto>> getBooks(){
        List<BookDto> books = bookService.getBooks();
        return ResponseEntity.ok(books);
    }
}
