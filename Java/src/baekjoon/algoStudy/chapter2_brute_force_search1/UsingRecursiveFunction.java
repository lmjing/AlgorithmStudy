package baekjoon.algoStudy.chapter2_brute_force_search1;

import java.util.Scanner;

public class UsingRecursiveFunction {
    static void num9095() {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for (int i=0; i<T; i++) {
            int n = Integer.parseInt(sc.nextLine());
            System.out.println(cal(n));
        }
    }
    
    static int cal(int n) {
        if (n < 1) return 0;
        int sum = 0;
        // 앞자리가 i일 경우
        for (int i=1; i<=3; i++) {
            if (i>=n) {
                sum ++;
                break;
            }
            int diff = n - i;
            sum += cal(diff);
        }
        return sum;
    }
}
