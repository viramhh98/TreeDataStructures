package Treesdata;

import java.util.ArrayList;
import java.util.Scanner;

class completeBinaryTrees {
    static ArrayList<Integer> completeTree;

    public static void main(String[] args) {
        completeTree = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the number of nodes you want to enter : ");
        int NodeCount = sc.nextInt();
        System.out.println();
        for (int i = 0; i < NodeCount; i++) {
            System.out.print("enter the node value : ");
            int val = sc.nextInt();
            Insert(val);
            System.out.println();
        }

        printTree(0, 0, completeTree.size());

    }

    static void Insert(int data) {
        completeTree.add(data);
    }

    static void printTree(int i, int indent, int size) {
        if (i >= size) {
            return;
        }

        // Print right subtree (top) with additional spaces
        printTree(i * 2 + 2, indent + 4, size);

        // Print current node with indentation
        for (int j = 0; j < indent; j++) {
            System.out.print(" ");
        }
        System.out.println(completeTree.get(i));

        // Print left subtree (bottom) with additional spaces
        printTree(2 * i + 1, indent + 4, size);
    }
}