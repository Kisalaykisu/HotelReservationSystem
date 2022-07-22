package com.bridgelabz;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

public class HotelReservationTest {

    @Test
    public void givenHotelNamesWhenAddedShouldReturnSize() {
        HotelReservation obj = new HotelReservation();
        obj.addHotel();
        Assertions.assertEquals(3, obj.hotelReservation.size());
    }

    @Test
    public void givenDateRangeShouldReturnTheCheapestHotelRate() {
        HotelReservation obj = new HotelReservation();
        obj.addHotel();
        Assertions.assertEquals(220, obj.findCheapestHotel("2022-07-10", "2022-09-11"));
    }

    @Test
    public void givenWeekDayWeekEndRatesShouldReturnThoseRates() {
        HotelReservation obj = new HotelReservation();
        obj.addHotel();
        Assertions.assertEquals(90, obj.hotelReservation.get("Lakewood").getWeekendRate());
        Assertions.assertEquals(50, obj.hotelReservation.get("Bridgewood").getWeekendRate());
        Assertions.assertEquals(150, obj.hotelReservation.get("Ridgewood").getWeekendRate());
    }
}