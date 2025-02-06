package com.vibesyncer.reactive.services.impl;

import org.springframework.stereotype.Service;

import com.vibesyncer.reactive.domain.Book;
import com.vibesyncer.reactive.domain.PagedResponse;
import com.vibesyncer.reactive.services.BookService;
import com.vibesyncer.reactive.services.BooksClient;

import reactor.core.publisher.Flux;

@Service
public class BookServiceImpl implements BookService {

    private final BooksClient booksClient;

    public BookServiceImpl(final BooksClient booksClient) {
        this.booksClient=booksClient;
    }

    @Override
    public Flux<Book> getBooks(Integer page) {
        return booksClient.getBooks(page)
        .map(PagedResponse::getContent)
        .flatMapMany(Flux::fromIterable);
    }

}
