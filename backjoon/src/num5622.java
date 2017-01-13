import java.util.Scanner;

/**
 * Created by mijeong on 2017. 1. 13..
 */
public class num5622 {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        String[] input = stdin.nextLine().split("");

        int result = 0;
        for (String a : input) {
            if (a.equals("A") || a.equals("B") || a.equals("C")) result += 3;
            else if (a.equals("D") || a.equals("E") || a.equals("F")) result += 4;
            else if (a.equals("G") || a.equals("H") || a.equals("I")) result += 5;
            else if (a.equals("J") || a.equals("K") || a.equals("L")) result += 6;
            else if (a.equals("M") || a.equals("N") || a.equals("O")) result += 7;
            else if (a.equals("P") || a.equals("Q") || a.equals("R") || a.equals("S")) result += 8;
            else if (a.equals("T") || a.equals("U") || a.equals("V")) result += 9;
            else if (a.equals("W") || a.equals("X") || a.equals("Y") || a.equals("Z")) result += 10;
        }

        System.out.print(result);
    }
}