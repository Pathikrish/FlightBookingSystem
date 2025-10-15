package com.flightbookingsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class FlightBookingApp {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        Admin admin=new Admin("Pathi");

        ArrayList<Passenger> passengers=new ArrayList<>();
        ArrayList<Flight> fligts=new ArrayList<>();
        ArrayList<Booking> bookings=new ArrayList<>();

        fligts.add(new Flight("AI101","Coimbatore","Chennai",5500));
        fligts.add(new Flight("BB201","Dubai","UK",15000));
        fligts.add(new Flight("JK301","China","Kolkatta",12500));
        fligts.add(new Flight("CH401","Kerala","Delhi",3500));
        fligts.add(new Flight("RY501","Mumbai","Dubai",6500));

        int passengerIdCounter=1;

        while(true)
        {
            admin.showMenu();
            System.out.println("Enter the choice:");
            int choice=sc.nextInt();
            sc.nextLine();

            switch(choice)
            {
                case 1:
                    System.out.println("Enter the Name:");
                    String pname=sc.nextLine();
                    System.out.println("Enter Contact:");
                    String contact=sc.nextLine();
                    passengers.add(new Passenger(passengerIdCounter++,pname,contact));
                    System.out.println("Successfully Registered");
                    break;

                case 2:
                    System.out.println("Available Flights");
                    for(Flight f:fligts)
                    {
                        System.out.println(f.getFlightNo()+" : "+f.getSource()+" --> "+f.getDestination()+" : Rs."+f.getPrice());
                    }
                    break;

                case 3:
                    if(passengers.isEmpty())
                    {
                        System.out.println("Register as passenger first");
                        break;
                    }

                    System.out.println("Passengers List");
                    for(Passenger p:passengers)
                    {
                        System.out.println(p.getId()+" : "+p.getName());
                    }

                    System.out.println("Enter passenger id");
                    int pid=sc.nextInt();
                    sc.nextLine();

                    Passenger selectedPassenger=null;
                    for(Passenger p:passengers){
                        if(p.getId()==pid)
                        {
                            selectedPassenger=p;
                            break;
                        }
                    }
                    if(selectedPassenger==null)
                    {
                        System.out.println("Invalid ID");
                        break;
                    }
                    System.out.println("Flights:");
                    for(int i=0;i<fligts.size();i++)
                    {
                        System.out.println((i+1)+". "+fligts.get(i).getFlightNo());
                    }
                    System.out.println("Choose Flight Number:");
                    int fid=sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter the travel date(dd-mm-yyyy):");
                    String date=sc.nextLine();
                    bookings.add(new Booking(selectedPassenger,fligts.get(fid-1),date));
                    System.out.println("Flight Booked");
                    break;

                case 4:
                    if(bookings.isEmpty())
                    {
                        System.out.println("No Bookings Yet");
                        break;
                    }
                    for(Booking b:bookings)
                    {
                        b.display();
                    }
                    break;

                case 5:
                    System.out.println("Enter the Souce:");
                    String src=sc.nextLine().toLowerCase();
                    System.out.println("Enter the Destination:");
                    String dest=sc.nextLine().toLowerCase();

                    boolean found=false;
                    System.out.println("Search Results");
                    for(Flight f:fligts)
                    {
                        if(f.getSource().toLowerCase().equals(src) && f.getDestination().toLowerCase().equals(dest))
                        {
                            System.out.println(f.getFlightNo()+" : "+f.getSource()+" --> "+f.getDestination()+" : Rs. "+f.getPrice());
                            found=true;
                        }
                    }
                    if(!found)
                    {
                        System.out.println("No flights found for the selected route!!");
                    }
                    break;

                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                    sc.close();
                    break;

                default:
                    System.out.println("Invalid Choice");
            }
        }

    }

}
