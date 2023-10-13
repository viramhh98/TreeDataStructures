package Treesdata;

import java.util.ArrayList;

class MaxHeap {
    static ArrayList<Integer> ans;
    static ArrayList<Integer> deletedElements;
    static maxHeapM m;
    public static void main(String[] args) {
        m = new maxHeapM();
        ans = new ArrayList<>();
        deletedElements = new ArrayList<>();

        insert(34);
        insert(22);
        insert(42);
        insert(16);
        insert(19);
        insert(73);
        insert(77);
        m.printHeap(ans);
        m.printTree(0, 0, ans);
        deletionInHeap(ans);
        deletionInHeap(ans);
        System.out.println("all deleted  element "+deletedElements+"\n");


    }

    static void insert(int data) {
        ans.add(data);
        m.buildHeap(ans);
    }

    static void deletionInHeap(ArrayList<Integer> ans) {
        int temp = ans.get(0);
        int dummy = ans.get(ans.size() - 1);
        ans.set(0, dummy);
        ans.set(ans.size() - 1, temp);
        int deletedElement = ans.remove(ans.size() - 1);
        deletedElements.add(deletedElement);
        System.out.println("\t\t deleted max element "+deletedElement+"\n");
        m.buildHeap(ans);        
        m.printTree(0, 0, ans);

    }
}

class maxHeapM {

    public void buildHeap(ArrayList<Integer> ans) {
        int heapSize = ans.size();
        for (int i = (int) Math.floor(heapSize / 2); i >= 0; i--) {
            maxHeapify(ans, i);
        }
    }

    public void maxHeapify(ArrayList<Integer> ans, int element) {
        int left = element * 2 + 1;
        int right = (element * 2) + 2;
        int heapSize = ans.size();
        int largest = 0;
        if (left < heapSize && ans.get(left) > ans.get(element)) {
            largest = left;
        } else {
            largest = element;
        }
        if (right < heapSize && ans.get(right) > ans.get(largest)) {
            largest = right;
        }
        if (largest != element) {

            int temp = ans.get(element);
            ans.set(element, ans.get(largest));
            ans.set(largest, temp);
            maxHeapify(ans, largest);
        }
    }

    public void printHeap(ArrayList<Integer> ans) {
        System.out.println(ans);
    }

    public void printTree(int i, int indent, ArrayList<Integer> ans) {
        if (i >= ans.size()) {
            return;
        }

        // Print right subtree (top) with additional spaces
        printTree(i * 2 + 2, indent + 4, ans);

        // Print current node with indentation
        for (int j = 0; j < indent; j++) {
            System.out.print(" ");
        }

        System.out.println(ans.get(i));

        // Print left subtree (bottom) with additional spaces
        printTree(2 * i + 1, indent + 4, ans);
    }
}