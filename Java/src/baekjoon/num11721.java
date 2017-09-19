package baekjoon;

import java.util.Scanner;

/**
 * Created by mijeong on 2017. 1. 4..
 */
public class num11721 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        String input = stdin.nextLine();

        while(!input.isEmpty()){
            if(input.length()>10){
                System.out.println(input.substring(0,10));
                input = input.substring(10);
            }else{
                System.out.print(input);
                input = "";
            }
        }
    }
}
