import java.util.Scanner;

public class ArrayQueue {
    private final int capacity = 5;
    private final Object[] data = new Object[capacity];
    private int first = 0;
    private int size = 0;
    
    public void enqueue(Object value) {
        if(size + 1 <= capacity) {
            int index = (first + size) % capacity;
            data[index] = value;
            size++;
        } else {
            throw new IllegalStateException("Queue is full");
        }
    }
    
    public Object dequeue() {
        if(isEmpty()) 
            return null;
        Object first_element = data[first];
        data[first] = null;
        size--;
        first = (first + 1) % capacity;
        return first_element;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public Object first() {
        if(isEmpty())
            return null;
        else
            return data[first];
    }
    
    public int size() {
        return size;
    }
    
    public int length() {
        return size;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        ArrayQueue queue = new ArrayQueue();
        for(String value: input) {
            queue.enqueue(Integer.parseInt(value));
        }
        System.out.println(queue.dequeue() + " " + queue.first() + " " + queue.size());
    }
}
