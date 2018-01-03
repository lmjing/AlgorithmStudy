package baekjoon.individual;

import java.util.Scanner;

/**
 * Created by mijeong on 2016. 12. 2..
 */
public class num8958 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int cnt = stdin.nextInt();
        String[] testcase = new String[cnt];
        for(int i=0;i<cnt;i++) {
            testcase[i] = stdin.next();
            System.out.println(count(testcase[i]));
        }
    }

    static int count(String str){
        int total = 0;
        int temp = 0;
        String[] ox = str.split("");
        for(String a:ox){
            if(a.equals("O")) ++temp;
            else temp=0;

            total+=temp;
        }
        return total;
    }
}
