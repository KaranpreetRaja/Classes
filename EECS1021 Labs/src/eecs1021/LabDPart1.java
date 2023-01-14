package eecs1021;
import java.util.Scanner;
import java.util.Random;

public class LabDPart1 {
    public static void main(String[] args) {
        final int UpperBounds = 18;
        Random randobj = new Random();
        int randint; int inp; int count;
        Scanner scanobj = new Scanner(System.in);
        while(true)
            {
                randint = randobj.nextInt(UpperBounds);
                System.out.println("New Game Initialized");
                count = 1;

                while(true) {
                    System.out.println("Please guess a value in between 0 and " + UpperBounds);
                    inp = scanobj.nextInt();

                    if (inp == randint){
                        System.out.println("Congratulations you guessed the number right, and it only took " + count + " attempts");
                        break;
                    }
                    else if (inp > randint){
                        System.out.println("Your guess was too high, please try again!");
                    }
                    else {
                        System.out.println("Your guess was too low, please try again!");
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
