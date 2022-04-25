

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
        else
            throw new RuntimeException("the index isn't in the array");
    }

    @Override
    public Integer minimum() {
        if (count==0)
            throw new RuntimeException("empty array");
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
        if (count==0)
            throw new RuntimeException("empty array");
        int maxIndex=0;
        int max=arr[0];
        int i=1;
        while(i<count){
            if(max<arr[i]){
                max=arr[i];
                maxIndex=i;
            }
            i++;
        }
        return maxIndex;
    }

    @Override
    public Integer successor(Integer index) {
        if(count==0)
            throw new RuntimeException("empty array");
        int number=arr[index];
        int successor=maximum();
        if(successor==number)
            throw new RuntimeException("no successor");
        for(int i=0;i<count;i++){
            if(number<arr[i] && arr[i]<successor)
                successor=arr[i];
        }
        return successor;
    }

    @Override
    public Integer predecessor(Integer index) {
        if(count==0)
            throw new RuntimeException("empty array");
        int number=arr[index];
        int predecessor=minimum();
        if(predecessor==number)
            throw new RuntimeException("no predecessor");
        for(int i=0;i<count;i++){
            if(predecessor<arr[i] && arr[i]<number)
                predecessor=arr[i];
        }
        return predecessor;
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
