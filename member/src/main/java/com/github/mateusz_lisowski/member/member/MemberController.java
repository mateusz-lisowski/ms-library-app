package com.github.mateusz_lisowski.member.member;

import com.github.mateusz_lisowski.member.member.schemas.MemberCrateRequest;
import com.github.mateusz_lisowski.member.member.schemas.MemberResponse;
import com.github.mateusz_lisowski.member.member.schemas.MemberUpdateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MemberResponse> createMember(
            @RequestBody @Valid MemberCrateRequest request
    ) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping
    public ResponseEntity<List<MemberResponse>> readAllMembers() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{member-id}")
    public ResponseEntity<MemberResponse> readMemberById(
            @PathVariable("member-id") UUID uuid
    ) {
        return ResponseEntity.ok(service.findById(uuid));
    }

    @PutMapping("/{member-id}")
    public ResponseEntity<MemberResponse> updateMember(
            @PathVariable("member-id") UUID uuid,
            @RequestBody @Valid MemberUpdateRequest request
    ) {
        return ResponseEntity.ok(service.update(uuid, request));
    }

    @DeleteMapping("/{member-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable("member-id") UUID uuid
    ) {
        service.delete(uuid);
    }

}
