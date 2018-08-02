package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int answer = 0;
        if (n > 2 ) {
            if (m > 4) {
                answer = 3;
                if (m - 7 > 0)
                    answer += (m - 5);
                else
                    answer += (m - 3) / 2;
            } else answer = m;
        } else answer = (m - 1) / 2 + 1;
        System.out.println(answer);
    }
}