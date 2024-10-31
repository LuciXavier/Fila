public class Pilha
{
    Elemento topo;
    int tam;

    public Pilha()
    {
        this.topo = null;
        this.tam = 0;
    }

    public char pop()
    {
        if (tam == 0) {
            throw new IllegalStateException("Pilha vazia");
        }
        Elemento elemento = this.topo;
        char val = (char) elemento.val;
        topo = topo.proximo;
        tam--;
        return val;
    }

    public void push(char elemento)
    {
        Elemento elemen = new Elemento(elemento);
        elemen.proximo = topo;
        topo = elemen;
        tam++;
    }
}