import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by mijeong on 2017. 1. 12..
 */
public class num1316 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);

        int cnt = stdin.nextInt();
        String[] word = new String[cnt];
        for(int i=0; i<cnt; i++)
            word[i] = stdin.next();

        int result = 0;

        for(int i=0;i<cnt;i++){
            ArrayList<String> list = new ArrayList<>();
            String[] temp = word[i].split("");
            String before = temp[0];
            list.add(temp[0]);
            boolean flag = true;
            for(int j=1; j<=temp.length; j++){
                if(j==temp.length){
                    if(flag == true){
                        result++;
                        break;
                    }
                }

                if(!temp[j].equals(before)){
                    if(list.contains(temp[j])){
                        flag = false;
                        break;
                    }
                    else list.add(temp[j]);
                }
                before = temp[j];
            }
        }

        System.out.print(result);
    }
}
