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

    public static void num6588() {
        Scanner sc = new Scanner(System.in);
        int n = 1000000;
        int[] prime = new int[1000001];

        // 소수 체크
        int i = 1;
        int lastPrime = -1;
        boolean end = false; // 에라토스테네스의 체의 마지막 조건 확인 용
        while (++i <= n) {
            if (prime[i] == 0) {
                lastPrime = i;
                // 마지막 조건을 넘긴 경우 배수 확인 작업을 하지 않는다.
                // 굳이 삽입한 이유 : i * i가 long범위를 넘기게 되어 음수가 되어 이상해짐
                if (end || i * i > n) {
                    end = true;
                    continue;
                }
                // 배수 지우는 작업
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = lastPrime;
                }
            } else
                prime[i] = lastPrime;
        }
        prime[2] = prime[1] = -1;

        int input = sc.nextInt();
        while (input != 0) {
            int b = prime[input]; // input보다 작은 값 중 가장 큰 홀수소수
            int a = input - b;
            while (b > 0 && prime[a] != 0) {
                b = prime[b - 1];
                a = input - b;
            }
            if (b > 0)
                System.out.println(input + " = " + a + " + " + b);
            else // b가 0이하가 되면 답이 없다.
                System.out.println("Goldbach's conjecture is wrong.");

            input = sc.nextInt();
        }
    }
}
