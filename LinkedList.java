package doubleLinkedList;

public class LinkedList {

	Node head;

	public LinkedList() {
		this.head = null;
	}

	public boolean isEmpty() {
		return this.head == null;
	}

	// metodos recursivos

	public void addLast(int value) {
		if (isEmpty())
			this.head = new Node(value);
		else
			addLastRecursivo(this.head, value);

	}

	private void addLastRecursivo(Node no, int value) {

		if (no.next == null) {
			Node newNode = new Node(value);
			no.next = newNode;
			newNode.previous = no;
		} else {
			addLastRecursivo(no.next, value);
		}

	}

	public int size() {
		return size(this.head);
	}

	private int size(Node no) {
		if (no == null)
			return 0;
		else
			return 1 + size(no.next);
	}

	public int sum() {
		return sum(this.head);
	}

	private int sum(Node no) {

		if (no == null)
			return 0;
		else
			return no.value + sum(no.next);
	}

	public boolean isSorted() {
		return isSorted(this.head);
	}

	private boolean isSorted(Node no) {
		if ((no == null) || (no.next == null))
			return true;
		else
			return ((no.value < no.next.value) && isSorted(no.next));
	}

	// metodos iterativos

	public void add(int index, int elemento) {
		int cont = 0;
		Node aux = this.head;

		while (cont <= index && aux != null) {
			aux = aux.next;
			cont++;
		}

		if (aux != null) {
			Node newNode = new Node(elemento);

			if (aux.next == null) {
				aux.next = newNode;
				newNode.previous = aux;
			} else {
				newNode.next = aux.next;
				newNode.next.previous = newNode;
				aux.next = newNode;
				newNode.previous = aux;

			}
		}
	}

	public void remove(int index) {

		if (index == 0) {
			this.head = head.next;
			this.head.previous = null;
		} else {
			int cont = 0;
			Node aux = this.head;

			while (cont <= index && aux != null) {
				aux = aux.next;
				cont++;
			}

			if (aux != null) {
				if (aux.next == null) {
					aux.previous.next = null;
				} else {
					aux.previous.next = aux.next;
					aux.next.previous = aux.previous;
				}
			}
		}
	}
}

class Node {

	int value;
	Node previous;
	Node next;

	public Node(int value) {
		this.value = value;
	}
}
