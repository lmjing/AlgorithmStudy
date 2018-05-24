package baekjoon.algoStudy;

import java.util.*;

public class Main {
    // Diff : 부분집합의 합과 다른 것 = 공집합이 없음
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