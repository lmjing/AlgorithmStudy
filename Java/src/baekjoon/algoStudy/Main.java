package baekjoon.algoStudy;

import java.util.*;

public class Main {

    static int n;
    static int s;
    static int[] array;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.nextInt();
        array = new int[n];
        for (int i=0; i<n; i++) {
            array[i] = sc.nextInt();
        }
        Subset subset = new Subset();
        System.out.println(subset.getAnswer());
    }

    static class Subset {
        long[] frontHalf;
        long[] afterHalf;
        int frontArrow = 0;
        int afterArrow = 0;
        int idx = 0;

        public Subset() {
            int half = n / 2;
            frontHalf = new long[(int) Math.pow(2, half)];
            afterHalf = new long[(int) Math.pow(2, n - half)];

            makeSubset(0, half, 0,true);
            idx = 0;
            makeSubset(half, n, 0, false);
            Arrays.sort(frontHalf);
            Arrays.sort(afterHalf);
            afterArrow = afterHalf.length-1;
        }

        public int getAnswer() {
            int count = 0;
            while (frontArrow < frontHalf.length && afterArrow >= 0) {
                long a = frontHalf[frontArrow];
                long b = afterHalf[afterArrow];
                long sum = a + b;
                if(sum == s && !(a == 0 && b == 0))  {
                    int i1 = 1; int i2 = 1;
                    while (++frontArrow < frontHalf.length && frontHalf[frontArrow] == a) i1++;
                    while (--afterArrow >= 0 && afterHalf[afterArrow] == b) i2++;
                    count += i1 * i2;
                }else {
                    if (sum >= 0) afterArrow--;
                    else frontArrow++;
                }
            }
            return count;
        }

        private void makeSubset(int ai, int e, int sum, boolean flag) {
            long[] halfArray = flag ? frontHalf : afterHalf;

            if(ai == e) {
                halfArray[idx++] = sum;
                return;
            }
            makeSubset(ai + 1, e, sum, flag);
            makeSubset(ai + 1, e, sum + array[ai], flag);
        }
    }
}