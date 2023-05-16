public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAtStart(5);
        list.insertAtStart(8);
        list.insertAtStart(3);
        list.insertAtStart(2);
        list.insertAtEnd(7);
        list.removeFromStart();
        System.out.println(list.get(2));
        list.removeFromEnd();
        System.out.printf("Lista Completa: ");
        list.printList();
        System.out.printf("Lista Invertida:");
        list.printListReverse();
    }
}
