package com.example.demo.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    @Query(value = "SELECT * FROM RESERVATION WHERE RES_DATE = ?1", nativeQuery = true)
    List <Reservation> findReservationsByDate(Date date);
}
