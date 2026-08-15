import java.util.*;

class EuclideanAlgo {

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter two integers -");
        int n1 = scan.nextInt();
        int n2 = scan.nextInt();
        int g = gcd(n1, n2); // Corrected variable name to 'g'

        System.out.println("GCD is " + g); // Added missing semicolon

    }
}