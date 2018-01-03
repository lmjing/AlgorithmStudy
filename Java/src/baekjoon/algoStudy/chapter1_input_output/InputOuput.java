package baekjoon.algoStudy.chapter1_input_output;

import java.util.Scanner;

public class InputOuput {
    public void num2557() {
        System.out.print("Hello World!");
    }

    public void num11718() {
        //그대로 출력하기

        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
    }
}
