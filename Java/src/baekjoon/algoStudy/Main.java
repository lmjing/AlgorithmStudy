package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] inputs = sc.nextLine().toCharArray();

        int i = inputs.length - 1;
        char[] outputs = new char[(inputs.length - 1) / 3 + 1];
        int j = outputs.length - 1;
//        StringBuilder answer = new StringBuilder();
        while (i > -1) {
            int octal = 0;
            for (int pb = 1; i >= 0 && pb < 8; pb *= 2) {
                octal += pb * (inputs[i] - '0');
                i--;
            }
            outputs[j--] = (char)(octal + 48);
        }
        System.out.println(String.valueOf(outputs));
    }
}