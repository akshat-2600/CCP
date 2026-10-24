class LinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;

    // Helper method to add elements for demonstration
    public void insertAtBack(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // 1. Delete from the Front (Head)
    public void deleteFromFront() {
        if (head == null) {
            System.out.println("List is empty! Nothing to delete.");
            return;
        }
        // Move the head pointer to the next node
        head = head.next;
    }

    // 2. Delete from the Back (Tail)
    public void deleteFromBack() {
        if (head == null) {
            System.out.println("List is empty! Nothing to delete.");
            return;
        }

        // If there is only one node in the list
        if (head.next == null) {
            head = null;
            return;
        }

        // Traverse to the second-to-last node
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }

        // Disconnect the last node
        temp.next = null;
    }

    // 3. Delete from a Specific Position (0-indexed)
    public void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("List is empty! Nothing to delete.");
            return;
        }

        // If position is 0, it's a deletion from the front
        if (position == 0) {
            head = head.next;
            return;
        }

        Node temp = head;

        // Traverse to the node right before the one we want to delete
        for (int i = 0; i < position - 1; i++) {
            if (temp == null || temp.next == null) {
                System.out.println("Position out of bounds!");
                return;
            }
            temp = temp.next;
        }

        // Check if the node to be deleted exists
        if (temp.next == null) {
            System.out.println("Position out of bounds!");
            return;
        }

        // Skip the target node to unlink it
        temp.next = temp.next.next;
    }

    // Utility method to print the linked list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Setting up the initial list: 5 -> 10 -> 15 -> 20 -> 25 -> null
        list.insertAtBack(5);
        list.insertAtBack(10);
        list.insertAtBack(15);
        list.insertAtBack(20);
        list.insertAtBack(25);
        
        System.out.print("Initial list: ");
        list.printList(); 

        System.out.print("\nAfter deleting from front: ");
        list.deleteFromFront();
        list.printList(); // Output: 10 -> 15 -> 20 -> 25 -> null

        System.out.print("\nAfter deleting from back: ");
        list.deleteFromBack();
        list.printList(); // Output: 10 -> 15 -> 20 -> null

        System.out.print("\nAfter deleting node at position 1 (the number 15): ");
        list.deleteAtPosition(1);
        list.printList(); // Output: 10 -> 20 -> null
    }
}
