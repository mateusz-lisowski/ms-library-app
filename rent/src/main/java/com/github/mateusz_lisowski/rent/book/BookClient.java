package com.github.mateusz_lisowski.rent.book;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(
        name = "book-service",
        url = "${application.config.books-url}"
)
public interface BookClient {

    @GetMapping("/{book-id}")
    BookResponse findBookById(@PathVariable("book-id") UUID bookId);

}
