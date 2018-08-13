package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        if (m + k != n + 1)
            System.out.print(-1);
        else {
            int i = 1;
            while (i < m)
            
            int s = 1, e = n;

            // 오름차순
            while (s < m)
                result.append(s++ + " ");

            result.append(e-- + " ");
            // 내림차순
            int temp = s + (k - 1);
            String des = "";
            while (s < temp)
                des = (s++) + " " + des;

            result.append(des);

            while (s <= e) {
                result.append(e-- + " ");
                if (s <= e) result.append(s++ + " ");
            }
            System.out.print(result);
        }
    }
}