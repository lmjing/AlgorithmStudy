package baekjoon;

import java.util.Scanner;

/**
 * Created by mijeong on 2016. 12. 2..
 */

/*
함정 : 공백 여러개일 경우 처리 따로 해주어야 함
 */
public class num1152 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        String str = stdin.nextLine();
        String[] word;
        word = str.split(" ");

        int result = word.length;
        for(String a:word){
            if(a.equals("")) result--;
        }

        System.out.print(result);
    }
}
