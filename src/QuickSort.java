import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

class QuickSort {
    static Card[] A;

    static int partition(int l, int r){
        int i = l-1;

        for (int j = l; j < r; j++){
            if (A[j].n <= A[r].n){
                i++;
                // swap
                Card temp = A[j];
                A[j] = A[i];
                A[i] = temp;
            }
        }
        i++;
        Card temp = A[r];
        A[r] = A[i];
        A[i] = temp;
        return i;
    }

    static void quickSort(int l, int r){
        if (l < r){
            int q = partition(l,r);
            quickSort(l,q-1);
            quickSort(q+1,r);
        }
    }

    static String stable(Card[] A, Card[] B){
        for (int i = 0; i < A.length; i++)
            if (!A[i].c.equals(B[i].c))
                return "Not stable";
        return "Stable";
    }

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        A = new Card[n];

        for (int i = 0; i < n; i++)
            A[i] = new Card(sc.next(),sc.nextInt());

        Card[] B = new Card[n];
        for (int i = 0; i < n; i++)
            B[i] = A[i];

        Arrays.sort(B,(Card a, Card b) -> b.n - a.n);

        quickSort(0,n-1);

        System.out.println(stable(A,B));

        for (int i = 0; i < n; i++)
            System.out.println(A[i].c + ' ' + A[i].n);
    }

    static class Card{
        String c;
        int n;
        Card(String c, int n){
            this.c = c;
            this.n = n;
        }
    }

    /**
     * MyScanner is a user-defined fast I/O class.
     * Source: https://algocoding.wordpress.com/2015/04/23/fast-io-methods-for-competitive-programming/
     */

    static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }

        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
