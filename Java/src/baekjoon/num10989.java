package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by mijeong on 2017. 1. 22..
 */
public class num10989 {
    public static void main(String[] args) throws IOException {
        /* java scanner 너무느림
        Scanner stdin = new Scanner(System.in);
        */
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        String input_c = stdin.readLine();
        int count = Integer.parseInt(input_c);
        int[] input = new int[10001];
        int max = 0;
        for(int i=0;i<count;i++){
            String inp = stdin.readLine();
            int temp = Integer.parseInt(inp);
            input[temp]++;
            if(max<temp) max = temp;
        }

        /* 이거 자바는 안되고 c만됨 ㅎㅎㅎ c언어로 갈아탈거야*/
        int cnt = 0;
        for(int i=1;i<=max;i++){
            if(cnt>=count) break;
            if(input[i]>0){
                for (int j=0;j<input[i];j++){
                    System.out.println(i);
                    cnt++;
                }
            }
        }

        /* 시간초과 - 선택정렬 시간복잡 O(n^2)
        for(int i=0;i<count-1;i++){
            int min = i;
            for(int j=i+1;j<count;j++){
                if(input[j]<input[min]) min = j;
            }
            int temp = input[i];
            input[i] = input[min];
            input[min] = temp;
            System.out.println(input[i]);
        }
        System.out.println(input[input.length-1]);
        */

        /*
        quick(input,0,count-1);
        for(int a : input){
            System.out.println(a);
        }
        */
    }

    /*
    public static void quick(int[] input,int left,int right){
        if(left<right) {
            int low = left+1;
            int high = right;
            int pivot = left;

            while (low < high) {
                while (input[low] < input[pivot]) {
                    low++;
                }
                while (input[high] > input[pivot]) {
                    high--;
                }
                if (low < high) {
                    int temp = input[low];
                    input[low] = input[high];
                    input[high] = temp;
                }
            }
            int temp = input[pivot];
            input[pivot] = input[high];
            input[high] = temp;

            quick(input,left,high-1);
            quick(input,high+1,right);
        }
    }
    */
}
