import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;


class StackOfStrings {
	ArrayList<String> data;

	public StackOfStrings() {
		 data = new ArrayList<String>();
	}

	public void push(String s) {
		this.data.add(s);
	}

	public void print() {
		System.out.println("Current stack state: " + this.data.toString());
	}

	public String pop() {	
		if (this.data.size() > 0) {
			String s = this.data.remove(this.data.size() - 1);
			return s;
		}
		return "";	
	}

	public boolean isEmpty() {
		return this.data.size() == 0;
	}
}


class Main {
	public static void main(String[] args) {
		StackOfStrings st = new StackOfStrings();

		System.out.println("Is stack empty?: " + st.isEmpty());
		st.push("banana");
		st.push("orange");
		st.push("pear");
		st.push("apple");
		st.print();
		String popedItem = st.pop();
		System.out.println("Poped item: " + popedItem);
		st.print();
		System.out.println("Is stack empty?: " + st.isEmpty());
	}
}
