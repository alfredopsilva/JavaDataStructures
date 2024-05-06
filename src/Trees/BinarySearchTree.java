package Trees;

// Trees are build like a Doubly-LinkedList.
// Instead of have next and previous, we will have left and right. To be considered as Binary Tree, each node must point at maximum for 2 nodes. 
// To be characterized as perfect, each node must point to another other 2 nodes in that level. If neither point to nodes, can be considered as perfect as well.
// Each node can have only one parent. 
// A node that doesn't have a child, is called leaf.

// To be a binary search tree, numbers greater than parent value, should be placed at right and smaller at left. 

// BST Big O => O(log n) => For Lookup, Insert and Remove.

public class BinarySearchTree {

    Node root;

    public class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);

        // In case this BTS is empty.
        if (root == null) {
            root = newNode;
            return true;
        }

        Node temp = root;
        while (true) {
            if (newNode.value == temp.value)
                return false;
            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contains(int value) {
        if (root == null)
            return false;
        Node temp = root;
        while (temp != null) {
            if (value < temp.value) {
                temp = temp.left;

            } else if (value > temp.value) {
                temp = temp.right;
            } else {
                return true;
            }
        }
        return false;
    }
}
