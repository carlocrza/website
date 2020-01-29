public class dis1 {
	public static void main(String[] args) {
		boolean[] x = new boolean[5]; // primitive type
		String[] y = new String[5]; // reference type
		System.out.println(x[0]);
		System.out.println(y[0]);

		System.out.println(fib1(6));
		System.out.println(fib(6));
		System.out.println(fib_iterative(6));
	}

	public static int fib1(int N) {
	    if (N <= 1) {
	        return N;
	    } else {
	        return fib1(N - 1) + fib1(N - 2);
	    }
	}

	public static int fib(int N) {
		return fib2(N, 0, 0, 1);
	}

	private static int fib2(int N, int k, int f0, int f1) {
	    if (N == k) {
	        return f0;
	    } else {
	        return fib2(N, k + 1, f1, f0 + f1);
	    }
	}

	public static int fib_iterative(int N) {
		int k = 0;
		int f0 = 0;
		int f1 = 1;
		while (N != k) {
			int temp = f1;
			f1 = f0 + f1;
			f0 = temp;
			k += 1;
		}
		return f0;
	}
}