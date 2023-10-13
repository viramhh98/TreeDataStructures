package Treesdata;

import java.util.ArrayList;

class MinHeap {
    static ArrayList<Integer> ans;
    static minHeapMethods m ;

    public static void main(String args[]){
        m = new minHeapMethods();
        ans = new ArrayList<>();
        insert(55);
        insert(62);
        insert(42);
        insert(35);
        insert(77);
        insert(85);
        insert(91);
        m.buildHeap(ans);
        m.printHeap(ans);
        m.printTree(0, 0, ans);
    }
    static void insert(int data){
        ans.add(data);
        m.buildHeap(ans);
    }
   
}

class minHeapMethods {

    public void buildHeap(ArrayList<Integer> ans) {
        int heapSize = ans.size();
        for (int i = (int) Math.floor(heapSize / 2); i >= 0; i--) {
            maxHeapify(ans, i );
        }
    }

    public void maxHeapify(ArrayList<Integer> ans, int element) {
        int left = element * 2+1;
        int right = (element * 2) + 2;
        int heapSize = ans.size();
        int smallest = 0;
        if (left < heapSize && ans.get(left) < ans.get(element)) {
            smallest = left;
        } else {
            smallest = element;
        }
        if (right < heapSize && ans.get(right) < ans.get(smallest)) {
            smallest = right;
        }
        if (smallest != element) {
            

            int temp = ans.get(element);
            ans.set(element, ans.get(smallest));
            ans.set(smallest, temp);
            maxHeapify(ans, smallest);
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