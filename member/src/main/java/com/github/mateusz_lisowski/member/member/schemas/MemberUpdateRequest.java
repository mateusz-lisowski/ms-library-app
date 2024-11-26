package com.github.mateusz_lisowski.member.member.schemas;

import jakarta.validation.constraints.NotBlank;

public record MemberUpdateRequest(
        @NotBlank(message = "Member's firstname cannot be blank")
        String firstname,
        @NotBlank(message = "Member's lastname cannot be blank")
        String lastname
) {
}
