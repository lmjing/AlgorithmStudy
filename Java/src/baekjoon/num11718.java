package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mijeong on 2016. 12. 26..
 */
public class num11718 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        ArrayList<String> str = new ArrayList<>();
        int cnt = 0;

        while (stdin.hasNextLine()){
            String temp = stdin.nextLine();

            if(Pattern.matches("^([a-zA-Z0-9 ]+)", temp)
                    && !temp.startsWith(" ")
                    && !temp.endsWith(" ")
                    && temp.length()<=100
                    && cnt<100)
            {
                cnt++;
                //matches():주어진 문자열 전체가 특정 패턴과 일치하는 가를 판단
                str.add(temp);
            }
        }

        for(int i=0;i<str.size();i++){
            System.out.println(str.get(i));
        }
    }
}
