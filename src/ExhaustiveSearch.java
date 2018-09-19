import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ExhaustiveSearch {

    static int n;
    static int[] A;

    public static boolean solve(int p, int t){
        if (t == 0) return true;
        if (p >= n) return false;
        return solve(p+1, t) || solve(p+1, t - A[p]) ;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        A = new int[n];

        String[] nums = br.readLine().trim().split("\\s+");
        for (int i = 0; i < n; i++)
            A[i] = Integer.parseInt(nums[i]);

        int q = Integer.parseInt(br.readLine());
        nums = br.readLine().trim().split("\\s+");
        br.close();

        for (int i = 0; i < q; i++) {
            int m = Integer.parseInt(nums[i]);
            String ans = solve(0, m) ? "yes" : "no";
            System.out.println(ans);
        }
    }
}