package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        StringBuilder str = new StringBuilder();
        if (n <= m * k && n + 1 >= m + k) {
            str.append(flip(1, k));

            int i = k + 1;
            m--;
            n -= k;
            boolean flag = true;

            while (m > 0 && n >= m) {
                int h = n / m;
                m--;
                if (h == 1) {
                    if (flag) {
                        str.append((i++) + " ");
                        flag = false;
                        n -= 1;
                        continue;
                    }
                    h++;
                }
                str.append(flip(i, h));
                i += h;
                n -= h;
                flag = true;
            }

            System.out.println(str);
        } else System.out.println(-1);
    }

    static StringBuilder flip (int s, int count) {
        StringBuilder str = new StringBuilder();
        for (int i = s + count - 1; i >= s; i--)
            str.append(i + " ");
        return str;
    }
}