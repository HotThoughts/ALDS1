import java.util.Scanner;

class PrimeNumbers {

    private static boolean isPrime(int n){
        int sqrt = (int) Math.sqrt(n) + 1;

        for (int i = 2; i < sqrt; i++)
            if (n % i == 0)
                return false;

        return true;
    }


    public static void main(String[] args) throws Exception{

        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();

        int ans = 0;

        while (sc.hasNextInt())
            if (isPrime(sc.nextInt()))
                ans++;

        System.out.println(ans);
    }
}
