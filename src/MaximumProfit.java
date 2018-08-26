import java.util.*;

class MaximumProfit {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int a = sc.nextInt();
        int b = sc.nextInt();

        int maxProfit = b - a;

        int min = Math.min(a,b);  // the minimum number in the dataset

        while(sc.hasNextInt()){
            int next = sc.nextInt();

            maxProfit = Math.max(maxProfit, next - min);

            min = Math.min(min, next);
        }
        System.out.println(maxProfit);
    }
}
