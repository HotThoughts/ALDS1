import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class BinaryTrees {
    static int root;

    static ArrayList<Node> nodes = new ArrayList<>();
    static int n;


    static void findRoot(){
        for (int i = 0; i < n; i++)
            if (nodes.get(i).parent() == -1) {
                root = i;
                break;
            }
    }
    // for all nodes, updating depth
    static void updateDepth(Node p){
        if (p.l != null) {
            p.l.setDepth(p.depth + 1);
            updateDepth(p.l);
        }
        if (p.r != null){
            p.r.setDepth(p.depth + 1);
            updateDepth(p.r);
        }
    }

    static int updateHeight(Node p){
        int l = 0, r = 0;
        if(p.l != null){
            l = updateHeight(p.l)+1;
        }
        if(p.r != null){
            r = updateHeight(p.r)+1;
        }
        int h = Math.max(l,r);
        p.setHeight(h);
        return h;
    }

    static boolean isLeaf(Node p){
        if (p.height == 0) return true;
        return false;
    }

    static String type(int p){
        if(p == root) return "root";
        if (isLeaf(nodes.get(p))) return "leaf";
        return "internal node";
    }

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            nodes.add(i,new Node(null,null,null));
        }

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();

            if (l != -1) {
                nodes.get(l).setParentSibling(nodes.get(id),r);
                nodes.get(id).addL(nodes.get(l));
            }
            if (r != -1){
                nodes.get(r).setParentSibling(nodes.get(id),l);
                nodes.get(id).addR(nodes.get(r));
            }

        }

        findRoot();
        updateDepth(nodes.get(root));
        updateHeight(nodes.get(root));
        // print the output
        for (int i = 0; i < n; i++) {
            System.out.printf("node %d: parent = %d, sibling = %d, degree = %d, depth = %d, height = %d, %s\n",
                    i, nodes.get(i).parent(),nodes.get(i).sibling(), nodes.get(i).degree(), nodes.get(i).depth, nodes.get(i).height, type(i));
        }
    }

    static class Node{
        int depth = 0, height = 0, s = -1;
        Node p, l, r;

        Node (Node p, Node l, Node r){
            this.p = p;
            this.l = l;
            this.r = r;
        }

        void setDepth(int d){
            depth = d;
        }

        void setHeight(int h){
            height = h;
        }
        void setParentSibling(Node p,int s){
            this.p = p;
            this.s = s;
        }

        void addL(Node l){
            this.l = l;
        }
        void addR(Node r){
            this.r = r;
        }

        int sibling(){
            return s;
        }

        int parent(){
            if (p == null) return -1;
            return nodes.indexOf(p);
        }
        int degree(){
            int ans = 0;
            if (l != null) ans++;
            if (r != null) ans++;
            return ans;
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
