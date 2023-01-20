import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean playing = true;
        Scanner console = new Scanner(System.in);
        int players = 0;
        int diff = 0;
        boolean firstTime = true;
        while(playing)
        {
            if(firstTime)
            {
                firstTime = false;
                System.out.print("How many players? ");
                players = console.nextInt();
                System.out.print("\nWhat difficulty? ");
                diff = console.nextInt();
                console.nextLine();
                System.out.println();
            }
            BlackJack testing = new BlackJack(players, diff);
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
            if(resp.toLowerCase().charAt(0) == 'y')
            {
                System.out.print("Same settings? ");
                resp = console.nextLine();
                switch (resp.toLowerCase().charAt(0))
                {
                    case 'n':
                        firstTime = true;
                        break;
                    case 'y':
                        break;
                    default:
                        System.out.println("Invalid response please try again.");
                }
            }
        }
    }
}