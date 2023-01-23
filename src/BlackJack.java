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
        boolean playersPlaying = true;
        Scanner console = new Scanner(System.in);
        ArrayList<Boolean> playerCanPlay = new ArrayList<Boolean>(numPlayers);
        for(int i = 0; i < numPlayers; i++)
        {
            playerCanPlay.add(i, true);
        }
        ArrayList<Boolean> playerWins = new ArrayList<Boolean>(numPlayers + 1);
        for(int i = 0; i <= numPlayers; i++)
        {
            playerWins.add(i, false);
        }
        while(playersPlaying)
        {
            showBoard();
            for(int i = 0; i < numPlayers; i++)
            {
                if(playerCanPlay.get(i)) {
                    boolean currentPlayerPlaying = true;
                    boolean currentPlayerBust = false;
                    while (currentPlayerPlaying)
                    {
                        int player = i + 1;
                        System.out.println("Player " + player + " what would you like to do?");
                        String resp = console.nextLine();
                        switch (resp.toLowerCase().charAt(0)) {
                            case 'h': {
                                hands.get(i).getHand().add(shoe.pop());
                                if(hands.get(i).getTotal()[0] > 21)
                                {
                                    currentPlayerPlaying = false;
                                    playerCanPlay.set(i, false);
                                    currentPlayerBust = true;
                                    playerWins.set(i, false);
                                }
                                break;
                            }
                            case 's': {
                                System.out.println("Player " + player + " decides to stand.");
                                currentPlayerPlaying = false;
                                playerCanPlay.set(i, false);
                                break;
                            }
                            default: {
                                System.out.println("Invalid response given, please try again.");
                                break;
                            }
                        }
                        showBoard();
                        if(currentPlayerBust)
                        {
                            System.out.println("Player " + player + " you have busted.");
                        }
                    }
                }
                if(!playerCanPlay.contains(true))
                {
                    playersPlaying = false;
                }

            }
        }

        //Dealers turn begins
        playersPlaying = true;
        boolean dealerBusted = false;

        /*for(int i = 0; i < numPlayers; i++)
        {
            if(!playerWins.contains(true))
            {
                playersPlaying = false;
            }
        }
         */

        while(playersPlaying)
        {
            if (hands.get(numPlayers).getTotal()[0] == 21 || hands.get(numPlayers).getTotal()[1] == 21)
            {
                playersPlaying = false;
                playerWins.set(numPlayers, true);

            } else if(hands.get(numPlayers).getTotal()[0] >= 17 || hands.get(numPlayers).getTotal()[1] >= 17)
            {
                playersPlaying = false;
            }
            else if(hands.get(numPlayers).getTotal()[0] < 17 || hands.get(numPlayers).getTotal()[1] < 17)
            {
                hands.get(numPlayers).getHand().add(shoe.pop());
                if(hands.get(numPlayers).getTotal()[0] > 21)
                {
                    dealerBusted = true;
                    playersPlaying = false;
                }
            }
        }
        hands.get(numPlayers).getHand().get(0).unhide();
        boolean useDealerSecond = false;
        if(hands.get(numPlayers).getTotal()[0] < hands.get(numPlayers).getTotal()[1] && hands.get(numPlayers).getTotal()[1] < 22)
        {
            useDealerSecond = true;
        }
        //Dealer turn ends

        // INSERT NOTEBOOK LOGIC

        showBoard();

        for(int i = 0; i < numPlayers; i++)
        {
            for(int j = 0; j < 2; j++)
            {
                if(hands.get(i).getTotal()[j] < 22)
                {
                    if (hands.get(i).getTotal()[j] >= hands.get(numPlayers).getTotal()[0] && hands.get(numPlayers).getTotal()[0] < 22 && !useDealerSecond)
                    {
                        playerWins.set(i, true);
                    } else if (hands.get(i).getTotal()[j] >= hands.get(numPlayers).getTotal()[1] && hands.get(numPlayers).getTotal()[1] < 22 && useDealerSecond)
                    {
                        playerWins.set(i, true);
                    }
                }
            }
        }

        if(dealerBusted)
        {
            for(int i = 0; i < numPlayers; i++)
            {
                if(hands.get(i).getTotal()[0] < 22)
                {
                    playerWins.set(i, true);
                }
            }
            System.out.println("Dealer busted.");
        }
        for(int i = 0; i < numPlayers; i++)
        {
            int player = i + 1;

            if(playerWins.get(i) == true)
            {
                if(hands.get(i).getTotal()[0] == hands.get(numPlayers).getTotal()[0] || hands.get(i).getTotal()[1] == hands.get(numPlayers).getTotal()[0])
                {
                    System.out.println("PLayer " + player + " tied.");
                }
                else
                {
                    System.out.println("Player " + player + " won!");
                }
            }else if(playerWins.get(i) == false)
            {
                System.out.println("Player " + player + " lost.");
            }
        }
    }
    private void showBoard()
    {
        System.out.println("Dealer has: ");
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
        hands.get(numPlayers).getHand().get(0).hide();
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
