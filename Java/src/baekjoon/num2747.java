package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by mijeong on 2016. 12. 7..
 */
public class num2747 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int cnt = stdin.nextInt();

        ArrayList<Integer> pivo = new ArrayList<>();
        pivo.add(0);
        pivo.add(1);
        for(int i=2;i<=cnt;i++){
            int su = pivo.get(i-2)+pivo.get(i-1);
            pivo.add(su);
        }
        System.out.print(pivo.get(cnt));
    }
}
