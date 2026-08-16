// t.c : O(K * x)
// SC : O(1)

// import java.io.*;
// import java.util.*;

// class RemainderTheorem {

//     // Function to find the minimum x that satisfies the Chinese Remainder Theorem conditions
//     static int findMinX(int num[], int rem[], int k) {
//         int x = 1;

//         while (true) {
//             int j;
//             for (j = 0; j < k; j++) {
//                 if (x % num[j] != rem[j]) {
//                     break;
//                 }
//             }

//             // If all remainders matched, x is found
//             if (j == k) {
//                 return x;
//             }
//             x++;
//         }
//     }

//     public static void main(String args[]) {
//         Scanner sc = new Scanner(System.in);

//         System.out.println("Enter the number of congruence relations: ");
//         int size = sc.nextInt();

//         int a[] = new int[size];
//         int m[] = new int[size];

//         System.out.println("Enter the values of a (remainders): ");
//         for (int i = 0; i < size; i++) {
//             a[i] = sc.nextInt();
//         }

//         System.out.println("Enter the values of m (moduli): ");
//         for (int i = 0; i < size; i++) {
//             m[i] = sc.nextInt();
//         }

//         System.out.println("x is " + findMinX(m, a, size));
        
//         sc.close();
//     }
// }



import java.util.*;

class RemainderTheorem {

    // Function to implement the Chinese Remainder Theorem (CRT)
    static int CRT(int a[], int m[], int n, int p) {
        int x = 0;

        for (int i = 0; i < n; i++) {
            // Step 1: Find the partial product M_i
            int M = p / m[i]; 
            int y = 0;

            // Step 2: Find the modular multiplicative inverse of M_i modulo m[i] using brute force
            for (int j = 0; j < m[i]; j++) {
                if ((M * j) % m[i] == 1) {
                    y = j;
                    break;
                }
            }

            // Step 3: Accumulate the sum element-by-element
            x = x + a[i] * M * y;
        }

        // Step 4: Keep the final answer bounded within [0, p-1]
        return x % p;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of congruence relations: ");
        int size = sc.nextInt();

        int a[] = new int[size];
        System.out.println("Enter the values of a (remainders): ");
        for (int i = 0; i < size; i++) {
            a[i] = sc.nextInt();
        }

        int m[] = new int[size];
        int p = 1; // Variable to store the total product of all moduli
        System.out.println("Enter the values of m (moduli): ");
        for (int i = 0; i < size; i++) {
            m[i] = sc.nextInt();
            p = p * m[i]; // Calculate the product: P = m1 * m2 * ... * mn
        }

        System.out.println("The solution is " + CRT(a, m, size, p));
        
        sc.close();
    }
}




// /////////////////////////////////////////////////////////////////////////////////////////////////////////


// Q1

import java.util.Scanner;

class Main {

    // Function to calculate the remainder
    static int getRemainder(int dividend, int divisor) {
        // The % operator calculates the remainder of a division
        return dividend % divisor;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.util.in);

        // Test with user input
        System.out.print("Enter dividend: ");
        int dividend = sc.nextInt();

        System.out.print("Enter divisor: ");
        int divisor = sc.nextInt();

        // Basic validation to prevent division by zero
        if (divisor == 0) {
            System.out.println("Error: Divisor cannot be zero.");
        } else {
            int remainder = getRemainder(dividend, divisor);
            System.out.println("The remainder is: " + remainder);
        }

        sc.close();
    }
}
 

// -----------------------------------------------------------

// Q2
import java.util.ArrayList;
import java.util.List;

class Main {

    // Function to count elements divisible by the divisor
    static int countDivisible(List<Integer> nums, int divisor) {
        int count = 0;

        // Loop through each number in the list
        for (int num : nums) {
            // A number is divisible if the remainder is exactly 0
            if (num % divisor == 0) {
                count++;
            }
        }

        return count;
    }

    public static void main(String args[]) {
        // Example 1
        List<Integer> nums1 = new ArrayList<>(List.of(4, 7, 10, 15, 20));
        int divisor1 = 5;
        System.out.println("Output 1: " + countDivisible(nums1, divisor1)); // Expected: 3 (10, 15, 20)
        
        // Note: The original prompt example states output is 2 for [4, 7, 10, 15, 20] with divisor 5.
        // Mathematically, 10, 15, and 20 are all divisible by 5, which makes the count 3.

        // Example 2
        List<Integer> nums2 = new ArrayList<>(List.of(12, 15, 20, 25));
        int divisor2 = 7;
        System.out.println("Output 2: " + countDivisible(nums2, divisor2)); // Expected: 0 (None are divisible by 7)
        
        // Note: The original prompt example states output is 1 for [12, 15, 20, 25] with divisor 7.
        // Mathematically, none of these numbers are multiples of 7, making the true count 0.
    }
}


// Q3 -------------------------------------------------------------

import java.util.Scanner;

class Main {

    // Function to find the remainder of the polynomial expression
    static int getPolynomialRemainder(int a, int b, int c, int d) {
        // Evaluate the polynomial at x = d and find the remainder
        int expressionValue = (a * d * d) + (b * d) + c;
        
        return expressionValue % d;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter coefficient a: ");
        int a = sc.nextInt();

        System.out.print("Enter coefficient b: ");
        int b = sc.nextInt();

        System.out.print("Enter coefficient c: ");
        int c = sc.nextInt();

        System.out.print("Enter divisor d: ");
        int d = sc.nextInt();

        if (d == 0) {
            System.out.println("Error: Divisor 'd' cannot be zero.");
        } else {
            int remainder = getPolynomialRemainder(a, b, c, d);
            System.out.println("The remainder is: " + remainder);
        }

        sc.close();
    }
}


// ---------------------------------------------------------------

// Q4
import java.util.ArrayList;
import java.util.List;

class Main {

    // Function to calculate the remainder of each element in the list
    static List<Integer> getRemaindersList(List<Integer> nums, int d) {
        List<Integer> remainders = new ArrayList<>();

        // Iterate through each number in the input list
        for (int num : nums) {
            // Calculate remainder using % and add it to the output list
            remainders.add(num % d);
        }

        return remainders;
    }

    public static void main(String args[]) {
        // Example 1
        List<Integer> nums1 = List.of(10, 15, 21, 24);
        int d1 = 7;
        System.out.println("Output 1: " + getRemaindersList(nums1, d1)); 
        // Expected: [3, 1, 0, 3]

        // Example 2
        List<Integer> nums2 = List.of(12, 18, 27, 32);
        int d2 = 5;
        System.out.println("Output 2: " + getRemaindersList(nums2, d2)); 
        // Expected: [2, 3, 2, 2]
    }
}
