package eecs1021;
import java.util.Scanner;
import java.util.Random;

public class LabDPart2 {
    public static void main(String[] args) {
        final int UpperBounds = 36;
        Random randobj = new Random();
        int randint; int inp; int count;
        Scanner scanobj = new Scanner(System.in);
        while(true)
        {
            randint = randobj.nextInt(UpperBounds);
            System.out.println("New Game Initialized");
            count = 1;

            int max = UpperBounds;
            int min = 0;

            while(true) {
                System.out.println(max-min);
                inp = randobj.nextInt(max-min+1) + min-1;
                System.out.println("The computer guessed " + inp);

                if (inp == randint){
                    System.out.println("Congratulations you guessed the number right, and it only took " + count + " attempts");
                    break;
                }
                else if (inp > randint){
                    System.out.println("Your guess was too high, please try again!");
                    max = inp;
                }
                else {
                    System.out.println("Your guess was too low, please try again!");
                    min = inp+1;
                }
                count ++;

            }
            System.out.println("Would you like to play again? enter 1 for yes, 0 for no");
            inp = scanobj.nextInt();
            if (inp == 0){
                System.out.println("Stopped Successfully");
                break;
            }
        }
    }

}
