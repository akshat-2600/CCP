// T.C : O(sqrt(n) * logn)
// S.C : O(1)

class EulerPhi {
    // Function to return GCD of a and b
    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a%b);
    }

    // Function to calculate Euler's Totient (Phi)
    static int phi(int n) {
        int result = 1;
        
        for (int i = 2; i*i < n; i++) {
            if (gcd(i, n) == 1) {
                result++;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        int n = 8;
        
        // Finding Phi for input n
        System.out.println(phi(n));
    }
}


// ----------------------------------------------------------------------------------------

// T.C : O(sqrt(n))
// S.C : O(1)

import java.io.*;

class Main {

    static int phi(int n) {
        float result = n;

        for (int p = 2; p * p <= n; ++p) {
            if (n % p == 0) {
                while (n % p == 0) {
                    n /= p;
                }
                result *= (1.0 - (1.0 / (float) p));
            }
        }

        if (n > 1) {
            result -= result / n;
        }

        return (int) result;
    }

    public static void main(String args[]) {
        int n = 35;
        System.out.println("phi(" + n + ") = " + phi(n));
    }
}


// ------------------------------------------------------------------------------------------\

// T.C : O(sqrt(n))
// S.C : O(1)

import java.io.*;

class Main {

    static int phi(int n) {
        int result = n;

        for (int p = 2; p * p <= n; ++p) {
            if (n % p == 0) {
                while (n % p == 0) {
                    n /= p;
                }
                result -= result / p;
            }
        }

        if (n > 1) {
            result -= result / n;
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 1000;
        System.out.println(phi(n));
    }
}
