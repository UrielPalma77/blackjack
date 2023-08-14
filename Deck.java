import java.util.ArrayList;
import java.util.Collections;
//CHRISTIAN PALMA
// CS 145
// the Deck class handles different functions of the deck as the game 
// is played. Stores the symbols for the cards and shuffles the deck.
public class Deck {
    private ArrayList<Card> cards;   // ArrayList to store the cards in the deck

    public Deck() {
        cards = new ArrayList<>();   // Initialize the ArrayList to store cards
        initializeDeck();             // Populate the deck with cards
        shuffleDeck();                // Shuffle the deck
    }

    // Array containing the shapes (suits) of the cards
    // Create a new Card object for each shape and number, and add it to the deck
    private void initializeDeck() {
        String[] shapes = {"Spades", "Hearts", "Diamonds", "Clubs"};  
        for (String shape : shapes) {
            for (int number = 2; number <= 14; number++) {
                cards.add(new Card(number, shape));   
            }
        }
    }

     // Shuffle the cards in the deck using the Collections.shuffle() method

    private void shuffleDeck() {
        Collections.shuffle(cards);  
    }
    // If the deck is empty, this return null as there are no cards to draw
     // Remove and return the top card from the deck when the deck 
    public Card drawCard() {
        if (cards.isEmpty()) {
            return null;   
        }
        return cards.remove(cards.size() - 1);  
    }
    // Return the number of remaining cards in the deck
    public int getRemainingCards() {
        return cards.size();   
    }
}
