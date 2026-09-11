import java.util.Arrays;

public class PalindromeGenerator {

    public static String getLexicographicallyFirstPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "-1";
        }

        // Step 1: Count frequencies of each character
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        // Step 2: Count how many characters have an odd frequency
        int oddCount = 0;
        char oddChar = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
                oddCount++;
                oddChar = (char) (i + 'a');
            }
        }

        // A palindrome cannot be formed if more than one character has an odd frequency
        if (oddCount > 1) {
            return "-1";
        }

        // Step 3: Build the palindrome from the outside in (or build halves)
        // Since we iterate from 'a' to 'z', it guarantees the lexicographically smallest result
        StringBuilder leftHalf = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                // Take half of the count for the left side of the palindrome
                int countToPut = freq[i] / 2;
                for (int j = 0; j < countToPut; j++) {
                    leftHalf.append((char) (i + 'a'));
                }
            }
        }

        // Step 4: Assemble the final string
        String left = leftHalf.toString();
        String right = leftHalf.reverse().toString(); // Mirroring the left half
        
        // Re-reverse leftHalf back to original for safety, though we already have our string
        if (oddCount == 1) {
            return left + oddChar + right;
        } else {
            return left + right;
        }
    }

    public static void main(String[] args) {
        // Test Cases
        System.out.println(getLexicographicallyFirstPalindrome("aabb"));    // Output: abba
        System.out.println(getLexicographicallyFirstPalindrome("abc"));     // Output: -1
        System.out.println(getLexicographicallyFirstPalindrome("aaabbb"));  // Output: -1 (two odd counts: a and b)
        System.out.println(getLexicographicallyFirstPalindrome("mdaam"));   // Output: madam
    }
}
