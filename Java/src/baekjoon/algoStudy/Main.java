package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] input = new int[n][2]; // 0 : vaule, 1 : sum
        int max = 0;

        for (int i = 0; i < n; i++) {
            int vaule = sc.nextInt();
            input[i][0] = vaule;
            input[i][1] = vaule;
            for (int j = 0; j < i; j++) {
                if (vaule > input[j][0])
                    input[i][1] = Math.max(input[i][1], input[j][1] + vaule);
            }
            max = max < input[i][1] ? input[i][1] : max;
        }
        System.out.println(max);
    }
}