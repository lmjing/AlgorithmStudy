package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        Stack<Integer> nums = new Stack<>();
        Stack<Character> operators = new Stack<>();
        int num = 0;
        for (char c : input.toCharArray()) {
            if (c == '-' || c == '+') {
                operators.push(c);
                nums.push(num);
                num = 0;
            } else num = num * 10 + (c - '0');
        }
        nums.push(num);

        int answer = 0;
        while (!operators.isEmpty()) {
            char oper = operators.pop();
            int su = nums.pop();
            if (oper == '-') answer -= su;
            else nums.push(su + nums.pop());
        }
        System.out.println(answer + nums.pop());
    }
}