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
}


class Main {
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		
		try {
			n1.addNext(n2);
			n2.addNext(n3);
		}
		catch (Exception e) {
			System.out.print("Print");
		}
		try {
			n2.addNext(n1);
		} catch (Exception e) {
			System.out.print("[" + e + "], error occured.");
		}
	}
}

