import java.util.Scanner;

public class ArrayStack {
    private final int capacity = 5;
    private final Object[] data = new Object[capacity];
    private int t = -1;
    private int length = 0;
    
    public void push(Object value) {
        if(length + 1 <= capacity) {
            length++;
            t++;
            data[t] = value;
        } else {
            throw new IllegalStateException("Stack is full");
        }
    }
    
    public Object pop() {
        Object value = data[t];
        data[t] = null;
        t--;
        length--;
        return value;
    }
    
    public Object peek() {
        if(isEmpty())
            return null;
        else
            return data[t];
    }
    
    public boolean isEmpty() {
        return length == 0;
    }
    
    public int length() {
        return length;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        ArrayStack stack = new ArrayStack();
        for(String split: input) {
            int value = Integer.parseInt(split);
            stack.push(value);
        }
        System.out.println(stack.pop() + " " + stack.peek() + " " + stack.length());
    }
}
