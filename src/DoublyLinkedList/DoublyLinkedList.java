package DoublyLinkedList;

public class DoublyLinkedList {

    public class Node {
        public int value;
        Node prev;
        Node next;

        public Node(int value) {
            this.value = value;
            prev = null;
            next = null;
        }
    }

    private Node head;
    private Node tail;
    private int length;

    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void getHead() {
        System.out.println("Head " + head.value);
    }

    public void getTail() {
        System.out.println("Tail " + tail.value);
    }

    public void getLength() {
        System.out.println("Length " + length);
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {

            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast() {

        Node temp = tail;
        if (length == 0)
            return null;
        if (length == 1) {
            head = null;
            tail = null;
        } else {

            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }
        length--;
        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst() {
        Node temp = head;
        if (length == 0)
            return null;
        if (length == 1) {
            head = null;
            tail = null;
        } else {

            temp.next.prev = null;
            temp.next = null;
        }
        length--;
        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index >= length)
            return null;

        Node temp = null;

        if (index < length / 2) {
            temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i = length - 1; i > index; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length)
            return false;
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node before = get(index - 1);
        Node after = before.next;
        newNode.prev = before;
        newNode.next = after;
        before.next = newNode;
        after.prev = newNode;
        length++;
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length)
            return null;
        if (index == 0)
            return removeFirst();
        if (index == length - 1)
            return removeLast();
        Node temp = get(index);
        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;
        temp.next = null;
        temp.prev = null;
        length--;
        return temp;
    }

    public void swapFirstLast() {
        if (length < 2)
            return;

        int temp = head.value;
        head.value = tail.value;
        tail.value = temp;
    }

    public void reverse() {
        if (length == 0)
            return;

        Node currentNode = head;
        Node temporaryNode = null;

        while (currentNode != null) {
            temporaryNode = currentNode.prev;
            currentNode.prev = currentNode.next;
            currentNode.next = temporaryNode;
            currentNode = currentNode.prev;
        }
        temporaryNode = head;
        head = tail;
        tail = temporaryNode;
    }

    public boolean isPalindrome() {
        boolean isPalindrome = true;
        for (int i = 0; i < length; i++) {
            if (get(i).value != get((length - 1) - i).value) {
                isPalindrome = false;
            }
        }

        return isPalindrome;
    }

    public boolean isPalindrome2() {
        if (length <= 1)
            return true;

        Node forwardNode = head;
        Node backwardNode = tail;

        for (int i = 0; i < length / 2; i++) {
            if (forwardNode.value != backwardNode.value)
                return false;
            forwardNode = forwardNode.next;
            backwardNode = backwardNode.prev;
        }
        return true;
    }

    public void swapPairs() {
        Node dummyNode = new Node(0);
        dummyNode.next = head;
        Node previousNode = dummyNode;

        while (head != null && head.next != null) {
            Node firstNode = head;
            Node secondNode = head.next;

            previousNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            secondNode.prev = previousNode;
            firstNode.prev = secondNode;

            if (firstNode.next != null) {
                firstNode.next.prev = firstNode;
            }

            head = firstNode.next;
            previousNode = firstNode;
        }

        head = dummyNode.next;
        if (head != null)
            head.prev = null;
    }

}
