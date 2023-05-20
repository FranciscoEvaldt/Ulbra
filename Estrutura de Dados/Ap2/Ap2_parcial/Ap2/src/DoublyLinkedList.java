public class DoublyLinkedList {
    Node head;
    Node tail;
    int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void insertAtStart(int data) {
        Node new_node = new Node(data);
        if (this.head == null) {
            this.head = new_node;
            this.tail = new_node;
        } else {
            new_node.next = this.head;
            this.head.prev = new_node;
            this.head = new_node;
        }
        this.size++;
    }

    public void insertAtEnd(int data) {
        Node new_node = new Node(data);
        if (this.tail == null) {
            this.head = new_node;
            this.tail = new_node;
        } else {
            new_node.prev = this.tail;
            this.tail.next = new_node;
            this.tail = new_node;
        }
        this.size++;
    }

    public int removeFromStart() {
        if (this.head == null) {
            return -1;
        }
        int data = this.head.data;
        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
            this.head.prev = null;
        }
        this.size--;
        return data;
    }

    public int removeFromEnd() {
        if (this.tail == null) {
            return -1;
        }
        int data = this.tail.data;
        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }
        this.size--;
        return data;
    }

    public int get(int index) {
        if (index < 0 || index >= this.size) {
            return -1;
        }
        Node current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public void printList() {
        Node current = this.head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void printListReverse() {
        Node current = this.tail;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }
}
