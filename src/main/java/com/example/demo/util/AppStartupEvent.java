package com.example.demo.util;

import com.example.demo.data.*;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {

    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;

    public AppStartupEvent(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }


    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Iterable <Room> rooms = this.roomRepository.findAll();
        rooms.forEach(x-> System.out.println(x));
        System.out.println("----------------------");

        List <Reservation> reservations = this.reservationRepository.findReservationsByDate(Date.valueOf("2022-01-01"));
        System.out.println("reservations.size() : " + reservations.size());
        System.out.println(reservations.get(0));
        System.out.println("----------------------");

    }
}
