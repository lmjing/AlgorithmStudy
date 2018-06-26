package baekjoon.algoStudy;

import java.util.*;

public class Main {
    static int[] max;
    static int[] price;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        price = new int[n + 1];
        max = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            price[i] = sc.nextInt();
            max[i] = price[i];
            for (int j = i - 1; j >= i / 2 && i > 1; j--) {
                if (max[j] + price[i - j] > max[i]) max[i] = max[j] + price[i - j];
            }
        }

        System.out.println(max[n]);
    }

    public static int goTo (int n) {
        if (max[n] == 0) {
            max[n] = price[n];
            if (n > 1) {
                for (int j = n - 1; j >= n / 2; j--) {
                    if (goTo(j) + price[n - j] > max[n]) max[n] = max[j] + price[n - j];
                }
            }
        }
        return max[n];
    }
}