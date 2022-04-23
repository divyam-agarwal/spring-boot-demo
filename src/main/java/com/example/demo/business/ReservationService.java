package com.example.demo.business;

import com.example.demo.data.*;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {

    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;

    public ReservationService(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getReservationsByDate(Date date){
        List<Reservation> reservations = this.reservationRepository.findReservationsByDate(date);
        return reservations;
    }

    public List<Room> getRooms(){
        Iterable<Room> roomsFromRepo = roomRepository.findAll();
        List<Room> rooms = new ArrayList<>();
        for(Room room: roomsFromRepo){
            rooms.add(room);
        }
        return rooms;
    }

    public List<Guest> getGuests(){
        Iterable<Guest> guestsFromRepo = guestRepository.findAll();
        List<Guest> guests = new ArrayList<>();
        guestsFromRepo.forEach(g->{guests.add(g);});
        for(Guest guest: guestsFromRepo){
            guests.add(guest);
        }
        return guests;
    }

    public void saveGuest(Guest guest){
        guestRepository.save(guest);
    }
}
