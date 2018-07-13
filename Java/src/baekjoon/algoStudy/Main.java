package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int num = 0;
        int sum = 0;
        int answer = 0;
        boolean flag = true;
        for (char c : input.toCharArray()) {
            int su = c - '0';
            if (su < 0) {
                sum += num;
                num = 0;
                if (c == '-') {
                    if (flag) answer += sum;
                    else answer -= sum;
                    sum = 0;
                    flag = false;
                }
            } else num = num * 10 + (c - '0');
        }
        sum += num;
        System.out.println(answer + (flag ? sum : -1 * sum));
    }
}