package baekjoon.algoStudy.chapter2_brute_force_search2;

import java.util.Scanner;

public class TwoPointerAlgorithms {
    public static void num2003() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] input = new int[n+1];
        sc.nextLine();
        for (int i=0; i<n; i++) input[i] = sc.nextInt();
        int i = 0, j = 0;
        int sum = input[0], count = 0;
        while (j < n && i <= j) {
            if (sum < m) {
                j++;
                sum += input[j];
            }else if (sum == m) {
                count++;
                sum -= input[i]; i++;
                j++; sum += input[j];
            }else if (sum > m) {
                sum -= input[i];
                i++;
                if (i > j) {
                    j++;
                    sum += input[j];
                }
            }
        }
        System.out.println(count);
    }

    public static void num1806() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] input = new int[n+1];
        sc.nextLine();
        for (int i=0; i<n; i++) input[i] = sc.nextInt();
        int i = 0, j = 0;
        int sum = input[0], min = 100000;
        while (j < n && i <= j) {
            if (sum < s) {
                j++;
                sum += input[j];
            }else if (sum >= s) {
                min = min > j-i+1 ? j-i+1 : min;
                sum -= input[i];
                i++;
                if (i > j) {
                    j++;
                    sum += input[j];
                }
            }
        }
        System.out.println(min == 100000 ? 0 : min);
    }
}
