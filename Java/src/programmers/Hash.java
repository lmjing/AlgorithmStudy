package programmers;

import java.util.HashMap;

public class Hash {
    // TIME : start 4:44, end 4:53
    public String solution(String[] participant, String[] completion) {
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
}
