import java.util.Scanner;

/**
 * Created by mijeong on 2017. 1. 22..
 */
public class num1011 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int T = stdin.nextInt();
        for(int i=0;i<T;i++){
            int x = stdin.nextInt();
            int y = stdin.nextInt();

            int result = 0;
            int index = 1;
            boolean flag = true;

            while (x<y){
                if(flag==true){
                    x+=index;
                    ++result;
                    flag = false;
                }else{
                    x+=index;
                    ++result;
                    index++;
                    flag = true;
                }
            }

            System.out.println(result);
        }
    }
}
