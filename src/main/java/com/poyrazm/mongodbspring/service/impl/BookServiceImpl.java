package com.poyrazm.mongodbspring.service.impl;

import com.poyrazm.mongodbspring.dto.BookRequest;
import com.poyrazm.mongodbspring.entity.Book;
import com.poyrazm.mongodbspring.repository.IBookRepository;
import com.poyrazm.mongodbspring.service.services.IBookServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements IBookServices {

    private final IBookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(String id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book save(BookRequest bookRequest) {
        Book book = Book.builder()
                .name(bookRequest.getName())
                .description(bookRequest.getDescription())
                .authorName(bookRequest.getAuthorName())
                .build();

        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(String bookId, BookRequest bookRequest) {
        Book book = bookRepository.findReferenceById(bookId);

        book.setName(bookRequest.getName());
        book.setAuthorName(bookRequest.getAuthorName());
        book.setDescription(bookRequest.getDescription());

        return bookRepository.save(book);
    }

    @Override
    public void deleteById(String id) {
        bookRepository.deleteById(id);
    }
}
