package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
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
