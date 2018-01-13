package baekjoon.algoStudy.chapter2_brute_force_search1;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class UsingPermutation {
    public void num10819_fail1() {
        // 규칙 찾아 적용하였으나 테스트케이스 끝 부분쯤에 틀렸다고 나옴.
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        LinkedList<Integer> arrayList = new LinkedList<Integer>();
        LinkedList<Integer> minusList = new LinkedList<Integer>();
        for (int i=0; i<n; i++) {
            int su = sc.nextInt();
            if (su < 0) minusList.add(su);
            else arrayList.add(su);
        }

        int answer = 0;
        // 음수의 개수가 양수보다 1 작을 경우 -(-)가 되어 모두 + 가 된다.
        // 따라서 처음 + 마지막 + (중간 값들의 합 x 2)을 하면 답
        // 그러니 처음, 마지막이 당연히 가장 작은 양수들이여야 할 것
        if (minusList.size() * 2 + 1 == n) {
            Collections.sort(arrayList);
            for (int i : minusList) answer += i * (-2);
            answer += arrayList.removeFirst() + arrayList.removeFirst();
            for (int i : arrayList) answer += i * 2;
            System.out.println(answer);
        }else {
            arrayList.addAll(minusList);
            Collections.sort(arrayList);

            int max = arrayList.removeLast();
            int before = max;
            while (arrayList.size() > 1) {
                int small = arrayList.removeFirst();
                answer += Math.abs(before - small);
                before = small;

                if (arrayList.size() == 1) break;
                int large = arrayList.removeLast();
                answer += Math.abs(before - large);
                before = large;
            }
            int last = arrayList.getLast();
            // 마지막에 남은 값은 위의 맨 마지막 값과 최대값과의 차이 중 큰 것의 값을 결과에 더하면 된다.
            int diff1 = Math.abs(max - last); int diff2 = Math.abs(before - last);
            answer += diff1 > diff2 ? diff1 : diff2;
            System.out.println(answer);
        }
    }

    public static void num10819() {
        // 8!만큼 다 순열 일일이 하는 방식
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int[] permutationList = new int[n];
        for (int i=0; i<n; i++) {
            permutationList[i]= sc.nextInt();
        }
        Arrays.sort(permutationList);

        int max = 0;
        int calOfList;
        do {
            calOfList = cal(permutationList);
            max = max < calOfList ? calOfList : max;
        } while (next_permutation(permutationList));

        System.out.println(max);
    }

    private static int cal(int[] list) {
        int sum = 0;
        for (int i=1; i<list.length; i++) {
            sum += Math.abs(list[i] - list[i-1]);
        }
        return sum;
    }

    private static boolean next_permutation(int[] array) {
        int i = array.length-1;
        while (i > 0 && array[i] <= array[i-1]) i--;
        if (i <= 0) return false;

        int j = array.length-1;
        while (array[j] <= array[i-1]) j--;

        swap(array, i-1, j);
        j = array.length - 1;
        while (i < j) {
            swap(array, i, j);
            ++i; --j;
        }
        return true;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void num10971() {
        // 방식 : n의 범위가 적어 이동 순열을 일일이 나열한 후 합을 구하고 최소값과 비교하였다.
        // 첫번째 시도 틀린 이유 : 0일 경우 못간다는 예외처리를 하지 않음. 즉 0을 더해버렸으므로 이 값이 최소가 되어 다른 답이 나왔었음
        // TODO : 나중에 나오겠지만, DP 식으로 재귀함수 사용해서 풀어 볼 것
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] inputArray = new int[n][n];
        int[] permutation = new int[n];
        for (int i=0; i<n; i++) {
            permutation[i] = i;
            for (int j=0; j<n; j++) {
                inputArray[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }

        int min = 99999999;
        do {
            int sum = 0;
            for (int i=0; i<n; i++) {
                int start = permutation[i];
                int end = permutation[i>=n-1 ? 0 : i+1];
                if (inputArray[start][end] == 0) {
                    sum = -1; break;
                }
                sum += inputArray[start][end];
            }
            min = min > sum && sum > 0 ? sum : min;
        } while (next_permutation(permutation));
        System.out.println(min);
    }
}
