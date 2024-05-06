package Queue;

public class Queue {

    public class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

    }

    private Node first;
    private Node last;
    private int length;

    public Queue(int value) {
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length = 1;
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        length++;
    }

    public Node dequeue() {
        if (length == 0)
            return null;
        Node temp = first;
        if (length == 1) {
            first = null;
            last = null;
        } else {

            first = temp.next;
            temp.next = null;
        }
        length--;
        return temp;
    }

}
