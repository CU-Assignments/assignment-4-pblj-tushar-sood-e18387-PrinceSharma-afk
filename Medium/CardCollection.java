import java.util.*;

class Card {
    private String rank;
    private String symbol;

    public Card(String rank, String symbol) {
        this.rank = rank;
        this.symbol = symbol;
    }

    public String getRank() {
        return rank;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return rank + " of " + symbol;
    }
}

public class CardCollection {
    private Collection<Card> cards = new ArrayList<>(); // Using Collection interface

    public void addCard(String rank, String symbol) {
        cards.add(new Card(rank, symbol));
        System.out.println("Card added successfully!");
    }

    public void searchBySymbol(String symbol) {
        boolean found = false;
        for (Card card : cards) {
            if (card.getSymbol().equalsIgnoreCase(symbol)) {
                System.out.println(card);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No cards found with symbol: " + symbol);
        }
    }

    public void displayAllCards() {
        if (cards.isEmpty()) {
            System.out.println("No cards stored.");
        } else {
            System.out.println("Stored Cards:");
            for (Card card : cards) {
                System.out.println(card);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardCollection collection = new CardCollection();
        int choice;

        do {
            System.out.println("\n1. Add Card");
            System.out.println("2. Search by Symbol");
            System.out.println("3. Display All Cards");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Symbol (Hearts, Diamonds, etc.): ");
                    String symbol = scanner.nextLine();
                    System.out.print("Enter Rank (Ace, 2, King, etc.): ");
                    String rank = scanner.nextLine();
                    collection.addCard(rank, symbol);
                    break;
                case 2:
                    System.out.print("Enter Symbol to Search: ");
                    String searchSymbol = scanner.nextLine();
                    collection.searchBySymbol(searchSymbol);
                    break;
                case 3:
                    collection.displayAllCards();
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
