import java.util.Collections;
import java.util.Stack;

public class Deck {

    private boolean jokers;
    private Stack<Card> deck;

    public Deck(boolean inJokers)
    {
        jokers = inJokers;
        createDeck();
        //deck = new Stack<Card>();
    }

    private void createDeck()
    {
        deck = new Stack<Card>();
        char[] suit = {'*', '#', '~', '@'};
        for(int i = 1; i <= 13; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                deck.add(new Card(i, suit[j]));
            }
        }
        if(jokers)
        {
            deck.add(new Card(0, '+'));
            deck.add(new Card(0, '+'));
        }
    }
    public int getSize()
    {
        return deck.size();
    }
    public Card popCard()
    {
        return deck.pop();
    }
    public void shuffle()
    {
        Collections.shuffle(deck);
    }
    public String toString()
    {
        String deckString = "";
        for(int i = 0; i < deck.size(); i++)
        {
            deckString += " ___  ";
        }
        deckString += "\n";
        for(int i = 0; i < deck.size(); i++)
        {
            if(deck.get(i).getVal() == ':')
            {
                deckString += "|10 | ";
            }
            else
            {
                deckString += "|" + deck.get(i).getVal() + "  | ";
            }
        }
        deckString += "\n";
        for(int i = 0; i < deck.size(); i++)
        {
            deckString += "| " + deck.get(i).getSuit() + " | ";
        }
        deckString += "\n";
        for(int i = 0; i < deck.size(); i++)
        {
            if(deck.get(i).getVal() == ':')
            {
                deckString += "|_10| ";
            }
            else
            {
                deckString += "|__" + deck.get(i).getVal() + "| ";
            }
        }
        return deckString;
    }
}
