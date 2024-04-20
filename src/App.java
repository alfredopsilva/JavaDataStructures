import DoublyLinkedList.DoublyLinkedList;
import LinkedList.LinkedList;

public class App {
    public static void main(String[] args) throws Exception {
        DoublyLinkedList myDLL = new DoublyLinkedList(2);
        myDLL.append(1);

        // (2) Items - Returns 2 Node
        System.out.println(myDLL.removeFirst().value);
        // (1) Item - Returns 1 Node
        System.out.println(myDLL.removeFirst().value);
        // (0) Items - Returns null
        System.out.println(myDLL.removeFirst());
    }
}