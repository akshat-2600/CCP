// import java.util.*;
// import java.util.regex.Matcher;
// import java.util.regex.Pattern;

// /**
//  * Natural Sort Implementation - Sorts strings in human-readable order
//  * Example: "file2.txt" comes before "file10.txt" in natural order
//  */
// public class NaturalSort {
    
//     /**
//      * Comparator that implements natural sorting order
//      */
//     public static class NaturalOrderComparator implements Comparator<String> {
        
//         @Override
//         public int compare(String s1, String s2) {
//             if (s1 == null && s2 == null) return 0;
//             if (s1 == null) return -1;
//             if (s2 == null) return 1;
            
//             // Split strings into parts (numeric and non-numeric)
//             List<String> parts1 = splitIntoParts(s1);
//             List<String> parts2 = splitIntoParts(s2);
            
//             int i = 0;
//             while (i < parts1.size() && i < parts2.size()) {
//                 String part1 = parts1.get(i);
//                 String part2 = parts2.get(i);
                
//                 // Check if both parts are numeric
//                 boolean isNum1 = isNumeric(part1);
//                 boolean isNum2 = isNumeric(part2);
                
//                 if (isNum1 && isNum2) {
//                     // Compare numeric parts as integers
//                     int num1 = Integer.parseInt(part1);
//                     int num2 = Integer.parseInt(part2);
//                     if (num1 != num2) {
//                         return Integer.compare(num1, num2);
//                     }
//                 } else {
//                     // Compare as strings
//                     int cmp = part1.compareTo(part2);
//                     if (cmp != 0) {
//                         return cmp;
//                     }
//                 }
//                 i++;
//             }
            
//             // If all parts equal, shorter string comes first
//             return Integer.compare(parts1.size(), parts2.size());
//         }
        
//         /**
//          * Splits a string into alternating non-numeric and numeric parts
//          * Example: "file10.txt" → ["file", "10", ".txt"]
//          */
//         private List<String> splitIntoParts(String str) {
//             List<String> parts = new ArrayList<>();
//             Pattern pattern = Pattern.compile("(\\D*)(\\d*)");
//             Matcher matcher = pattern.matcher(str);
            
//             while (matcher.find()) {
//                 String nonNumeric = matcher.group(1);
//                 String numeric = matcher.group(2);
                
//                 if (!nonNumeric.isEmpty()) {
//                     parts.add(nonNumeric);
//                 }
//                 if (!numeric.isEmpty()) {
//                     parts.add(numeric);
//                 }
//             }
            
//             return parts;
//         }
        
//         private boolean isNumeric(String str) {
//             return str.matches("\\d+");
//         }
//     }
    
//     /**
//      * Alternative implementation using different approach
//      * Compares character by character with numeric chunk handling
//      */
//     public static class NaturalOrderComparatorV2 implements Comparator<String> {
        
//         @Override
//         public int compare(String s1, String s2) {
//             if (s1 == null && s2 == null) return 0;
//             if (s1 == null) return -1;
//             if (s2 == null) return 1;
            
//             int i1 = 0, i2 = 0;
            
//             while (i1 < s1.length() && i2 < s2.length()) {
//                 char c1 = s1.charAt(i1);
//                 char c2 = s2.charAt(i2);
                
//                 // Check if both are digits
//                 if (Character.isDigit(c1) && Character.isDigit(c2)) {
//                     // Extract complete numbers
//                     StringBuilder num1 = new StringBuilder();
//                     StringBuilder num2 = new StringBuilder();
                    
//                     while (i1 < s1.length() && Character.isDigit(s1.charAt(i1))) {
//                         num1.append(s1.charAt(i1++));
//                     }
//                     while (i2 < s2.length() && Character.isDigit(s2.charAt(i2))) {
//                         num2.append(s2.charAt(i2++));
//                     }
                    
//                     // Compare as integers
//                     int n1 = Integer.parseInt(num1.toString());
//                     int n2 = Integer.parseInt(num2.toString());
                    
//                     if (n1 != n2) {
//                         return Integer.compare(n1, n2);
//                     }
//                 } else {
//                     // Compare characters normally
//                     if (c1 != c2) {
//                         return Character.compare(c1, c2);
//                     }
//                     i1++;
//                     i2++;
//                 }
//             }
            
//             // If all equal, shorter string comes first
//             return Integer.compare(s1.length(), s2.length());
//         }
//     }
    
//     /**
//      * Main method with comprehensive test cases
//      */
//     public static void main(String[] args) {
//         // Test data
//         List<String> testData = Arrays.asList(
//             "file1.txt",
//             "file2.txt",
//             "file10.txt",
//             "file11.txt",
//             "file20.txt",
//             "file100.txt",
//             "image1.png",
//             "image2.png",
//             "image10.png",
//             "photo1.jpg",
//             "photo2.jpg",
//             "photo10.jpg",
//             "item1",
//             "item2",
//             "item10",
//             "item11",
//             "item20",
//             "chapter1",
//             "chapter2",
//             "chapter10",
//             "chapter11",
//             "a1b2c3",
//             "a1b10c3",
//             "a2b1c1",
//             "version1.2",
//             "version1.10",
//             "version2.1",
//             "version10.1",
//             "test1_2",
//             "test1_10",
//             "test2_1",
//             "test10_1",
//             "abc123def456",
//             "abc123def45",
//             "123abc",
//             "abc123",
//             "abc",
//             "123"
//         );
        
//         // Test using NaturalOrderComparator
//         System.out.println("=== Natural Sort using NaturalOrderComparator ===");
//         List<String> sorted1 = new ArrayList<>(testData);
//         Collections.sort(sorted1, new NaturalOrderComparator());
//         displaySortedList(sorted1);
        
//         // Test using NaturalOrderComparatorV2
//         System.out.println("\n=== Natural Sort using NaturalOrderComparatorV2 ===");
//         List<String> sorted2 = new ArrayList<>(testData);
//         Collections.sort(sorted2, new NaturalOrderComparatorV2());
//         displaySortedList(sorted2);
        
//         // Demonstrate difference between natural and lexicographic sort
//         System.out.println("\n=== Comparison: Natural vs Lexicographic Sort ===");
//         List<String> comparisonData = Arrays.asList(
//             "file1", "file2", "file10", "file11", "file20", "file100"
//         );
        
//         // Natural sort
//         List<String> naturalSorted = new ArrayList<>(comparisonData);
//         Collections.sort(naturalSorted, new NaturalOrderComparator());
//         System.out.println("Natural Sort:    " + naturalSorted);
        
//         // Lexicographic sort (default)
//         List<String> lexicographicSorted = new ArrayList<>(comparisonData);
//         Collections.sort(lexicographicSorted);
//         System.out.println("Lexicographic Sort: " + lexicographicSorted);
        
//         // Demonstrate with file system like sorting
//         System.out.println("\n=== File System Style Sorting ===");
//         List<String> files = Arrays.asList(
//             "IMG_001.jpg",
//             "IMG_002.jpg",
//             "IMG_010.jpg",
//             "IMG_011.jpg",
//             "IMG_100.jpg",
//             "IMG_101.jpg",
//             "DSC_1.jpg",
//             "DSC_2.jpg",
//             "DSC_10.jpg",
//             "DSC_11.jpg"
//         );
        
//         Collections.sort(files, new NaturalOrderComparator());
//         displaySortedList(files);
        
//         // Demonstrate using Java 8 Stream API
//         System.out.println("\n=== Using Java 8 Stream API ===");
//         List<String> streamSorted = testData.stream()
//             .sorted(new NaturalOrderComparator())
//             .toList();
//         displaySortedList(streamSorted);
//     }
    
//     /**
//      * Utility method to display sorted list
//      */
//     private static void displaySortedList(List<String> list) {
//         int count = 0;
//         for (String item : list) {
//             System.out.printf("%2d: %s%n", ++count, item);
//         }
//     }
    
//     /**
//      * Helper class for sorting arrays
//      */
//     public static class NaturalSortUtility {
        
//         /**
//          * Sorts an array of strings using natural order
//          */
//         public static void sort(String[] array) {
//             Arrays.sort(array, new NaturalOrderComparator());
//         }
        
//         /**
//          * Sorts a list of strings using natural order
//          */
//         public static void sort(List<String> list) {
//             Collections.sort(list, new NaturalOrderComparator());
//         }
        
//         /**
//          * Returns a sorted copy of the list
//          */
//         public static List<String> sortedCopy(List<String> list) {
//             List<String> copy = new ArrayList<>(list);
//             Collections.sort(copy, new NaturalOrderComparator());
//             return copy;
//         }
//     }
// }


// ---------------------------------------------------------------------------------------------------


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NaturalSort {

    // Matches integers or decimal numbers
    private static final Pattern TOKEN_PATTERN =
            Pattern.compile("\\d+(?:\\.\\d+)?|\\D+");

    public static void main(String[] args) {

        List<String> items = Arrays.asList(
                "Photo10.jpg",
                "Photo.jpg",
                "Photo2.jpg",
                "Photo1.jpg",
                "Photo20.jpg",
                "    Photo0000   1974.jpg",
                "Photo0002.jpg",
                "Photo1.5.jpg",
                "Photo1.20.jpg",
                "Photo10.2.jpg",
                "Photo2.10.jpg"
        );

        Comparator<String> naturalOrderComparator = (s1, s2) -> {

            // Ignore leading/trailing spaces
            s1 = s1.trim();
            s2 = s2.trim();

            Matcher m1 = TOKEN_PATTERN.matcher(s1);
            Matcher m2 = TOKEN_PATTERN.matcher(s2);

            while (m1.find() && m2.find()) {

                String token1 = m1.group();
                String token2 = m2.group();

                boolean number1 = isNumber(token1);
                boolean number2 = isNumber(token2);

                // Both tokens are numeric
                if (number1 && number2) {

                    BigDecimal n1 = new BigDecimal(token1);
                    BigDecimal n2 = new BigDecimal(token2);

                    int result = n1.compareTo(n2);

                    if (result != 0) {
                        return result;
                    }

                    /*
                     * If numerically equal:
                     * 2 and 0002 are considered equal.
                     *
                     * Continue comparing remaining parts.
                     */
                }

                // One is numeric and the other is not
                else if (number1 != number2) {

                    // Numbers come before text
                    return number1 ? -1 : 1;
                }

                // Both are text
                else {

                    int result = token1.compareToIgnoreCase(token2);

                    if (result != 0) {
                        return result;
                    }
                }
            }

            // If one string has remaining tokens
            if (m1.find()) {
                return 1;
            }

            if (m2.find()) {
                return -1;
            }

            // Completely equal
            return 0;
        };

        items.sort(naturalOrderComparator);

        System.out.println("Natural Sorted:");
        for (String item : items) {
            System.out.println(item);
        }
    }

    private static boolean isNumber(String s) {
        return s.matches("\\d+(?:\\.\\d+)?");
    }
}
