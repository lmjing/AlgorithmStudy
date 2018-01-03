package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=0; i<n*2-1; i++) {
            int temp = i<n? i : n*2-2-i;
            for(int j=0; j<n*2-temp-1; j++) {
                if(j>=temp) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println("");
        }
    }
}
