/**
 * Created by mijeong on 2017. 1. 11..
 */
import java.util.*;

public class num1157 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        String input = stdin.nextLine();
        String[] origin = input.toUpperCase().split("");
        HashMap<String,Integer> word_cnt = new HashMap<>();

        for(String s : origin){
            if(word_cnt.containsKey(s)){
               int temp = word_cnt.get(s);
                word_cnt.replace(s,temp+1);
            }else{
                word_cnt.put(s,1);
            }
        }

        String result = null;
        int max = 0;
        boolean flag = false;

        for(String s : word_cnt.keySet()){
            if(max < word_cnt.get(s)){
                max = word_cnt.get(s);
                result = s;
                flag = false;
            }else if(max == word_cnt.get(s)) flag = true;
        }

        if(flag == true) System.out.print("?");
        else System.out.print(result);
    }

}
