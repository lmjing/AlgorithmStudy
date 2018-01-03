package baekjoon.algoStudy.chapter1_input_output;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

    public void num2558() throws IOException {
//        Scanner scanner = new Scanner(System.in);
//        int a = Integer.parseInt(scanner.nextLine());
//        int b = Integer.parseInt(scanner.nextLine());
//        System.out.print(a + b);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        System.out.print(a + b);
    }

    public void num10950() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] answer = new int[T];

        for(int i=0; i<T; i++) {
            char[] c = new char[3];
            br.read(c);
            br.skip(1);
            answer[i] = Integer.parseInt(String.valueOf(c[0])) + Integer.parseInt(String.valueOf(c[2]));
        }

        for (int a:answer) {
            System.out.println(a);
        }
    }

    public void num10951() throws IOException {
        // Scanner만 hasNext 함수가 있기 때문에 EOF를 알 수 있다.
        // 백준에서 입력, 출력 나눠서 한꺼번에 보여줄 필요가 없다...
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a + b);
        }
    }
}
