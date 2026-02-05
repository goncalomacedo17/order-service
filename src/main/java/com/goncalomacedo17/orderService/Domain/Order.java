package com.goncalomacedo17.orderService.Domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "`order`")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total")
    private BigDecimal totalPrice;

    @Column(name="quantity")
    private Long ticketCount;

    @CreationTimestamp
    @Column(name = "placed_at", updatable = false, nullable = false)
    private LocalDateTime placedAt;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "event_id")
    private Long eventId;
}
