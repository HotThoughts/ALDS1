import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Dictionary {
    static Map<String, Integer> A = new HashMap<String, Integer>();

    static void insert(String s){
        A.put(s,1);
    }

    static String find(String s){
        if (A.containsKey(s)) return "yes";
        return "no";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String operation = st.nextToken();

            if(operation.equals("insert")) insert(st.nextToken());
            else System.out.println(find(st.nextToken()));
        }
    }
}
