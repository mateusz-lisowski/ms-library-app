package com.github.mateusz_lisowski.rent.rent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RentRepository extends JpaRepository<Rent, UUID> {

    List<Rent> findAllByBookIdAndReturnDateIsNull(UUID bookId);

    List<Rent> findAllByMemberIdAndReturnDateIsNull(UUID memberId);

    List<Rent> findAllByMemberId(UUID memberId);

}
