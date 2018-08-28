import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class ShellSort {
    private static int cnt = 0;

    private static void insertionSort(int[] A, int n, int g){

        for (int i = g; i < n; i++) {
            int v = A[i];
            int j = i - g;

            while (j >= 0 && A[j] > v){
                A[j+g] = A[j];
                j -= g;
                cnt++;
            }
            A[j+g] = v;
        }
    }

    private static void shellSort(int[] A, int n){
        cnt = 0;

        List<Integer> G = new ArrayList<>();

        for (int i = 1; i <= n; i = 3 * i + 1)
            G.add(0, i);

        int m = G.size();
        System.out.println(m);

        for (int i = 0; i < m - 1; i++)
            System.out.print(G.get(i)+" ");
        System.out.print(G.get(m - 1) + "\n");

        for (int i = 0; i < m; i++)
            insertionSort(A, n, G.get(i));
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] A = new int[n];
        for (int i = 0; i < n; i++)
            A[i] = sc.nextInt();

        shellSort(A, n);
        System.out.println(cnt);

        for (int num: A)
            System.out.println(num);
    }
}
