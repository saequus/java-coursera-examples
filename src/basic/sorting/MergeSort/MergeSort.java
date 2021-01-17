import java.util.Arrays;

class Main {

	public static void mergeSort(int[] array, int l, int m, int r) {
		int leftLength = m - l + 1;
		int rightLength = r - m;

		int[] left = new int[leftLength];			
		int[] right = new int[rightLength];
			
			
		for (int i = 0; i < leftLength; i++) {
			left[i] = array[l + i];
		}

		for (int i = 0; i < rightLength; i++) {
			right[i] = array[m + 1 + i];
		}
		
		int i = 0;
		int j = 0;
		int k = l;

		while (i < rightLength && j < leftLength) {

			if (right[i] <= left[j]) {
				array[k] = right[i];
				i++;
			} else {
				array[k] = left[j];
				j++;
			}
			k++;
		}
		while (i < rightLength) {
			array[k] = right[i];
			k++;
			i++;
		}

		while (j < leftLength) {
			array[k] = left[j];
			k++;
			j++;
		}
	}

	public static void sort(int[] array, int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;

			sort(array, l, m);
			sort(array, m + 1, r);

			mergeSort(array, l, m, r);
		}
	}

	public static void main(String[] args) {

		int[] arr = {23, 45, 21, 3, 14, 5, 1, 4, 2, 10};
		
		System.out.println("Array before sorting:");
		System.out.println(Arrays.toString(arr));
		
		sort(arr, 0, arr.length - 1);
	
		System.out.println("Array after sorting:");	
		System.out.println(Arrays.toString(arr));
	}

}
