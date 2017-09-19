package baekjoon;

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
            int half = (y-x)/2;

            while(half>index){
                half -= index;
                x+=index*2;
                index++;
                result+=2;
            }

            if(y-x<index-1){
                --index;
                x-=index*2;
                result-=2;
                if(y-x>=index*2+1){
                    x+=index+1;
                    result+=1;
                }
            }

            while (x<y){
                if(y-x>=index){
                    x+=index;
                    ++result;
                }else --index;
            }

            System.out.println(result);
        }
    }
}

/*
#include <stdio.h>

int main(void) {

    int T = 0;
    scanf("%d",&T);
    int i=0;

    for(i=0;i<T;i++){
    	int x=0, y=0;
    	scanf("%d",&x);
    	scanf("%d",&y);

        int result = 0;
        int index = 1;
        int half = (y-x)/2;
        int flag = 0;

        while(half>index){
        	half -= index;
        	x+=index*2;
        	index++;
        	result+=2;
        }

        if(y-x<index-1){
        	--index;
        	x-=index*2;
        	result-=2;
        	if(y-x>=index*2+1){
        		x+=index+1;
        		result+=1;
        	}
        }

         while (x<y){
         	if(y-x>=index){
         		x+=index;
         		++result;
         	}else --index;
        }

        printf("%d\n",result);
    }
	return 0;
}
 */