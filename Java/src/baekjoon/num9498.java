package baekjoon;/*
시험 점수를 입력받아 90 ~ 100점은 A, 80 ~ 89점은 B, 70 ~ 79점은 C, 60 ~ 69점은 D, 나머지 점수는 F를 출력하는 프로그램을 작성하시오.
 */
import java.util.*;

public class num9498 {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        Integer jumsu = stdin.nextInt();

        if(jumsu>=90&&jumsu<=100)
            System.out.print("A");
        else if(jumsu>=80&&jumsu<90)
            System.out.print("B");
        else if(jumsu>=70&&jumsu<80)
            System.out.print("C");
        else if(jumsu>=60&&jumsu<70)
            System.out.print("D");
        else
            System.out.print("F");
    }
}
