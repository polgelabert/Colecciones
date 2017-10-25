import java.util.List;

public class Objeto {

    public String nombreobj;
    public String tipo;
    public String descripcion;
    public int valor;
    public int coste;

    public Objeto (String nobj, String t, String des, int v, int c){
        this.nombreobj = nobj;
        this.tipo = t;
        this.descripcion = des;
        this.valor = v;
        this.coste = c;
    }


    public boolean objetoEsIgual(Objeto o) {

        boolean resp = false;

        if (o.nombreobj == this.nombreobj && o.tipo == this.tipo && o.descripcion == this.descripcion && o.valor == this.valor && o.coste == this.coste) {
            resp = true;
        }

        return resp;
    }



}
