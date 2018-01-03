package baekjoon.individual;

import java.util.Scanner;

/**
 * Created by mijeong on 2017. 1. 3..
 */
public class num2558 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int a = stdin.nextInt();
        int b = stdin.nextInt();
        System.out.println(plus(a,b));
    }

    public static int plus(int a, int b){
        return a+b;
    }
}
