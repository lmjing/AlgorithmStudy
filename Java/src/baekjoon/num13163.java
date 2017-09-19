package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class num13163 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> results = new ArrayList<>();

        int inputNumber = Integer.parseInt(scanner.nextLine());

        for(int i=0;i<inputNumber;i++){
            String inputLine = scanner.nextLine();
            String[] array = inputLine.split(" ");
            array[0] = "god";
            results.add(String.join("",array));
        }

        for(String str:results) {
            System.out.println(str);
        }
    }
}
