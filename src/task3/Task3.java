package task3;

import java.util.Arrays;

public class Task3 {
	private static int getUniqueElems(int[] arr) {
		int[] result = new int[arr.length];
		int k = 0;
		for (int item : arr) {
			if (Arrays.binarySearch(result, item) < 0) {
				result[k++] = item;
				Arrays.sort(result);
			}
		}
		return k;
	}

	public static void main(String[] args) {
		int[] arr = {1, 4, 4, 1, 5};
		System.out.println(getUniqueElems(arr));
	}
}
