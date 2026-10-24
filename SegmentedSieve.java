// T.C : O(n)
// S.C : O(n)


import java.util.*;

class SegmentedSieve {
    static int N = 100000;
    static boolean arr[] = new boolean[N + 1];

    // Populates the base sieve array with prime information up to N
    static void simpleSieve() {
        for (int i = 2; i <= N; i++) {
            arr[i] = true;
        }
        
        for (int i = 2; i * i <= N; i++) {
            if (arr[i] == true) {
                for (int j = i * i; j <= N; j = j + i) {
                    arr[j] = false;
                }
            }
        }
    }

    // Generates a list of all primes up to sqrt(n)
    static ArrayList<Integer> generatePrimes(int n) {
        ArrayList<Integer> al = new ArrayList<>();
        int limit = (int) Math.sqrt(n);
        
        for (int i = 2; i <= limit; i++) {
            if (arr[i] == true) {
                al.add(i);
            }
        }
        return al;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int low = sc.nextInt();
        int high = sc.nextInt();
        
        simpleSieve();
        
        ArrayList<Integer> al = generatePrimes(high);
        int range = high - low + 1;
        boolean dummy[] = new boolean[range];
        
        for (int i = 0; i < range; i++) {
            dummy[i] = true;
        }

        // Special case: 1 is not a prime number
        if (low == 1) {
            dummy[0] = false;
        }

        // Mark multiples of primes in the range [low, high]
        for (int prime : al) {
            int firstMultiple = (low / prime) * prime;
            if (firstMultiple < low) {
                firstMultiple = firstMultiple + prime;
            }
            
            int start = Math.max(firstMultiple, prime * prime);
            for (int j = start; j <= high; j += prime) {
                dummy[j - low] = false;
            }
        }

        // Print all prime numbers in the given range
        for (int i = low; i <= high; i++) {
            if (dummy[i - low] == true) {
                System.out.print(i + " ");
            }
        }
        
        sc.close();
    }
}


// ===========================================================================================================


import java.util.*;

class SegmentedSieve {

    // Corrected Simple Sieve: Dynamically generates base primes up to sqrt(high)
    static ArrayList<Integer> simpleSieve(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        
        // 0 and 1 are not prime
        if (limit >= 0) isPrime[0] = false;
        if (limit >= 1) isPrime[1] = false;

        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Collect all base primes needed for the segmented range
        ArrayList<Integer> basePrimes = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                basePrimes.add(i);
            }
        }
        return basePrimes;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int low = sc.nextInt();
        int high = sc.nextInt();
        
        // 1. Calculate the limit needed for the base sieve: sqrt(high)
        int limit = (int) Math.sqrt(high);
        
        // 2. Generate only the necessary primes up to sqrt(high)
        ArrayList<Integer> basePrimes = simpleSieve(limit);
        
        // 3. Initialize the segmented dummy array
        int range = high - low + 1;
        boolean dummy[] = new boolean[range];
        Arrays.fill(dummy, true);

        // Special case: numbers less than 2 are not prime
        if (low <= 1) {
            int offset = 1 - low;
            if (offset >= 0 && offset < range) {
                dummy[offset] = false; // Mark 1 as non-prime
            }
            if (low == 0 && range > 1) {
                dummy[0] = false;     // Mark 0 as non-prime
            }
        }

        // 4. Mark multiples of base primes in the range [low, high]
        for (int prime : basePrimes) {
            // Find the first multiple of 'prime' greater than or equal to 'low'
            int firstMultiple = (low / prime) * prime;
            if (firstMultiple < low) {
                firstMultiple += prime;
            }
            
            // Start marking from the maximum of its first multiple or its square
            int start = Math.max(firstMultiple, prime * prime);
            
            for (int j = start; j <= high; j += prime) {
                dummy[j - low] = false;
            }
        }

        // 5. Print all prime numbers in the given range
        for (int i = low; i <= high; i++) {
            if (i >= 2 && dummy[i - low]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        
        sc.close();
    }
}
