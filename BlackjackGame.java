import java.util.ArrayList;
import java.util.Scanner;
//CHRISTIAN PALMA
// CS 145
// This class contains the game logic to play blackjack.
public class BlackjackGame {
    private Deck deck; //Represent the deck of cards
    private ArrayList<Card> playerHand; // The players cards are kept in this list
    private ArrayList<Card> dealerHand; // dealers cards are kept in this list
    private Scanner scanner;

    public BlackjackGame() {
        deck = new Deck();
        playerHand = new ArrayList<>();
        dealerHand = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    // This method executes the game and interacts with the player 
    // to take different actions base on the cards on hand
    public void play() {
        // Reset player's hand
        playerHand.clear();

        // Initial deal to start the game. two cards are dealt to the player
        // and two to the dealer
        playerHand.add(deck.drawCard());
        dealerHand.add(deck.drawCard());
        playerHand.add(deck.drawCard());
        dealerHand.add(deck.drawCard());

        System.out.println("Blackjack Game\n");

        boolean playerTurn = true;
        while (playerTurn) {
            System.out.println("Player's Hand: " + playerHand);
            System.out.println("Dealer's Hand: [" + dealerHand.get(0) + ", Hidden Card]");
            System.out.println("Choose an action: (1) Hit, (2) Stand");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    playerHand.add(deck.drawCard());
                    if (getHandValue(playerHand) > 21) {
                        playerTurn = false;
                        System.out.println("Player's Hand: " + playerHand);
                        System.out.println("Player Busts! Dealer wins.");
                    }
                    break;
                case 2:
                    playerTurn = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }

        // Dealer's turn. different actions are taken base on the value of the dealers cards
        
        boolean dealerTurn = true;
        while (dealerTurn && getHandValue(playerHand) <= 21) {
            System.out.println("\nDealer's Hand: " + dealerHand);
            if (getHandValue(dealerHand) < 17) {
                dealerHand.add(deck.drawCard());
                System.out.println("Dealer Hits.");
            } else if (getHandValue(dealerHand) > 21) {
                dealerTurn = false;
                System.out.println("Dealer Busts!");
            } else {
                dealerTurn = false;
                System.out.println("Dealer Stands.");
            }
}


        // This loop checks the value of the players hand and the dealer hand
        // and determines the winner
        if (getHandValue(playerHand) > 21) {
            System.out.println("\nPlayer Busts! Dealer wins.");
        } else if (getHandValue(dealerHand) > 21) {
            System.out.println("\nDealer Busts! Player wins.");
        } else {
            int playerValue = getHandValue(playerHand);
            int dealerValue = getHandValue(dealerHand);
            System.out.println("\nPlayer's Hand: " + playerHand + " (" + playerValue + ")");
            System.out.println("Dealer's Hand: " + dealerHand + " (" + dealerValue + ")");
            if (playerValue > dealerValue) {
                System.out.println("Player wins!");
                //  System.out.println("player total " + playerValue);
                // System.out.println("Dealer total " + dealerValue);
            } else if (playerValue < dealerValue) {
                System.out.println("Dealer wins!");
                //  System.out.println("player total " + playerValue);
                // System.out.println("Dealer total " + dealerValue);
            } else {
                System.out.println("It's a tie!");
            }
                System.out.println("player total " + playerValue);
                System.out.println("Dealer total " + dealerValue);
        }
    }
           

    // Helper method to calculate the value of a hand
    
    private static int getHandValue(ArrayList<Card> hand) {
        int value = 0;
        int numAces = 0;
        for (Card card : hand) {
            int cardNumber = card.getNumber();
            if (cardNumber > 10) {
                value += 10;
            } else if (cardNumber == 1) {
                value += 11;
                numAces++;
            } else {
                value += cardNumber;
            }
        }
        while (value > 21 && numAces > 0) {
            value -= 10;
            numAces--;
        }
        return value;
    }
}
