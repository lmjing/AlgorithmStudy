package baekjoon;

import java.util.Scanner;

/**
 * Created by mijeong on 2016. 12. 1..
 * 3*2^k     k<=10
 * timeout
 */


/*
string => char로 바꾸고
이중 for문으로 하나하나 print하지 않고
for문 하나만 사용하여 char행들을 프린트한 결과 시간단축됨
 */
public class num2448 {
    static char [][] star;
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int insert = stdin.nextInt();

        int temp = insert/3;
        int width = (insert-1)*2;
        star = new char [insert][width+1];

        for(int i=0;i<insert;i++){
            for(int j=0;j<=width;j++)
                star[i][j]=' ';
        }

        triangle(0,width/2,insert,temp);

        for(int i=0;i<insert;i++){
            System.out.println(star[i]);
        }
    }

    public static void triangle(int start_y,int start_x,int height, int count){
        if(count==1){
            star[start_y][start_x]='*';
            star[start_y+1][start_x-1]='*';
            star[start_y+1][start_x+1]='*';
            for(int i=-2;i<3;i++)
                star[start_y+2][start_x+i]='*';
        }else{
            height/=2;
            int temp = (count*3)/2;
            triangle(start_y+height,start_x-temp,height,count/2);
            triangle(start_y+height,start_x+temp,height,count/2);
            triangle(start_y,start_x,height,count/2);
        }
    }
}
