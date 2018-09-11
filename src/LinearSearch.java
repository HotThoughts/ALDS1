import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class LinearSearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        // read the first list of integers
        int n = Integer.parseInt(br.readLine());
        int A[] = new int[n];
        String[] nums = br.readLine().trim().split("\\s+");
        for (int i = 0; i < n; i++)
            A[i] = Integer.parseInt(nums[i]);

        // read the second list of integers
        n = Integer.parseInt(br.readLine());
        int B[] = new int[n];
        nums = br.readLine().trim().split("\\s+");
        for (int i = 0; i < n; i++)
            B[i] = Integer.parseInt(nums[i]);

        int ans = 0;
        for (int b: B)
            for (int a: A)
                if (a == b) {
                    ans++;
                    break;
                }

        System.out.println(ans);
    }

}
