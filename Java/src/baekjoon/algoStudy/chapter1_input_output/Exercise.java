package baekjoon.algoStudy.chapter1_input_output;

import java.util.Scanner;

public class Exercise {
    public void num2741() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1; i<=n; i++) {
            System.out.println(i);
        }
    }

    public void num2742() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = n; i>0; i--) {
            System.out.println(i);
        }
    }

    public void num2739() {
        //구구단
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1; i<10; i++) {
            System.out.println(n + " * " + i + " = " + (n * i));
        }
    }

    public void num1924() {
        //2007년 한정, 날짜 주어졌을 때 요일 맞추기
        int[] dayCount = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] weekOfDay = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int date = y;

        for(int i=1; i<x; i++) {
            date += dayCount[i];
        }
        System.out.println(weekOfDay[date % 7]);
    }

    public void num8393() {
        // 1부터 n까지의 합
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(n * (n+1) / 2);
    }

    public void num10818() {
        // 최소, 최대
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int max = -1000001;
        int min = 1000001;
        for(int i = 0; i < n; i++) {
            int input = sc.nextInt();
            max = max < input ? input : max;
            min = min > input ? input : min;
        }
        System.out.println(min + " " + max);
    }
}
