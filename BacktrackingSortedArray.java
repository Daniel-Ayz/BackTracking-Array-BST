

public class BacktrackingSortedArray implements Array<Integer>, Backtrack {
    private Stack stack;
    public int[] arr; // This field is public for grading purposes. By coding conventions and best practice it should be private.
    // TODO: implement your code here

    // Do not change the constructor's signature
    public BacktrackingSortedArray(Stack stack, int size) {
        this.stack = stack;
        arr = new int[size];
    }
    
    @Override
    public Integer get(int index){
        // TODO: implement your code here
    	return null; // temporal return command to prevent compilation error
    }

    @Override
    public Integer search(int k) {
        // TODO: implement your code here
    	return null; // temporal return command to prevent compilation error
    }

    @Override
    public void insert(Integer x) {
        // TODO: implement your code here
    }

    @Override
    public void delete(Integer index) {
        // TODO: implement your code here
    }

    @Override
    public Integer minimum() {
        // TODO: implement your code here
    	return null; // temporal return command to prevent compilation error
    }

    @Override
    public Integer maximum() {
        // TODO: implement your code here
    	return null; // temporal return command to prevent compilation error
    }

    @Override
    public Integer successor(Integer index) {
        // TODO: implement your code here
    	return null; // temporal return command to prevent compilation error
    }

    @Override
    public Integer predecessor(Integer index) {
        // TODO: implement your code here
    	return null; // temporal return command to prevent compilation error
    }

    @Override
    public void backtrack() {
        // TODO: implement your code here
    }

    @Override
    public void retrack() {
		/////////////////////////////////////
		// Do not implement anything here! //
		/////////////////////////////////////
    }

    @Override
    public void print() {
        // TODO: implement your code here
    }
    
}
