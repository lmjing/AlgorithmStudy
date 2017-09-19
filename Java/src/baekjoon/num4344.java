package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by mijeong on 2017. 1. 7..
 */
public class num4344 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);

        int count = stdin.nextInt();
        int cnt[] = new int[count];
        ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>();
        int sum[] = new int[count];

        for(int i=0; i<count; i++){
            cnt[i] = stdin.nextInt();
            array.add(new ArrayList<Integer>());
            sum[i] = 0;
            for(int j=0; j<cnt[i]; j++) {
                int temp = stdin.nextInt();
                array.get(i).add(temp);
                sum[i] += temp;
            }
        }

        double result[] = new double[count];
        for(int i=0;i<count;i++){
            int high =0;
            double avg = (double)sum[i]/(double)array.get(i).size();
            for(int jumsu:array.get(i)){
                if(jumsu>avg) high++;
            }
            result[i] = (double)high/(double)array.get(i).size()*100;
            result[i] = Math.round(result[i] * 10000d) / 10000.0;
            System.out.printf("%.3f",result[i]);
            System.out.println("%");
        }
    }
}
