import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

class MyQueue {

    static class Process{
        String name;
        int time;

        Process(String n, int t){
            name = n;
            time = t;
        }
        void updateTime(int t){
            time -= t;
        }
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int quantum = sc.nextInt();

        Queue<Process> queue = new LinkedList<>();

        for (int i = 0; i < n; i++)
            queue.add(new Process(sc.next(), sc.nextInt()));

        int elapsed = 0;
        while (queue.size() > 0){
            Process p = queue.poll();
            if (p.time <= quantum){
                elapsed += p.time;
                System.out.println(p.name + " " + elapsed);
            }
            else{
                elapsed += quantum;
                p.updateTime(quantum);
                queue.add(p);
            }
        }
    }
}
