import Stack.StackWithArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        // DoublyLinkedList myDLL = new DoublyLinkedList(1);
        // myDLL.append(2);
        // myDLL.append(3);
        // myDLL.append(2);
        // myDLL.append(1);

        // System.out.println("DLL before swap:");
        // myDLL.printList();

        // System.out.println("Checking if it is a palyndrome: " +
        // myDLL.isPalindrome());
        // System.out.println("Checking if it is a palyndrome: " +
        // myDLL.isPalindrome2());

        // Stack myStack = new Stack(10);
        // myStack.printStack();

        StackWithArrayList<Integer> myStack = new StackWithArrayList<>();
        myStack.push(3);
        myStack.push(1);
        myStack.push(4);
        myStack.push(2);
        // System.out.println(myStack.peek());
        // myStack.printStack();

        myStack.printStack();
    }
}