public class ArrayQueue {
    private final int capacity = 10;
    private final Record[] data = new Record[capacity];
    private int f = 0;
    private int size = 0;

    public static class Record {
        String id_num;
        String firstName;
        String lastName;
        char middleInitial;
        int age;
        String course;
        int height;
        double weight;

        public Record(String id_num, String firstName, String lastName, char middleInitial, int age, String course, int height, double weight) {
            this.id_num = id_num;
            this.firstName = firstName;
            this.lastName = lastName;
            this.middleInitial = middleInitial;
            this.age = age;
            this.course = course;
            this.height = height;
            this.weight = weight;
        }

        public String toString() {
            return (this.id_num + " " + this.firstName + " " + this.lastName + " " + String.valueOf(this.middleInitial) + " " + String.valueOf(this.age) + " " + this.course + " " + String.valueOf(this.height) + " " + String.valueOf(this.weight));
        }


    }

    public void enqueue(Record value) {
        if (size!=capacity) {
            int index = (f + size) % capacity;
            data[index] = value;
            size++;
        }
        else {
            dequeue();
            enqueue(value);
        }
    }

    public Record dequeue() {
        Record first_element = data[f];
        data[f] = null;
        size--;
        f = (f + 1) % capacity;
        return first_element;
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue();
        queue.enqueue(new Record("2020-0001", "Earl Ryan", "Aleluya", 'M', 22, "BSEC", 180, 60.25));
        Record record = queue.dequeue();
        System.out.println(record);
    }

}
