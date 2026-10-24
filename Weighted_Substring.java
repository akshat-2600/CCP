import java.util.*;

class Weighted_Substring {
    static int distinctSubString(String P, String Q, int K, int N) {
        // Hashmap to store all subStrings
        HashSet<String> S = new HashSet<>();
        
        // Iterate over all subStrings
        for (int i = 0; i < N; ++i) {
            // Maintain the sum of all characters encountered so far
            int sum = 0;
            // Maintain the subString till the current position
            String s = "";
            
            for (int j = i; j >= i && j < N; ++j) {
                // Get the position of the character in String Q
                int pos = P.charAt(j) - 'a';

                // Add weight to current sum
                sum += Q.charAt(pos) - '0';
                
                // Add current character to subString
                s += P.charAt(j);
                
                // If sum of characters is <=K then insert it into the set
                if (sum <= K) {
                    S.add(s);
                } else {
                    break;
                }
            }
        }
        // required value
        return S.size();
    }

    public static void main(String[] args) {
        // Sample Input
        String P = "abcde";
        String Q = "12345678912345678912345678";
        int K = 5;
        int N = P.length();
        
        System.out.print(distinctSubString(P, Q, K, N));
    }
}
