package com.vibesyncer.reactive.services;

import com.vibesyncer.reactive.domain.Book;

import reactor.core.publisher.Flux;

/**
 * Service to deal with Books
 */
public interface BookService {

    Flux<Book> getBooks(final Integer page);

}
