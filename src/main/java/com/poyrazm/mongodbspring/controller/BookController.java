package com.poyrazm.mongodbspring.controller;

import com.poyrazm.mongodbspring.dto.BookRequest;
import com.poyrazm.mongodbspring.entity.Book;
import com.poyrazm.mongodbspring.service.interfaces.IBookServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class BookController {

    private final IBookServices bookServices;

    @GetMapping(value = "/books")
    public List<Book> getAllBooks() {
        return bookServices.findAll();
    }

    @GetMapping(value = "/books/{bookId}")
    public Optional<Book> getBook(@PathVariable String bookId) {
        return bookServices.findById(bookId);
    }

    @PostMapping(value = "/books")
    public Book createBook(@RequestBody BookRequest bookRequest) {
        return bookServices.save(bookRequest);
    }

    @PutMapping(value = "/books/{bookId}")
    public Book updateBook(@PathVariable String bookId, @RequestBody BookRequest bookRequest) {
        return bookServices.updateBook(bookId, bookRequest);
    }

    @DeleteMapping(value = "/books/{bookId}")
    public void deleteBook(@PathVariable String bookId) {
        bookServices.deleteById(bookId);
    }

}
