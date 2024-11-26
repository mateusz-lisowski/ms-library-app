package com.github.mateusz_lisowski.rent.member;

import java.util.UUID;

public record MemberResponse(
        UUID id,
        String firstname,
        String lastname
) {
}
