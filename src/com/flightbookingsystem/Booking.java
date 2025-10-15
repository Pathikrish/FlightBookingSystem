package com.flightbookingsystem;

public class Booking {
    private Flight flight;
    private Passenger passenger;
    private String date;

    public Booking(Passenger passenger,Flight flight, String date) {
        this.flight = flight;
        this.passenger = passenger;
        this.date = date;
    }

    public void display(){
        System.out.println("-------------------------------------");
        System.out.println("Passenger - "+passenger.getName()+"("+passenger.getContact()+")");
        System.out.println("Flight - "+flight.getFlightNo()+" --> "+flight.getSource()+" to "+flight.getDestination());
        System.out.println("Date - "+date+" Rs."+flight.getPrice());
        System.out.println("-------------------------------------");
    }


}
