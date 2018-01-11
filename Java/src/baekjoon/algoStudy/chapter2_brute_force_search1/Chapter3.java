package baekjoon.algoStudy.chapter2_brute_force_search1;

import java.util.LinkedList;
import java.util.Scanner;

public class Chapter3 {
    public void num1476() {
        Scanner sc = new Scanner(System.in);
        int[] input = new int[3];
        int[] esm = {15, 28, 19};
        for (int i=0; i<3; i++) {
            input[i] = sc.nextInt();
            if (input[i] == esm[i]) input[i] = 0;
        }

        for (int i=0; i<=15*29; i++) {
            int n = 28 * i + input[1];
            if (n % 15 == input[0] && n % 19 == input[2]) {
                System.out.println(n > 0 ? n : 15*28*19);
                break;
            }
        }
    }

    public void num1107() {
        LinkedList<Integer> enableKeys = new LinkedList<Integer>();
        for (int i = 0; i < 10; i++) {
            enableKeys.add(i);
        }

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int inputNum = Integer.parseInt(input);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            enableKeys.remove(Integer.valueOf(sc.nextInt()));
        }
        // 가까운 수로 접근하는 방식
        int answer = nearNumber(input, inputNum, enableKeys);
        // -1이면 모두 번호로 입력 가능
        if (answer == -1) answer = input.length();
        // +,- 버튼으로 가는게 젤 빠를 경우 변경
        answer = answer > Math.abs(inputNum - 100) ? Math.abs(inputNum - 100) : answer;

        System.out.println(answer);
    }

    private int largeOfSu(LinkedList<Integer> enableKeys, int index, int rest, String nearNum) {
        String numStr = "";
        if (enableKeys.size() <= index) {
            int front = nearNum.length() > 0 ? Integer.parseInt(nearNum) + 1 : 1;
            numStr += front;
            numStr += enableKeys.getFirst();
        }else numStr = nearNum + enableKeys.get(index);
        for (int i=0; i<rest; i++) numStr += enableKeys.getFirst();
        return Integer.parseInt(numStr);
    }

    private int smallOfSu(LinkedList<Integer> enableKeys, int index, int rest, String nearNum) {
        String numStr = "";
        for (int i=0; i<rest; i++) numStr += enableKeys.getLast();
        if (0 <= index - 1) {
            numStr = nearNum + enableKeys.get(index - 1) + numStr;
        }
        return Integer.parseInt(numStr);
    }

    private int nearNumber(String input, int inputNum, LinkedList<Integer> enableKeys) {
        if (enableKeys.isEmpty()) return 9999999;
        String nearNumStr = "";
        String[] inputArray = input.split("");
        for (int i = 0; i < input.length(); i++) {
            int su = Integer.parseInt(inputArray[i]);

            int index = 0;
            boolean findFlag = false;
            for (index = 0; index < enableKeys.size(); index++) {
                int find = enableKeys.get(index);
                if (find == su) {
                    findFlag = true;
                    break;
                }
                if (find > su) break;
            }

            if (findFlag) {
                nearNumStr += su;
                continue;
            }

            int rest = input.length() - (i + 1);
            int nearLarge = largeOfSu(enableKeys, index, rest, nearNumStr);
            int nearSmall = smallOfSu(enableKeys, index, rest, nearNumStr);
            int nearNum = Math.abs(inputNum - nearLarge) < Math.abs(inputNum - nearSmall) ?
                    nearLarge : nearSmall;
            return Integer.toString(nearNum).length() + Math.abs(inputNum - nearNum);
        }
        return -1;
    }
}
