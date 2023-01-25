/*
    The deck class contains a stack of cards, the deck.
    It can have jokers if passed a true value in the constructor.
    I used * , # , ~ , and @ as the suits, as I feel it is more readable
    than s , c , h , d with the way I display the cards. The suit is also
    not relevant in blackjack.
*/
import java.util.Collections;
import java.util.Stack;
public class Deck
{
    private final boolean jokers;
    private Stack<Card> deck;
    public Deck(boolean inJokers)
    {
        jokers = inJokers;
        createDeck();
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
    public Card popCard()
    {
        return deck.pop();
    }
    public void shuffle()
    {
        Collections.shuffle(deck);
    }
    //I used this toString to come up with the formula to display the cards how I wanted.
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