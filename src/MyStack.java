import java.util.Scanner;
import java.util.Stack;

class MyStack {
    static Stack<Integer> ans = new Stack<>();
    static int a;
    static int b;

    private static int compute(String s){
        if (s.charAt(0) == '+') return b + a;
        else if ( s.charAt(0) == '-') return b - a;

        return b * a;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc = new Scanner(s);

        while(sc.hasNext()){
            if(sc.hasNextInt())
                ans.push(sc.nextInt());
            else{
                a = ans.pop();
                b = ans.pop();
                ans.push(compute(sc.next()));
            }
        }
        System.out.println(ans.pop());
    }
}
