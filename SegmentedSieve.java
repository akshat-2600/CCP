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
