package com.example.demo.web;

import com.example.demo.business.ReservationService;
import com.example.demo.data.Reservation;
import com.example.demo.util.DateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/reservations")
public class RoomReservationController {

    private final DateUtil dateUtil;
    private final ReservationService reservationService;

    public RoomReservationController(DateUtil dateUtil, ReservationService reservationService) {
        this.dateUtil = dateUtil;
        this.reservationService = reservationService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getReservations(@RequestParam(value="date", required = false) String dateString, Model model){
        Date date = dateUtil.createDateFromDateString(dateString);
        List<Reservation> reservationList = reservationService.getReservationsByDate((java.sql.Date) date);
        model.addAttribute("roomReservations", reservationList);
        return "roomres";

    }
}
