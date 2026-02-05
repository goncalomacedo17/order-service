package com.goncalomacedo17.orderService.Service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.goncalomacedo17.bookingService.Event.BookingEvent;
import com.goncalomacedo17.orderService.Domain.Order;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderService {

    @KafkaListener(topics = "booking", groupId = "order-service")
    public void orderEvent(BookingEvent bookingEvent){
        log.info("Received event: {}", bookingEvent);

        //create order
        Order order = createOrder(bookingEvent);
        
        //update inventory
    }

    private Order createOrder(BookingEvent event){
        return Order.builder()
            .customerId(event.getUserId())
            .eventId(event.getEventId())
            .ticketCount(event.getTicketCount())
            .totalPrice(event.getTicketPrice())
            .build();
    }
}
