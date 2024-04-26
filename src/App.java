import DoublyLinkedList.DoublyLinkedList;
import LinkedList.LinkedList;

public class App {
    public static void main(String[] args) throws Exception {
        DoublyLinkedList myDLL = new DoublyLinkedList(1);
        myDLL.append(2);
        myDLL.append(3);
        myDLL.append(2);
        myDLL.append(1);

        System.out.println("DLL before swap:");
        myDLL.printList();

        System.out.println("Checking if it is a palyndrome: " + myDLL.isPalindrome());
        System.out.println("Checking if it is a palyndrome: " + myDLL.isPalindrome2());

    }
}