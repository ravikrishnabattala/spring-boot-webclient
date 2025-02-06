package com.vibesyncer.server.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vibesyncer.server.domain.Book;

public interface BookService {

    Page<Book> getBooks(Pageable pageable);

    Optional<Book> getBook(String isbn);

}
