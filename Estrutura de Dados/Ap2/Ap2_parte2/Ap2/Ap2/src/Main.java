public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Insere elementos no início, meio e fim da lista
        list.insertAtBeginning(3);
        list.insertAfter(3, 5);
        list.insertAfter(3, 4);
        list.insertAtEnd(6);

        // Imprime os elementos da lista
        System.out.print("Lista original: ");
        list.printList();

        // Ordena os elementos em ordem crescente (algoritmo A)
        long timeStart = System.currentTimeMillis();
        list.sortDescending();
        long timeEnd = System.currentTimeMillis();
        System.out.print("Lista ordenada em ordem crescente: ");
        list.printList();
        System.out.println("Número de comparações: " + list.getComparisonCount());
        System.out.println("Tempo de comparações (ordem crescente): " + (timeEnd - timeStart) + " ms");

        // Ordena os elementos em ordem decrescente (algoritmo B)
        timeStart = System.currentTimeMillis();
        list.sortAscending();
        timeEnd = System.currentTimeMillis();
        System.out.print("Lista ordenada em ordem decrescente: ");
        list.printList();
        System.out.println("Número de comparações: " + list.getComparisonCount());
        System.out.println("Tempo de comparações (ordem decrescente): " + (timeEnd - timeStart) + " ms");
    }

}