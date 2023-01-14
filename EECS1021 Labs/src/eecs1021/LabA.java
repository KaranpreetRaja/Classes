package eecs1021;
import java.util.Scanner;

public class LabA {
    public static void main(String args[]){
        System.out.print("What is your name? ");
        Scanner inputobj = new Scanner(System.in);
        String inputname = inputobj.nextLine();
        System.out.println("Hello, " + inputname.toUpperCase() + '!');
    }
}
