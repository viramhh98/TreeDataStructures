package Treesdata;
import java.util.Scanner;

//node class
class Node {
    int key;
    Node left;
    Node right;
    int height;

    Node(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
        this.height = 0;
    }
}

public class AVL {
    public static void main(String[] args) {
        Node root = null;
        Scanner sc=new Scanner(System.in);
        System.out.print("enter the number of nodes you want to enter : ");
        int NodeCount=sc.nextInt();
        System.out.println();
        for(int i=0; i<NodeCount; i++){
            System.out.print("enter the node value : ");
            int val=sc.nextInt();
            root=insert(root, val);
            System.out.println();
        }
        printTree(root, 0);
        
    }

    
    //method to get height of the node
    static int getHeight(Node n) {
        if (n == null)
            return 0;
        return n.height;
    }

    //method to create a new node
    static Node createNode(int key) {
        Node node = new Node(key);
        return node;
    }

    //method to get max of two number used to calculate height
    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    //method to get balance factor of a given node
    static int getBalanceFactor(Node n) {
        if (n == null) {
            return 0;
        }
        return getHeight(n.left) - getHeight(n.right);
    }


    //method for right rotation
    static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        x.height = max(getHeight(x.right), getHeight(x.left)) + 1;
        y.height = max(getHeight(y.right), getHeight(y.left)) + 1;

        return x;
    }

    //method for left rotation
    static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = max(getHeight(x.right), getHeight(x.left)) + 1;
        y.height = max(getHeight(y.right), getHeight(y.left)) + 1;

        return y;
    }


    //method to insert a node 
    static Node insert(Node node, int key) {
        if (node == null)
            return createNode(key);

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);

        node.height = 1 + max(getHeight(node.left), getHeight(node.right));
        int bf = getBalanceFactor(node);

        // Left Left Case
        if (bf > 1 && key < node.left.key) {
            return rightRotate(node);
        }
        // Right Right Case
        if (bf < -1 && key > node.right.key) {
            return leftRotate(node);
        }
        // Left Right Case
        if (bf > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // Right Left Case
        if (bf < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }


    //method to find preorder of a tree
    static void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }


    //method to print tree but it prints in horizontal way
    static void printTree(Node node, int indent) {
        if (node == null) {
            return;
        }

        // Print right subtree (top) with additional spaces
        printTree(node.right, indent + 4);

        // Print current node with indentation
        for (int i = 0; i < indent; i++) {
            System.out.print(" ");
        }
        System.out.println(node.key+" ");

        // Print left subtree (bottom) with additional spaces
        printTree(node.left, indent + 4);
    }

}
