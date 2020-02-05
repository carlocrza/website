public class IntList {
	private int head;
	private IntList tail;
	public IntList(int head, IntList tail) {
		this.head = head;
		this.tail = tail;
	}

	public String toString() {
		IntList L = this;
		String result = "";
		while (L != null) {
			result += L.head + ", ";
			L = L.tail;
		}
		return result;
	}

	public static IntList reverseDestructiveIterative(IntList L) {
		if (L == null || L.tail == null) {
			return L;
		}
		IntList A = L;
		IntList B = L.tail;
		A.tail = null;
		IntList C = null;
		while (B != null) {
			C = B.tail;
			B.tail = A;
			A = B;
			B = C;
		}
		return A;
	}

	public static IntList insertRecursive(IntList L, int item, int position) {
		if (position == 0 || L == null) {
			return new IntList(item, L);
		}
		L.tail = insertRecursive(L.tail, item, position - 1);
		return L;
	}

	public static void main(String[] args) {
		IntList L = new IntList(3, null);
		L = new IntList(2, L);
		L = new IntList(1, L);
		System.out.println(reverseDestructiveIterative(L));
	}
}