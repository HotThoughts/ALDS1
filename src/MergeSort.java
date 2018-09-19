import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class MergeSort {

    static int[] A;
    static final int SENTINEL = Integer.MAX_VALUE;
    static int count = 0;
    static int[] L = new int[500000];
    static int[] R = new int[500000];

    static void merge(int l, int m, int r){
        int n1 = m - l, n2 = r - m;


        for (int i = 0; i < n1; i++)
            L[i] = A[l + i];
        for (int i = 0; i < n2; i++)
            R[i] = A[m + i];

        L[n1] = SENTINEL;
        R[n2] = SENTINEL;

        int i = 0, j = 0;

        for (int k = l; k < r; k++) {
            count++;
            if (L[i] <= R[j]) A[k] = L[i++];
            else A[k] = R[j++];
        }
    }

    static void mergeSort(int l, int r){
        if (l + 1 < r){
            int m = (l+r)/2;
            mergeSort(l,m);
            mergeSort(m,r);
            merge(l,m,r);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        A = new int[n];

        String[] nums = br.readLine().trim().split("\\s+");
        for (int i = 0; i < n; i++)
            A[i] = Integer.parseInt(nums[i]);

        mergeSort(0,n);

        StringBuilder s = new StringBuilder().append(A[0]);
        for (int i = 1; i < n; i++)
            s.append(" ").append(A[i]);

        System.out.println(s);
        System.out.println(count);
    }
}
