package baekjoon.individual;

import java.util.Scanner;

/**
 * Created by mijeong on 2016. 12. 5..
 */
//USE: 소수 찾기

public class num1978 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int result = 0;

        for(int i=0;i<cnt;i++){
            int a = sc.nextInt();
            if(check(a)==true) result++;
        }

        System.out.print(result);
    }

    static boolean check(int num){
        if(num==1) return false;
        for(int i=2;i<num;i++){
            if(num%i==0)
                return false;
        }
        return true;
    }
}
