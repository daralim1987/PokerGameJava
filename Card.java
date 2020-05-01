//Class Card
public class Card implements Comparable<Card> {

        //Declare and initialize variables
		private int suit;
		private int value;
        //"C" represent clubs suit, "D" is Diamond, "H" is Heart, "S" is spades
		private final static String[] suits = {"C","D","H","S"};
        //"2" is the lowest value, "T" is 10, "J" is jack, "Q" is queen, "K" is king, and "A" is ace
		private final static String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"};
												
		//Constructor initialize suit and rank value
		public Card(int v, int s) {
            value = v;
            suit = s;
		}
		
        //getter methods
		public int getSuit() {
			return suit;
		}
		
		public int getValue() {
			return value;
		}
    
        //Method to compare value rank of card
        public int compareTo(Card other) {
            if (this.getValue() > other.getValue())
                    return 1;
            else if (this.getValue() < other.getValue())
                    return -1;
            else
                    return 0;
        }
		
        //convert to string method
		public String toString() {
			String info = values[value] + suits[suit];	
			return info;
		}
		
		
		
	}


