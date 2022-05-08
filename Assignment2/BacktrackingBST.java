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
        insert(node,false);
    }

    private void insert(Node node, boolean retrack){
        if(node==null)
            throw new RuntimeException("node null");
        if(root==null)
            root=node;
        else
            root.insert(node);
        stack.push(node);
        stack.push(1);
        if(!retrack)
            redoStack.clear();
    }

    public void delete(Node node) {
        delete(node,false);
    }

    private void delete(Node node, boolean retrack) {
        if(node==null)
            throw new RuntimeException("node null");
        if(node==root)
            root=root.delete(stack);
        else
            node.delete(stack);
        if(!retrack)
            redoStack.clear();
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
        if (node == null)
            throw new RuntimeException("empty node");
    	return node.successor();
    }

    public Node predecessor(Node node) {
        if(node==null)
            throw new RuntimeException("empty node");
        return node.predecessor();
    }

    //Backtrack stack=> {del=0/ins=1/del2sons=2, Node toInsertBack/toDelete, if(del)=> Node parent}
    @Override
    public void backtrack() {
        if(!stack.isEmpty()){
            int delIns=(int)stack.pop();
            Node node=(Node) stack.pop();
            if(delIns==0){ //Backtrack delete=> insert node to the past position
                Node parent=(Node) stack.pop();
                if(root==null) //Backtrack single node delete
                    root=node;
                else{
                    if(parent==null){ //root
                        node.backtrackDeleteRoot(root);
                        root=node;
                    }
                    else
                        node.backtrackDelete(parent);
                }
                redoStack.push(node);
                redoStack.push(0);
            }
            else if(delIns==2){ //Backtrack delete with 2 children=> insert node to the past position and continue backtracking successor.
                Node parent=(Node) stack.pop();
                if(parent==null){
                    node.backtrackDelete2Root(root);
                    root=node;
                }
                else{
                    node.backtrackDelete2(parent);
                }
                stack.pop();
                Node node2=(Node)stack.pop();
                Node father2=(Node)stack.pop();
                node2.backtrackDelete(father2);
                redoStack.push(node);
                redoStack.push(0);
            }
            else{  //Backtrack insert=> delete the node
                if(root==node)
                    root=null;
                else
                    node.backtrackInsert();
                redoStack.push(node);
                redoStack.push(1);
            }
        }
    }

    //Retrack stack=> {del=0/ins=1, Node toDeleteAgain/toInsertAgain}
    @Override
    public void retrack() {
        if(!redoStack.isEmpty()){
            int delIns=(int)redoStack.pop();
            Node node=(Node) redoStack.pop();
            if(delIns==0){ //retrack delete=> delete again this node
                delete(node,true);
            }
            else{ //retrack insert=> insert again this node
                insert(node,true);
            }
        }
    }

    public void printPreOrder(){
        if(root!=null)
            System.out.println(root.preOrder());
    }

    @Override
    public void print() {
    	printPreOrder();
    }

//-------------------------------------------------**************************
    public String toString() {
        if (root!=null) {
            System.out.println("***************************");
            return root.toString2();
        }
        else
            return "Empty Tree";
    }
//	----------------------------------------------**************************


    public static class Node {
    	// These fields are public for grading purposes. By coding conventions and best practice they should be private.
        public BacktrackingBST.Node left;
        public BacktrackingBST.Node right;
        
        public BacktrackingBST.Node parent;
        private int key;
        private Object value;

        public Node(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public Node search(int k){
            if (getKey() == k)
                return this;
            if (left!=null && getKey() > k)
                return left.search(k);
            if (right!=null && getKey() < k)
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
            if(p==null)
                throw new RuntimeException("no successor");
            return p;
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
                while(p!=null && p.left==child){
                    child=p;
                    p=p.parent;
                }
                if(p==null)
                    throw new RuntimeException("no successor");
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
                if(right==null){
                    right=node;
                    node.parent = this;
                }
                else
                    right.insert(node);
            }
            else{
                if(left==null) {
                    left = node;
                    node.parent = this;
                }
                else
                    left.insert(node);
            }
        }

        public Node delete(Stack stack){
            int toPush=0;
            Node toReturn = null;
            if(left==null && right==null){ //no children
                if(parent!=null){
                    if(parent.left==this)
                        parent.left=null;
                    else
                        parent.right=null;
                }
            }
            else if(left==null){  //only right child
                right.parent=parent;
                if (parent != null) {
                    if (parent.left == this)
                        parent.left = right;
                    else
                        parent.right = right;
                }
                toReturn = right;
            }
            else if(right==null){  //only left child
                left.parent=parent;
                if (parent != null) {
                    if (parent.left == this)
                        parent.left = left;
                    else
                        parent.right = left;
                }
                toReturn = left;
            }
            else{ //2 children
                Node successor=right.minimum();
                successor.delete(stack);
                successor.left=left;
                successor.right=right;
                successor.parent=parent;
                if(right!=null)  //null if the successor was the right node
                    right.parent=successor;
                left.parent=successor;
                if (parent != null) {
                    if (parent.left == this)
                        parent.left = successor;
                    else
                        parent.right = successor;
                }
                toReturn = successor;
                toPush=2;
            }
            stack.push(parent);
            stack.push(this);
            stack.push(toPush);
            right=null;
            left=null;
            parent=null;
            return toReturn;
        }

        public void backtrackInsert(){
            if(parent.right==this)
                parent.right=null;
            else
                parent.left=null;
        }

        public void backtrackDelete(Node father){
            Node child;
            if(father.key>this.key){
                child=father.left;
                father.left=this;
            }
            else{
                child=father.right;
                father.right=this;
            }
            if(child!=null){
                child.parent=this;
                if(child.key>key){
                    right=child;
                }
                else{
                    left=child;
                }
            }
            parent=father;
        }

        public void backtrackDeleteRoot(Node root){
            if(root.key>key)
                right=root;
            else
                left=root;
            root.parent=this;
        }

        public void backtrackDelete2(Node father){
            Node child;
            if(father.key>this.key){
                child=father.left;
                father.left=this;
            }
            else{
                child=father.right;
                father.right=this;
            }
            left=child.left;
            right=child.right;
            parent=father;
            if(child.right!=null)
                child.right.parent=this;
            child.left.parent=this;
            child.left=null;
            child.right=null;
            child.parent=null;
        }

        public void backtrackDelete2Root(Node root){
            left=root.left;
            right=root.right;
            if(root.right!=null)
                root.right.parent=this;
            root.left.parent=this;
            root.left=null;
            root.right=null;
            root.parent=null;
        }

//----------------------------------------8888888888888888888
        public String toString() {
            return ""+this.getKey()+"";
        }
        public String toString2() {
            String d="";
            return toString2(d);
        }

        private String toString2(String d) {
            String s="";
            if(right!=null)
                s=s+right.toString2(d+"  ");
            s=s+d+getKey()+"\n";
            if(left!=null)
                s=s+left.toString2(d+"  ");
            return s;
        }
//--------------8888888888888888888888888888888888888888888888888


    }

}
