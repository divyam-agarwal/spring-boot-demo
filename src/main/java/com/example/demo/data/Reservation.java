package com.example.demo.data;

import javax.persistence.*;

@Entity
public class Reservation {
//    RESERVATION_ID BIGSERIAL PRIMARY KEY,
//    ROOM_ID BIGINT NOT NULL,
//    GUEST_ID BIGINT NOT NULL,
//    RES_DATE DATE
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="RESERVATION_ID")
    private long reservationId;

    @Column(name="ROOM_ID")
    private String roomID;

    @Column(name="GUEST_ID")
    private String guestId;

    @Column(name="RES_DATE")
    private String resDate;

    public long getReservationId() {
        return reservationId;
    }

    public void setReservationId(long reservationId) {
        this.reservationId = reservationId;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getGuestId() {
        return guestId;
    }

    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }

    public String getResDate() {
        return resDate;
    }

    public void setResDate(String resDate) {
        this.resDate = resDate;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", roomID='" + roomID + '\'' +
                ", guestId='" + guestId + '\'' +
                ", resDate='" + resDate + '\'' +
                '}';
    }
}
