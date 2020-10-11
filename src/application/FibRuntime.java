package application;

public class FibRuntime {
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		long result = fibRecursive(3);
		long endTime = System.nanoTime();
		System.out.println("First trial got: " + result + " and " + (endTime - startTime) + " ms");
		
		long startTime2 = System.nanoTime();
		long result2 = fibNonrecursive(30);
		long endTime2 = System.nanoTime();
		System.out.println("Second trial got: " + result2 + " and " + (endTime2 - startTime2) + " ms");
	}
	
	public static long fibRecursive(long index) {
        if (index == 0) {
            return 0;
        } else if (index == 1) {
            return 1;
        } else {
            return fibRecursive(index - 1) + fibRecursive(index - 2);
        }
    }
	
	public static long fibNonrecursive(long index) {
		long var1 = 0, var2 = 1;
		long addedSum = 0;
		// Fibonacci series formation loop
		for (int i = 2; i <= index; ++i){
			addedSum = var1 + var2;
			var1 = var2;
			var2 = addedSum;
		}
		return addedSum;
	}
}
