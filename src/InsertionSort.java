import java.util.Scanner;

import java.lang.StringBuilder;

class InsertionSort{

    private static void insertionSort(int n,int[] numbers){

        toString(numbers);

        for (int i = 1; i < n; i++) {
            int key = numbers[i];
            /* insert A[i] into the sorted sequence A[0,...,j-1] */
            int j = i - 1;

            while (j >= 0 && numbers[j] > key){
                numbers[j+1] = numbers[j];
                j--;
            }

            numbers[j+1] = key;
            // print the current list
            toString(numbers);

        }
    }
    private static void toString(int[] numbers){
        StringBuilder ans = new StringBuilder().append(numbers[0]);
        for (int x = 1; x < numbers.length; x++)
            ans.append(" ").append(numbers[x]);
        System.out.println(ans.toString());
    }


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();

        int[] numbers = new int[length];

        int i = 0;
        while(sc.hasNextInt() && i < length) {
            numbers[i] = sc.nextInt();
            i++;
        }
        insertionSort(length,numbers);

        // Test
        //is.insertionSort(6,new int[]{5,2,4,6,1,3});
        //is.insertionSort(3,new int[]{1,2,3});

    }
}