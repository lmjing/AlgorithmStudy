package programmers;

import javax.swing.text.html.HTMLDocument;
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

    // 베스트 앨범
    // TIME : start 2:47, end 3:54 (알바라서 손님 응대 시간 포함 + 아빠 전화 시간....)
    static public int[] solution4(String[] genres, int[] plays) {
        // 일단 장르별로 분류
        HashMap<String, Genre> playlist = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            Genre genre = playlist.getOrDefault(genres[i], new Genre());
            genre.addMusic(plays[i], i);
            playlist.put(genres[i], genre);
        }

        // 결과 값 몇개 나올지 모르니 일단 저장
        ArrayList<Integer> result = new ArrayList<>();

        // value들 따로 담는 작업
        ArrayList<Genre> values = getGenreList(playlist);

        // value들 정렬 후 2개씩 담음
        Collections.sort(values);
        for (Genre genre : values) {
            Collections.sort(genre.list);
            int i = 0;
            while (i < 2 && i < genre.list.size()) {
                result.add(genre.list.get(i++).num);
            }
        }

        // 정답 배열로 다시 담음
        return convertToArray(result);
    }

    static ArrayList<Genre> getGenreList (HashMap<String, Genre> playlist) {
        ArrayList<Genre> values = new ArrayList<>();
        Iterator iter = playlist.values().iterator();
        while (iter.hasNext())
            values.add((Genre)iter.next());
        return values;
    }

    static int[] convertToArray(ArrayList<Integer> arrayList) {
        int[] answer = new int[arrayList.size()];
        Iterator iter = arrayList.iterator();
        int i = 0;
        while (iter.hasNext()) {
            answer[i++] = (int)iter.next();
            System.out.println(answer[i - 1]);
        }
        return answer;
    }

    static class Genre implements Comparable<Genre> {
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

        @Override
        public int compareTo(Genre o) {
            return o.allPlay - this.allPlay;
        }

        class Music implements Comparable<Music> {
            int play;
            int num;

            public Music(int play, int num) {
                this.play = play;
                this.num = num;
            }

            @Override
            public int compareTo(Music o) {
                if (o.play == this.play) {
                    return this.num - o.num;
                } else
                    return o.play - this.play;
            }
        }
    }

    static public void main (String[] args) {
        solution4(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});
    }
}
