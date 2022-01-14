public class SinglyLinkedListReverse {
    private ListNode head;
    
    public static class ListNode {
        private int data;
        private ListNode next;
        
        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    public void display(ListNode node) {
        ListNode current = node;
        while(current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }
    
    public void insertLast(int value) {
        ListNode newNode = new ListNode(value);
        if(head == null) {
            head = newNode;
            return;
        }
        ListNode current = head;
        while(null != current.next) {
            current = current.next;
        }
        current.next = newNode;
    }
    
    public ListNode reverse(ListNode ln) {
        if(ln == null) {
            return null;
        }
        ListNode current = ln;
        ListNode previous = null;
        ListNode next = null;
        
        while(current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
    
    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.head = new ListNode(20);
        sll.insertLast(8);
        sll.insertLast(11);
        sll.insertLast(1);
        ListNode reverseListHead = sll.reverse(sll.head);
        sll.display(reverseListHead);
    }
}
