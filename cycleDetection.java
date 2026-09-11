// T.C : O(N)
// S.C : O(1)


// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        this.val = x;
        this.next = null;
    }
}

class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Traverse the list with two pointers moving at different speeds
        while (fast != null && fast.next != null) {
            slow = slow.next;          // Moves 1 step
            fast = fast.next.next;     // Moves 2 steps

            // If the fast pointer meets the slow pointer, a cycle exists
            if (slow == fast) {
                return true;
            }
        }
        
        // Fast pointer reached the end of the list, so there is no cycle
        return false;
    }
}

// ------------------------------------------------------------------------------------------------


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        this.val = x;
        this.next = null;
    }
}

class Solution {
    public void removeCycle(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;
        boolean cycleDetected = false;

        // Step 1: Detect if a cycle exists
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                cycleDetected = true;
                break;
            }
        }

        // Step 2: If a cycle is present, find the start and break it
        if (cycleDetected) {
            // Move slow back to the head of the list
            slow = head;

            // Special Case: The cycle starts exactly at the head node
            if (slow == fast) {
                // Find the last node of the cycle
                while (fast.next != slow) {
                    fast = fast.next;
                }
                fast.next = null; // Break the cycle
                return;
            }

            // General Case: Move both pointers at equal speed until they meet
            // They will meet precisely at the entry node of the cycle
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }

            // fast.next is the starting node of the cycle, fast is the last node
            fast.next = null; // Break the loop link
        }
    }
}

public class Main {
    public static void printList(ListNode head, int limit) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count < limit) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
            count++;
        }
        if (curr == null) {
            System.out.println("null");
        } else {
            System.out.println("... (Cycle detected, printing stopped)");
        }
    }

    public static void main(String[] args) {
        // Constructing a linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        // Creating a cycle: 5 points back to 3 (Cycle starts at 3)
        node5.next = node3;

        System.out.print("Before removal: ");
        printList(head, 10); // Will show cycle warning

        Solution solution = new Solution();
        solution.removeCycle(head);

        System.out.print("After removal: ");
        printList(head, 10); // Will cleanly print 1 -> 2 -> 3 -> 4 -> 5 -> null
    }
}
