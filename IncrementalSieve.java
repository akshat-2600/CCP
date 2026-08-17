// T.C : O(n * log log n)
// S.C : O(sqrt(n))

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class IncrementalSieve {

    // Function implementing the incremental sieve logic
    static List<Integer> incrementalSieve(int limit) {
        List<Integer> primes = new ArrayList<>();
        
        // Edge case: if limit is less than 2, there are no primes
        if (limit < 2) {
            return primes;
        }

        // Initialize the tracking array for composites
        boolean[] isComposite = new boolean[limit + 1];
        
        // Add the first prime number
        primes.add(2);
        int nextNum = 3;

        while (nextNum <= limit) {
            // Check if the number was already marked as composite by a previous prime
            if (!isComposite[nextNum]) {
                boolean isPrime = true;
                double sqrtNextNum = Math.sqrt(nextNum);

                for (int prime : primes) {
                    if (prime > sqrtNextNum) {
                        break;
                    }
                    if (nextNum % prime == 0) {
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime) {
                    primes.add(nextNum);
                    
                    // Mark odd multiples of the newly discovered prime as composite
                    // Using long for the loop bounds to safely prevent integer overflow
                    long start = (long) nextNum * nextNum;
                    long step = (long) nextNum * 2;
                    
                    for (long i = start; i <= limit; i += step) {
                        isComposite[(int) i] = true;
                    }
                }
            }
            
            // Increment by 2 to completely bypass even numbers
            nextNum += 2;
        }

        return primes;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the limit to search for primes: ");
        int limit = sc.nextInt();

        List<Integer> result = incrementalSieve(limit);
        System.out.println("Primes found up to " + limit + ": " + result);
        
        sc.close();
    }
}
