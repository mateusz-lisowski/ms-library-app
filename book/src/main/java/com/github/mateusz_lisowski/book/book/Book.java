package com.github.mateusz_lisowski.book.book;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Builder
public class Book {

    @Id
    private UUID id;
    private String title;
    private String author;

}
