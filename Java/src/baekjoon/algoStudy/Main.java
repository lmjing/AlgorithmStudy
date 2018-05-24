package baekjoon.algoStudy;

import java.util.*;

public class Main {
    // Diff : 부분집합의 합과 다른 것 = 공집합이 없음
    static Scanner sc;
    public static void main (String[] args) {
//        sc = new Scanner(System.in);
//        int T = sc.nextInt();
//        Array firstArray = new Array(sc.nextInt());
//        firstArray.setInitArray();
//        Array secondArray = new Array(sc.nextInt());
//        secondArray.setInitArray();

//        for (int i = 1; i <= n; i++) {
//            int num = sc.nextInt();
//            for (int j=i; j>0; j--) {
//                long sum = sumTempArray[j-1] + num;
//                sumTempArray[j] = sum;
//                subSumArray[last++] = sum;
//            }
//        }
//
//
//        Arrays.sort(firstArray.subSumArray);
//        Arrays.sort(secondArray.subSumArray);
//
//        int fi = 0; int si = secondArray.last - 1;
//        long result = 0;
//
//        while (fi < firstArray.last && si >= 0) {
//            long f = firstArray.subSumArray[fi];
//            long s = secondArray.subSumArray[si];
//            long sum = f + s;
//
//            if (sum == T) {
//                int cnt1 = 1; int cnt2 = 1;
//                while (++fi < firstArray.last && firstArray.subSumArray[fi] == f) cnt1++;
//                while (--si >= 0 && secondArray.subSumArray[si] == s) cnt2++;
//                result += cnt1 * cnt2;
//            }else if (sum > T) --si;
//            else ++fi;
//        }
//
//        System.out.println(result);

        sc = new Scanner(System.in);
        int T = sc.nextInt();

        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i=0; i<n; i++) a[i] = sc.nextInt();

        int m =sc.nextInt();
        int[] b = new int[m];

        for (int i=0; i<m; i++) b[i] = sc.nextInt();

        Vector<Integer> a1 = new Vector<>();
        for (int i=0; i<n; i++) {
            int sum = a[i];
            a1.add(sum);
            for (int j=i+1; j<n; j++) {
                sum += a[j];
                a1.add(sum);
            }
        }

        Vector<Integer> b1 = new Vector<>();
        for (int i=0; i<m; i++) {
            int sum = b[i];
            b1.add(sum);
            for (int j=i+1; j<m; j++) {
                sum += b[j];
                b1.add(sum);
            }
        }

        Collections.sort(a1);
        Collections.sort(b1);

        int ai = 0; int bi = b1.size() - 1;
        long result = 0;

        while (ai < a1.size() && bi >= 0) {
            int f = a1.get(ai);
            long s = b1.get(bi);
            long sum = f + s;

            if (sum == T) {
                int cnt1 = 1; int cnt2 = 1;
                while (ai + 1 < a1.size() && a1.get(ai + 1) == f) {
                    cnt1++; ai++;
                }
                while (bi - 1 >= 0 && b1.get(bi - 1) == s) {
                    cnt2++; bi--;
                }
                result += cnt1 * cnt2;
                ai++;
            }else if (sum > T) --bi;
            else ++ai;
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

        public void setInitArray(int[] array) {
            for (int i = 1; i <= n; i++) {
                int num = array[i-1];
                for (int j=i; j>0; j--) {
                    long sum = sumTempArray[j-1] + num;
                    sumTempArray[j] = sum;
                    subSumArray[last++] = sum;
                }
            }
        }
    }
}