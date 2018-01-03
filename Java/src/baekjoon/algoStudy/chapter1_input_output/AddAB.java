package baekjoon.algoStudy.chapter1_input_output;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class AddAB {
    public void num1000() throws IOException {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.print(a + b);

        //이걸로 하면 시간 더 빠름
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        char[] test = new char[3];
//        br.read(test);
//        System.out.print(Integer.parseInt(String.valueOf(test[0])) + Integer.parseInt(String.valueOf(test[2])));
    }
}
