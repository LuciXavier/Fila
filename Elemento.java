public class Elemento {
    final Object val;
    Elemento proximo;

    public Elemento(Object val)
    {
        this.val = val;
        this.proximo = null;
    }

    @Override
    public String toString()
    {
        return this.val.toString();
    }

}