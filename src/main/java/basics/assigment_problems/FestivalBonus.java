package main.java.basics.assigment_problems;

import java.util.Scanner;

abstract class EmployeeBonus {
    protected String name;
    protected double salary;

    public EmployeeBonus(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public abstract double calculateBonus();
}

class FullTime extends EmployeeBonus {
    public FullTime(String name, double salary) {
        super(name, salary);
    }

    public double calculateBonus() {
        return salary * 0.10;
    }
}

class PartTime extends EmployeeBonus {
    public PartTime(String name, double salary) {
        super(name, salary);
    }

    public double calculateBonus() {
        return salary * 0.05;
    }
}

class Intern extends EmployeeBonus {
    public Intern(String name, double salary) {
        super(name, salary);
    }

    public double calculateBonus() {
        return 2000;
    }
}

public class FestivalBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            EmployeeBonus employee;

            if (type.equals("FULLTIME")) {
                employee = new FullTime(name, salary);
            } else if (type.equals("PARTTIME")) {
                employee = new PartTime(name, salary);
            } else {
                employee = new Intern(name, salary);
            }

            double bonus = employee.calculateBonus();

            System.out.printf("%s: %.2f%n", employee.name, bonus);
            total += bonus;
        }

        System.out.printf("Total Bonus: %.2f%n", total);

        sc.close();
    }
}