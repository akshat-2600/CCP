// import java.util.*;

// class LeadersInArray {

//     public static ArrayList<Integer> printLeadersBruteForce(int[] arr, int n) {
//         ArrayList<Integer> ans = new ArrayList<>();

//         for (int i = 0; i < n; i++) {
//             boolean leader = true;

//             for (int j = i + 1; j < n; j++) {
//                 if (arr[j] > arr[i]) {
//                     leader = false;
//                     break;
//                 }
//             }

//             if (leader) {
//                 ans.add(arr[i]);
//             }
//         }

//         return ans;
//     }

//     public static void main(String[] args) {
//         int n = 6;
//         int[] arr = {2, 4, 6, 3, 1, 2};
        
//         ArrayList<Integer> ans = printLeadersBruteForce(arr, n);

//         for (int i = 0; i < ans.size(); i++) {
//             System.out.print(ans.get(i) + " ");
//         }
//     }
// }

//- ---------------------------------------------------------------------------------------------------------------------

// import java.util.*;

// class Main {
//     // Finds and returns leaders in reverse order of appearance
//     public static ArrayList<Integer> printLeadersBruteForce(int[] arr, int n) {
//         ArrayList<Integer> ans = new ArrayList<>();
//         int max = arr[n - 1];
//         ans.add(arr[n - 1]);

//         for (int i = n - 2; i >= 0; i--) {
//             if (arr[i] > max) {
//                 ans.add(arr[i]);
//                 max = arr[i];
//             }
//         }

//         return ans;
//     }

//     public static void main(String[] args) {
//         int n = 6;
//         int[] arr = {1, 2, 12, 13, 0, 6};
        
//         ArrayList<Integer> ans = printLeadersBruteForce(arr, n);
//         Collections.sort(ans, Collections.reverseOrder());

//         for (int i = 0; i < ans.size(); i++) {
//             System.out.print(ans.get(i) + " ");
//         }
//     }
// }


// -----------------------------------------------------------------------------------------------------------------------


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        System.out.println("Enter size of the array");
        int n = s.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter elements of the array");
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        
        findLeaders(arr, n);
    }

    // Prints leaders from right to left as they are encountered
    static void findLeaders(int[] arr, int size) {
        int rightMaximum = arr[arr.length - 1];
        System.out.print(rightMaximum + " ");

        for (int i = size - 2; i >= 0; i--) {
            if (arr[i] > rightMaximum) {
                rightMaximum = arr[i];
                System.out.print(rightMaximum + " ");
            }
        }
    }
}

