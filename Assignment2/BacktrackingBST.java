package Assignment2;

import java.util.NoSuchElementException;

public class BacktrackingBST implements Backtrack, ADTSet<BacktrackingBST.Node> {
    private Stack stack;
    private Stack redoStack;
    private BacktrackingBST.Node root = null;

    // Do not change the constructor's signature
    public BacktrackingBST(Stack stack, Stack redoStack) {
        this.stack = stack;
        this.redoStack = redoStack;
    }

    public Node getRoot() {
    	if (root == null) {
    		throw new NoSuchElementException("empty tree has no root");
    	}
        return root;
    }
	
    public Node search(int k) {
        if (root == null)
            return null;
        return root.search(k);
    }

    public void insert(Node node) {
        // TODO: implement your code here
    }

    public void delete(Node node) {
        // TODO: implement your code here
    }

    public Node minimum() {
        // TODO: implement your code here
    	return null; // temporal return command to prevent compilation error
    }

    public Node maximum() {
        // TODO: implement your code here
    	return null; // temporal return command to prevent compilation error
    }

    public Node successor(Node node) {
        if (node == null)
            throw new RuntimeException("empty node");
    	return node.successor();
    }

    public Node predecessor(Node node) {
        // TODO: implement your code here
    	return null; // temporal return command to prevent compilation error
    }

    @Override
    public void backtrack() {
        // TODO: implement your code here
    }

    @Override
    public void retrack() {
        // TODO: implement your code here
    }

    public void printPreOrder(){
        // TODO: implement your code here
    }

    @Override
    public void print() {
    	printPreOrder();
    }

    public static class Node {
    	// These fields are public for grading purposes. By coding conventions and best practice they should be private.
        public BacktrackingBST.Node left;
        public BacktrackingBST.Node right;
        
        private BacktrackingBST.Node parent;
        private int key;
        private Object value;

        public Node(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public Node search(int k){
            if (getKey() == k)
                return this;
            if (getKey() > k)
                return left.search(k);
            if (getKey() < k)
                return right.search(k);
            return null;
        }

        public Node successor(){
            if (right != null)
                return right.minimum();
            Node child = this;
            Node p = parent;
            while (p != null && child == p.right){
                child = p;
                p = p.parent;
            }

            return p;
        }

        public int getKey() {
            return key;
        }

        public Object getValue() {
            return value;
        }
        
    }

}
