import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Mundo {

    HashMap<String,Usuario> Map = new HashMap<>();
    List<Objeto> list_obj_cons;



    public boolean crearUsuario(Usuario u){

        Map.put(u.nombre, u);
        return true;
    }

    public void añadirObjetoAUsuario (String u, Objeto o){

        Map.get(u).list_obj.add(o);

    }

    public  Usuario consultarUsuario (String u){

       return Map.get(u);
    }

    public Objeto consultarObjetoDeUsuario(String u, String nom_obj){

        list_obj_cons = consultarObjetosDeUsuario(u);

        boolean enc= false;
        int m=0;
        while (!enc && m < list_obj_cons.size()){

            if(list_obj_cons.get(m).nombreobj.equals(nom_obj)){
                enc = true;
            } else {
                m++;
            }
        }

        if (enc == false){
            return null;
        }
        else {
            return list_obj_cons.get(m);
        }
    }

    public List<Objeto> consultarObjetosDeUsuario (String u) {

        return  Map.get(u).list_obj;
    }

    public boolean eliminarUsuario (String u){

        Map.remove(u);
        return true;
    }

    public boolean eliminarObjetosDeUsuario(String u){

        if(Map.get(u).list_obj.size() > 0){
            Map.get(u).list_obj.remove(0);
            return true;
        } else {
            return false;
        }

    }

    public void transferirObjetoEntreUsuarios (String origen, String destino, String nom_obj){

        Objeto o = consultarObjetoDeUsuario(origen, nom_obj);
        Map.get(destino).list_obj.add(o);
        Map.get(origen).list_obj.remove(o);
    }


















}
