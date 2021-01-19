import java.util.Arrays;


class ResizingArrayOfStrings {
	String[] data;
	int N;

	public ResizingArrayOfStrings() {
		data = new String[1];
		N = 0;
	}

	public void push(String item) {
		if (N == data.length) {
			resize(data.length * 2);
		}
		data[N++] = item;
	}

	public String pop() {
		N = N - 1;	
		String item = data[N];
		data[N] = null;
		if (N > 0 && N == Math.abs(data.length / 4)) resize(N);
		return item;
	}

	private void resize(int capacity) {
		String[] copy = new String[capacity];
		for (int i = 0; i < data.length; i++) {
			if (data[i] != null) copy[i] = data[i];
		}
		data = copy;
	}

	public void print() {
		System.out.println("Printing of the current stack's state started:");
		for (int i = data.length - 1; i >= 0; i--) {
			if (data[i] != null) System.out.println("Next item: " + data[i]);
		}
	}

}


class Main {

	public static void main(String[] args) {
		
		ResizingArrayOfStrings arr = new ResizingArrayOfStrings();
		arr.push("apple");
		arr.push("banana");
		arr.push("pineapple");
		arr.push("coconut");
		arr.print();	
		arr.pop();
		arr.pop();
		arr.print();

	}

}
