package baekjoon.algoStudy.chapter2_brute_force_search2;

import java.util.ArrayList;
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

    public static void num1644() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> primeList = getprime(n);
        int l = 0, r = 0, ans = 0;
        //BEFORE: primeList.get(0)으로 했더니 런타임 오류남
        //AFTER: input이 자연수인데 1일 때 처리를 안해줌
        int sum = primeList.isEmpty() ? 0 : primeList.get(0);
        while (r < primeList.size() && l<=r) {
            if (sum == n)
                ans++;
            if (sum > n) {
                sum -= primeList.get(l);
                l++;
            }else {
                r++;
                if (r < primeList.size())
                    sum += primeList.get(r);
            }
        }
        System.out.println(ans);
    }

    //USE: 소수 찾기(에라토스테네스의 체 이용)
    static ArrayList<Integer> getprime(int n){
        boolean[] check = new boolean[n+1];
        ArrayList<Integer> prime = new ArrayList<Integer>();
        for(int i=2; i<=n; i++){
            if (!check[i]) {
                prime.add(i);

                for (int p=i*2; p<=n; p+=i) {
                    check[p] = true;
                }
            }
        }
        return prime;
    }
}
