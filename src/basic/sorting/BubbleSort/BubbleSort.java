import java.util.Arrays;

class Main {

	public static void bubbleSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			boolean notChanged = true;
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		System.out.println("Bubble sorting finished, result:");
		System.out.println(Arrays.toString(array));
	}

	public static void main(String[] args) {
		int[] arr = {23, 1, 12, 7, 14, 4, 10, 19, 32, 2};

		bubbleSort(arr);
	}
}
