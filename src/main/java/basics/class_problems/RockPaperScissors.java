package main.java.basics.class_problems;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    // This method decides the winner of one round
    static String playRound(String playerMove, String computerMove) {

        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if (playerMove.equals("Rock") && computerMove.equals("Scissors")) {
            return "Player Wins";
        }

        if (playerMove.equals("Paper") && computerMove.equals("Rock")) {
            return "Player Wins";
        }

        if (playerMove.equals("Scissors") && computerMove.equals("Paper")) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int rounds = 5;

        String[] moves = {"Rock", "Paper", "Scissors"};

        String[] playerMoves = new String[rounds];
        String[] computerMoves = new String[rounds];
        String[] results = new String[rounds];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        // Play 5 rounds
        for (int i = 0; i < rounds; i++) {

            System.out.println("\nRound " + (i + 1));
            System.out.print("Enter Rock, Paper or Scissors: ");

            String playerMove = sc.nextLine();

            // Convert first letter to uppercase
            playerMove = playerMove.substring(0, 1).toUpperCase()
                    + playerMove.substring(1).toLowerCase();

            // Generate computer move randomly
            String computerMove = moves[random.nextInt(3)];

            // Find result
            String result = playRound(playerMove, computerMove);

            // Store round information
            playerMoves[i] = playerMove;
            computerMoves[i] = computerMove;
            results[i] = result;

            System.out.println("Computer: " + computerMove);
            System.out.println("Result: " + result);

            // Update scoreboard
            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        // Calculate win percentage
        double winPercentage = (wins * 100.0) / rounds;

        // Final summary
        System.out.println("\n========== FINAL SUMMARY ==========");

        System.out.printf("%-8s %-15s %-15s %-20s%n",
                "Round", "Player Move", "Computer Move", "Result");

        for (int i = 0; i < rounds; i++) {
            System.out.printf("%-8d %-15s %-15s %-20s%n",
                    (i + 1),
                    playerMoves[i],
                    computerMoves[i],
                    results[i]);
        }

        System.out.println("\nWins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.printf("Win Percentage: %.1f%%%n", winPercentage);

        sc.close();
    }
}
