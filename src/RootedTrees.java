import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class RootedTrees {
    static Node[] nodes;
    static int n;

    static int root(){
        for (int i = 0; i < n; i++)
            if (nodes[i].parent == -1)
                return i;
        return -1;
    }
    // for all nodes, updating depth
    static void updateDepth(int p){
        for (int i = 0; i < nodes[p].children.size(); i++) {
            int c = nodes[p].children.get(i);
            nodes[c].updateDepth(nodes[p].depth+1);
            updateDepth(c);
        }
    }

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        n = sc.nextInt();

        nodes = new Node[n];

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            int degree = sc.nextInt();

            Node node = new Node(id);
            if (nodes[id] != null) node = nodes[id];
            else nodes[id] = node;

            for (int j = 0; j < degree; j++)
                node.addChild(sc.nextInt());
        }
        // update every node's depth in the tree from root to the bottom
        updateDepth(root());
        // print the output
        for (Node node: nodes) {
            System.out.printf("node %d: parent = %d, depth = %d, %s, %s\n",
                    node.id, node.parent, node.depth, node.type(), node.children());
        }
    }

    static class Node{
        int id, parent, depth = 0;
        ArrayList<Integer> children = new ArrayList<>();

        Node (int id){
            this.id = id;
            parent = -1;
        }
        Node (int id, int parent){
            this.id = id;
            this.parent = parent;
        }

        void addChild(int n){
            children.add(n);
            // update the parent of the child
            // if the child has already added into nodes, update parent
            // otherwise, create a new node, update its parent, then added into nodes
            if (nodes[n] != null) nodes[n].updateParent(this.id);
            else nodes[n] = new Node(n, this.id);

        }
        void updateParent(int p){
            parent = p;
        }
        void updateDepth(int d){
            depth = d;
        }

        String type(){
            if (parent == -1) return "root";
            if (children.isEmpty()) return "leaf";
            return "internal node";
        }

        String children(){
            if (children.isEmpty()) return "[]";
            StringBuilder sb = new StringBuilder("[").append(children.get(0));
            for (int i = 1; i < children.size(); i++)
                sb.append(", ").append(children.get(i));
            return sb.append("]").toString();
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
