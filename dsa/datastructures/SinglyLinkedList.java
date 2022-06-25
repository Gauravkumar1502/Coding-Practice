package dsa.datastructures;

import javax.naming.OperationNotSupportedException;

public class SinglyLinkedList {
    /**
     * Node
     */
    public class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node head;
    Node tail;
    int length;

    public SinglyLinkedList() {
    }

    public SinglyLinkedList(int value) {
        add(value);
    }

    public SinglyLinkedList(int... values) {
        for (int value : values) {
            add(value);
        }
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

    public void add(int index, int value) {
        if (index > length) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            shift(value);
            return;
        }
        if (index == length) {
            add(value);
            return;
        }
        Node current = head;
        while (index-- > 1) {
            current = current.next;
        }
        Node newNode = new Node(value);
        newNode.next = current.next;
        current.next = newNode;
        length++;
    }

    public void shift(int value) {
        if (head == null) {
            head = new Node(value);
            tail = head;
        } else {
            Node newNode = new Node(value);
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public int unshift() {
        if (isEmpty()) {
            throw new IllegalStateException("List already Empty");
        }
        int value = head.data;
        head = head.next;
        length--;
        return value;
    }

    public int remove() {
        if (isEmpty()) {
            throw new IllegalStateException("List already Empty");
        }
        if (head == tail) {
            int value = head.data;
            head = null;
            tail = null;
            length--;
            return value;
        }
        Node current = head;
        while (current.next != tail) {
            current = current.next;
        }
        int value = tail.data;
        current.next = null;
        tail = current;
        length--;
        return value;
    }

    public int remove(int index) {
        if (index >= length) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            return unshift();
        }
        if (index == length - 1) {
            return remove();
        }
        Node current = head;
        while (index-- > 1) {
            current = current.next;
        }
        int value = current.next.data;
        current.next = current.next.next;
        length--;
        return value;
    }

    public int peek() {
        return tail.data;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int size() {
        return length;
    }

    public int indexOf(int element) {
        Node currNode = head;
        int i = 0;
        while (currNode != null) {
            if (currNode.data == element) {
                return i;
            }
            currNode = currNode.next;
            i++;
        }
        return -1;
    }

    public boolean contains(int element) {
        return indexOf(element) != -1;
    }

    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        }
        StringBuilder result = new StringBuilder("[");
        Node current = head;
        while (current != null) {
            result.append(current.data + ", ");
            current = current.next;
        }
        result.delete(result.length() - 2, result.length());
        result.append("]");
        return result.toString();
    }
}
