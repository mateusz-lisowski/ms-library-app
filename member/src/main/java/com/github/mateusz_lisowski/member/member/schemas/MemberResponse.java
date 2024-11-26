package com.github.mateusz_lisowski.member.member.schemas;

import java.util.UUID;

public record MemberResponse(
        UUID id,
        String firstname,
        String lastname
) {
}
