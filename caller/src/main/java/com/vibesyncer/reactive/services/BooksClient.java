package com.vibesyncer.reactive.services;

import com.vibesyncer.reactive.domain.Book;
import com.vibesyncer.reactive.domain.PagedResponse;

import reactor.core.publisher.Mono;

/**
 * Handles HTTP calls to the Books server
 */
public interface BooksClient {

    Mono<PagedResponse<Book>> getBooks(Integer page);

}
