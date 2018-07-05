package baekjoon.algoStudy;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n];
        int[] count = new int[1001];

        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }

        count[input[0]] = 1;
        int[] max = { 1, 1 };

        for (int i = 1; i < n; i++) {
            int smallIdx = i - 1;
            while (smallIdx >= 0 && input[smallIdx] >= input[i]) smallIdx--;
            count[input[i]] = smallIdx >= 0 ? count[input[smallIdx]] + 1 : 1;

            int v = input[i];
            if (max[0] < v) count[v] = max[1] + 1;
            else {
                if (v > input[i - 1])
                    count[v] = Math.max(count[v], count[input[i - 1]]);

            }


            if (max[0] < input[i]) count[input[i]] = max[1] + 1;
            else if (max[0] > input[i]){
                int smallIdx = i - 1;
                while (smallIdx >= 0 && input[smallIdx] >= input[i]) smallIdx--;
                count[input[i]] = smallIdx >= 0 ? count[input[smallIdx]] + 1 : 1;

                if (input[i - 1] < input[i])
                    count[input[i]] = Math.max(count[input[i]], count[input[i - 1]] + 1);
            }

            if (max[1] < count[input[i]]) {
                max[0] = input[i];
                max[1] = count[input[i]];
            }
        }
        System.out.print(max[1]);
    }
}