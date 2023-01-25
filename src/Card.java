/*
    The card class stores the card value (1-13 + joker) and the suit.
    Both values are set by the deck class. Cards can be hidden (face down)
    and will return blanks if it is true.

    Extra Credit: Switch/Case on line 37
*/
public class Card
{
    private final int val;
    private final char suit;
    private boolean hidden;
    public Card(int inVal, char inSuit)
    {
        hidden = false;
        val = inVal;
        suit = inSuit;
    }
    public void hide()
    {
        hidden = true;
    }
    public void unhide()
    {
        hidden = false;
    }
    public boolean isHidden()
    {
        return hidden;
    }
    public char getVal()
    {
        if(hidden)
        {
            return ' ';
        }
        switch(val)
        {
            case 0: return 'Z';
            case 1: return 'A';
            case 11: return 'J';
            case 12: return 'Q';
            case 13: return 'K';
            default: return (char)(val + '0');
        }
    }
    public int getInt()
    {
        if(val < 10)
        {
            return val;
        }
        else
        {
            return 10;
        }
    }
    public char getSuit()
    {
        if(val == 0)
        {
            return '+';
        }
        else if(hidden)
        {
            return ' ';
        }
        return suit;
    }
}