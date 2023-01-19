import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class BlackJack {

    private final int SHOELENGTH = 4;
    private int numPlayers;
    private int diff;
    private Stack<Card> shoe;

    private ArrayList<Hand> hands;
    public BlackJack(int inNumPlayers, int inDiff)
    {
        numPlayers = inNumPlayers;
        hands = new ArrayList<Hand>(numPlayers);
        diff = inDiff;
        shoe = new Stack<Card>();
    }

    public void play()
    {
        newShoe();
        newDeal();
        boolean playing = true;
        Scanner console = new Scanner(System.in);
        while(playing)
        {
            showBoard();
            for(int i = 0; i < numPlayers; i++)
            {
                int player = i + 1;
                System.out.println("Player " + player + " what would you like to do?");
                String resp = console.nextLine();
                switch (resp.toLowerCase().charAt(0))
                {
                    case 'h':
                        hands.get(i).getHand().add(shoe.pop());
                    case 's':
                        ;
                    default:
                        System.out.println("Invalid response given, please try again.");
                }
            }
            if(hands.get(numPlayers).getTotal()[0] < 17 || hands.get(numPlayers).getTotal()[1] < 17 )
            {
                hands.get(numPlayers).getHand().add(shoe.pop());
            }
        }
    }
    private void showBoard()
    {
        System.out.println("Dealer has: ");
        hands.get(numPlayers).getHand().get(0).hide();
        System.out.println(hands.get(numPlayers));
        showPlayers();
    }

    private void showPlayers()
    {
        for(int i = 0; i < numPlayers; i++)
        {
            int player = i + 1;
            System.out.println("Player " + player + " has:");
            System.out.println(hands.get(i).toString());
        }
    }

    private void newDeal()
    {
        for(int i = 0; i < numPlayers + 1; i++)
        {
            hands.add(new Hand(i));
        }
        for(int i = 0; i < 2; i++)
        {
            for(int j = 0; j < numPlayers + 1; j++)
            {
                hands.get(j).getHand().add(shoe.pop());
            }
        }
    }

    private void newShoe()
    {
        for(int i = 0; i < SHOELENGTH; i++)
        {
            Deck tempDeck = new Deck(false);
            tempDeck.shuffle();
            for(int j = 0; j < 52; j++)
            {
                shoe.push(tempDeck.popCard());
            }
        }
        Collections.shuffle(shoe);
    }
}
