import java.util.*;

class IncrementalSieve {
    
    // Function implementing the incremental sieve logic
    static List<Integer> incrementalSieve(int limit) {
        List<Intger> primes = new ArrayList<>();

        //edge case : if limit is less than 2, there are no primes
        if (limit < 2) {
            return primes;
        }

        // .. intinialize the tracking array for composite
        boolean[] isComposite = new boolean[limit+1];

        primes.add(2);
        int nextNum = 3;

        while (nextNum <= limit) {
            // check if the number was already marked as composite by a previosu prime
            if (!isComposite[nextNum]) {
                boolean isPrime = true;
                doubel sqrtNextNum = Math.sqrt(nextNum);

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

                    long start = (long) nextNum * nextNum;
                    long step = (long) nextNum * 2;
                    for (long i = start; i <= limit; i+=step) {
                        isComposite[(int)i] = true;
                    }
                }
            }
            nextNum += 2;
        }
        return primes;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the limit to search for primes: ");
        int limit = sc.nextInt();

        List<Integer> result = incrementalSieve(limit);
        System.out.println("Primes fount up to " + limt + ": " + result);
        sc.close();
    }
}