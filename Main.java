import java.util.Scanner;
//CHRISTIAN PALMA
// CS 145
// This class contains the main method, which serves as the entry point of the program.
// It displays a welcome message and the rules of the game.
// It prompts the user to choose whether they want to play or not.
// If the user chooses to play, it creates an instance of the BlackjackGame class and starts the game.
// After the game ends, it asks the user if they want to play again.
public class Main {
    private static boolean playAgain = true;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the blackjack table!");
        System.out.println("Where the house always wins!");
        System.out.println("These are the rules of the game:");
        System.out.println("https://www.mastersofgames.com/rules/blackjack-rules.htm");

        System.out.println("Would you like to play? (Y/N)");
        String gamble = scanner.nextLine();
        char choice = gamble.charAt(0);

        if (Character.toUpperCase(choice) == 'Y') {
            BlackjackGame game = new BlackjackGame();
            while (playAgain) {
                game.play();
                System.out.println("\nWould you like to play again? (Y/N)");
                String newGame = scanner.nextLine();
                char playAgainChoice = newGame.charAt(0);
                if (Character.toUpperCase(playAgainChoice) != 'Y') {
                    playAgain = false;
                }
            }
        }

        System.out.println("\nThank you for playing! Goodbye!");
    }
}