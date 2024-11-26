package com.github.mateusz_lisowski.rent.book;

import java.util.UUID;

public record BookResponse(
        UUID id,
        String title,
        String author
) {
}
