import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The the time complexity of Binary Search is O(Log n).
 */
class BinarySearch {
    static int A[], B[];

    /**
     * return true if int x is in A.
     * otherwise, return false if x is not found in A.
     */
    static boolean contains(int l, int r, int x){
        int mid = (l + r) / 2;
        if(r < l) return false;

        if(A[mid] == x) return true;
        if(A[mid] > x) return contains(l,mid-1,x);

        return contains(mid+1,r,x);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        // read the first list of integers
        int n = Integer.parseInt(br.readLine());
        A = new int[n];
        String[] nums = br.readLine().trim().split("\\s+");
        for (int i = 0; i < n; i++)
            A[i] = Integer.parseInt(nums[i]);

        // read the second list of integers
        n = Integer.parseInt(br.readLine());
        B = new int[n];
        nums = br.readLine().trim().split("\\s+");
        for (int i = 0; i < n; i++)
            B[i] = Integer.parseInt(nums[i]);

        int ans = 0;
        for (int b:B) {
            if(contains(0,A.length-1,b)) ans++;
        }


        System.out.println(ans);

    }

}
