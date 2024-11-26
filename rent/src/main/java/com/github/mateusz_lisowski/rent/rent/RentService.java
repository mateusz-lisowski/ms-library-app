package com.github.mateusz_lisowski.rent.rent;

import com.github.mateusz_lisowski.rent.book.BookClient;
import com.github.mateusz_lisowski.rent.book.BookResponse;
import com.github.mateusz_lisowski.rent.member.MemberClient;
import com.github.mateusz_lisowski.rent.member.MemberResponse;
import com.github.mateusz_lisowski.rent.rent.schemas.RentCreateRequest;
import com.github.mateusz_lisowski.rent.rent.schemas.RentResponse;
import feign.FeignException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class RentService {

    private final RentRepository repository;
    private final RentMapper mapper;
    private final BookClient bookClient;
    private final MemberClient memberClient;

    public RentResponse lendBookToMember(RentCreateRequest request) {

        try {
            bookClient.findBookById(request.bookId());
        } catch (FeignException.NotFound e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Book with id: " + request.bookId() + " not found"
            );
        }

        try {
            memberClient.findMemberById(request.memberId());
        } catch (FeignException.NotFound e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Member with id: " + request.bookId() + " not found"
            );
        }

        if (checkIfBookLent(request.bookId())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Book with id: " + request.bookId() + " is already lent"
            );
        }
        return mapper.toRentResponse(repository.save(
                Rent.builder()
                        .dueDate(request.dueDate())
                        .bookId(request.bookId())
                        .memberId(request.memberId())
                        .build()
        ));
    }

    public RentResponse returnBookFromMember(UUID uuid) {
        Rent rent = repository.findById(uuid).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Rent with id: " + uuid + " not found")
        );
        rent.setReturnDate(LocalDateTime.now());
        return mapper.toRentResponse(repository.save(rent));
    }

    public Boolean checkIfBookLent(UUID bookId) {
        return !repository.findAllByBookIdAndReturnDateIsNull(bookId).isEmpty();
    }

    public List<RentResponse> getAllUserRents(UUID memberId) {
        return repository.findAllByMemberId(memberId).stream().map(mapper::toRentResponse).toList();
    }

    public List<RentResponse> getAllDueUserRents(UUID memberId) {
        return repository.findAllByMemberIdAndReturnDateIsNull(memberId).stream().map(mapper::toRentResponse).toList();
    }

}
