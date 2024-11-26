package com.github.mateusz_lisowski.rent.rent;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Rent {

    @Id
    @GeneratedValue
    private UUID id;
    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime lendDate;
    private LocalDateTime dueDate;
    private LocalDateTime returnDate;
    private UUID bookId;
    private UUID memberId;

}
