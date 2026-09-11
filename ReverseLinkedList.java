// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
        this.val = 0;
        this.next = null;
    }

    ListNode(int x) {
        this.val = x;
        this.next = null;
    }

    ListNode(int x, ListNode next) {
        this.val = x;
        this.next = next;
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;  // Store next node
            curr.next = prev;  // Reverse current node's pointer

            prev = curr;       // Move pointers one position forward
            curr = next;
        }
        return prev;
    }
}

public class Main {
    // Helper method to print a linked list cleanly
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Constructing a linked list: 1 -> 2 -> 3 -> 4 -> 5 -> null
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Original List: ");
        printList(head);

        Solution solution = new Solution();
        ListNode reversedHead = solution.reverseList(head);

        System.out.print("Reversed List: ");
        printList(reversedHead);
    }
}

// ----------------------------------------------------------------------------------------------------


// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
        this.val = 0;
        this.next = null;
    }

    ListNode(int x) {
        this.val = x;
        this.next = null;
    }

    ListNode(int x, ListNode next) {
        this.val = x;
        this.next = next;
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        // Base Cases: If list is empty or has only one node, it's already reversed
        if (head == null || head.next == null) {
            return head;
        }

        // Recursively reverse the rest of the list
        ListNode newHead = reverseList(head.next);

        // Make the next node point back to the current node
        head.next.next = head;
        
        // Break the original forward link to avoid cycles
        head.next = null;

        // Return the new head of the fully reversed list
        return newHead;
    }
}

public class Main {
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Constructing a linked list: 1 -> 2 -> 3 -> 4 -> 5 -> null
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Original List: ");
        printList(head);

        Solution solution = new Solution();
        ListNode reversedHead = solution.reverseList(head);

        System.out.print("Reversed List: ");
        printList(reversedHead);
    }
}
