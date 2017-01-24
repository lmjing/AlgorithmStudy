import java.util.Scanner;

/**
 * Created by mijeong on 2017. 1. 24..
 */
public class num6064 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int count = stdin.nextInt();
        /* 시간초과(정말 단순한 방법)
        for(int z=0;z<count;z++){
            int M = stdin.nextInt();
            int N = stdin.nextInt();
            int input_x = stdin.nextInt();
            int input_y = stdin.nextInt();

            int x = 1, y = 1;
            int result = 1;

            while (input_x!=x||input_y!=y){
                if(x<M) x++;
                else x = 1;

                if(y<N) y++;
                else  y = 1;

                result++;

                if(x==1&&y==1){
                    result = -1;
                    break;
                }
            }
            System.out.println(result);
        }
        */
        for(int z=0;z<count;z++){
            int M = stdin.nextInt();
            int N = stdin.nextInt();
            int x = stdin.nextInt();
            int y = stdin.nextInt();

            int i = 0;
            int result = -1;

            if(M>=1&&N>=1) {
                int Max = getM(M, N);

                if (x == M && y == N) result = Max;

                for (int temp = x; temp <= Max; temp = i * M + x) {
                    if (temp % N == y) {
                        result = temp;
                        break;
                    }
                    i++;
                }
            }
            System.out.println(result);
        }
    }

    public static int getM(int x, int y){
        int result = 1;
        for(int i=2;i<=x;i++){
            if(y%i==0&&x%i==0){
                y/=i;
                x/=i;
                result *= i;
            }
        }
        result *= x;
        result *= y;
        return result;
    }
}
