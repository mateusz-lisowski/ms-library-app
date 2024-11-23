package com.github.mateusz_lisowski.book.book.schemas;

import jakarta.validation.constraints.NotBlank;

public record BookUpdateRequest(
        @NotBlank(message = "Book's title cannot be blank")
        String title,
        @NotBlank(message = "Book's author cannot be blank")
        String author
) {
}
