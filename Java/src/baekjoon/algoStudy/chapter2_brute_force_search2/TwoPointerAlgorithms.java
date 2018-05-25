package baekjoon.algoStudy.chapter2_brute_force_search2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TwoPointerAlgorithms {
    static class Num2143 {
        // Diff : 부분집합의 합과 다른 것 = 공집합이 없음
        // USE : Two Point, 부분 합
        // BEFORE : count는 int로 함
        // AFTER : count를 long으로 바꿈
        // NOTE : 여러가지 버전 acmicpc에 있으니 참고할 것, 이게 젤 메모리랑 시간이 적음
        static Scanner sc;
        public static void main (String[] args) {
            sc = new Scanner(System.in);
            int T = sc.nextInt();
            Array firstArray = new Array(sc.nextInt());
            firstArray.setInitArray();
            Array secondArray = new Array(sc.nextInt());
            secondArray.setInitArray();

            Arrays.sort(firstArray.subSumArray);
            Arrays.sort(secondArray.subSumArray);

            int fi = 0; int si = secondArray.last - 1;
            long result = 0;

            while (fi < firstArray.last && si >= 0) {
                long f = firstArray.subSumArray[fi];
                long s = secondArray.subSumArray[si];
                long sum = f + s;

                if (sum == T) {
                    long cnt1 = 1; long cnt2 = 1;
                    while (++fi < firstArray.last && firstArray.subSumArray[fi] == f) cnt1++;
                    while (--si >= 0 && secondArray.subSumArray[si] == s) cnt2++;
                    result += cnt1 * cnt2;
                }else if (sum > T) --si;
                else ++fi;
            }

            System.out.println(result);
        }

        static class Array {
            int n;
            int last = 0;
            long[] subSumArray;
            long[] sumTempArray;

            public Array(int n) {
                this.n = n;
                sumTempArray = new long[n + 1];
                int size = (n/2) * (1 + n);
                if (n % 2 == 1) size += n/2 + 1;

                subSumArray = new long[size];
            }

            public void setInitArray() {
                for (int i = 1; i <= n; i++) {
                    int num = sc.nextInt();
                    for (int j=i; j>0; j--) {
                        long sum = sumTempArray[j-1] + num;
                        sumTempArray[j] = sum;
                        subSumArray[last++] = sum;
                    }
                }
            }
        }
    }

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

    public static void num7453() {
        Scanner sc = new Scanner(System.in);
        int[][] input;
        int[] index = {0, 0, 0, 0};
        long count = 0;
        int n;

        n = sc.nextInt();
        input = new int[n][4];
        for (int i=0; i<n; i++) {
            for (int j=0; j<4; j++) {
                input[i][j]= sc.nextInt();
            }
        }

        int N = n*n;
        long[] front = new long[N];
        long[] back = new long[N];

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                front[i * n + j] = input[i][0] + input[j][1];
                back[i * n + j] = input[i][2] + input[j][3];
            }
        }

        Arrays.sort(front);
        Arrays.sort(back);

        int fi = 0;
        int bi = N - 1;

        while (fi < N && bi >= 0) {
            long f = front[fi]; long b = back[bi];
            if (f * b == 1) break;

            long sum = f + b;
            if (sum == 0) {
                long c1 = 1, c2 = 1;
                while (++fi < N && front[fi] == f) c1++;
                while (--bi >= 0 && back[bi] == b) c2++;
                count += c1 * c2;
            }else if (sum > 0) bi--;
            else fi++;
        }

        System.out.println(count);
    }
}
