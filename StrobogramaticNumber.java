import java.util.*;

public class StrobogrammaticNumber {
    
    public static boolean isStrobogrammatic(String num) {
       
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        
        int left = 0;
        int right = num.length() - 1;
        
        while (left <= right) {
            char leftChar = num.charAt(left);
            char rightChar = num.charAt(right);
            
            // Check if both characters are valid for rotation
            if (!map.containsKey(leftChar) || !map.containsKey(rightChar)) {
                return false;
            }
            
            // Check if rotated left character equals right character
            if (map.get(leftChar) != rightChar) {
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }
    
    public static boolean isStrobogrammaticAlternative(String num) {
        int left = 0;
        int right = num.length() - 1;
        
        while (left <= right) {
            char l = num.charAt(left);
            char r = num.charAt(right);
            
            // Check all valid pairs
            if (!isValidPair(l, r)) {
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }
    
    private static boolean isValidPair(char left, char right) {
        return (left == '0' && right == '0') ||
               (left == '1' && right == '1') ||
               (left == '6' && right == '9') ||
               (left == '8' && right == '8') ||
               (left == '9' && right == '6');
        }
    
    // Main method with test cases
    public static void main(String[] args) {
        // Test cases
        String[] testNumbers = {
            "69",    // true: 69 rotated becomes 69
            "88",    // true: 88 rotated becomes 88
            "962",   // false: 962 rotated becomes 296
            "101",   // true: 101 rotated becomes 101
            "609",   // false: 609 rotated becomes 609 (invalid middle digit)
        };
        
        System.out.println("Strobogrammatic Number Checker");
        System.out.println("=================================");
        
        for (String num : testNumbers) {
            boolean result = isStrobogrammatic(num);
            System.out.println(num + " → " + result);
        }
        
        // Additional test with user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter a number to check (or 'quit' to exit):");
        
        while (true) {
            System.out.print("Number: ");
            String input = scanner.nextLine().trim();
            
            if (input.equalsIgnoreCase("quit")) {
                break;
            }
            
            // Check if input is a valid number
            if (!input.matches("\\d+")) {
                System.out.println("Please enter a valid number (digits only)");
                continue;
            }
            
            boolean result = isStrobogrammatic(input);
            System.out.println(input + " is " + (result ? "" : "NOT ") + "strobogrammatic");
            System.out.println();
        }
        
        scanner.close();
    }
}


// ------------------------------------------------------------------------------------------------

import java.util.*;

public class EthCode {
    
    public static ArrayList<String> strobogrammaticNum(int n) {
        return numDef(n, n);
    }

    public static ArrayList<String> numDef(int n, int length) {
        if (n == 0) {
            return new ArrayList<>(Arrays.asList(""));
        }
        
        if (n == 1) {
            return new ArrayList<>(Arrays.asList("1", "0", "8"));
        }
        
        ArrayList<String> middles = numDef(n - 2, length);
        ArrayList<String> result = new ArrayList<>();

        for (String middle : middles) {
            if (n != length) {
                result.add("0" + middle + "0");
            }
            result.add("1" + middle + "1");
            result.add("6" + middle + "9");
            result.add("8" + middle + "8");
            result.add("9" + middle + "6");
        }
        
        return result;
    }

    public static void main(String args[]) {
        System.out.println(strobogrammaticNum(3));
    }
}
