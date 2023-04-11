public class Main {
    String[] vetor = new String[10];
    int fim = -1;

    public static void main(String[] args) {
        FilaDeString fila = new FilaDeString();
        fila.add("chico");
        fila.add("chico2");
        fila.add("chico3");
        fila.list();
        fila.remove();
        fila.list();
    }

    void add(String value){
        fim++;
        vetor[fim]=value;
    }

    void remove(){
        for (int i=0;)
    }
}