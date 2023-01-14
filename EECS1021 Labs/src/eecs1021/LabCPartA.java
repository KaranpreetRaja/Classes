package eecs1021;

import java.util.Scanner;

public class LabCPartA {
    public static void main(String args[]){
        Scanner inputobj = new Scanner(System.in);
        inputobj.useRadix(2);
        int sum  = 0;
        int num;
        while (inputobj.hasNext()){
            System.out.println("Enter a binary number: ");
            num = inputobj.nextInt();
            sum += num;
            System.out.println("The current sum is: " + (Integer.toBinaryString(sum)));
        }
    }
}

