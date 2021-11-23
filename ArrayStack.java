public class ArrayStack {
    private final int capacity = 5;
    private final SinglyLinkedList[] data = new SinglyLinkedList[capacity];
    private int t = -1;
    private int size = 0;

    public static class SinglyLinkedList {

        private ListNode head;

        public static class ListNode {
            private final Object data;
            private ListNode next;

            public ListNode(Object data) {
                this.data = data;
                this.next = null;
            }

            public Object getData() {
                return this.data;
            }

            public ListNode getNext() {
                return this.next;
            }

            public void setNext(ListNode next) {
                this.next = next;
            }

        }

        public String toString() {
            ListNode current = head;
            String temp = "";
            while(current != null) {
                if (temp.isEmpty()) {
                    temp = (String) current.getData();
                } else {
                    temp = temp + " " + current.getData();
                }
                current = current.getNext();
            }
            return temp;
        }

        public void insertLast(Object value) {
            ListNode newNode = new ListNode(value);
            if(this.head == null) {
                this.head = newNode;
            }
            else {
                ListNode current = head;
                while(current.getNext() != null) {
                    current = current.getNext();
                }
                current.setNext(newNode);
            }
        }

    }

    public void push(SinglyLinkedList value) {
        t = (t + 1) % capacity;
        data[t] = value;

        if (size != capacity) {
            size++;
        }
    }

    public SinglyLinkedList pop() {
        SinglyLinkedList value = data[t];
        data[t] = null;
        t--;
        return value;
    }


    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack();

        SinglyLinkedList sll1 = new SinglyLinkedList();
        sll1.insertLast("2020-0001");
        sll1.insertLast("Earl Ryan");
        sll1.insertLast("Aleluya");
        sll1.insertLast('M');
        sll1.insertLast(22);
        sll1.insertLast("BSEC");
        sll1.insertLast(180);
        sll1.insertLast(60.25);
        stack.push(sll1);

        SinglyLinkedList record = stack.pop();
        System.out.println(record);
    }
}
