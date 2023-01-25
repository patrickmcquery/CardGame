/*
    The hand class contains an ArrayList of cards.
    This way it can be expanded to hold multiple cards
    when the player decides to hit. It also has an int
    that represents the player number.
*/
import java.util.ArrayList;
public class Hand
{
    private ArrayList<Card> hand;
    private final int player;
    public Hand(int inPlayer)
    {
        player = inPlayer;
        hand = new ArrayList<Card>(0);
    }
    public ArrayList<Card> getHand()
    {
        return hand;
    }
    /*
        Returns an int array only 2 long. The first value is for if
        the player does not have an ace. If the player has an ace
        it adds 10 to the first value to represent the case of
        ace = 11
    */
    public int[] getTotal()
    {
        int val = 0;
        int[] tempList = {0,0};
        boolean containsAce = false;

        for(int i = 0; i < hand.size(); i++)
        {
            if(hand.get(i).getInt() == 1)
            {
                containsAce = true;
            }
            val += hand.get(i).getInt();
        }
        tempList[0] = val;
        if(containsAce)
        {
            val += 10;
            if(val <= 21)
            {
                tempList[1] = val;
            }
        }
        return tempList;
    }
    /*
        Primary toString that is used in the program. Prints out the hand
        as an ascii art image. Numbers in the corners, suit in the middle
        just like a real card.
     */
    public String toString()
    {
        String handString = "";
        for(int i = 0; i < hand.size(); i++)
        {
            handString += " ___  ";
        }
        handString += "\n";
        for(int i = 0; i < hand.size(); i++)
        {
            if(hand.get(i).isHidden())
            {
                handString += "|   | ";
            }else if(hand.get(i).getVal() == ':')
            {
                handString += "|10 | ";
            }
            else
            {
                handString += "|" + hand.get(i).getVal() + "  | ";
            }
        }
        handString += "\n";
        for(int i = 0; i < hand.size(); i++)
        {
            if(hand.get(i).isHidden())
            {
                handString += "|   | ";
            }
            else
            {
                handString += "| " + hand.get(i).getSuit() + " | ";
            }
        }
        handString += "\n";
        for(int i = 0; i < hand.size(); i++)
        {
            if(hand.get(i).isHidden())
            {
                handString += "|___| ";
            }else if(hand.get(i).getVal() == ':')
            {
                handString += "|_10| ";
            }
            else
            {
                handString += "|__" + hand.get(i).getVal() + "| ";
            }
        }
        return handString;
    }
}