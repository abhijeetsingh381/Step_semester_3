package main.java.basics.class_problems;

import java.util.Scanner;

abstract class Transport {

    protected double distance;

    public Transport(double distance) {
        this.distance = distance;
    }

    public abstract double calculateFare();

    public abstract String getType();
}

class Bus extends Transport {

    public Bus(double distance) {
        super(distance);
    }

    public double calculateFare() {

        double fare = 2 + (0.10 * distance);

        if (fare > 10) {
            fare = 10;
        }

        return fare;
    }

    public String getType() {
        return "BUS";
    }
}

class Train extends Transport {

    public Train(double distance) {
        super(distance);
    }

    public double calculateFare() {
        return 3 + (0.15 * distance);
    }

    public String getType() {
        return "TRAIN";
    }
}

class Metro extends Transport {

    private double peakHourFactor;

    public Metro(
            double distance,
            double peakHourFactor) {

        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    public double calculateFare() {

        double fare =
                1.50 + (0.20 * distance);

        return fare * peakHourFactor;
    }

    public String getType() {
        return "METRO";
    }
}

public class TransportFare {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double distance = sc.nextDouble();

            Transport transport;

            if (type.equals("BUS")) {

                transport = new Bus(distance);

            } else if (type.equals("TRAIN")) {

                transport = new Train(distance);

            } else {

                double factor = sc.nextDouble();

                transport =
                        new Metro(
                                distance,
                                factor);
            }

            double fare =
                    transport.calculateFare();

            System.out.printf(
                    "%s: %.2f%n",
                    transport.getType(),
                    fare
            );

            total += fare;
        }

        System.out.printf(
                "Total: %.2f%n",
                total
        );

        sc.close();
    }
}