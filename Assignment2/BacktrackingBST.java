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
        // TODO: implement your code here
    	return null; // temporal return command to prevent compilation error
    }

    public void insert(Node node) {
        if(node==null)
            throw new RuntimeException("node null");
        if(root==null)
            root=node;
        else
            root.insert(node);
    }

    public void delete(Node node) {
        if(node==null)
            throw new RuntimeException("node null");
        if(node==root)
            root=null;
        else
            node.delete();
    }

    public Node minimum() {
        if(root==null)
            throw new RuntimeException("empty tree");
        else
            return root.minimum();
    }

    public Node maximum() {
        if(root==null)
            throw new RuntimeException("empty tree");
        else
            return root.maximum();
    }

    public Node successor(Node node) {
        // TODO: implement your code here
    	return null; // temporal return command to prevent compilation error
    }

    public Node predecessor(Node node) {
        if(node==null)
            throw new RuntimeException("empty node");
        return node.predecessor();
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
        if(root!=null)
            System.out.println(root.preOrder());
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

        public int getKey() {
            return key;
        }

        public Object getValue() {
            return value;
        }

        public Node minimum(){
            if(left==null)
                return this;
            else
                return left.minimum();
        }

        public Node maximum(){
            if(right==null)
                return this;
            else
                return right.maximum();
        }

        public Node predecessor(){
            if(left!=null)
                return left.maximum();
            else{
                Node child=this;
                Node p=parent;
                while(p!=null && p.left==this){
                    child=p;
                    p=p.parent;
                }
                return p;
            }
        }

        public String preOrder(){
            String str=((Integer)key).toString();
            if(left!=null)
                str+=" "+left.preOrder();
            if(right!=null)
                str+=" "+right.preOrder();
            return str;
        }

        public void insert(Node node){
            if(key<node.key){
                if(right==null)
                    right=node;
                else
                    right.insert(node);
            }
            else{
                if(left==null)
                    left=node;
                else
                    left.insert(node);
            }
        }

        public void delete(){
            if(left==null && right==null){ //no children
                if(parent.left==this)
                    parent.left=null;
                else
                    parent.right=null;
            }
            else if(left==null){  //only right child
                if(parent.left==this)
                    parent.left=right;
                else
                    parent.right=right;
            }
            else if(right==null){  //only left child
                if(parent.left==this)
                    parent.left=left;
                else
                    parent.right=left;
            }
            else{ //2 children
                Node successor=minimum();
                successor.delete();
                successor.left=left;
                successor.right=right;
                if(parent.left==this)
                    parent.left=successor;
                else
                    parent.right=successor;
            }
        }
        
    }

}
