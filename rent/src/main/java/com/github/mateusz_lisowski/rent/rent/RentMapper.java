package com.github.mateusz_lisowski.rent.rent;

import com.github.mateusz_lisowski.rent.rent.schemas.RentResponse;
import org.springframework.stereotype.Service;

@Service
public class RentMapper {

    public RentResponse toRentResponse(Rent rent) {
        return new RentResponse(
                rent.getId(),
                rent.getLendDate(),
                rent.getDueDate(),
                rent.getReturnDate(),
                rent.getBookId(),
                rent.getMemberId()
        );
    }

}
