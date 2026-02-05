package com.goncalomacedo17.orderService.Service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.goncalomacedo17.orderService.Domain.Order;
import com.goncalomacedo17.orderService.Event.BookingEvent;
import com.goncalomacedo17.orderService.Repository.OrderRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    @KafkaListener(topics = "booking", groupId = "order-service")
    public void orderEvent(BookingEvent bookingEvent){
        log.info("Received event: {}", bookingEvent);

        //create order
        Order order = createOrder(bookingEvent);
        orderRepository.save(order);
        //update inventory
    }

    private Order createOrder(BookingEvent event){
        return Order.builder()
            .customerId(event.getUserId())
            .eventId(event.getEventId())
            .ticketCount(event.getTicketCount())
            .totalPrice(event.getTotalPrice())
            .build();
    }
}
