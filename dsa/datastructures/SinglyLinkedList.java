package dsa.datastructures;

public class SinglyLinkedList {

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int length;

    public SinglyLinkedList() {
    }

    public SinglyLinkedList(int value) {
        head = new Node(value);
        tail = head;
        length = 1;
    }

    public void add(int value) {
        if (head == null) {
            head = new Node(value);
            tail = head;
        } else {
            tail.next = new Node(value);
            tail = tail.next;
        }
        length++;
    }

    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        Node current = head;
        while (current != null) {
            sb.append(current.data);
            sb.append(", ");
            current = current.next;
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();
    }
}
