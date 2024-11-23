package com.github.mateusz_lisowski.book.book.schemas;

import java.util.UUID;

public record BookResponse(
        UUID id,
        String title,
        String author
) {
}
