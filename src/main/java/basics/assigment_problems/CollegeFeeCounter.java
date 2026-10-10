package main.java.basics.assigment_problems;

import java.util.Scanner;

interface BusUser {
    double TRANSPORT_FEE = 12000;
}

abstract class StudentFee {
    String name;

    StudentFee(String name) {
        this.name = name;
    }

    abstract double getFee();
}

class DayScholar extends StudentFee implements BusUser {
    DayScholar(String name) {
        super(name);
    }

    double getFee() {
        return 40000 + TRANSPORT_FEE;
    }
}

class Hosteller extends StudentFee {
    Hosteller(String name) {
        super(name);
    }

    double getFee() {
        return 40000 + 60000;
    }
}

class Scholar extends StudentFee implements BusUser {
    Scholar(String name) {
        super(name);
    }

    double getFee() {
        return 20000 + TRANSPORT_FEE;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            StudentFee student;

            switch (type) {
                case "DAY_SCHOLAR":
                    student = new DayScholar(name);
                    break;
                case "HOSTELLER":
                    student = new Hosteller(name);
                    break;
                case "SCHOLAR":
                    student = new Scholar(name);
                    break;
                default:
                    continue;
            }

            double fee = student.getFee();

            System.out.printf("%s: %.2f%n", name, fee);
            total += fee;
        }

        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}
