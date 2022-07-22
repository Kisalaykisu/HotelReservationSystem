package com.bridgelabz;  // Import package

import java.time.DayOfWeek;  // Import Dayofweek
import java.time.LocalDate; // Tell you about localdate and time
import java.util.*; // Import all util packages
import java.util.stream.Collectors; // it uses four operations : supplier ,accumulator,combiner,finisher

public class HotelReservation { // class template

    Map<String, Hotel> hotelReservation = new HashMap<>(); // Make Hash obj

    public static void main(String[] args) {  //Entry point of program

        System.out.println("Welcome to the Hotel Reservation System");
        HotelReservation obj = new HotelReservation();
        obj.addHotel();  //calling the method
        obj.enterDates();
    }

    /**
     * Method for adding Hotel to the HotelReservationSystem
     */
    public void addHotel() {
        Hotel obj1 = new Hotel("Lakewood", 3, 110, 90, 80, 80);
        Hotel obj2 = new Hotel("Bridgewood", 4, 150, 50, 110, 50);
        Hotel obj3 = new Hotel("Ridgewood", 5, 220, 150, 100, 40);
        hotelReservation.put(obj1.getHotelName(), obj1); // put is used to assign the value
        hotelReservation.put(obj2.getHotelName(), obj2);
        hotelReservation.put(obj3.getHotelName(), obj3);
    }

    /**
     * Method for inputting the dates from user
     */
    public void enterDates() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the 2 dates in yyyymmdd format: ");
        String date1 = sc.nextLine();  // returns the input that was skipped
        String date2 = sc.nextLine();
        findCheapestHotel(date1, date2);
    }

    /**
     * Method for finding the cheapest Hotel for given dates
     *
     * @param d1 day1 is passed as String parameter
     * @param d2 day2 is passed as String parameter
     * @return returns the cheapest total rates
     */
    public int findCheapestHotel(String d1, String d2) {
        DayOfWeek day1 = LocalDate.parse(d1).getDayOfWeek(); // receives some string as input, "extracts"
        DayOfWeek day2 = LocalDate.parse(d2).getDayOfWeek(); // the necessary information from it

        List<Hotel> hotelObjList = hotelReservation.values().stream().sorted(Comparator.comparing(Hotel -> Hotel.weekdayRate)).collect(Collectors.toList());
        System.out.println(" The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Rating : " + hotelObjList.get(0).getRating() + ", Total Rates = $" + hotelObjList.get(0).getWeekdayRate() * 2);
        return (hotelObjList.get(0).getWeekdayRate() * 2);  // four operations : supplier ,accumulator,combiner,finisher
    }
}
