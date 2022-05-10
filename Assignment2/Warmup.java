package Assignment2;

public class Warmup {
    public static int backtrackingSearch(int[] arr, int x, int forward, int back, Stack myStack) {
        int index=0;
        while(index<arr.length){
            for(int i=0;i<forward && index<arr.length;i++){
                if(arr[index]==x)
                    return index;
                myStack.push(arr[index]);
                index++;
            }
            for(int j=0;j<back && index<arr.length;j++){
                if(arr[index]==x)
                    return index;
                myStack.pop();
                index--;
            }
        }
        return -1;
    }

    public static int consistentBinSearch(int[] arr, int x, Stack myStack) {

        int low = 0, high = arr.length - 1;
        while (low <= high){
            int middle = low+(high-low)/2;

            myStack.push(low);
            myStack.push(middle);
            myStack.push(high);

            if(arr[middle] == x) {
                return middle;
            }
            else if (x < arr[middle])
                high = middle-1;
            else
                low = middle+1;

            int inconsistencies = Consistency.isConsistent(arr);
            int undoCount = 0;
            while (undoCount < inconsistencies){
                high = (int)myStack.pop();
                middle = (int)myStack.pop();
                low = (int)myStack.pop();
                undoCount++;
            }
        }
        return -1;
    }
    
}
