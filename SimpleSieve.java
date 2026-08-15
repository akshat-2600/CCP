import java.util.*;

public class SimpleSieve {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number");
        int num = sc.nextInt();

        // Sieve of Eratosthenes initialization
        boolean[] bool = new boolean[num];
        for (int i = 0; i < bool.length; i++) {
            bool[i] = true;
        }

        // Processing primes up to the square root of the number
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (bool[i] == true) {
                for (int j = (i * i); j < num; j = j + i) {
                    bool[j] = false;
                }
            }
        }

        // Displaying the results
        System.out.println("List of prime numbers upto given number are : ");
        int count = 0;
        int sum = 0;
        int k = 10;
        int kthprime = 0;
        int lastprime = 2;
        int currprime = 2;
        List<int[]> pairs = new ArrayList<>();


        for (int i = 2; i < bool.length; i++) {
            if (bool[i] == true) {
                currprime = i;
                if (currprime - lastprime == 2) {
                    pairs.add(new int[]{lastprime, currprime});
                    
                }
                lastprime = currprime;

                System.out.println(i);
                count++;
                sum += i;
                if (count == k) {
                    kthprime = i;
                }
            }
        }
        System.out.println("Count: " + count);
        System.out.println("Sum: " + sum);
        System.out.println("Kth prime: " + kthprime);

        System.out.println("Pairs diff 2 : ");
        for (int[] row : pairs) {
            System.out.println(Arrays.toString(row));
        }
        sc.close();
    }
}
