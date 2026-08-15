// Time Complexity : O(n*n)

// Space Complexity : O(1)

class MajorityElement {

    static void findMajority(int arr[], int n) {
        int maxCount = 0;
        int index = -1;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }

            if (count > maxCount) {
                maxCount = count;
                index = i;
            }
        }

        if (maxCount > n / 2) {
            System.out.println(arr[index]);
        } else {
            System.out.println("No Majority Element");
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 1, 2, 1, 3, 5, 1};
        findMajority(arr, arr.length);
    }
}


//-----------------------------------------------------------------------------------------


// Time Complexity :  O(n^n) in case of BST
//                    O(nlogn) in case of balanced BST

// Space Complexity : O(1)  

import java.io.*;

class Node {
    int key;
    int c = 0;
    Node left, right;
}

class BSTMajorityElement {
    static int ma = 0;

    // create a new BST node
    static Node newNode(int item) {
        Node temp = new Node();
        temp.key = item;
        temp.c = 1;
        temp.left = temp.right = null;
        return temp;
    }

    // insert a new node with given key in BST
    static Node insert(Node node, int key) {
        // if tree empty, return a new node
        if (node == null) {
            if (ma == 0) {
                ma = 1;
            }
            return newNode(key);
        }

        // Otherwise, recur down the tree
        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        } else {
            node.c++;
        }

        // Find the max count
        ma = Math.max(ma, node.c);

        // Return the (unchanged) node pointer
        return node;
    }

    // inorder traversal of BST
    static void inorder(Node root, int s) {
        if (root != null) {
            inorder(root.left, s);
            if (root.c > (s / 2)) {
                System.out.println(root.key);
            }
            inorder(root.right, s);
        }
    }

    public static void main(String[] args) {
        int a[] = { 1, 3, 3, 3, 2 };
        int size = a.length; // Fixed missing size declaration
        Node root = null;

        for (int i = 0; i < size; i++) {
            root = insert(root, a[i]);
        }

        if (ma > (size / 2)) {
            inorder(root, size);
        } else {
            System.out.println("-1"); // Fixed literal null printing issue
        }
    }
}


//    -----------------------------------------------------------------------------------------



// Time Complexity :  O(n)
// Space Complexity : O(1) 

import java.util.HashMap;
import java.util.Map;

class EthCode {

    // Function to find the majority element present in a given array
    public static int findMajorityElement(int[] A) {
        // create an empty `HashMap`
        Map<Integer, Integer> map = new HashMap<>();

        // store each element's frequency in a map
        for (int i : A) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // return the element if its count is more than `n/2`
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > A.length / 2) {
                return entry.getKey();
            }
        }

        // no majority element is present
        return -1;
    }

    public static void main(String[] args) {
        // assumption: valid input (majority element is present)
        int[] arr = { 1, 8, 7, 4, 1, 2, 2, 2, 2, 2, 2 };

        int result = findMajorityElement(arr);

        if (result != -1) {
            System.out.println(result);
        } else {
            System.out.println("No Majority Element");
        }
    }
}


// ---------------------------------------------------------------------------------------

// Time Complexity :  O(n)
// Space Complexity : O(1) 

// Boyre-Moore Solution: Two step process Algorithm


class EthCode {

    // Function to find the majority element present in a given array
    public static int findMajorityElement(int[] A) {
        int m = -1;
        int i = 0;

        // Phase 1: Find a candidate
        for (int j = 0; j < A.length; j++) {
            if (i == 0) {
                m = A[j];
                i = 1;
            } else if (m == A[j]) {
                i++;
            } else {
                i--;
            }
        }

        // Phase 2: Verify the candidate (The missing check!)
        int actualCount = 0;
        for (int j = 0; j < A.length; j++) {
            if (A[j] == m) {
                actualCount++;
            }
        }

        // Return candidate only if it strictly exceeds n/2 occurrences
        if (actualCount > A.length / 2) {
            return m;
        }

        // Return -1 to indicate no majority element exists
        return -1; 
    }

    public static void main(String[] args) {
        // Test Case 1: Has a valid majority element (Outputs: 2)
        int[] arr1 = { 1, 8, 7, 4, 1, 2, 2, 2, 2, 2, 2 };
        System.out.println("Result 1: " + findMajorityElement(arr1));

        // Test Case 2: No majority element exists (Outputs: -1 instead of 3)
        int[] arr2 = { 1, 2, 3 };
        System.out.println("Result 2: " + findMajorityElement(arr2));
    }
}

