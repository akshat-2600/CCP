import java.util.*;

public class CombinationExample {

    // Generates combinations of alphabets using backtracking
    public static void generateCombinations(List<Character> alphabets, int r, int startIndex, 
                                            StringBuilder current, Set<String> result) {
        // Base Case: If current combination reaches size r, add it to result
        if (current.length() == r) {
            result.add(current.toString());
            return;
        }

        // Loop through the remaining alphabets
        for (int i = startIndex; i < alphabets.size(); i++) {
            current.append(alphabets.get(i));                               // Choose
            generateCombinations(alphabets, r, i + 1, current, result);     // Explore
            current.deleteCharAt(current.length() - 1);                     // Un-choose (Backtrack)
        }
    }

    public static void main(String args[]) {
        // Changed input from integers to alphabets
        List<Character> alphabets = new ArrayList<Character>();
        alphabets.add('B'); 
        alphabets.add('A'); 
        alphabets.add('C'); 
        alphabets.add('E'); 
        alphabets.add('A'); // Duplicate alphabet to test uniqueness

        // Sort the list so duplicate combinations end up in the exact same character order
        Collections.sort(alphabets); // Becomes: [A, A, B, C, E]

        int r = 3; // Let's find combinations of size 3
        
        // Using a Set to automatically filter out duplicate combinations
        Set<String> result = new LinkedHashSet<>();
        generateCombinations(alphabets, r, 0, new StringBuilder(), result);

        System.out.println("The unique alphabet combinations of size " + r + " are:");
        for (String combo : result) {
            System.out.println(combo);
        }
        System.out.println("Total unique combinations: " + result.size());
    }
}
