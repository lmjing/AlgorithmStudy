package baekjoon.algoStudy.chapter1_input_output;

import java.util.Scanner;

public class StarPrint {
    public void num2438() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
