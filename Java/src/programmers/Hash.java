package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// programmers 코딩테스트 고득점 kit
public class Hash {
    // Q : 완주하지 못한 문제
    // TIME : start 4:44, end 4:53
    public String solution1(String[] participant, String[] completion) {
        HashMap<String, Integer> check = new HashMap<>();

        for (String com : completion) {
            check.put(com, check.getOrDefault(com, 0) + 1);
        }
        for (String par : participant) {
            int count = check.getOrDefault(par, 0);
            if (count > 0) {
                count--;
                check.put(par, count);
            } else
                return par;
        }

        return new String();
    }

    // Q. 전화번호 목록
    // TIME : start 4:56, end 5:20
    // TODO : String 함수를 활용해 쉽게 구하는 방법으로!
    static public boolean my_solution2(String[] phone_book) {
        boolean answer = true;
        Map<Character, ArrayList<String>> temp = new HashMap<>();

        for (String phone : phone_book) {
            ArrayList<String> samePhones = temp.getOrDefault(phone.charAt(0), new ArrayList<>());
            System.out.println(phone + "차례 "+phone.charAt(0) + "*");
            for (String sp : samePhones) {
                int i = 0;
                System.out.println(sp);
                boolean flag = false;
                while (i < phone.length() && i < sp.length()) {
                    if (phone.charAt(i) != sp.charAt(i++)) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) return false;
            }
            samePhones.add(phone);
            temp.put(phone.charAt(0), samePhones);
        }

        return true;
    }

    static public void main (String[] args) {
    }
}
