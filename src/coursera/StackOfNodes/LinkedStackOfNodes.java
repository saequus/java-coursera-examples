class LinkedStackOfNodes {
	private Node head = null;
	
	private class Node {
		String value;
		Node next;

		public Node(String s) {
			value = s;
		}
	}

	public LinkedStackOfNodes(String value) {
		head = new Node(value);
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void addNext(String s) {
		Node newNode = new Node(s);
		if (head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
	}

	public void traverse() {
		Node current = head;
		System.out.println("Forward traversion started:");
		while (current != null && current.value != null) {
			System.out.println("Next node value: " + current.value);
			current = current.next;
		}
	}

	public String pop() {
		String value = head.value;
		head = head.next;
		return value;
	}
}



class Main {

	public static void main(String[] args) {

		LinkedStackOfNodes ls = new LinkedStackOfNodes("apple");
		ls.addNext("banana");
		ls.addNext("pear");
		ls.addNext("lemon");
		ls.traverse();
		System.out.println("Poped item: " + ls.pop());
	}

}
