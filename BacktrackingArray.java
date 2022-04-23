

public class BacktrackingArray implements Array<Integer>, Backtrack {
    private Stack stack;
    private int[] arr;
    private int count;

    // Do not change the constructor's signature
    public BacktrackingArray(Stack stack, int size) {
        this.stack = stack;
        arr = new int[size];
        count=0;
    }

    @Override
    public Integer get(int index){
        if(0<=index && index<count)
            return arr[index];
        return -1;
    }

    @Override
    public Integer search(int k) {
        return binarySearch(0,count,k);
    }

    private Integer binarySearch(int low,int high,int k){
        if(high>=low){
            int middle=low+(high-low)/2;
            if(arr[middle]==k)
                return middle;
            else if(arr[middle]>k)
                return binarySearch(low,middle-1,k);
            else return binarySearch(middle+1,high,k);
        }
        else return -1;
    }

    @Override
    public void insert(Integer x) {
        if(count==arr.length)
            throw new RuntimeException("the array is full");
        arr[count]=x;
        count++;
    }

    @Override
    public void delete(Integer index) {
        if(0<=index && index<count){
            int j=index;
            while(j<count-1) {
                arr[j]=arr[j+1];
                j++;
            }
            count--;
        }
    }

    @Override
    public Integer minimum() {
        if (count==0)
            return -1;
        int minIndex=0;
        int min=arr[0];
        int i=1;
        while(i<count){
            if(arr[i]<min){
                min=arr[i];
                minIndex=i;
            }
            i++;
        }
        return minIndex;
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
