
public class Question7_RotateLinkedList {
    // Define a simple singly-linked list node
    static class ListNode {
        String val;
        ListNode next;

        ListNode(String val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val;
        }
    }

    /**
     * Rotates the linked list to the right by n positions.
     * @param head The head of the linked list
     * @param n The number of positions to rotate
     * @return New head of the rotated list
     */
    public static ListNode rotateRight(ListNode head, int n) {
        if (head == null || head.next == null || n == 0) {
            return head; // No need to rotate
        }
        // Step 1: Compute the length of the list
        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Step 2: Normalize n in case it's >= length
        n = n % length;
        if (n == 0) return head; // No rotation needed

        // Step 3: Make the list circular
        tail.next = head;

        // Step 4: Find new tail (at length - n - 1) and new head
        ListNode newTail = head;
        for (int i = 0; i < length - n - 1; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null; // Break the circle

        return newHead;
    }

    // Helper method to print list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) System.out.print(" -> ");
            current = current.next;
        }
        System.out.println(" -> null");
    }

    // Test cases
    public static void runTests() {
        System.out.println("Test Case 1: Rotate by 2");
        ListNode head1 = buildList("ID_A01", "ID_A02", "ID_A03", "ID_A04", "ID_A05", "ID_A06");
        ListNode rotated1 = rotateRight(head1, 2);
        printList(rotated1);

        System.out.println("Test Case 2: Rotate by 0");
        ListNode head2 = buildList("A", "B", "C");
        ListNode rotated2 = rotateRight(head2, 0);
        printList(rotated2);

        System.out.println("Test Case 3: Rotate by length");
        ListNode head3 = buildList("A", "B", "C");
        ListNode rotated3 = rotateRight(head3, 3);
        printList(rotated3);

        System.out.println("Test Case 4: Rotate empty list");
        ListNode rotated4 = rotateRight(null, 1);
        printList(rotated4);

        System.out.println("Test Case 5: Single element list");
        ListNode head5 = buildList("X");
        ListNode rotated5 = rotateRight(head5, 3);
        printList(rotated5);
    }

    // Helper to build list from varargs
    public static ListNode buildList(String... vals) {
        if (vals.length == 0) return null;
        ListNode head = new ListNode(vals[0]);
        ListNode current = head;
        for (int i = 1; i < vals.length; i++) {
            current.next = new ListNode(vals[i]);
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        runTests();
    }

}
