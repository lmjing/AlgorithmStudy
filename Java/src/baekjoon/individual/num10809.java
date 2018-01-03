package baekjoon.individual;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by mijeong on 2016. 12. 2..
 */
public class num10809 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        String input = stdin.next();
        String[] get_alpha = input.split("");
        String[] alplah = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        HashMap<String,Integer> r = new HashMap<>();
        r.clear();
        for(String s : alplah)
            r.put(s,-1);

        for(int i=0;i<get_alpha.length;i++){
           if(r.get(get_alpha[i]) == -1)
               r.put(get_alpha[i],i);
        }

        for(int i=0;i<r.size();i++){
            System.out.print(r.get(alplah[i])+" ");
        }

    }
}
