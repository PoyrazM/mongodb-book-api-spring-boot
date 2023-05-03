package com.poyrazm.mongodbspring.repository;

import com.poyrazm.mongodbspring.dto.BookRequest;
import com.poyrazm.mongodbspring.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends MongoRepository<Book, String> {

    Book findReferenceById(String id);
}
