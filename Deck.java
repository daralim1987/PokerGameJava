import java.util.ArrayList;
import java.util.Collections;

//class Deck
public class Deck {
    //Declare size of deck
    private final int SIZE_DECK = 52;
   //deck of cards
	public ArrayList<Card> cards = new ArrayList<Card>(SIZE_DECK);
	//Constructor with creating 52 cards in a deck and shuffle it up
	public Deck() {
		for(int rank = 0; rank < 13; rank++) {
			for(int suit = 0; suit < 4; suit++) {
				Card newCard = new Card(rank, suit);
				cards.add(newCard);
			}
		}
        Collections.shuffle(cards);
	}
    //deal card method
    public Card dealCard(){
        return cards.remove(0);
    }
}


