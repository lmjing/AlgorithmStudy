package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=1; i<n*2; i++) {
            for(int j=1; j<=n; j++) {
                int temp = i<=n ? i : n*2-i;
                if(j <= n-temp) System.out.print(" ");
                else System.out.print("*");
            }
            System.out.println("");
        }
    }
}
