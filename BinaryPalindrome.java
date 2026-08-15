class Main {

    public static boolean Palindrome(int N) {

        String s = Integer.toBinaryString(N);
        int i = 0, j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        System.out.println("enter the number -");
        int x = s1.nextInt();
        System.out.println(Palindrome(x));
    }
}


// ------------------------------------------------------------------------------------------------


String bin = Integer.toBinaryString(n);

String rev = new StringBuilder(bin).reverse().toString();

return bin.equals(rev);

// -------------------------------------------------------------------------------------------------------


import java.io.*;

class Binary {

        public static void main(String[] args) {

            int x = 9;

            String s = Integer.toBinaryString(x);

            boolean ans = false;

            String s1 = "";

            for (int i = s.length() - 1; i >= 0; i--) {

                s1 = s1 + s.charAt(i);

            }

            if (s.equals(s1)) {

                System.out.println("True");

            } else {
                System.out.println("False");
            }

        }

}