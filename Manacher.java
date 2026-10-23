public class Manacher {
    
    static int manacherAlgo(String s, int N) {
        String str = getModifiedString(s, N);
        int len = 2 * N + 1;
        int[] LPS = new int[len];
        
        // c = center of palindrome having the rightmost boundary
        int c = 0;
        // r = right boundary of that palindrome
        int r = 0;
        int maxLen = 0;
        
        for (int i = 0; i < len; i++) {
            // Mirror of i with respect to center c
            int mirror = 2 * c - i;
            
            // If i lies inside current palindrome, use information from mirror
            if (i < r) {
                LPS[i] = Math.min(r - i, LPS[mirror]);
            }
            
            int a = i + (1 + LPS[i]);
            int b = i - (1 + LPS[i]);
            
            // Expand around i
            while (a < len && b >= 0 && str.charAt(a) == str.charAt(b)) {
                LPS[i]++;
                a++;
                b--;
            }
            
            // Track the maximum length found so far
            maxLen = Math.max(maxLen, LPS[i]);
            
            // If palindrome around i extends beyond current right boundary
            if (i + LPS[i] > r) {
                c = i;
                r = i + LPS[i];
            }
        }
        
        return maxLen;
    }

    static String getModifiedString(String s, int N) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("#");
            sb.append(s.charAt(i));
        }
        sb.append("#");
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "abacabacabb";
        int N = str.length();
        System.out.println(manacherAlgo(str, N)); // Output: 3
    }
}
