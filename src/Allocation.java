import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Allocation {

    static int[] A;
    static int n,k;

    static int binarySearch(int l, int r){
        while (r - l > 1){
            int mid = (l + r) / 2;
            if ( check(mid) >= n) r = mid;
            else l = mid;
        }
        return r;
    }

    static int check(int p){
        int i = 0;
        for (int j = 0; j < k; j++) {
            int s = 0;
            while(s + A[i] <= p){
                s += A[i++];
                if (i == n) return n;
            }
        }
        return i;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        String[] sl = br.readLine().trim().split("\\s+");

        n = Integer.parseInt(sl[0]); // # of packages
        k = Integer.parseInt(sl[1]); // # of trucks
        A = new int[n];

        for (int i = 0; i < n; i++)
            A[i] = Integer.parseInt(br.readLine());

        br.close();
        System.out.println(binarySearch(0,100000 * 100000));
    }
}
