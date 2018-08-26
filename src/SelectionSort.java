import java.util.Scanner;

class SelectionSort {

    private static String toString(int[] numbers){
        StringBuilder ans = new StringBuilder().append(numbers[0]);
        for (int x = 1; x < numbers.length; x++)
            ans.append(" ").append(numbers[x]);
        return ans.toString();
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] A = new int[n];

        // stores all numbers in the array A
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

         /**
        int n = 6;
        int[] A = new int[]{5,6,4,2,1,3};
         */

        int count = 0;
        for (int i = 0; i < n; i++) {
            int mini = i;
            for (int j = i; j < n; j++)
                if (A[j] < A[mini])
                    mini = j;
            // swap operation
            if(mini != i) {
                int temp = A[i];
                A[i] = A[mini];
                A[mini] = temp;
                count++;
            }
        }
        System.out.println(toString(A));
        System.out.println(count);
    }

}

