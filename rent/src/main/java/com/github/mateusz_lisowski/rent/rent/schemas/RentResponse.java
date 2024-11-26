package com.github.mateusz_lisowski.rent.rent.schemas;

import java.time.LocalDateTime;
import java.util.UUID;

public record RentResponse(
        UUID id,
        LocalDateTime lendDate,
        LocalDateTime dueDate,
        LocalDateTime returnDate,
        UUID bookId,
        UUID memberId
) {
}
