package com.AltenAcadamy.Ruslan.bookStore.controller;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AltenAcadamy.Ruslan.bookStore.dto.BookDto;
import com.AltenAcadamy.Ruslan.bookStore.service.BookService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Api(value = "Book Api", tags = "Book Api", produces = "application/json")
@RestController
@RequestMapping("api/v1/books")
public class BookController {

    //    @Autowired
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @ApiOperation(value = "get list of books", response = BookDto[].class, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retried list of book"),
            @ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(responseCode = "404", description = "Not found resource")
    })
    @GetMapping()
    public ResponseEntity<List<BookDto>> getBooks() {

        List<BookDto> books = bookService.getBooks();
        return ResponseEntity.ok(books);
    }
}
