// T.C  : o(N^2)

// public static int multiplication(int X, int Y) {
//     // Convert numbers into string
//     String x = Integer.toString(X);
//     String y = Integer.toString(Y);
//     int result = 0;

//     // Looping over y
//     for (int i = 0; i < y.length(); i++) {
//         int carry = 0;          // intermediate carry
//         String inter_res = "";  // intermediate result

//         // Looping over x.
//         for (int j = x.length() - 1; j >= 0; j--) {
//             // intermediate multiplication of each digit and addition of carry.
//             int num = Character.getNumericValue(y.charAt(i)) * Character.getNumericValue(x.charAt(j)) + carry;

//             if (num > 9 && j > 0) {
//                 inter_res = Integer.toString(num % 10) + inter_res;
//                 carry = num / 10;
//             } 
//             // else the digit is append to the intermediate result
//             // And assign carry as zero
//             else {
//                 inter_res = Integer.toString(num) + inter_res;
//                 carry = 0;
//             }
//         }

//         // Adding the intermediate results
//         result *= 10;
//         result += Integer.parseInt(inter_res);
//     }

//     System.out.print("result: ");
//     return result;
// }


// -----------------------------------------------------------------------------------------

// For string num ("123") to (123) use Integer.parseInt(num)

// T.C  : O(n ^ (log(3) base 2)) == O(n^(1.585))

// T.C  : T(n) = 3 * T(n/2) + O(n)

import java.util.*;

public class Main {
    public static int karatsuba(int x, int y) {
        if (x < 10 || y < 10) {
            return x * y;
        }

        int m = Math.max(getNumDigits(x), getNumDigits(y));
        int halfM = m / 2;
        int powerOf10 = (int) Math.pow(10, halfM);

        int a = x / powerOf10;
        int b = x % powerOf10;
        int c = y / powerOf10;
        int d = y % powerOf10;

        int ac = karatsuba(a, c);
        int bd = karatsuba(b, d);
        int abcd = karatsuba(a + b, c + d);

        int result = ac * (int) Math.pow(10, 2 * halfM) + (abcd - ac - bd) * powerOf10 + bd;
        return result;
    }

    private static int getNumDigits(int x) {
        if (x == 0) {
            return 1;
        }
        int count = 0;
        while (x > 0) {
            count++;
            x /= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        System.out.print("enter number1-");
        int x = s1.nextInt();
        System.out.print("enter number2-");
        int y = s1.nextInt();

        int product = karatsuba(x, y);
        System.out.println(x + " * " + y + " = " + product);
    }
}




// -----------------------------------------------------------------------------------------------------

import java.math.BigInteger;
import java.util.Scanner;

public class KaratsubaAlgorithm {
    public static BigInteger karatsuba(BigInteger x, BigInteger y) {
        int n = Math.max(x.bitLength(), y.bitLength());
        
        // Base case: if either x or y is small, use standard multiplication
        if (n <= 2000) {
            return x.multiply(y);
        }

        // Split the numbers into two halves
        int half = (n + 32) / 64 * 32;  // round up to the nearest multiple of 64 bits
        BigInteger mask = BigInteger.ONE.shiftLeft(half).subtract(BigInteger.ONE);

        BigInteger xLow = x.and(mask);
        BigInteger yLow = y.and(mask);
        BigInteger xHigh = x.shiftRight(half);
        BigInteger yHigh = y.shiftRight(half);

        BigInteger z0 = karatsuba(xLow, yLow);
        BigInteger z1 = karatsuba(xLow.add(xHigh), yLow.add(yHigh));
        BigInteger z2 = karatsuba(xHigh, yHigh);

        // Combine the results
        BigInteger result = z2.shiftLeft(2 * half)
                .add(z1.subtract(z2).subtract(z0).shiftLeft(half))
                .add(z0);
                
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        BigInteger x = scanner.nextBigInteger();
        System.out.print("Enter the second number: ");
        BigInteger y = scanner.nextBigInteger();

        BigInteger product = karatsuba(x, y);
        System.out.println("Product: " + product);
    }
}



// ------------------------------------------------------------------------------------


import java.util.*;

public class Main {

    // Main Karatsuba algorithm for polynomial multiplication
    public static int[] karatsuba(int[] poly1, int[] poly2) {
        int n = Math.max(poly1.length, poly2.length);

        // Base case: If the arrays are small, use standard naive multiplication
        if (n <= 2) {
            return naiveMultiply(poly1, poly2);
        }

        // Pad the polynomials with trailing zeros to make their lengths equal to a power of 2
        // or a standardized size 'n' for even division
        int[] p1 = Arrays.copyOf(poly1, n);
        int[] p2 = Arrays.copyOf(poly2, n);

        int halfN = n / 2;

        // Split poly1 into low and high halves: p1(x) = low1(x) + high1(x) * x^halfN
        int[] low1 = Arrays.copyOfRange(p1, 0, halfN);
        int[] high1 = Arrays.copyOfRange(p1, halfN, n);

        // Split poly2 into low and high halves: p2(x) = low2(x) + high2(x) * x^halfN
        int[] low2 = Arrays.copyOfRange(p2, 0, halfN);
        int[] high2 = Arrays.copyOfRange(p2, halfN, n);

        // Recursive steps (Karatsuba formulas)
        int[] z0 = karatsuba(low1, low2);               // low1 * low2
        int[] z2 = karatsuba(high1, high2);             // high1 * high2

        // Compute (low1 + high1) * (low2 + high2)
        int[] sum1 = addPolynomials(low1, high1);
        int[] sum2 = addPolynomials(low2, high2);
        int[] z1 = karatsuba(sum1, sum2);               // mid product

        // Compute middle term: z1 - z2 - z0
        int[] mid = subtractPolynomials(z1, addPolynomials(z0, z2));

        // Combine parts into final product: z0 + mid * x^halfN + z2 * x^(2 * halfN)
        int[] result = new int[2 * n - 1];
        
        // Add z0 to result
        for (int i = 0; i < z0.length; i++) {
            result[i] += z0[i];
        }
        // Add mid shifted by halfN
        for (int i = 0; i < mid.length; i++) {
            result[i + halfN] += mid[i];
        }
        // Add z2 shifted by 2 * halfN
        for (int i = 0; i < z2.length; i++) {
            result[i + 2 * halfN] += z2[i];
        }

        return trimZeros(result);
    }

    // Helper: Naive standard multiplication for base case
    private static int[] naiveMultiply(int[] poly1, int[] poly2) {
        int[] result = new int[poly1.length + poly2.length - 1];
        for (int i = 0; i < poly1.length; i++) {
            for (int j = 0; j < poly2.length; j++) {
                result[i + j] += poly1[i] * poly2[j];
            }
        }
        return result;
    }

    // Helper: Add two polynomial arrays
    private static int[] addPolynomials(int[] p1, int[] p2) {
        int len = Math.max(p1.length, p2.length);
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int val1 = (i < p1.length) ? p1[i] : 0;
            int val2 = (i < p2.length) ? p2[i] : 0;
            res[i] = val1 + val2;
        }
        return res;
    }

    // Helper: Subtract two polynomial arrays
    private static int[] subtractPolynomials(int[] p1, int[] p2) {
        int len = Math.max(p1.length, p2.length);
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int val1 = (i < p1.length) ? p1[i] : 0;
            int val2 = (i < p2.length) ? p2[i] : 0;
            res[i] = val1 - val2;
        }
        return res;
    }

    // Helper: Remove trailing zero elements from array that padding caused
    private static int[] trimZeros(int[] arr) {
        int i = arr.length - 1;
        while (i > 0 && arr[i] == 0) {
            i--;
        }
        return Arrays.copyOf(arr, i + 1);
    }

    public static void main(String[] args) {
        // Sample Input
        int[] poly1 = {1, 2, 3}; // 1 + 2x + 3x^2
        int[] poly2 = {4, 5, 6}; // 4 + 5x + 6x^2

        int[] product = karatsuba(poly1, poly2);

        // Sample Output: [4, 13, 28, 27, 18]
        System.out.println(Arrays.toString(product));
    }
}
