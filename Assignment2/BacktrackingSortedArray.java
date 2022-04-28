package Assignment2;

public class BacktrackingSortedArray implements Array<Integer>, Backtrack {
    private Stack stack;
    public int[] arr; // This field is public for grading purposes. By coding conventions and best practice it should be private.
    public int count;

    // Do not change the constructor's signature
    public BacktrackingSortedArray(Stack stack, int size) {
        this.stack = stack;
        arr = new int[size];
        count=0;
    }
    
    @Override
    public Integer get(int index){
        if(0<=index && index<count)
            return arr[index];
        else
            throw new RuntimeException("index out of bound");
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
        if(arr.length==count)
            throw new RuntimeException("array full");
        int index=sortedIndex(x);
        int[] re={1,index};
        stack.push(re);
        shiftRight(index);
        arr[index]=x;
    }

    @Override
    public void delete(Integer index) {
        if(0<=index && index<count){
            int[] re={0,index,arr[index]};
            stack.push(re);
            shiftLeft(index);
        }
        else
            throw new RuntimeException("the index isn't in the array");
    }

    private void shiftLeft(Integer index){
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

    private void shiftRight(Integer index){
        if(0<=index && index<=count){
            int j=count;
            while(index<j) {
                arr[j]=arr[j-1];
                j--;
            }
            count++;
        }
        else
            throw new RuntimeException("the index isn't in the array");
    }

    private int sortedIndex(Integer value) {
        int low = 0,
                high = count;
        while (low < high) {
            int mid = low+(high-low)/2;
            if (arr[mid] < value)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    @Override
    public Integer minimum() {
        if (count==0)
            throw new RuntimeException("empty array");
        return 0;
    }

    @Override
    public Integer maximum() {
        if (count==0)
            throw new RuntimeException("empty array");
        return count-1;
    }

    @Override
    public Integer successor(Integer index) {
        if(index<0 || count<=index+1)
            throw new RuntimeException("no successor");
        return index+1;
    }

    @Override
    public Integer predecessor(Integer index) {
        if(index-1<0 || count<=index)
            throw new RuntimeException("no predecessor");
        return index-1;
    }

    @Override
    public void backtrack() {
        if(!stack.isEmpty()){
            int[] re= (int[])stack.pop(); //stack-> re={delete=0/insert=1 , index , value}
            if(re[0]==0){ //ctrl+Z->delete
                shiftRight(re[1]);
                arr[re[1]]=re[2];
            }
            else{ //ctrl+Z->insert
                shiftLeft(re[1]);
            }
        }
    }

    @Override
    public void retrack() {
		/////////////////////////////////////
		// Do not implement anything here! //
		/////////////////////////////////////
    }

    @Override
    public void print() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        String str="";
        for(int i=0;i<count;i++){
            if(str=="")
                str=str+arr[i];
            else
                str=str+" "+arr[i];
        }
        return str;
    }
}
