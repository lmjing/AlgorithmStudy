package baekjoon.algoStudy.DataStructure;

import java.util.*;

public class Map {
    public static void num1764 () {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        HashMap<String, Boolean> checkList = new HashMap<>();

        for (int i = 0; i < n; i++)
            checkList.put(sc.next(), true);

        ArrayList<String> answer = new ArrayList();

        for (int i = 0; i < m; i++) {
            String str = sc.next();
            if (checkList.containsKey(str)) {
                answer.add(str);
            }
        }
        System.out.println(answer.size());

        Collections.sort(answer);
        for (String s : answer) {
            System.out.println(s);
        }
    }
}
