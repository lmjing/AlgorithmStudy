package baekjoon.algoStudy.chapter1_input_output;

import java.util.Scanner;

public class InputOuput {
    public void num2557() {
        System.out.print("Hello World!");
    }

    public void num11718_11719() {
        //그대로 출력하기

        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
    }

    public void num11720() {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int sum = 0;
        String[] input = sc.nextLine().split("");

        for(int i=0; i<N; i++) {
            sum += Integer.parseInt(input[i]);
        }
        System.out.println(sum);
    }
}
