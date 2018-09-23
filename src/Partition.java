import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Partition {
    static int[] A;

    static int partition(int l, int r){
        int i = l-1;

        for (int j = l; j < r; j++){
            if (A[j] <= A[r]){
                i++;
                // swap
                int temp = A[j];
                A[j] = A[i];
                A[i] = temp;
            }
        }
        i++;
        int temp = A[r];
        A[r] = A[i];
        A[i] = temp;
        return i;
    }

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();


        A = new int[n];

        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        int x = partition(0,n-1);

        StringBuilder s = new StringBuilder().append(A[0]);
        for (int i = 1; i < n; i++) {
            if (i == x) s.append(" [").append(A[i]).append("]");
            else s.append(" ").append(A[i]);
        }

        System.out.println(s);


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
