package baekjoon;

import java.util.Scanner;

/**
 * Created by mijeong on 2016. 12. 2..
 */
public class num2675 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);

        int num = stdin.nextInt();
        int[] cnt = new int[num];
        String[] word = new String[num];

        String[] result = new String[num];

        for(int i=0;i<num;i++){
            cnt[i]=stdin.nextInt();
            word[i]=stdin.next();
            result[i] = newString(word[i],cnt[i]);
        }

        for(String a:result)
            System.out.println(a);
    }

    public static String newString(String str, int cnt){
        String[] one = str.split("");
        String result = "";
        for(int j=0;j<one.length;j++)
            for(int i=0;i<cnt;i++)
                result+=one[j];

        return result;
    }
}
