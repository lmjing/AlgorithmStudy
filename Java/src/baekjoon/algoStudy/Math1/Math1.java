package baekjoon.algoStudy.Math1;

import java.util.*;

public class Math1 {
    public static void num11005() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();

        String str = new String();
        while (n > 0) {
            int r = n % b;
            str = (char)(r + (r < 10 ? 48 : 55)) + str;
            n -= r;
            n /= b;
        }
        System.out.print(str);
    }

    public static void num1373() {
        Scanner sc = new Scanner(System.in);
        char[] inputs = sc.nextLine().toCharArray();

        int i = inputs.length - 1;
        char[] outputs = new char[(inputs.length - 1) / 3 + 1];
        int j = outputs.length - 1;
        while (i > -1) {
            int octal = 0;
            for (int pb = 1; i >= 0 && pb < 8; pb *= 2) {
                octal += pb * (inputs[i] - '0');
                i--;
            }
            outputs[j--] = (char)(octal + 48);
        }
        System.out.println(String.valueOf(outputs));
    }
}
