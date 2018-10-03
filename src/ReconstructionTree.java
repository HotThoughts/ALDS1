import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class ReconstructionTree {
    static int n, pos = 0;

    static ArrayList<Integer> preorder = new ArrayList<>();
    static ArrayList<Integer> inorder = new ArrayList<>();
    static ArrayList<Integer> postorder = new ArrayList<>();

    static void reconstruction(int l, int r){
        if (l < r) {
            int root = preorder.get(pos++);
            int m = inorder.indexOf(root);
            reconstruction(l, m);
            reconstruction(m + 1, r);
            postorder.add(root);
        }
    }

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        n = sc.nextInt();

        for (int i = 0; i < n; i++) preorder.add(i,sc.nextInt());
        for (int i = 0; i < n; i++) inorder.add(i,sc.nextInt());

        reconstruction(0,n);
        StringBuilder sb = new StringBuilder().append(postorder.get(0));
        for (int i = 1; i < n; i++) sb.append(" ").append(postorder.get(i));
        System.out.println(sb.toString());
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
