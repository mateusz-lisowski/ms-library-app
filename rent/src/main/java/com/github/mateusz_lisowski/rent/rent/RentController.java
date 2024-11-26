package com.github.mateusz_lisowski.rent.rent;

import com.github.mateusz_lisowski.rent.rent.schemas.RentCreateRequest;
import com.github.mateusz_lisowski.rent.rent.schemas.RentResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/rents")
@RequiredArgsConstructor
public class RentController {

    private final RentService service;

    @PostMapping
    public ResponseEntity<RentResponse> lendBookToMember(
            @RequestBody @Valid RentCreateRequest request
    ) {
        return ResponseEntity.ok(service.lendBookToMember(request));
    }

    @GetMapping("/{rent-id}")
    public ResponseEntity<RentResponse> returnBookFromMember(
            @PathVariable("rent-id") UUID uuid
    ) {
        return ResponseEntity.ok(service.returnBookFromMember(uuid));
    }

    @GetMapping("/check/book/{book-id}")
    public ResponseEntity<Boolean> checkIfBookLent(
            @PathVariable("book-id") UUID bookId
    ) {
        return ResponseEntity.ok(service.checkIfBookLent(bookId));
    }

    @GetMapping("/check/member/{member-id}")
    public ResponseEntity<List<RentResponse>> getALLUserRents(
            @PathVariable("member-id") UUID memberId
    ) {
        return ResponseEntity.ok(service.getAllUserRents(memberId));
    }

    @GetMapping("/check/due/member/{member-id}")
    public ResponseEntity<List<RentResponse>> getALLDueUserRents(
            @PathVariable("member-id") UUID memberId
    ) {
        return ResponseEntity.ok(service.getAllDueUserRents(memberId));
    }

}
