import java.util.Scanner;

/**
 * Created by mijeong on 2017. 1. 13..
 */
public class num2941 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        String input = stdin.nextLine();

        /*
        String[] croatia = {"c=","c-","dz=","d-","lj","nj","s=","z="};

        int result = 0;
        for(String cro : croatia){
            if(input.length()<1) break;
            int index = input.indexOf(cro);
            if(index != -1){
                result++;
                String a =  "";
                if(index>0) a = input.substring(0,index);
                String b = input.substring(index+cro.length());
                input = a+b;
            }
        }
        result+=input.length();
        System.out.print(result);
        */
        /*
            replaceAll => 문자열 대치 함수
         */

        int result = input.replaceAll("c=|c-|dz=|d-|lj|nj|s=|z=","a").length();
        System.out.print(result);
    }
}
