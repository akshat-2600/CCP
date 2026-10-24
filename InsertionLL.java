class LinkedList {
    // Node class representing each element in the list
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;

    // 1. Insert at the Front (Head)
    public void insertAtFront(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // 2. Insert at the Back (Tail)
    public void insertAtBack(int data) {
        Node newNode = new Node(data);

        // If the list is empty, make the new node the head
        if (head == null) {
            head = newNode;
            return;
        }

        // Traverse to the last node
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        // Link the last node to the new node
        temp.next = newNode;
    }

    // 3. Insert at a Specific Position (0-indexed)
    public void insertAtPosition(int data, int position) {
        // If position is 0, it's an insertion at the front
        if (position == 0) {
            insertAtFront(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;

        // Traverse to the node right before the desired position
        for (int i = 0; i < position - 1; i++) {
            if (temp == null) {
                System.out.println("Position out of bounds!");
                return;
            }
            temp = temp.next;
        }

        // If the position is valid, link the new node
        if (temp == null) {
            System.out.println("Position out of bounds!");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
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

        System.out.println("Inserting 10 and 20 at back:");
        list.insertAtBack(10);
        list.insertAtBack(20);
        list.printList(); // Output: 10 -> 20 -> null

        System.out.println("\nInserting 5 at front:");
        list.insertAtFront(5);
        list.printList(); // Output: 5 -> 10 -> 20 -> null

        System.out.println("\nInserting 15 at position 2:");
        list.insertAtPosition(15, 2);
        list.printList(); // Output: 5 -> 10 -> 15 -> 20 -> null
    }
}
