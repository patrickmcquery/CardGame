import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> hand;

    private int player;


    public Hand(int inPlayer)
    {
        player = inPlayer;
        hand = new ArrayList<Card>(0);
    }

    public ArrayList<Card> getHand()
    {
        return hand;
    }

    public void setHand(ArrayList<Card> inHand)
    {
        hand = inHand;
    }

    public int getPlayer()
    {
        return player;
    }
    public void addCard(Card inCard)
    {
        hand.add(inCard);
    }

    public Card getCard(int i)
    {
        return hand.get(i);
    }

    public ArrayList<Integer> getTotal()
    {
        int val = 0;
        ArrayList<Integer> tempList = new ArrayList<Integer>(2);
        boolean containsAce = false;
        for(int i = 0; i < hand.size(); i++)
        {
            if(hand.get(i).getInt() == 1)
            {
                containsAce = true;
            }
        }
        if(!containsAce)
        {
            for(int i = 0; i < hand.size(); i++)
            {
                val += hand.get(i).getInt();
            }
            tempList.add(val);
        } else
        {
            for(int i = 0; i < hand.size(); i++)
            {
                val += hand.get(i).getInt();
                if(hand.get(i).getInt() == 1)
                {

                }
            }
        }
        return tempList;
    }
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
            else {
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
