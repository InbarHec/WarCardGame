import javax.swing.*;

public class GameManager {

	// Attributes
	private static int WAR_CARDS=3;

	// Main function to run the game
	public static void main(String[] args) {
		war();
	}

	// Method to divide the main deck into 2 decks, after shuffling it
	private static void divide(DeckOfCards main, DeckOfCards a, DeckOfCards b) {
		main.shuffle();
		for(int i=0; i<main.numOfCards(); i++) {
			if(i%2==0)
				a.addCard(main.getCard());
			else
				b.addCard(main.getCard());
		}
		main.clearDeck();
	}

	// War game
	private static void war() {
		String message=""; // Message that will be shown on every move
		// Creating main deck
		DeckOfCards temp= new DeckOfCards();
		// Creating two empty decks to fill with the main (temp) deck later
		DeckOfCards deckA= new DeckOfCards(0);
		DeckOfCards deckB= new DeckOfCards(0);

		divide(temp, deckA, deckB);

		// Progress of the war game
		while(!(deckA.isEmptyDeck() || deckB.isEmptyDeck())) {
			// Remove and "show" the first card of each deck from A and B, and show what they were 
			Card cardA= deckA.dealCard();
			Card cardB= deckB.dealCard();
			message= "Player A got: " +cardA + "\nPlayer B got: " +cardB;

			// Compare the two cards
			if(!(cardA==null || cardB==null)){
				// Case Player A wins the round
				if(cardA.getValue()>cardB.getValue()) {
					deckA.addCards(cardA, cardB);
					message+= "\nPlayer A won!";
					JOptionPane.showMessageDialog(null, message);
				}
				// Case Player B wins the round
				else if (cardA.getValue()<cardB.getValue()) {
					deckB.addCards(cardA, cardB);
					message+= "\nPlayer B won!";
					JOptionPane.showMessageDialog(null, message);
				}
				// Case Player A and Player B have the same card value, start the war game procedure
				else {
					// Since both of the cards were removed, we'll keep them in a temporary deck, until we'll get a score 
					temp.addCards(cardA, cardB);
					temp=warTime(temp, deckA, deckB);
					message+= "\nIt's A War!";
					JOptionPane.showMessageDialog(null, message);

					// If one of the Players lost all his cards during the war, the game will stop
					if(deckA.isEmptyDeck()||deckB.isEmptyDeck()) {
						techWin(deckA, deckB, message);
						break;
					}

					// Case Player A wins the war
					if(deckA.getCard().getValue()>deckB.getCard().getValue()) {
						deckA.addDeck(temp);
						deckA.addCard(deckB.dealCard());
						message+= "\nPlayer A won the war!";
						JOptionPane.showMessageDialog(null, message);
					}

					// Case Player B wins the war
					else {
						deckB.addDeck(temp);
						deckB.addCard(deckA.dealCard());
						message+= "\nPlayer B won the war!";
						JOptionPane.showMessageDialog(null, message);
					}
					temp.clearDeck();
				}
			}
		}
		// Check if one of the decks is empty after every round
		techWin(deckA,deckB, message);
	}


	// Procedure of the war itself, when deckA and deckBs' last card's values are the same
	private static DeckOfCards warTime(DeckOfCards temp, DeckOfCards A, DeckOfCards B) {
		String message="";
		// Deal 3 cards from each deck, and add them to a temporary deck, as long as the war mode is keep on going on
		for(int i=0; i<WAR_CARDS && !A.isEmptyDeck() && !B.isEmptyDeck(); i++) {
			Card cardA= A.dealCard();
			Card cardB= B.dealCard();
			temp.addCards(cardA, cardB);
		}
		// Check if during the war one of the decks has been emptied
		techWin(A,B,message);

		// Check if the decks' fourth card in every war has the same value, and if so- keep the war procedure until scored 
		if(!(A.isEmptyDeck() || B.isEmptyDeck())) {
			if(A.getCard().getValue()==B.getCard().getValue())
				warTime(temp, A, B);
		}
		return temp;
	}

	// Check for a "technical win"- where one of the decks has been emptied, and lost the game
	private static void techWin(DeckOfCards deckA, DeckOfCards deckB, String message) {
		if(deckA.isEmptyDeck()) {
			message+= "\nPlayer A ran out of cards.\nPlayer B has won the game!";
			JOptionPane.showMessageDialog(null, message);
		}
		else if(deckB.isEmptyDeck()) {
			message+= "\nPlayer B ran out of cards.\nPlayer A has won the game!";
			JOptionPane.showMessageDialog(null, message);
		}
	}
}
