import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NaturalSort {

    public static List<String> naturalSort(List<String> strings) {
        // Splitting into text/number chunks allows element-by-element comparison
        strings.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                List<String> chunks1 = splitChunks(s1);
                List<String> chunks2 = splitChunks(s2);

                int minSize = Math.min(chunks1.size(), chunks2.size());
                for (int i = 0; i < minSize; i++) {
                    String c1 = chunks1.get(i);
                    String c2 = chunks2.get(i);

                    // If both chunks are digits, compare them as numbers
                    if (Character.isDigit(c1.charAt(0)) && Character.isDigit(c2.charAt(0))) {
                        int num1 = Integer.parseInt(c1);
                        int num2 = Integer.parseInt(c2);
                        if (num1 != num2) {
                            return Integer.compare(num1, num2);
                        }
                    } else {
                        // Otherwise, compare them alphabetically
                        int textComp = c1.compareTo(c2);
                        if (textComp != 0) {
                            return textComp;
                        }
                    }
                }
                return Integer.compare(chunks1.size(), chunks2.size());
            }
        });
        return strings;
    }

    // Breaks a string like "file10.txt" into ["file", "10", ".txt"]
    private static List<String> splitChunks(String str) {
        List<String> chunks = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\d+|\\D+");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            chunks.add(matcher.group());
        }
        return chunks;
    }

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("file1.txt");
        strings.add("file10.txt");
        strings.add("file2.txt");
        strings.add("file20.txt");
        strings.add("file3.txt");

        List<String> sortedStrings = naturalSort(strings);
        for (String str : sortedStrings) {
            System.out.println(str);
        }
    }
}

