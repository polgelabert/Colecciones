import java.util.ArrayList;
import java.util.List;


public class Usuario {

    public String nombre;
    public String password;
    public int nivel;
    public int ataque;
    public int defensa;
    public int resistencia;
    //public ObjectList myList = new ObjectList(n) {};
    public List<Objeto> list_obj;


    public Usuario (String n, String p, int niv, int a, int d, int r, ArrayList lobj){
        this.nombre = n;
        this.password = p;
        this.nivel = niv;
        this.ataque = a;
        this.defensa = d;
        this.resistencia = r;
        this.list_obj = lobj;
    }

}
