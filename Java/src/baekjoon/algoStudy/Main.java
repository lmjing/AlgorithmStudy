package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int team = n / 2 < m ? n / 2 : m;
        int rest = (n + m) - team * 3;
        k -= rest;
        System.out.println(team - ((k + 2) / 3));
    }
}