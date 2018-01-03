package baekjoon.individual;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by mijeong on 2017. 1. 12..
 */
public class num2908 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        String a = stdin.next();
        String b = stdin.next();

        String[] a_list = a.split("");
        String[] b_list = b.split("");

        int a_su = change(a_list);
        int b_su = change(b_list);

        if(a_su <= b_su){
            System.out.print(b_su);
        }else{
            System.out.print(a_su);
        }
    }

    public static int change(String[] word){
        String result = "";

        for(int i=word.length-1;i>=0;i--){
            result += word[i];
        }

        return Integer.parseInt(result);
    }
}
