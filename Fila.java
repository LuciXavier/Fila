public class Fila{

    private Elemento inicio;
    private Elemento fim;
    private int tam;

    public Fila()
    {
        this.inicio = null;
        this.fim = null;
        this.tam = 0;
    }

    public boolean isEmpty()
    {
        return this.tam == 0;
    }

    public int tam()
    {
        return this.tam;
    }

    public void enfileirar(Object val)
    {
        Elemento elemento = new Elemento(val);
        if(isEmpty())
        {
            this.inicio = elemento;
            this.fim = elemento;
        }else
        {
            this.fim.proximo = elemento;
            this.fim = elemento;
        }
        this.tam++;
    }

    public void desenfileirar()
    {
        if(isEmpty())
        {
            throw new IllegalStateException("Não há objeto na fila");
        }
            this.inicio = this.inicio.proximo;
            this.tam--;
        if(this.tam == 0)
        {
            this.fim = null;
        }
    }

    public Object inicio()
    {
        if(isEmpty())
        {
            throw new IllegalStateException("Fila vazia");
        }
        return this.inicio.val;
    }

    @Override
    public String toString()
    {
        if(isEmpty())
        {
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        Elemento atual = this.inicio;
        while(atual != null)
        {
            builder.append(atual.val);
            builder.append(", ");
            atual = atual.proximo;
        }
        builder.append("]");
        return builder.toString();
    }

    public void inverter()
    {
        if(isEmpty())
        {
            throw new IllegalStateException("fila vazia");
        }

        Pilha pilha = new Pilha();

        while(!isEmpty())
        {
            pilha.push((char) inicio());
            desenfileirar();
        }

        while(pilha.tam > 0)
        {
            enfileirar(pilha.pop());
        }
    }

    public int contador(Object val)
    {   
        if(isEmpty())
        {
            throw new IllegalStateException("Fila vazia");
        }

        int conta = 0;
        int tamOri = this.tam;

        for(int i = 0; i < tamOri; i++)
        {
            Object elementoAtual = inicio();
            desenfileirar();

            if(elementoAtual.equals(val))
            {
                conta++;
            }
            enfileirar(elementoAtual);
        }
        return conta;
    }

}