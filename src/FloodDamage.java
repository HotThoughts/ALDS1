import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


class FloodDamage {
    /**
     * A data structure to represent the shape of the diagram
     */
    static class Pair{
        int pos, area;
        Pair(int pos, int area){
            this.pos = pos;
            this.area= area;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        // convert the diagram representation to a list of char
        char[] diagram = br.readLine().toCharArray();

        Stack<Integer> a = new Stack<>();
        Stack<Pair> b = new Stack<>();

        int ans = 0; // the sum of flood area
        for (int i = 0; i < diagram.length; i++) {
            if (diagram[i] == '\\') a.push(i);
            if (diagram[i] == '/' && !a.isEmpty()){
                int j = a.pop();
                int area2 = i - j;
                ans += area2;
                while (!b.isEmpty() && b.peek().pos > j)
                    area2 += b.pop().area;
                b.push(new Pair(j, area2));
            }
        }
        Stack<Integer> areas = new Stack<>();
        while(!b.isEmpty()) areas.push(b.pop().area);
        System.out.println(ans);
        System.out.print(areas.size());
        while(!areas.isEmpty()) System.out.print(" " + areas.pop());
        System.out.println();
    }
}
