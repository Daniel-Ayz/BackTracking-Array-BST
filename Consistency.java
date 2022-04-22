public class Consistency {

	public static int[] incosistencies = {0,1,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
    public static int incosistenciesIndex = 0;
    
    public static int isConsistent(int[] arr) {
        return incosistencies[incosistenciesIndex++];
    }
	
//	// Don't remove this function, but you may change its implementation
//	public static int isConsistent(int[] arr) {
//        double res = Math.random() * 100 - 75;
//
//        if (res > 0) {
//            return (int)Math.round(res / 10);
//        } else {
//            return 0;
//        }
//    }
	
}
