package com.poyrazm.mongodbspring.service.services;

import com.poyrazm.mongodbspring.dto.BookRequest;
import com.poyrazm.mongodbspring.entity.Book;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface IBookServices {

    List<Book> findAll();

    Optional<Book> findById(String id);

    Book save(BookRequest bookRequest);

    Book updateBook(String id, BookRequest bookRequest);

    void deleteById(String id);

}
