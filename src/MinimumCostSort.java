import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

class MinimumCostSort {

    static final int MAX = 10000+1;
    static int cost,n, s, x = MAX;
    static int[] A, B, C = new int[MAX];
    static boolean[] V = new boolean[1000];

    static void sort(){
        Arrays.sort(B, 0, n);
        for(int i = 0; i < n; i++)
            C[B[i]] = i;

        for(int i = 0; i < n; i++) {
            if(V[i]) continue;
            int j = i, s = 0, min = MAX, k = 0;
            while(!V[j]) {
                k++;
                min = Math.min(min,A[j]);
                s += A[j];
                V[j] = true;
                j = C[A[j]];
            }
            cost += Math.min(s + (k - 2) * min, min + s + (k + 1) * x);
        }
    }

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        n = sc.nextInt();

        A = new int[n];
        B = new int[n];

        for (int i = 0; i < n; i++) {
            int next = sc.nextInt();
            A[i] = next;
            B[i] = A[i];
            V[i] = false;
            x = Math.min(x,next);
        }
        sort();
        System.out.println(cost);
    }



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
