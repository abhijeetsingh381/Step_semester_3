
package main.java.basics.class_problems;

import java.util.Scanner;

abstract class Booking {
    double distance;

    static final double BOOKING_FEE = 50;

    Booking(double distance) {
        this.distance = distance;
    }

    abstract double getFare();

    double getTotal() {
        return getFare() + BOOKING_FEE;
    }
}

class Bus extends Booking {
    Bus(double distance) {
        super(distance);
    }

    double getFare() {
        return distance * 2;
    }
}

class Train extends Booking {
    Train(double distance) {
        super(distance);
    }

    double getFare() {
        return distance * 1.5;
    }
}

class Flight extends Booking {
    Flight(double distance) {
        super(distance);
    }

    double getFare() {
        return 2500 + distance * 4;
    }
}

public class TravelBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String mode = sc.next().toUpperCase();
            double distance = sc.nextDouble();

            Booking booking;

            switch (mode) {
                case "BUS":
                    booking = new Bus(distance);
                    break;

                case "TRAIN":
                    booking = new Train(distance);
                    break;

                case "FLIGHT":
                    booking = new Flight(distance);
                    break;

                default:
                    System.out.println("Invalid booking mode");
                    continue;
            }

            System.out.printf("%s: %.2f%n", mode, booking.getTotal());
            total += booking.getTotal();
        }

        System.out.printf("Total Booking Cost: %.2f%n", total);

        sc.close();
    }
}
