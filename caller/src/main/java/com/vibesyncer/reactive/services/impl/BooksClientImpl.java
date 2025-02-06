package com.vibesyncer.reactive.services.impl;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.vibesyncer.reactive.domain.Book;
import com.vibesyncer.reactive.domain.PagedResponse;
import com.vibesyncer.reactive.services.BooksClient;

import reactor.core.publisher.Mono;

@Service
public class BooksClientImpl implements BooksClient {

    private final WebClient webClient;

    public BooksClientImpl(final WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Mono<PagedResponse<Book>> getBooks(Integer page) {
        final ParameterizedTypeReference<PagedResponse<Book>> pagedResponseBooks =
            new ParameterizedTypeReference<PagedResponse<Book>>() {
        };

        return webClient.get()
                .uri(builder -> builder.path("/books").queryParam("page", page).build())
                .retrieve()
                .bodyToMono(pagedResponseBooks);
    }

}
