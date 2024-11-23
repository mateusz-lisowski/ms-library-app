package com.github.mateusz_lisowski.book.book;

import com.github.mateusz_lisowski.book.book.schemas.BookCreateRequest;
import com.github.mateusz_lisowski.book.book.schemas.BookResponse;
import com.github.mateusz_lisowski.book.book.schemas.BookUpdateRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository repository;
    private final BookMapper mapper;

    public BookResponse create(BookCreateRequest request) {
        Book book = mapper.toBook(request);
        return mapper.toBookResponse(repository.save(book));
    }

    public BookResponse findById(UUID uuid) {
        return repository.findById(uuid).map(mapper::toBookResponse).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book with id: " + uuid + " not found")
        );
    }

    public List<BookResponse> findAll() {
        return repository.findAll().stream().map(mapper::toBookResponse).toList();
    }

    public List<BookResponse> findByAuthor(String author) {
        return repository.findAllByAuthor(author).stream().map(mapper::toBookResponse).toList();
    }

    public BookResponse update(UUID uuid, BookUpdateRequest request) {
        Book book = repository.findById(uuid).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book with id: " + uuid + " not found")
        );
        book.setTitle(request.title());
        book.setAuthor(request.author());
        return mapper.toBookResponse(repository.save(book));
    }

    public void delete(UUID uuid) {
        Book book = repository.findById(uuid).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book with id: " + uuid + " not found")
        );
        repository.delete(book);
    }

}
