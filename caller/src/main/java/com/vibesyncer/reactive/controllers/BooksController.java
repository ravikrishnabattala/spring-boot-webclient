package com.vibesyncer.reactive.controllers;

import java.util.Optional;

import com.vibesyncer.reactive.domain.PagedResponse;
import com.vibesyncer.reactive.services.BooksClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vibesyncer.reactive.domain.Book;
import com.vibesyncer.reactive.services.BookService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class BooksController {

    private final BookService bookService;

    private final BooksClient booksClient;

    public BooksController(final BookService bookService, BooksClient booksClient) {
        this.bookService = bookService;
        this.booksClient = booksClient;
    }

    @GetMapping(path = "/books")
    public Flux<Book> listBooks(@RequestParam(name = "page", required = false) final Integer page) {
        final Integer requestPage = Optional.ofNullable(page).orElse(0);
        return bookService.getBooks(requestPage);
    }

    @GetMapping(path = "/booksServer")
    public Mono<PagedResponse<Book>> listBooksServer(@RequestParam(name = "page", required = false) final Integer page) {
        final Integer requestPage = Optional.ofNullable(page).orElse(0);
        return booksClient.getBooks(requestPage);
    }

}
