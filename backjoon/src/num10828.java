import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by mijeong on 2016. 12. 7..
 ※ next() 메서드 실행뒤에 첫단어만 가져오고 개행문자가 앞에 남기때문에 다음 nextLine()을 만나면 개행문자를 한줄로 가져오게 된다.
 ※ next()뿐만 아니라 nextInt()등과 같은 메서드와 nextLine()메서드를 섞어 사용할 경우에는 주의해야 한다.
 */
public class num10828 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int cnt = stdin.nextInt();
        stdin.nextLine();

        ArrayList<String> order = new ArrayList<>();
        order.clear();
        for(int i=0;i<cnt;i++){
            order.add(stdin.nextLine());
        }

        Stack stack = new Stack();

        for(String od : order){
            if(od.equals("pop"))
                System.out.println(stack.pop());
            else if(od.equals("top"))
                System.out.println(stack.top());
            else if(od.equals("size"))
                System.out.println(stack.size());
            else if(od.equals("empty"))
                System.out.println(stack.empty());
            else{
                if(od.substring(0,4).equals("push")){
                    int x = Integer.parseInt(od.substring(5));
                    stack.push(x);
                }
            }
        }
    }
}

class Stack{

    LinkedList<Integer> stack;

    public Stack(){
        stack = new LinkedList<>();
    }

    public void push(int x){
        stack.add(x);
    }

    public int pop(){
        if(stack.isEmpty()) return -1;
        else {
            int x = stack.getLast();
            stack.removeLast();
            return x;
        }
    }

    public int size(){
        return stack.size();
    }

    public int empty(){
        if(stack.isEmpty()) return 1;
        else return 0;
    }

    public int top(){
        if(stack.isEmpty()) return -1;
        else return stack.getLast();
    }
}
