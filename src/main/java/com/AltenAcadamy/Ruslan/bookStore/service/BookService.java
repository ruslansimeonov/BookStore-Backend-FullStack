package com.AltenAcadamy.Ruslan.bookStore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.AltenAcadamy.Ruslan.bookStore.dto.BookDto;
import com.AltenAcadamy.Ruslan.bookStore.model.Book;
import com.AltenAcadamy.Ruslan.bookStore.repository.BookRepository;

@Service
public class BookService
{
    private final BookRepository bookRepository;
    public final ModelMapper modelMapper;

    public BookService(BookRepository bookRepository, ModelMapper modelMapper)
    {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    public List<BookDto> getBooks(){
        Iterable<Book> all = bookRepository.findAll();
        return StreamSupport.stream(all.spliterator(), false)
                .map(convertBookModelToBookDto())
                .collect(Collectors.toList());
    }

    private Function<Book, BookDto> convertBookModelToBookDto()
    {
        return book -> modelMapper.map(book, BookDto.class);
    }
}
