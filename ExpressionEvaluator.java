import java.util.EmptyStackException;
import java.util.Scanner;

public class ExpressionEvaluator {
    
    public static class Stack {
        private ListNode top;
        private int length;
        
        private static class ListNode {
            private final int data;
            private ListNode next;
            
            public ListNode(int data) {
                this.data = data;
                this.next = null;
            }
        }
        
        public Stack() {
            top = null;
            length = 0;
        }
        
        public int length() {
            return length;
        }
        
        public boolean isEmpty() {
            return length == 0;
        }
        
        public void push(int data) {
            ListNode temp = new ListNode(data);
            temp.next = top;
            top = temp;
            length++;
        }
        
        public int pop() {
            if(isEmpty())
                throw new EmptyStackException();
            int result = top.data;
            top = top.next;
            length--;
            return result;
        }
    }
    
    public static boolean isInteger(String string) {
        switch(string) {
            case "+":
            case "-":
            case "/":
            case "*":
            case "^":
                return false;
            default:
                return true;
        }
    }
    
    public static int evaluate(String input) {
        Stack stack = new Stack();
        String[] array = input.split(" ");
        for(String value: array) {
            if(isInteger(value))
                stack.push(Integer.parseInt(value));
            else {
                int val1 = stack.pop();
                int val2 = stack.pop();
                switch(value) {
                    case "+":
                        stack.push(val2 + val1);
                        break;
                    case "-":
                        stack.push(val2 - val1);
                        break;
                    case "/":
                        stack.push(val2 / val1);
                        break;
                    case "*":
                        stack.push(val2 * val1);
                        break;
                    case "^":
                        stack.push((int) Math.pow(val2, val1));
                        break;
                }
            }
        }
        return stack.pop();
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String test = input.nextLine();
        System.out.println(evaluate(test));
    }
}
