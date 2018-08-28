package baekjoon;

import java.io.*;

public class TestFile {
    public static void main(String[] args) {

//        String txt = "테스트입니다!!" ;

        String fileName = "/Users/mijeong/Desktop/testcase1.txt" ;

        StringBuffer str = new StringBuffer("50\n");
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                str.append("1 ");
            }
            str.delete(str.length() - 1, str.length());
            str.append("\n");
        }

        try{

            // 파일 객체 생성
            File file = new File(fileName) ;

            // true 지정시 파일의 기존 내용에 이어서 작성
            FileWriter fw = new FileWriter(file, true) ;

            // 파일안에 문자열 쓰기
            fw.write(String.valueOf(str));
            fw.flush();

            // 객체 닫기
            fw.close();


        }catch(Exception e){
            e.printStackTrace();
        }


    }
}
