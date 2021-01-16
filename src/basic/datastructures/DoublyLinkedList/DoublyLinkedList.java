class NodeAlreadyExistsException extends Exception {
	public NodeAlreadyExistsException(String message) {
		super(message);
	}
}


class NodeDoesNotExistException extends Exception {
	public NodeDoesNotExistException(String message) {
		super(message);
	}
}


class Node {

	int value;
	Node next;
	Node prev;

	public Node(int value) {
		this.value = value;
		this.next = null;
		this.prev = null;
		
	}

	public void addNext(Node node) throws NodeAlreadyExistsException {
		if (this.next != null) {
			throw new NodeAlreadyExistsException("Next node already set.");
		} else {
			this.next = node;
		}
	}

	public void addPrev(Node node) throws NodeAlreadyExistsException {
		if (this.prev != null) {
			throw new NodeAlreadyExistsException("Previous node already set.");
		} else {
			this.prev = node;
		}
	}

	public void rmNext() throws NodeDoesNotExistException {
		if (this.next == null) {
			throw new NodeDoesNotExistException("Next node does not exist.");
		} else {
			this.next = null;
		}
	}

	public void rmPrev() throws NodeDoesNotExistException {
		if (this.prev == null) {
			throw new NodeDoesNotExistException("Prev node does not exist."); 
		} else {
			this.next = null;
		}
	}

	public void traverseForwards() {
		System.out.println("Forwards traversion started: ");			
		Node current = this;
		int i = 0;
		while (current != null) {
			System.out.println("Node " + i + " value: " + current.value);
			current = current.next;
			i++;
		}
	}

	public void traverseBackwards() {
		System.out.println("Backwards traversion started: ");	

		Node current = this;
		int i = 0;
		while (current != null) {
		System.out.println("Node " + Math.abs(i) + " value: " + current.value);
			current = current.prev;
			i--;	
		}
	}
}

class Manage {
	public static void rmDoublyLinkedListNodeByNode(Node startNode, boolean forwards) {
		String direction = forwards == true ? "Forwards" : "Backwards";
		System.out.println(direction + " deletion node by node started: ");
		if (forwards == true) {
			int i = 0;
			Node current = startNode;
			while (current != null) {
				System.out.println("Removed node " + i + " with value: " + current.value);
				Node prev = current;
				current = current.next;
				prev.next = null;
				i++;
			}
		} else {
			int i = 0;
			Node current = startNode;
			while (current != null) {
				System.out.println("Removed node " + i + " with value: " + current.value);
				Node next = current;
				current = current.prev;
				next.prev = null;
				i--;
			}
		}
	}
}


class Main {
	public static void main(String[] args) {
		System.out.print("Unseccussful doubly linked list creation with Exception called");

		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		
		try {
			n1.addNext(n2);
			n2.addNext(n3);
			n2.addNext(n1);
		} catch (Exception e) {
			System.out.print("Error occured: [" + e + "]");
		}
	}
}

class Main2 {
	public static void main(String[] args) {

		System.out.println("Successful doubly linked list creation and traverse forwards and backwards:");

		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);

		try {
			n1.addNext(n2);
			n2.addNext(n3);
			n3.addNext(n4);
		} catch (Exception e) {
			System.out.print("Error occured: [" + e + "]");
		}

		try {
			n4.addPrev(n3);
			n3.addPrev(n2);
			n2.addPrev(n1);
		} catch (Exception e) {
			System.out.print("Error occured: [" + e + "]");
		}	
	

		n1.traverseForwards();
		n4.traverseBackwards();
	}

}

class Main3 {
	public static void main(String[] args) {
		System.out.print("Successfull linked list creation and removal node by node");
			
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		
		try {
			n1.addNext(n2);
			n2.addNext(n3);
			n3.addNext(n4);
		} catch (Exception e) {
			System.out.print("Error occured: [" + e + "]");
		}	

		Manage mn = new Manage();
		mn.rmDoublyLinkedListNodeByNode(n1, true);	
	}
}
