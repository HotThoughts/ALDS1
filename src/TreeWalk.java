import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class TreeWalk {

    static int root;

    static ArrayList<Node> nodes = new ArrayList<>();
    static int n;


    static void findRoot(){
        for (int i = 0; i < n; i++)
            if (nodes.get(i).p == null) {
                root = i;
                break;
            }
    }

    static void preorder(Node p){
        if (p != null) {
            System.out.printf(" %d",nodes.indexOf(p));
            preorder(p.l);
            preorder(p.r);
        }

    }
    static void inorder(Node p){
        if (p != null){
            inorder(p.l);
            System.out.printf(" %d",nodes.indexOf(p));
            inorder(p.r);
        }

    }
    static void postorder(Node p){
        if (p != null){
            postorder(p.l);
            postorder(p.r);
            System.out.printf(" %d",nodes.indexOf(p));
        }
    }

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        n = sc.nextInt();


        for (int i = 0; i < n; i++) {
            nodes.add(i, new Node(null,null,null));
        }

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt(), l = sc.nextInt(), r = sc.nextInt();

            if (l != -1) {
                nodes.get(l).setParent(nodes.get(id));
                nodes.get(id).addL(nodes.get(l));
            }
            if (r != -1){
                nodes.get(r).setParent(nodes.get(id));
                nodes.get(id).addR(nodes.get(r));
            }
        }
        findRoot();
        // print the output
        System.out.println("Preorder");
        preorder(nodes.get(root));
        System.out.println("\nInorder");
        inorder(nodes.get(root));
        System.out.println("\nPostorder");
        postorder(nodes.get(root));
        System.out.println();
    }


    static class Node{
        Node p, l, r;

        Node (Node p, Node l, Node r){
            this.p = p;
            this.l = l;
            this.r = r;
        }
        void setParent(Node p){
            this.p = p;
        }
        void addL(Node l){
            this.l = l;
        }
        void addR(Node r){
            this.r = r;
        }
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
