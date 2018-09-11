import java.util.Scanner;

class Inversions {

    static int[] L = new int[200000 / 2 + 2];
    static int[] R = new int[200000 / 2 + 2];

    private static long merge(int A[], int l, int m, int r){
        int n1 = m-l;
        int n2 = r-m;
        long count = 0;

        for (int i = 0; i < n1; i++)
            L[i] = A[l+i];
        for (int i = 0; i < n2; i++)
            R[i] = A[m+i];

        L[n1] = 2000000000;
        R[n2] = 2000000000;

        int i = 0, j = 0;
        for (int k = l; k < r; k++) {
            if (L[i] <= R[j]){
                    A[k] = L[i++];
            }
            else{
                count += n1-i;
                A[k] = R[j++];
            }
        }
        return count;

    }

    private static long sort(int A[], int l, int r){
        long sum = 0;

        if (l + 1 < r ){
            int mid = (l + r) / 2;
            sum += sort(A, l, mid);
            sum += sort(A, mid, r);
            sum += merge(A, l, mid, r);
        }

        return sum;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        System.out.println(sort(a,0, n));
    }
}
