package baekjoon.individual;

import java.util.Scanner;

/**
 * Created by mijeong on 2017. 1. 19..
 */
public class num1427 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        String input = stdin.nextLine();
        String[] array = input.split("");
        for(int i=0; i<array.length-1; i++){
            int max = Integer.parseInt(array[i]);
            int index = i;
            for(int j=i+1;j<array.length;j++){
                int temp = Integer.parseInt(array[j]);
                if(max < temp){ max = temp; index = j; }
            }
            array[index] = array[i];
            array[i] = String.valueOf(max);
        }
        for(String s : array) System.out.print(s);
    }
}
