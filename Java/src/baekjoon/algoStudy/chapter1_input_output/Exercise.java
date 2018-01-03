package baekjoon.algoStudy.chapter1_input_output;

import java.util.Scanner;

public class Exercise {
    public void num2741() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1; i<=n; i++) {
            System.out.println(i);
        }
    }

    public void num2742() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = n; i>0; i--) {
            System.out.println(i);
        }
    }
}
