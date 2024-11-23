package com.github.mateusz_lisowski.book.book;

import com.github.mateusz_lisowski.book.book.schemas.BookCreateRequest;
import com.github.mateusz_lisowski.book.book.schemas.BookResponse;
import org.springframework.stereotype.Service;

@Service
public class BookMapper {

    public Book toBook(BookCreateRequest request) {
        return Book.builder()
                .id(request.id())
                .title(request.title())
                .author(request.author())
                .build();
    }

    public BookResponse toBookResponse(Book book) {
        return new BookResponse(book.getId(), book.getTitle(), book.getAuthor());
    }

}
