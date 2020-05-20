import java.util.HashMap;

public class dis6demo {
	public static void main(String[] args) {
		System.out.println(containsDuplicates(new int[]{1, 2, 2, 1, 3, 3}));
	}

	public static boolean containsDuplicates(int[] array) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int key : array) {
			if (map.containsKey(key)) {
				map.put(key, map.get(key) + 1);
			} else {
				map.put(key, 1);
			}
		}

		for (int key : map.keySet()) {
			if (map.get(key) < 2) {
				return false;
			}
		}
		return true;
	}
}