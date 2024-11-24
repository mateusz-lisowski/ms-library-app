package com.github.mateusz_lisowski.rent.member;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(
        name = "member-service",
        url = "${application.config.members-url}"
)
public interface MemberClient {

    @GetMapping("/{member-id}")
    MemberResponse findMemberById(@PathVariable("member-id") UUID memberId);

}
