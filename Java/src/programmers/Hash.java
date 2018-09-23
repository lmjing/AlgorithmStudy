package programmers;

import java.util.*;

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

    // Q. 위
    // TIME : start 2:35, end 2:46 (알바라서 손님 응대 시간 포함)
    static public int solution3(String[][] clothes) {
        // 옷 종류별로 분류해서 카운팅
        HashMap<String, Integer> clothesMap = new HashMap<>();
        for (String[] c : clothes) {
            clothesMap.put(c[1], clothesMap.getOrDefault(c[1], 0) + 1);
        }

        // 모든 경우의 수는 (카운트 + 1)들의 곱 - 1
        // 카운트에 +1 하는 이유는 자신이 포함하지 않을 경우 포함
        // -1 하는 이유는 전체 선택안한 경우 제외
        int answer = 0;
        for (int count : clothesMap.values()) {
            answer *= count + 1;
        }
        return answer - 1;
    }


    // TIME : start 2:47, end 2:46 (알바라서 손님 응대 시간 포함)
    public int[] solution4(String[] genres, int[] plays) {
        HashMap<String, ArrayList<Music>> playlist = new HashMap<>();
        HashMap<String, Integer> playTimes = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            ArrayList<Music> list = playlist.getOrDefault(genres[i], new ArrayList<>());
            list.add(new Music(plays[i], i));
            playlist.put(genres[i], list);
        }

        // 장르
        ArrayList<ArrayList<Music>> values = (ArrayList<ArrayList<Music>>) playlist.values();
        Collections.sort(values, new Comparator<ArrayList<Music>>() {
            @Override
            public int compare(ArrayList<Music> o1, ArrayList<Music> o2) {
                return o1.size() - o2.size();
            }
        });

        int[] answer = {};
        return answer;
    }

    void printSorted (HashMap<String, ArrayList<Music>> playlist) {

    }

    class Genre {
        int allPlay;
        ArrayList<Music> list;

        public Genre() {
            this.allPlay = 0;
            this.list = new ArrayList<>();
        }

        public void addMusic (int play, int num) {
            list.add(new Music(play, num));
            allPlay += play;
        }

        class Music {
            int play;
            int num;

            public Music(int play, int num) {
                this.play = play;
                this.num = num;
            }
        }
    }

    static public void main (String[] args) {

    }
}
