package baekjoon.algoStudy;

import java.util.*;

public class Main {
    static int[] tile;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        tile = new int[n+1];
        tile[1] = 1;
        if (n > 1) tile[2] = 3;

        System.out.println(goTo(n));
    }

    public static int goTo (int n) {
        if (n > 2)
            tile[n] = (goTo(n-1) + tile[n-2] * 2) % 10007;
        return tile[n];
    }
}