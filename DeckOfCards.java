
import java.security.SecureRandom;
import java.util.ArrayList;

public class DeckOfCards{

	// Attributes
	private static final int NUM_OF_CARDS=52;
	private ArrayList<Card> deck= new ArrayList<Card>();
	private final String[] faces= {"Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
	private final String[] suits= {"Hearts", "Diamonds", "Clubs", "Spades"};
	private Card joker= new Card("Joker");
	private Card card;
	private int currCard=0;
	private static final SecureRandom randomNumbers= new SecureRandom();

	// Constructor of a full deck
	public DeckOfCards() {
		for(int count=0; count<NUM_OF_CARDS; count++ ) {
			deck.add(new Card(faces[count%faces.length], suits[count/faces.length]));
		}
		deck.add(joker);
		deck.add(joker);
	}

	// Constructor of an empty deck
	public DeckOfCards(int i) {
		DeckOfCards emptyDeck= new DeckOfCards();
		emptyDeck.clearDeck();
	}

	// Clear the deck
	public void clearDeck() {
		deck.clear();
	}

	// Check if the deck is empty
	public boolean isEmptyDeck() {
		return deck.isEmpty();
	}

	// Returns the number of cards in the deck
	public int numOfCards() {
		if(!deck.isEmpty())
			return deck.size();
		return 0;
	}

	// Adds a single card
	public void addCard(Card card) {
		deck.add(card);
	}

	// Add two cards
	public void addCards(Card cardA, Card cardB) {
		deck.add(cardA);
		deck.add(cardB);
	}

	// Add all the cards of the other deck to this deck
	public void addDeck(DeckOfCards other) {
		deck.addAll(other.deck);
	}

	// Removes the given card
	public void removeCard(Card card) {
		deck.remove(card);
	}

	// Shuffle the deck
	public void shuffle() {
		currCard=0;
		for(int first=0; first<deck.size(); first++) {
			int second= randomNumbers.nextInt(deck.size());
			Card temp= deck.get(first);
			deck.set(first, deck.get(second));
			deck.set(second, temp);
		}
	}

	// Returns the next card, without removing it from the deck
	public Card getCard() {
		if(deck.size()>0 && currCard < deck.size()) {
			return deck.get(currCard++);
		}
		else if (deck.size()>0 && currCard>=deck.size())
			return deck.get(0);
		return null;
	}

	// Returns the first card from the deck, and removes it from the deck
	public Card dealCard() {
		if(deck.size()>0) {
			card= deck.get(0);
			deck.remove(0);
			return card;
		}
		return null;
	}

	// Prints the cards in the deck
	public String toString() {
		String printDeck="";
		if(deck.size()==0)
			return "No cards in this deck";
		for(int i=0; i<deck.size();i++) {
			if(i==deck.size()-1)
				return printDeck+ deck.get(i);
			printDeck+= deck.get(i).toString()+", ";
			if(i%4==3)
				printDeck+="\n";
		}
		return printDeck;
	}


}
