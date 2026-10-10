package main.java.basics.assigment_problems;

import java.util.Scanner;

interface NightService {
    double NIGHT_RATE = 1.20;
}

abstract class Cab {
    double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double getRate();

    double getFare() {
        return Math.max(100, km * getRate());
    }
}

class MiniCab extends Cab {
    MiniCab(double km) {
        super(km);
    }

    double getRate() {
        return 10;
    }
}

class SedanCab extends Cab implements NightService {
    SedanCab(double km) {
        super(km);
    }

    double getRate() {
        return 14;
    }

    double getNightFare() {
        return getFare() * NIGHT_RATE;
    }
}

class SUVCab extends Cab implements NightService {
    SUVCab(double km) {
        super(km);
    }

    double getRate() {
        return 18;
    }

    double getNightFare() {
        return getFare() * NIGHT_RATE;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab;

            switch (type) {
                case "MINI":
                    cab = new MiniCab(km);
                    break;
                case "SEDAN":
                    cab = new SedanCab(km);
                    break;
                case "SUV":
                    cab = new SUVCab(km);
                    break;
                default:
                    continue;
            }

            if (time.equals("NIGHT") && !(cab instanceof NightService)) {
                System.out.println(type + ": night service not available");
                continue;
            }

            double fare = cab.getFare();

            if (time.equals("NIGHT")) {
                fare = fare * NightService.NIGHT_RATE;
            }

            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
