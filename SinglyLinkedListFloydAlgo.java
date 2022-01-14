import java.util.Scanner;

public class SinglyLinkedListFloydAlgo {
    private ListNode head;

    public SinglyLinkedList(String input) {
        String[] array = input.split(" ");
        ListNode current = null;
        for(int i = 0; i < array.length; i++) {
            ListNode newNode = new ListNode(Integer.parseInt(array[i]));
            if(i == 0) {
                head = newNode;
            } else {
                current.next = newNode;
            }
            current = newNode;
        }
    }

    public static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void output() {
        ListNode current = head;
        while(current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    public void removeDupeUsingFloydAlgoVariation() {
        ListNode current = head;
        ListNode next;
        ListNode temp;

        if (head == null) {
            return;
        }

        while (current != null) {
            temp = current;
            next = current.next;

            while (next != null) {
                if (current.data == next.data) {
                    temp.next = next.next;
                } else {
                    temp = next;
                }
                next = next.next;
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SinglyLinkedList sll = new SinglyLinkedList(scanner.nextLine());
        sll.removeDupeUsingFloydAlgoVariation();
        sll.output();
    }
}
