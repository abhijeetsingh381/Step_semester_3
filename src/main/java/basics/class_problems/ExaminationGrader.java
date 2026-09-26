package main.java.basics.class_problems;

import java.util.Scanner;

abstract class Question {

    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    public Question(
            String correctAnswer,
            String studentAnswer,
            double points) {

        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public abstract double grade();

    public abstract String getType();
}

class MCQQuestion extends Question {

    public MCQQuestion(
            String correctAnswer,
            String studentAnswer,
            double points) {

        super(correctAnswer, studentAnswer, points);
    }

    public double grade() {

        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }

        return 0;
    }

    public String getType() {
        return "MCQ";
    }
}

class TFQuestion extends Question {

    public TFQuestion(
            String correctAnswer,
            String studentAnswer,
            double points) {

        super(correctAnswer, studentAnswer, points);
    }

    public double grade() {

        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }

        return 0;
    }

    public String getType() {
        return "TF";
    }
}

class EssayQuestion extends Question {

    public EssayQuestion(
            String correctAnswer,
            String studentAnswer,
            double points) {

        super(correctAnswer, studentAnswer, points);
    }

    public double grade() {

        String[] keywords =
                correctAnswer.split(",");

        int count = 0;

        String answer =
                studentAnswer.toLowerCase();

        for (String keyword : keywords) {

            keyword = keyword.trim().toLowerCase();

            if (answer.contains(keyword)) {
                count++;
            }
        }

        if (count >= 2) {
            return points * 0.75;
        } else if (count == 1) {
            return points * 0.50;
        }

        return 0;
    }

    public String getType() {
        return "ESSAY";
    }
}

public class ExaminationGrader {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        double total = 0;

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            String[] parts = line.split("\"");

            String type = parts[0].trim();

            String correctAnswer = parts[3];

            String studentAnswer = parts[5];

            double points =
                    Double.parseDouble(parts[6].trim());

            Question question;

            if (type.equals("MCQ")) {

                question =
                        new MCQQuestion(
                                correctAnswer,
                                studentAnswer,
                                points);

            } else if (type.equals("TF")) {

                question =
                        new TFQuestion(
                                correctAnswer,
                                studentAnswer,
                                points);

            } else {

                question =
                        new EssayQuestion(
                                correctAnswer,
                                studentAnswer,
                                points);
            }

            double score = question.grade();

            System.out.printf(
                    "%s: %.2f%n",
                    question.getType(),
                    score
            );

            total += score;
        }

        System.out.printf(
                "Total Score: %.2f%n",
                total
        );

        sc.close();
    }
}