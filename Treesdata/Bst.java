package Treesdata;

import java.util.Scanner;
//code also present 
//delete min 
//delete max
//inorder
//preorder
//postorder
class Bst {
    public static void main(String[] args) {
        treeObj bst = new treeObj();

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
        bst.printLevel();
        bst.visualizeTree(bst.head, 0);
    }
}

class treeObj {
    Node head;

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

    void postorder(Node n) {
        if (n == null) {
            return;
        }
        postorder(n.leftChild);
        postorder(n.rightChild);
        System.out.print(n.data + " ");
    }

    void preorder(Node n) {
        if (n == null) {
            return;
        }
        System.out.print(n.data + " ");
        preorder(n.leftChild);
        preorder(n.rightChild);
    }

    void inorder(Node n) {
        if (n == null) {
            return;
        }
        inorder(n.leftChild);
        System.out.print(n.data + " ");
        inorder(n.rightChild);
    }

    void deleteMin() {
        Node traverse = head;
        if (traverse == null) {
            System.out.println("empty tree");
            return;
        }
        Node beforeNull = null;
        while (traverse != null) {
            beforeNull = traverse;
            traverse = traverse.leftChild;
        }
        System.out.println("deleted value : " + beforeNull.data);
        if (beforeNull == head) {
            Node head1 = head;
            head = head.rightChild;
            head1.rightChild = null;
            head1.leftChild = null;
            head1 = null;
            return;
        }
        if (beforeNull.rightChild == null) {
            beforeNull.parent.leftChild = null;
            beforeNull = null;
        } else {
            traverse = beforeNull;
            beforeNull.parent.leftChild = beforeNull.rightChild;
            beforeNull.rightChild.parent = beforeNull.parent;
            beforeNull = null;
        }

    }

    void deleteMax() {
        Node traverse = head;
        if (traverse == null) {
            System.out.println("empty tree");
            return;
        }
        Node beforeNull = null;
        while (traverse != null) {
            beforeNull = traverse;
            traverse = traverse.rightChild;
        }
        System.out.println("deleted value : " + beforeNull.data);
        if (beforeNull == head) {
            Node head1 = head;
            head = head.leftChild;
            head1.rightChild = null;
            head1.leftChild = null;
            head1 = null;
            return;
        }

        if (beforeNull.leftChild == null) {
            beforeNull.parent.rightChild = null;
            beforeNull = null;
        } else {
            traverse = beforeNull;
            beforeNull.parent.rightChild = beforeNull.leftChild;
            beforeNull.leftChild.parent = beforeNull.parent;
            beforeNull = null;

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
