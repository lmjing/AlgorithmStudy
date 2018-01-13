package baekjoon.algoStudy.chapter2_brute_force_search1;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class UsingPermutation {
    public void num10819_fail1() {
        // 규칙 찾아 적용하였으나 테스트케이스 끝 부분쯤에 끝났다고 나옴.
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        LinkedList<Integer> arrayList = new LinkedList<Integer>();
        for (int i=0; i<n; i++) {
            arrayList.add(sc.nextInt());
        }
        Collections.sort(arrayList);

        int answer = 0;
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
}
