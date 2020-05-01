import java.util.ArrayList;
import java.util.Scanner;

//class Player
public class Player {
    //create array of integer
    int arr[] = {0,0,0,0,0,0,0,0,0};
	//Maximum number of card each player can have
    private final int HAND_SIZE = 5;
    //Each player's card in hand
	private ArrayList<Card> hand = new ArrayList<Card>(HAND_SIZE);
    //method add cards to player's hand
	public void addCard(Card card) {
		hand.add(card);
    }
	//method convert to string
	public String toString() {
		String output = "";
		for(Card card : hand) {
			output += card.toString() + "\n";
		}
		return output;
    }
    //Method to check what card player have
	public String checkHand(){
        //Declare and initialize variables
        boolean onePair = false;
        boolean twoPair = false;
        boolean threeOfAKind = false;
        boolean straight = false;
        boolean flush = false;
        boolean fullHouse = false;
        boolean fourOfAKind = false;
        boolean straightFlush = false;
        //Loop to compare player's five cards and sort them in ascending order
		for (int h = 0; h < 5; h++){
			for (int c = 0; c<4; c++) {
				int compare = hand.get(c).compareTo(hand.get(c+1));
				if (compare>0){
					Card tmp=hand.get(c);
					hand.set(c,hand.get(c+1));
					hand.set(c+1, tmp);
				}
			}
		}
        //output the card of player
        for(int i = 0; i < hand.size(); i++){
            System.out.print(hand.get(i));
            System.out.print(" ");
        }
        //Loop to access player's five card and determine what card player has
		for (int k = 0; k<4; k++) {
			//check for one pair and two pair
			if (hand.get(k).getValue() == hand.get(k+1).getValue()
					&& (k-1<0||hand.get(k-1).getValue()!=hand.get(k).getValue())
					&& (k+2>4||hand.get(k+2).getValue()!=hand.get(k).getValue())) {
				if (onePair == true) {
					twoPair = true;
                }
				onePair = true;
            }
            //condition check for four of a kind
			if ((k<2) && hand.get(k).getValue() == hand.get(k+1).getValue() && hand.get(k+1).getValue()
					== hand.get(k+2).getValue() && hand.get(k+2) == hand.get(k+3)) {
				fourOfAKind = true;
			}
			//condition check for three of a kind
			if (!fourOfAKind && (k<3) && hand.get(k).getValue() == hand.get(k+1).getValue()
					&& hand.get(k+1).getValue() == hand.get(k+2).getValue()) {
				threeOfAKind = true;
            }
            //Condition check for straight hand
			if ((k<1) && (hand.get(k+4).getValue()==12 && hand.get(k).getValue()==0||
					hand.get(k).getValue() + 1 == hand.get(k+1).getValue())
					&& hand.get(k+1).getValue() +1 == hand.get(k+2).getValue() &&
					hand.get(k+2).getValue() +1 == hand.get(k+3).getValue() &&
					hand.get(k+3).getValue() +1 == hand.get(k+4).getValue()) {
				
				straight=true;
			}
            //condition check for flush hand
			if ((k<1) && hand.get(k).getSuit() == hand.get(k+1).getSuit() &&
				hand.get(k+1).getSuit() == hand.get(k+2).getSuit() &&
				hand.get(k+2).getSuit() == hand.get(k+3).getSuit() &&
				hand.get(k+3).getSuit() == hand.get(k+4).getSuit()) {
                flush = true;
				if (straight == true) {
					straightFlush = true;
                }
            }
		}
		//fullhouse is threeOfAKind with one pair
		fullHouse= threeOfAKind & onePair;
	
        if (straightFlush){
            arr[8] = 1;
			return "\nYour card is a Straight Flush!!";
        }
        if (fourOfAKind){
            arr[7] = 1;
			return "\nYour card is a Four of a Kind!!";
        }
        if (fullHouse){
            arr[6] = 1;
			return "\nYour card is a Full House!!";
        }
        if (flush){
            arr[5] = 1;
			return "\nYour card is a Flush!!";
        }
        if (straight){
            arr[4] = 1;
			return "\nYour card is a Straight!!";
        }
        if (threeOfAKind){
            arr[3] = 1;
			return "\nYour card is a Three of a Kind!";
        }
        if (twoPair){
            arr[2] = 1;
			return "\nYour card is Two Pairs!";
        }
        if (onePair){
            arr[1] = 1;
			return "\nYou card is One Pair!";
        }
        else{
            arr[0] = 1;
			return "\nYour card is a High Card";
        }
	}
}
