import java.util.Scanner;

class GreatestCommonDivisor {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();

        while(a!=0 && b!=0) // until either one of them is 0
        {
            int c = b;
            b = a%b;
            a = c;
        }

        System.out.println(a + b);


    }
}
