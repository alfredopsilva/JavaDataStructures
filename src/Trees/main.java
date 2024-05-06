package Trees;

public class main {

    public static void main(String[] args) {
        BinarySearchTree myBTS = new BinarySearchTree();
        myBTS.insert(47);
        myBTS.insert(21);
        myBTS.insert(76);
        myBTS.insert(18);
        myBTS.insert(52);
        myBTS.insert(82);
        myBTS.insert(27);
        System.out.println("ROOT = " + myBTS.root.left.right.value);
    }
}
