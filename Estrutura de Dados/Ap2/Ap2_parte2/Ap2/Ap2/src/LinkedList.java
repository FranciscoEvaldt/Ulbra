
class LinkedList {
    Node head;
    Node tail;

    private int comparisonCount;

    public int getComparisonCount() {
        return comparisonCount;
    }

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    // Insere um elemento no início da lista
    public void insertAtBeginning(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
    }

    // Insere um elemento no meio da lista, após um elemento específico
    public void insertAfter(int existingValue, int newValue) {
        Node newNode = new Node(newValue);

        Node current = head;
        while (current != null && current.value != existingValue) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Elemento não encontrado na lista.");
            return;
        }

        newNode.next = current.next;
        newNode.previous = current;

        if (current.next != null) {
            current.next.previous = newNode;
        } else {
            tail = newNode;
        }

        current.next = newNode;
    }

    // Insere um elemento no fim da lista
    public void insertAtEnd(int value) {
        Node newNode = new Node(value);

        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.previous = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Ordena os elementos da lista em ordem crescente (algoritmo A)
    public void sortAscending() {
        if (head == null || head.next == null) {
            return; // Lista vazia ou com apenas um elemento, já está ordenada
        }

        boolean swapped;
        Node current;

        do {
            swapped = false;
            current = head;

            while (current.next != null) {
                if (current.value < current.next.value) {
                    swapNodes(current, current.next);
                    swapped = true;
                    comparisonCount++;
                }


                current = current.next;
            }
        } while (swapped);
    }

    // Ordena os elementos da lista em ordem decrescente (algoritmo B)
    public void sortDescending() {
        if (head == null || head.next == null) {
            return; // Lista vazia ou com apenas um elemento, já está ordenada
        }

        boolean swapped;
        Node current;

        do {
            swapped = false;
            current = head;

            while (current.next != null) {
                if (current.value > current.next.value) {
                    swapNodes(current, current.next);
                    swapped = true;
                    comparisonCount++;
                }


                current = current.next;
            }
        } while (swapped);
    }

    // Método auxiliar para trocar dois nós na lista
    private void swapNodes(Node node1, Node node2) {
        comparisonCount++;
        int temp = node1.value;
        node1.value = node2.value;
        node2.value = temp;
    }


    // Imprime os elementos da lista
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }


    public void mergeSort() {
        head = mergeSort(head);
    }

    private Node mergeSort(Node node) {
        if (node == null || node.next == null) {
            return node; // Lista vazia ou com apenas um elemento, já está ordenada
        }

        Node middle = getMiddle(node);
        Node nextOfMiddle = middle.next;
        middle.next = null;

        Node left = mergeSort(node);
        Node right = mergeSort(nextOfMiddle);

        return merge(left, right);
    }

    private Node merge(Node left, Node right) {
        Node result = null;

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        if (left.value <= right.value) {
            result = left;
            result.next = merge(left.next, right);
        } else {
            result = right;
            result.next = merge(left, right.next);
        }

        return result;
    }

    private Node getMiddle(Node node) {
        if (node == null) {
            return node;
        }

        Node slow = node;
        Node fast = node.next;

        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }

        return slow;
    }

}