public class Card {
    private int number;         // The numerical value of the card
    private String shape;       // The suit of the card
    private boolean cardUsed;   // Indicates if the card has been used
    private String symbol;      // The symbol representation of the card
    private String name;        // The name of the card
   
    // Returns a string representation of the card
    @Override
    public String toString() {
        return name + " of " + shape;   
    }

    // Assigns the provided number to the card's number
    // Assigns the provided shape to the card's shape

    public Card(int number, String shape) {
        this.number = number;   
        this.shape = shape;     

        if (number < 11) {
            symbol = Integer.toString(number);   
            name = Integer.toString(number);     
        } else if (number == 11) {
            symbol = "J";   
            name = "Jack";  
        } else if (number == 12) {
            symbol = "Q";   
            name = "Queen"; 
        } else if (number == 13) {
            symbol = "K";   
            name = "King";  
        } else {
            symbol = "A";   // I tried making the ace value 1 or 10 here but I could not
            name = "Ace";   
        }
 // Prints a message indicating that a card was created with its number and symbol
 // for testing 
        // System.out.println("Card " + number + symbol + " was created");
       
    }
// Returns the shape of the card
    public String getShape() {
        return shape;   
    }
 // Returns the name of the card
    public String getName() {
        return name;   
    }
 // Returns the number of the card
    public int getNumber() {
        return number; 
    }
}
