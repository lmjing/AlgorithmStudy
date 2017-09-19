package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by mijeong on 2016. 12. 7..
 */
public class num10845 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int cnt = stdin.nextInt();
        stdin.nextLine();

        ArrayList<String> order = new ArrayList<>();
        order.clear();
        for(int i=0;i<cnt;i++){
            order.add(stdin.nextLine());
        }

        Queue queue = new Queue();

        for(String od : order){
            if(od.equals("pop"))
                System.out.println(queue.pop());
            else if(od.equals("front"))
                System.out.println(queue.front());
            else if(od.equals("back"))
                System.out.println(queue.back());
            else if(od.equals("size"))
                System.out.println(queue.size());
            else if(od.equals("empty"))
                System.out.println(queue.empty());
            else{
                if(od.substring(0,4).equals("push")){
                    int x = Integer.parseInt(od.substring(5));
                    queue.push(x);
                }
            }
        }
    }
}

class Queue{

    LinkedList<Integer> queue;

    public Queue(){
        queue = new LinkedList<>();
    }

    public void push(int x){
        queue.add(x);
    }

    public int pop(){
        if(queue.isEmpty()) return -1;
        else {
            int x = queue.getFirst();
            queue.removeFirst();
            return x;
        }
    }

    public int size(){
        return queue.size();
    }

    public int empty(){
        if(queue.isEmpty()) return 1;
        else return 0;
    }

    public int front(){
        if(queue.isEmpty()) return -1;
        else return queue.getFirst();
    }

    public int back(){
        if(queue.isEmpty()) return -1;
        else return queue.getLast();
    }
}
