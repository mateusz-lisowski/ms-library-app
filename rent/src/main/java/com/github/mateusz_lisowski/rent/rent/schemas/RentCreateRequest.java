package com.github.mateusz_lisowski.rent.rent.schemas;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record RentCreateRequest(
        @NotNull(message = "You must specify due date")
        LocalDateTime dueDate,
        @NotNull(message = "You have to specify book id for lending process")
        UUID bookId,
        @NotNull(message = "You have to specify member id for lending process")
        UUID memberId
) {
}
