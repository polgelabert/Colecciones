import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class Mundo2 {

    Logger log = Logger.getLogger("a");


    public ArrayList<Usuario> UsuarioInicial(ArrayList<Usuario> list_usu){

        // Inicialmente, se añade 1 usuario con un objeto.
        log.info("introduce nombre de usuario, contraseña, nivel, ataque, defensa y resistencia: (separados por ENTER)");
        Scanner input = new Scanner(System.in);
        String n = input.nextLine();
        String p = input.nextLine();
        int niv = input.nextInt();
        int a = input.nextInt();
        int d = input.nextInt();
        int r = input.nextInt();
        ArrayList<Objeto> lobj = new ArrayList<Objeto>();    // ArrayList que se se guardaran los objetos de cada jugador.

        log.info("Introduce el objeto: nombre, tipo, descripción, valor y coste: (separados por ENTER)");
        Scanner input4 = new Scanner(System.in);
        String nobj = input4.nextLine();
        String t = input4.nextLine();
        String des = input4.nextLine();
        int v = input4.nextInt();
        int c = input4.nextInt();
        Objeto o = new Objeto (nobj, t, des, v, c);
        lobj.add(o);

        Usuario player1 = new Usuario(n, p, niv, a, d, r, lobj);
        newUsuario(list_usu, player1);



        // 2o usuario con otro objeto.
        log.info("introduce nombre de usuario, contraseña, nivel, ataque, defensa y resistencia: (separados por ENTER)");
        input = new Scanner(System.in);
        n = input.nextLine();
        p = input.nextLine();
        niv = input.nextInt();
        a = input.nextInt();
        d = input.nextInt();
        r = input.nextInt();
        lobj = new ArrayList<Objeto>();    // ArrayList que se se guardaran los objetos de cada jugador.

        log.info("Introduce el objeto: nombre, tipo, descripción, valor y coste: (separados por ENTER)");
        input4 = new Scanner(System.in);
        nobj = input4.nextLine();
        t = input4.nextLine();
        des = input4.nextLine();
        v = input4.nextInt();
        c = input4.nextInt();
        o = new Objeto (nobj, t, des, v, c);
        lobj.add(o);

        player1 = new Usuario(n, p, niv, a, d, r, lobj);
        newUsuario(list_usu, player1);

        return list_usu;
    }

    public void newUsuario (ArrayList<Usuario> list_usu, Usuario player1){

        list_usu.add(player1);

    }

    public int getUsuario (ArrayList<Usuario> list_usu, String usu){

        boolean b = false;
        int i=0;                    // Contador de usuarios
        int m = 0;                  // Parametro que guarda el indice del usuario en la lista de usuarios

        while (!b && i < list_usu.size()){           // Comprueba si el nombre introducido = usuario
            if (list_usu.get(i).nombre.equals(usu)){
                b = true;
                m = i;
                i++;
            } else {
                i++;
            }
        }
        if ( !b ){
            return -1;
        }
        return m;
    }

    public void añadirObjetoAUsuario ( ArrayList<Usuario> list_usu, String usu){


        int m = getUsuario(list_usu, usu);
        if (m!= -1){
            log.info("Introduce el objeto: nombre, tipo, descripción, valor y coste: (separados por ENTER)");
            Scanner input4 = new Scanner(System.in);
            String nobj = input4.nextLine();
            String t = input4.nextLine();
            String des = input4.nextLine();
            int v = input4.nextInt();
            int c = input4.nextInt();
            Objeto o = new Objeto (nobj, t, des, v, c);
            list_usu.get(m).list_obj.add(o);
        } else{
            log.severe("*** null: el usuario " + usu + " no existe.");          // Mensaje error.
        }

    }

    public  Usuario consultarUsuario ( ArrayList<Usuario> list_usu, String usu){
        String NL = System.lineSeparator();     // Enter en System.out.println()

        int m = getUsuario(list_usu,usu);
        Usuario usu_consult;

        if (m !=-1){
            // Consulta usuario.
            usu_consult = list_usu.get(m);


            // Display información del usuario consultado.
            log.info("Nombre jugador: " + usu_consult.nombre + NL + "Contraseña: " + usu_consult.password + NL + "Nivel: " + usu_consult.nivel + NL + "Ataque: " + usu_consult.ataque + NL + "Defensa: " + usu_consult.defensa + NL + "Resistencia: " + usu_consult.resistencia + NL + "........................");
            int l = 0;     // Contador de objetos.
            for (int k = 0; k < usu_consult.list_obj.size(); k++) {
                log.info("Nombre objeto " + ++l + ": " + usu_consult.list_obj.get(k).nombreobj + NL + "Tipo obj: " + usu_consult.list_obj.get(k).tipo + NL + "Descripción obj: " + usu_consult.list_obj.get(k).descripcion + NL + "Valor obj: " + usu_consult.list_obj.get(k).valor + NL + "Coste obj: " + usu_consult.list_obj.get(k).coste + NL + "........................");
            }
            return usu_consult;
        } else {
            log.info("*** null: el usuario " + usu + " no existe.");      // Mensaje error.
            return null;
        }


    }

    public List<Objeto> consultarObjetosDeUsuario (ArrayList<Usuario> list_usu, String usu) {
        String NL = System.lineSeparator();     // Enter en System.out.println()

        int m = getUsuario(list_usu,usu);
        List<Objeto> list_obj_consult;

        if (m != -1){
            // Lista Objetos de un usuario
            list_obj_consult = list_usu.get(m).list_obj;


            if (list_obj_consult.isEmpty()){        // Comprueba si la lista esta vacía.
                log.info("*****" + NL + "* null: El usuario " + usu + " no tiene ningun objeto." + "*****");
                list_obj_consult = null;
            } else{

                int l  = 0;     // Contador de objetos.
                for (int k = 0; k < list_obj_consult.size(); k++){
                    log.info("Nombre objeto " + ++l + ": " + list_obj_consult.get(k).nombreobj + NL + "Tipo obj: " + list_obj_consult.get(k).tipo + NL + "Descripción obj: " + list_obj_consult.get(k).descripcion + NL + "Valor obj: " + list_obj_consult.get(k).valor + NL + "Coste obj: " + list_obj_consult.get(k).coste + NL + "........................");
                }
            }

        } else{
            log.info("*** null: el usuario " + usu + " no existe.");      // Mensaje error.
            list_obj_consult = null;
        }

        return list_obj_consult;
    }

    public Objeto consultarObjetoDeUsuario(ArrayList<Usuario> list_usu, String usu, String nom_obj){

        String NL = System.lineSeparator();     // Enter en System.out.println()

        int m = getUsuario(list_usu, usu);

        if(m!= -1){

            int k = 0;                  // k = contador de objetos.
            int l = 0;                  // l se queda con el indice de objeto encontrado en el inventario.
            boolean c = false;

            while ( c!= true && k < list_usu.get(m).list_obj.size()){
                if( list_usu.get(m).list_obj.get(k).nombreobj.equals(nom_obj)){
                    l = k;
                    c = true;
                } else{
                    k++;
                }
            }
            if(c==true){
                log.info("Nombre objeto :" + list_usu.get(m).list_obj.get(l).nombreobj + NL + "Tipo obj: " + list_usu.get(m).list_obj.get(l).tipo + NL + "Descripción obj: " + list_usu.get(m).list_obj.get(l).descripcion + NL + "Valor obj: " + list_usu.get(m).list_obj.get(l).valor + NL + "Coste obj: " + list_usu.get(m).list_obj.get(l).coste + NL + "........................");
                return list_usu.get(m).list_obj.get(l);
            } else{
                log.severe("El usuario " + usu + " no tiene objetos.");
                return null;
            }

        } else {
            log.severe("*** El usuario " + usu + " no existe.");
            return null;
        }
    }

    public void transferirObjetoEntreUsuarios (ArrayList<Usuario> list_usu, String orig, String dest, String nom_obj){

        int m = getUsuario(list_usu,orig);
        int n = getUsuario(list_usu,dest);

        if (m!= -1 && n!= -1){
            Objeto o = consultarObjetoDeUsuario(list_usu, orig, nom_obj);
            if(o != null){
                list_usu.get(n).list_obj.add(o);
                list_usu.get(m).list_obj.remove(o);
            } else {
                log.severe("*** El objeto " + nom_obj + " no pertenece al usuario " + orig );
            }
        } else {
            log.severe("*** El usuario no existe.");
        }





    }

    public boolean eliminarObjetosDeUsuario(ArrayList<Usuario> list_usu, String usu, String nom_obj){

        int m = getUsuario(list_usu, usu);
        Objeto obj = consultarObjetoDeUsuario(list_usu, usu, nom_obj);

        if (obj != null){
            list_usu.get(m).list_obj.remove(obj);
            log.info("Se ha eliminado el objeto: " + nom_obj + " del usuario: " + usu + " con éxito.");
            return true;
        } else{
            log.severe("El objeto: " + nom_obj + " o el usuario: " + usu + " no existen.");
            return false;
        }

    }

    public boolean eliminarUsuario (ArrayList<Usuario> list_usu, String usu){

        int m = getUsuario(list_usu, usu);
        if(m!= -1){
            list_usu.remove(m);
            log.info("Usuario eliminado correctamente.");
            return true;
        } else{
            log.severe("*** El usuario " + usu + " no existe.");
            return false;
        }
    }



}
