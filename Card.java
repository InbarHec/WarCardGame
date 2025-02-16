

import java.security.SecureRandom;

public class Card {
	// Attributes
	private String face;
	private String suit;
	private final String JOKER="Joker";
	private final String ACE="Ace";
	private final String[] faces= {"Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", ACE, JOKER};
	private final String[] suits= {"Hearts", "Diamonds", "Clubs", "Spades"};

	// Constructor for regular cards
	public Card(String cardFace, String cardSuit) {
		if(isValidCard(cardFace, cardSuit)) {
			face=cardFace;
			suit=cardSuit;
		}
	}

	// Constructor for Joker card
	public Card(String cardFace) {
		if(cardFace==JOKER) {
			face=cardFace;
			suit=suits[new SecureRandom().nextInt(suits.length)];
		}
	}

	// Check if the input is a valid card
	private boolean isValidCard(String cardFace, String cardSuit) {
		return isValidFace(cardFace)&&isValidSuit(cardSuit);
	}

	// Check if the face of the input is valid
	private boolean isValidFace(String cardFace) {
		for(int i=0; i<faces.length; i++) {
			if(cardFace.equals(faces[i]))
				return true;
		}
		return false;
	}

	// Check if the suit of the input is valid
	private boolean isValidSuit(String cardSuit) {
		for(int i=0; i<suits.length; i++) {
			if(cardSuit.equals(suits[i]))
				return true;
		}
		return false;
	}

	// Method toString()
	public String toString() {
		if(face==JOKER)
			return JOKER; 
		return face + " of " + suit;
	}

	// Returns the value of the card (where "Joker" is the highest value, "Ace" is next, and the rest of the deck remains the same)
	public int getValue() {
		for(int i=0; i<faces.length; i++) {
			if(face==faces[i]) {
				return i;
			}
		}
		return 0;
	}
}
