public class SinglyLinkedList {
    private ListNode head;
    
    public static class ListNode {
        private int data;
        private ListNode next;
        
        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
        
    }
    
    public void createALoopInLinkedList() {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);
        
        head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = third;
    }
    
    public void removeLoop() {
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            
            if(fast == slow) {
                ListNode temp = head;
                while(temp.next != slow.next) {
                    temp = temp.next;
                    slow = slow.next;
                }
                slow.next = null;
                return;
            }
        }
    }
    
    public void display() {
        ListNode current = head;
        while(current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }
    
    public static void main(String[] a) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.createALoopInLinkedList();
        sll.removeLoop();
        sll.display();
    }
}
