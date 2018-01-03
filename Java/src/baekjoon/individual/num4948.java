package baekjoon.individual;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by mijeong on 2017. 1. 27..
 */
public class num4948 {
    public static void main (String[] args) {
        Scanner stdin = new Scanner(System.in);

        ArrayList<Integer> prime = getprime();
        while (true) {
            int n = stdin.nextInt();
            if (n == 0) break;

            int[] arr = new int[n*2-n];

            for(int p : prime){
                if(p>(int)Math.sqrt(n*2)) break;
                int min = n*2;
                if(n>=p){
                    min = n/p + 1;
                }
                int index = min*p - (n+1);
                for(int i = min*p; i<=n*2; i+=p){
                    arr[index] = 1;
                    index+=p;
                }
            }

            int count = 0;
            for (int i : arr){
                if(i==0) count++;
            }

            System.out.println(count);
        }
    }

    static ArrayList<Integer> getprime(){
        ArrayList<Integer> prime = new ArrayList<Integer>();
        for(int i=2;i<=123456;i++){
            boolean flag = true;
            for(int a=0;a<prime.size();a++){
                if(i%prime.get(a)==0){
                    flag = false;
                    break;
                }
            }
            if(flag == true){
                prime.add(i);
            }
        }
        return prime;
    }
}