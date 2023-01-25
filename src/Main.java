/*
    Patrick McQuery

    Main class for my blackjack program. Contains the loop for playing multiple games,
    and the instructions.
*/
import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        boolean playing = true;
        Scanner console = new Scanner(System.in);
        int players = 0;
        boolean firstTime = true;
        while(playing)
        {
            if(firstTime)
            {
                firstTime = false;
                System.out.println("This is a Black Jack game. In this game the player(s) play against the dealer.");
                System.out.println("The players are not \"on a team\" or \"against each other\". It's every person for themselves.");
                System.out.println("The goal is to get as close to 21 without going over as possible.");
                System.out.println("Aces are worth 1 or 11, number cards are worth face value, nd Jacks through Kings are 10.");
                System.out.println("The dealer follows the standard rule of staying on a 17 or higher and hitting below that.");
                System.out.println("As a player, you have two options. Hit or Stay/Stand. If you hit the dealer will pull");
                System.out.println("the top card off the deck and add it to your hand. If you stay you pass your turn for the round.");
                System.out.println("The dealer's first card is face down until their turn.");
                System.out.print("How many players? ");
                players = console.nextInt();
                console.nextLine();
                System.out.println();
            }
            BlackJack testing = new BlackJack(players);
            testing.play();
            System.out.print("Would you like to play again? ");
            String resp = console.nextLine();
            switch (resp.toLowerCase().charAt(0))
            {
                case 'n': playing = false;
                          break;
                case 'y': break;
                default: System.out.println("Invalid response please try again.");
            }
        }
    }
}