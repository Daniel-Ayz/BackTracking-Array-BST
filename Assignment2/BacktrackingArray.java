package Assignment2;

import java.util.Arrays;

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
        else
            throw new RuntimeException("index out of bound");
    }

    @Override
    public Integer search(int k) {
        for(int i=0;i<count;i++){
            if(arr[i]==k)
                return i;
        }
        return -1;
    }



    //stack-> re={delete=0/insert=1 , index , value}
    @Override
    public void insert(Integer x) {
        if(count==arr.length)
            throw new RuntimeException("the array is full");
        arr[count]=x;
        count++;
        int[] re={1};
        stack.push(re);
    }

    //stack-> re={delete=0/insert=1 , index , value}
    @Override
    public void delete(Integer index) {
        if(0<=index && index<count){
            int[] re={0,index,arr[index]};
            stack.push(re);
            arr[index]=arr[count-1];
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
        if(index<0 || count<=index)
            throw new RuntimeException("index out of bound");
        int number=arr[index];
        int successorIndex=maximum();
        int successor=arr[successorIndex];
        if(successor==number)
            throw new RuntimeException("no successor");
        for(int i=0;i<count;i++){
            if(number<arr[i] && arr[i]<successor){
                successor=arr[i];
                successorIndex=i;
            }
        }
        return successorIndex;
    }

    @Override
    public Integer predecessor(Integer index) {
        if(count==0)
            throw new RuntimeException("empty array");
        if(index<0 || count<=index)
            throw new RuntimeException("index out of bound");
        int number=arr[index];
        int predecessorIndex=minimum();
        int predecessor=arr[predecessorIndex];
        if(predecessor==number)
            throw new RuntimeException("no predecessor");
        for(int i=0;i<count;i++){
            if(predecessor<arr[i] && arr[i]<number) {
                predecessor=arr[i];
                predecessorIndex = i;
            }
        }
        return predecessorIndex;
    }

    //stack-> re={delete=0/insert=1 , index , value}
    @Override
    public void backtrack() {
        if(!stack.isEmpty()){
            int[] re= (int[])stack.pop(); //stack-> re={delete=0/insert=1 , index , value}
            if(re[0]==0){ //ctrl+Z->delete
                arr[count]=arr[re[1]];
                arr[re[1]]=re[2];
                count++;
            }
            else{ //ctrl+Z->insert
                count--;
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
