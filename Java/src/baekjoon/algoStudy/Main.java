package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] inputs = sc.nextLine().toCharArray();

        int answer = 0;
        int p = 1;
        int i = inputs.length - 1;
        while (i > -1) {
            int octal = 0;
            for (int pb = 1; i >= 0 && pb < 8; pb *= 2) {
                octal += pb * (inputs[i] - '0');
                i--;
            }
            answer += p * octal;
            p *= 10;
        }
        System.out.println(answer);
    }
}