package Treesdata;

import java.util.Scanner;

public class LeftSkewedTree {
    public static void main(String[] args) {
        treeObj2 bst = new treeObj2();
        // insert the values in binary search tree and then it will convert to left skewed tree

        Scanner sc = new Scanner(System.in);
        System.out.print("enter the number of nodes you want to enter : ");
        int NodeCount = sc.nextInt();
        System.out.println();
        for (int i = 0; i < NodeCount; i++) {
            System.out.print("enter the node value : ");
            int val = sc.nextInt();
            bst.addNode(val);
            System.out.println();
        }

        
        System.out.println("\t\tbinary search tree\n");
        bst.visualizeTree(bst.head, 0);
        bst.order(bst.head);
        System.out.println("\n\n\n");
        System.out.println("\t\tleft skewed tree\n");
        bst.printLevel();

        bst.visualizeTree(bst.headleftSkewedTree, 0);
    }
}

class treeObj2 {
    Node head;
    Node headleftSkewedTree;

    class Node {
        Node leftChild;
        Node rightChild;
        Node parent;
        int data;

        Node(int data) {
            leftChild = null;
            rightChild = null;
            this.data = data;
        }
    }

    void addNode(int data) {
        if (head == null) {
            Node n = new Node(data);
            head = n;
        } else {
            Node traverse = head;
            Node n = new Node(data);
            Node beforeNull = null;
            while (traverse != null) {
                beforeNull = traverse;
                if (traverse.data > data) {
                    traverse = traverse.leftChild;
                } else {
                    traverse = traverse.rightChild;
                }
            }
            if (beforeNull.data > data) {
                beforeNull.leftChild = n;
                n.parent = beforeNull;
            } else {
                beforeNull.rightChild = n;
                n.parent = beforeNull;
            }
        }

    }

    void order(Node node) {
        Node traverse = node;
        if (traverse == null) {
            return;
        }
        order(traverse.rightChild);
        InsertRightSkewedTree(traverse.data);
        order(traverse.leftChild);
    }

    void InsertRightSkewedTree(int data) {
        if (headleftSkewedTree == null) {
            Node n = new Node(data);
            headleftSkewedTree = n;
        } else {
            Node traverse = headleftSkewedTree;
            Node n = new Node(data);
            while (traverse.leftChild != null) {
                traverse = traverse.leftChild;
            }
            traverse.leftChild = n;
        }

    }

    void printLevel() {
        for (int i = 0; i < 10; i++) {
            System.out.print("0" + i + "  ");
        }
        System.out.println("   levels");
        System.out.println();
    }

    void visualizeTree(Node node, int level) {
        Node traverse = node;
        if (traverse == null) {
            return;
        }

        visualizeTree(traverse.rightChild, level + 1);

        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }
        if (traverse.data < 10) {
            System.out.println("0" + traverse.data);
        } else {
            System.out.println(traverse.data);
        }

        visualizeTree(traverse.leftChild, level + 1);
    }
}
