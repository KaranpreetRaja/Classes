package eecs1021;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.StringJoiner;

public class LabB {
    private static final int DIMENSION = 3;

    private static int[][] parseMatrix(String s, int rowCount, int colCount) {
        String[] arr = s.split("\\s+");
        int[][] outputIntArray = new int[rowCount][colCount];

        for (int i = 0; i < rowCount; i++){
            for (int j = 0; j < colCount; j++){
                outputIntArray[i][j] = Integer.parseInt(arr[(i*colCount)+j]);
            }
        }
        return outputIntArray;
    }

    private static int[][] computeMatrixExpression(int[][] a, int[][] b, String op) {
        int x = switch (op) {
            case "+" -> 1;
            case "-" -> 2;
            case "*" -> 3;
            default -> 0;
        };

        int rows = b.length;
        int culmns = a[0].length;
        int multiconst = a.length;
        int[][] outputIntArray = new int[rows][culmns];

        if (x == 0) {
            return outputIntArray;
        }
        int cur = 0;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < culmns; j++){
                if (x == 1) {
                    outputIntArray[i][j] = (a[i][j]) + (b[i][j]);
                } else if (x == 2) {
                    outputIntArray[i][j] = (a[i][j]) - (b[i][j]);
                } else {
                    cur = 0;
                    for (int k = 0; k < multiconst; k++){
                        cur = cur + ((a[i][j]) * (b[j][i]));
                    }
                    outputIntArray[i][j] = cur;
                }
            }
        }

        return outputIntArray;
    }

    private static String matrixToString(int[][] mat) {
        int rows = mat.length;
        int culmns = mat[0].length;
        String s = "";

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < culmns; j++){
                s = s + Integer.toString(mat[i][j]) + " ";
            }
            s = s + "\n";
        }

        return s;
    }
    public static void main(String[] args) {
        Scanner inputobj = new Scanner(System.in);
        System.out.println(String.format("Please enter the values for the first%2d by%2d matrix seperated by spaces (this should be%2d inputs)", DIMENSION, DIMENSION, (DIMENSION*DIMENSION)));
        String s1 = inputobj.nextLine();
        int[][] mtrx1 = parseMatrix(s1,DIMENSION,DIMENSION);
        s1 = matrixToString(mtrx1);
        System.out.println(s1);

        System.out.println(String.format("Please enter the values for the second%2d by%2d matrix seperated by spaces (this should be%2d inputs)", DIMENSION, DIMENSION, (DIMENSION*DIMENSION)));
        String s2 = inputobj.nextLine();
        int[][] mtrx2 = parseMatrix(s2,DIMENSION,DIMENSION);
        s2 = matrixToString(mtrx2);
        System.out.println(s2);

        System.out.println("enter what operation you would like to be done with the two matrix's (\'+\', \'-\', \'*\')");
        String op = inputobj.nextLine();
        int[][] answer = computeMatrixExpression(mtrx1, mtrx2, op);
        System.out.println(matrixToString(answer));

        System.out.println("enter what operation you would like to be done with the two matrix's (\'+\', \'-\', \'*\')");
        op = inputobj.nextLine();
        answer = computeMatrixExpression(mtrx1, mtrx2, op);
        System.out.println(matrixToString(answer));

        System.out.println("enter what operation you would like to be done with the two matrix's (\'+\', \'-\', \'*\')");
        op = inputobj.nextLine();
        answer = computeMatrixExpression(mtrx1, mtrx2, op);
        System.out.println(matrixToString(answer));

    }
}
