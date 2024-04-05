import java.util.Scanner;
import java.util.Random;
public class numberguess {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 5;
        int score = 0;
        
        System.out.println("Welcome to the Guess the Number game!");
        
        while (true) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            System.out.println("\nI've picked a number between " + minRange + " and " + maxRange + ". Can you guess what it is? You have " + maxAttempts + " attempts.");
            
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;
                
                if (guess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    score++;
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }
            
            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + targetNumber + ".");
            }
            
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next();
            
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }
        
        System.out.printf("Thanks for playing");
        System.out.println("Your final score is "+score);
        scanner.close();
    }
}