// T.C : O(N)
// S.C : O(N)

public class EthCode {

    // Returns the safe position (1-indexed) in the Josephus circle
    static int josephus(int n, int k) {
        // Base Case: Only 1 person remains, they are the survivor
        if (n == 1) {
            return 1;
        }
        
        // Recursive step: The position returned by josephus(n - 1, k) is adjusted 
        // because the elimination shifts the start position for the remaining subset.
        return (josephus(n - 1, k) + k - 1) % n + 1;
    }

    public static void main(String[] args) {
        int n = 14;
        int k = 2;
        
        System.out.println("The safe position is: " + josephus(n, k));
    }
}
