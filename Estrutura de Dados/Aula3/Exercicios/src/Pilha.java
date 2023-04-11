public class Pilha {
    //pessoa
//idade,nome,nacionalidade
    int topo=-1;
    int[] vetor = new int[20];
    //pessoa
//caminhar,falar,andar_bike,....
    public int pop(){
        int valor=vetor[topo];
        topo--;
        return valor;
    }
    public int push(int valor){
        topo++;
        vetor[topo]=valor;
        return vetor[topo];
    }
    public void top(){
        System.out.println(vetor[topo]);
    }
//pop top init

    public static void main(String[] args) {
        Pilha minhaPilha = new Pilha();
        minhaPilha.push(5);
        minhaPilha.push(8);
        minhaPilha.push(7);
        minhaPilha.push(5);
        minhaPilha.push(8);
        minhaPilha.push(7);
        minhaPilha.push(5);
        minhaPilha.push(8);
        minhaPilha.push(7);
        minhaPilha.push(5);
        minhaPilha.push(8);
        minhaPilha.push(7);
        minhaPilha.pop();
        minhaPilha.pop();
        minhaPilha.pop();
        minhaPilha.pop();
        minhaPilha.pop();


        minhaPilha.top();
    }
}