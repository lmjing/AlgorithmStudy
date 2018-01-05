package baekjoon.algoStudy;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n];
        int index = 0;
        for (String s : br.readLine().split(" ")) {
            input[index++] = Integer.parseInt(s);
        }

        String answer = null;
        for (int i=n-1; i>0; i--) {
            if (input[i] < input[i-1]) {
                for(int j=n-1; j>=i; j--) {
                    if (input[i-1] > input[j]) {
                        swap(input, i-1, j);
                        answer = makeAnswer(input, i);
                        break;
                    }
                }
                break;
            }
        }

        System.out.println(answer != null ? answer : -1);
    }

    static void swap(int[] array, int i, int j) {
        //배열은 call by reference
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    static String makeAnswer(int[] array, int i) {
        String answer = "";
        for (int j=0; j<i; j++) {
            answer += array[j] + " ";
        }
        for (int j=array.length-1; j>=i; j--) {
            answer += array[j] + " ";
        }
        return answer;
    }
}
