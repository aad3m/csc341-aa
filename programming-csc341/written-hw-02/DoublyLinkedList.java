class DoublyLinkedList {
    private Node head;
    private Node tail;
    private Node middle;
    private int size;

    private class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    public DoublyLinkedList() {
        head = null;
        tail = null;
        middle = null;
        size = 0;
    }

    public void add(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
            middle = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        if (size % 2 == 0) {
                middle = middle.next;
            }
    }

    public void remove(int value) {
        Node current = head;
        while (current != null) {
            if (current.value == value) {
                if (current == head) {
                    head = current.next;
                    head.prev = null;
                } else if (current == tail) {
                    tail = current.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                size--;
                if (size % 2 == 1) {
                    middle = middle.prev;
                }
                return;
            }
            current = current.next;
        }
    }

    public int getMiddle() { // Method used to get the middle value of the list
        return middle.value;
    }
}