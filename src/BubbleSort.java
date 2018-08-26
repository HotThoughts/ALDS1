import java.util.Scanner;
import java.lang.StringBuilder;

class BubbleSort {


    private static String toString(int[] numbers){
        StringBuilder ans = new StringBuilder().append(numbers[0]);
        for (int x = 1; x < numbers.length; x++)
            ans.append(" ").append(numbers[x]);
        return ans.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] A = new int[n];

        for (int i = 0; i < n; i++)
            A[i] = sc.nextInt();

        //int n = 6;
        //int[] A = new int[]{6, 5, 4, 3, 2, 1};

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = n-1; j > i; j--) {
                if(A[j] < A[j-1]){
                    int temp = A[j-1];
                    A[j-1] = A[j];
                    A[j] = temp;
                    count++;
                }

            }
        }

        System.out.println(toString(A));
        System.out.println(count);
    }
}
