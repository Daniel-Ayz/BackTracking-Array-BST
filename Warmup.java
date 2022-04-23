

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
            for(int j=0;j<back;j++){
                if(arr[index]==x)
                    return index;
                myStack.pop();
                index--;
            }
        }
        return -1;
    }

    public static int consistentBinSearch(int[] arr, int x, Stack myStack) {
        // TODO: implement your code here

    	// Your implementation should contain a this line:
    	int inconsistencies = Consistency.isConsistent(arr);

    	return -987; // temporal return command to prevent compilation error
    }
    
}
