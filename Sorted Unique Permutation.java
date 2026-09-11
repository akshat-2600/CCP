import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Permutations {

    public static void main(String[] args) {
        String input = "BAC";
        distinctPermutations(input);
    }

    public static void distinctPermutations(String input) {
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        input = new String(chars);
        permute(input.toCharArray(), 0);
    }

    public static void permute(char[] chars, int index) {
        // Base case: if we reach the last character, print the configuration
        if (index == chars.length - 1) {
            System.out.println(String.valueOf(chars));
            return;
        }

        // Set to track duplicate characters at the current recursive level
        Set<Character> used = new HashSet<>();
        
        for (int i = index; i < chars.length; i++) {
            // Skip the character if it has already been used at this position
            if (used.contains(chars[i])) {
                continue;
            }
            
            used.add(chars[i]);
            swap(chars, index, i);      // Choose
            permute(chars, index + 1);  // Explore
            swap(chars, index, i);      // Un-choose (Backtrack)
        }
    }

    public static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
