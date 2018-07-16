package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputs = sc.nextLine().split("-");
        StringBuilder result = new StringBuilder("");
        for (String str : inputs)
            result.append(str.charAt(0));

        System.out.println(result);
    }
}