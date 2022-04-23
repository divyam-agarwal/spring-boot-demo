package com.example.demo.webservices;

import com.example.demo.business.ReservationService;
import com.example.demo.data.Guest;
import com.example.demo.data.Reservation;
import com.example.demo.data.Room;
import com.example.demo.util.DateUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class WebServiceController {
    private final ReservationService reservationService;
    private final DateUtil dateUtil;

    public WebServiceController(ReservationService reservationService, DateUtil dateUtil) {
        this.reservationService = reservationService;
        this.dateUtil = dateUtil;
    }

    @RequestMapping(value = "/reservations", method = RequestMethod.GET)
    List <Reservation> getReservations(@RequestParam(value="date",required = false) String dateString){
        Date date = dateUtil.createDateFromDateString(dateString);
        if(date==null){
            date = new Date();
        }
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        List<Reservation> reservationList = reservationService.getReservationsByDate(sqlDate);
        return reservationList;
    }

    @RequestMapping(value = "/guests", method = RequestMethod.GET)
    List <Guest> getGuests(){
        List<Guest> guests = reservationService.getGuests();
        return guests;
    }

    @RequestMapping(value = "/guests", method = RequestMethod.POST)
    Guest addGuest(@RequestParam(value="firstName") String firstName,
                          @RequestParam(value="lastName") String lastName,
                          @RequestParam(value="address") String address,
                          @RequestParam(value="email") String email,
                          @RequestParam(value="country") String country,
                          @RequestParam(value="state") String state,
                          @RequestParam(value="phoneNumber") String phoneNumber
                          ){
        Guest newGuest = new Guest(firstName,lastName,address,email,country,state,phoneNumber);
        reservationService.saveGuest(newGuest);
        return newGuest;


    }

    @RequestMapping(value = "/rooms", method = RequestMethod.GET)
    List <Room> getRooms(@RequestParam(value="date",required = false) String dateString){
        List<Room> rooms = reservationService.getRooms();
        return rooms;
    }
}
