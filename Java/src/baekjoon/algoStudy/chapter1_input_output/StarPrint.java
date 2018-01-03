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

    public void num2439() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            for(int j = n-1; j > i; j--) {
                System.out.print(" ");
            }
            for(int k = 0; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public void num2440() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            for(int j = n; j > i; j--) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public void num2441() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = n; i > 0; i--) {
            for(int j = n - i; j > 0; j--) {
                System.out.print(" ");
            }
            for(int k = 0; k < i; k++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public void num2442() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1; i<=n; i++) {
            for(int j=n; j>i; j--) {
                System.out.print(" ");
            }
            for(int k=1; k<2*i; k++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
