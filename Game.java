//Class game
public class Game {
    //Instantiate players and deck
    Player player1 = new Player();
    Player player2 = new Player();
    Deck deck = new Deck();
    //Method play game: deal five card per player's hand and call checkHand method
    public void playHand1() {
        for(int i = 0; i<5; i++) {
            Card card = deck.dealCard();
            player1.addCard(card);
        }
        System.out.print("Player1's cards are: ");
        System.out.println(player1.checkHand());
        System.out.println("\n");
    }
    public void playHand2() {
        for(int i = 0; i<5; i++) {
            Card card = deck.dealCard();
            player2.addCard(card);
        }
        System.out.print("Player2's cards are: ");
        System.out.println(player2.checkHand());
    }
    
		
}
