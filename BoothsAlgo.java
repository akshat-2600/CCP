import java.util.Scanner;

public class BoothsAlgo {

    public static int boothMultiply(int multiplicand, int multiplier) {

        int A = 0;
        int Q = multiplier;
        int M = multiplicand;
        int Q_1 = 0;

        // Number of bits
        int n = 32;

        for (int i = 0; i < n; i++) {

            int Q0 = Q & 1;

            // Booth's conditions
            if (Q0 == 1 && Q_1 == 0) {
                // A = A - M
                A = A - M;
            } 
            else if (Q0 == 0 && Q_1 == 1) {
                // A = A + M
                A = A + M;
            }

            // Arithmetic right shift of A, Q, Q_1
            Q_1 = Q & 1;

            Q = (Q >>> 1) | (A << 31);
            A = A >> 1;
        }

        return Q;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter multiplicand: ");
        int multiplicand = sc.nextInt();

        System.out.print("Enter multiplier: ");
        int multiplier = sc.nextInt();

        int result = boothMultiply(multiplicand, multiplier);

        System.out.println("Product = " + result);

        sc.close();
    }
}

// --------------------------------------------------------------------------------------------------------

// import java.util.Scanner;

// public class BoothsAlgo {
//     public static Scanner s = new Scanner(System.in);

//     /** Function to multiply using Booth's Algorithm **/
//     public int multiply(int n1, int n2) {
//         int[] m = binary(n1);
//         int[] m1 = binary(-n1);
//         int[] r = binary(n2);
//         int[] A = new int[9];
//         int[] S = new int[9];
//         int[] P = new int[9];

//         for (int i = 0; i < 4; i++) {
//             A[i] = m[i];
//             S[i] = m1[i];
//             P[i + 4] = r[i];
//         }

//         display(A, 'A');
//         display(S, 'S');
//         display(P, 'P');
//         System.out.println();

//         for (int i = 0; i < 4; i++) {
//             if (P[7] == 0 && P[8] == 1) {
//                 add(P, A);
//             } else if (P[7] == 1 && P[8] == 0) {
//                 add(P, S);
//             }
//             rightShift(P);
//             display(P, 'P');
//         }
//         return getDecimal(P);
//     }

//     /** Function to get Decimal equivalent of P **/
//     public int getDecimal(int[] B) {
//         int p = 0;
//         int t = 1;
//         for (int i = 7; i >= 0; i--, t *= 2) {
//             p += (B[i] * t);
//         }
//         if (B[0] == 1) { // if the result is negative
//             p = p - 256;
//         }
//         return p;
//     }

//     /** Function to right shift array **/
//     public void rightShift(int[] A) {
//         for (int i = 8; i > 0; i--) {
//             A[i] = A[i - 1];
//         }
//         // Sign extend
//         A[0] = A[1];
//     }

//     /** Function to add two binary arrays **/
//     public void add(int[] A, int[] B) {
//         int carry = 0;
//         for (int i = 8; i >= 0; i--) {
//             int temp = A[i] + B[i] + carry;
//             A[i] = temp % 2;
//             carry = temp / 2;
//         }
//     }

//     /** Function to get binary array of a number **/
//     public int[] binary(int n) {
//         int[] bin = new int[4];
//         int ctr = 3;
//         int num = n;
        
//         /** for negative numbers 2's complement **/
//         if (n < 0) {
//             num = 16 + n;
//         }
//         while (num != 0) {
//             bin[ctr--] = num % 2;
//             num /= 2;
//         }
//         return bin;
//     }

//     /** Function to print array **/
//     public void display(int[] P, char ch) {
//         System.out.print("\n" + ch + " : ");
//         for (int i = 0; i < P.length; i++) {
//             if (i == 4 || i == 8) {
//                 System.out.print(" ");
//             }
//             System.out.print(P[i]);
//         }
//     }

//     /** Main function **/
//     public static void main(String[] args) {
//         Scanner scan = new Scanner(System.in);
//         BoothsAlgo b = new BoothsAlgo();
        
//         System.out.println("Enter two integer numbers -");
//         int n1 = scan.nextInt();
//         int n2 = scan.nextInt();
        
//         int result = b.multiply(n1, n2);
//         System.out.println("\n\nResult : " + n1 + " * " + n2 + " = " + result);
//     }
// }


// ---------------------------------------------------------------------------------------------


// import java.util.Scanner;

// class MainBitwise {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
        
//         int multiplicand = sc.nextInt();
//         int multiplier = sc.nextInt();

//         int product = 0;
//         int multiplicandBits = Integer.toBinaryString(multiplicand).length();

//         for (int i = 0; i < multiplicandBits; i++) {
//             int currentBit = (multiplicand & 0b1);
//             if (currentBit == 1) {
//                 product += multiplier;
//             }
//             multiplier <<= 1;
//             multiplicand >>>= 1;
//         }
//         System.out.println(product);
//     }
// }
