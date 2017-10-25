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


    public Usuario(String n, String p, int niv, int a, int d, int r, ArrayList lobj) {
        this.nombre = n;
        this.password = p;
        this.nivel = niv;
        this.ataque = a;
        this.defensa = d;
        this.resistencia = r;
        this.list_obj = lobj;
    }


    public boolean usuarioEsIgual(Usuario player) {

        if (player.nombre == this.nombre && player.password == this.password && player.nivel == this.nivel && player.ataque == this.ataque && player.defensa == this.defensa && player.resistencia == this.resistencia) {
            if (player.list_obj.get(0).nombreobj == this.list_obj.get(0).nombreobj && player.list_obj.get(0).tipo == this.list_obj.get(0).tipo && player.list_obj.get(0).descripcion == this.list_obj.get(0).descripcion && player.list_obj.get(0).valor == this.list_obj.get(0).valor && player.list_obj.get(0).coste == this.list_obj.get(0).coste) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }




    public boolean listaEsIgual (List<Objeto> lobj_consult){

        boolean resp = false;
        int m = 0;
        for (int n = 0; n< lobj_consult.size(); n++) {

            if (lobj_consult.get(m).nombreobj == this.list_obj.get(m).nombreobj && lobj_consult.get(m).tipo == this.list_obj.get(m).tipo && lobj_consult.get(m).descripcion == this.list_obj.get(m).descripcion && lobj_consult.get(m).valor == this.list_obj.get(m).valor && lobj_consult.get(m).coste == this.list_obj.get(m).coste) {
                resp = true;
            } else {
                m = m+1;
            }
        }

        return resp;
    }


}