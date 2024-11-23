package com.github.mateusz_lisowski.book.book;

import com.github.mateusz_lisowski.book.book.schemas.BookCreateRequest;
import com.github.mateusz_lisowski.book.book.schemas.BookResponse;
import com.github.mateusz_lisowski.book.book.schemas.BookUpdateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BookResponse> createBook(
            @RequestBody @Valid BookCreateRequest request
    ) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping
    public ResponseEntity<List<BookResponse>> readAllBooks() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{book-id}")
    public ResponseEntity<BookResponse> readBookById(
            @PathVariable("book-id") UUID uuid
    ) {
        return ResponseEntity.ok(service.findById(uuid));
    }

    @GetMapping("/search/{author}")
    public ResponseEntity<List<BookResponse>> readBookByAuthor(
            @PathVariable String author
    ) {
        return ResponseEntity.ok(service.findByAuthor(author));
    }

    @PutMapping("/{book-id}")
    public ResponseEntity<BookResponse> updateBook(
            @PathVariable("book-id") UUID uuid,
            @RequestBody @Valid BookUpdateRequest request
    ) {
        return ResponseEntity.ok(service.update(uuid, request));
    }

    @DeleteMapping("/{book-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable("book-id") UUID uuid
    ) {
        service.delete(uuid);
    }

}
