package main.java.basics.class_problems;

public class Applicant {

    static int totalApplicants = 0;

    public Applicant() {
        totalApplicants++;
    }

    public static void main(String[] args) {

        Applicant applicant1 = new Applicant();
        Applicant applicant2 = new Applicant();
        Applicant applicant3 = new Applicant();

        System.out.println("Total applicants: " + Applicant.totalApplicants);
    }
}