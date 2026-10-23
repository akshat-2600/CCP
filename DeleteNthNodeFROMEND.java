// Definition for a singly-linked list node
class ListNode {
    int val;
    ListNode next;
    
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node to seamlessly handle edge cases (like removing the head)
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        // 1. Move the fast pointer 'n' steps ahead
        for (int i = 0; i < n; i++) {
            if (fast == null) return head; // Out of bounds safety check
            fast = fast.next;
        }
        
        // 2. Move both pointers until fast reaches the last node
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        // 3. Delink the target node (slow.next is the node to delete)
        slow.next = slow.next.next;
        
        // Return the actual head of the modified list
        return dummy.next;
    }
}
