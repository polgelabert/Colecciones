import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
//import java.util.logging.Logger; //logger java
import static org.junit.Assert.*;


public class Test2 {

    final static Logger log = Logger.getLogger(Test2.class.getName());          // test2.class.getname indica el nombre de la clase.

    Mundo2 miMundo;
    Usuario player1, player2, player, esperado;
    Objeto o, o1,o2;
    ArrayList<Objeto> lobj, lobj2, lobj_esperado;
    ArrayList<Usuario> list_usu;
    String usu, nom_obj;
    List<Objeto> lobj_consult;

    @Before @After
    public void setUp(){
        miMundo = new Mundo2();
        lobj = new ArrayList<Objeto>();
        lobj2 = new ArrayList<Objeto>();
        lobj_esperado = new ArrayList<Objeto>();
        list_usu = new ArrayList<Usuario>();

        //Se añade Usuario1 con 2 objetos.
        player1 = new Usuario("pol", "1234", 10, 20, 30, 40, lobj);
        o1 = new Objeto("espada", "samurai", "espada para luchar contra los enemigos", 500, 350);
        player1.list_obj.add(o1);
        o1 = new Objeto("pistola", "revolver", "pistola para disparar a los enemigos", 1000, 750);
        player1.list_obj.add(o1);
        list_usu.add(player1);


        //Se añade Usuario2 con objeto2.
        player2 = new Usuario("marc", "0000", 1, 2, 3, 4, lobj2);
        o2 = new Objeto("puñal", "asesinato", "puñal para enfrentar enemigos cuerpo a cuerpo", 250, 150);
        player2.list_obj.add(o2);
        list_usu.add(player2);
    }

    @Test
    public void eliminarUsuarioTest(){

        usu = "pol";
        boolean result = miMundo.eliminarUsuario(list_usu, usu);
        assertTrue(result);
        log.info("Usuario eliminado correctamente.");

    }

    @Test
    public void consultarUsuarioTest(){
        usu = "pol";
        player = miMundo.consultarUsuario(list_usu, usu);

        esperado = new Usuario("pol", "1234", 10, 20, 30, 40, lobj_esperado);
        o = new Objeto("espada", "samurai", "espada para luchar contra los enemigos", 500, 350);
        esperado.list_obj.add(o);

        boolean resp = esperado.usuarioEsIgual(player);         //Objects.equals(esperado, player);

        assertTrue(resp);
    }

    @Test
    public void consultarObjetoDeUsuarioTest(){

        usu = "pol";
        nom_obj = "espada";
        Objeto o = miMundo.consultarObjetoDeUsuario(list_usu, usu, nom_obj);
        Objeto esperado = new Objeto("espada", "samurai", "espada para luchar contra los enemigos", 500, 350);

        boolean resp = esperado.objetoEsIgual(o);
        assertTrue(resp);
    }

    @Test
    public void consultarObjetosDeUsuarioTest(){

        usu = "pol";
        int m = miMundo.getUsuario(list_usu, usu);
        lobj_consult = miMundo.consultarObjetosDeUsuario(list_usu, usu);

        List<Objeto> lobj_esperado = list_usu.get(0).list_obj;

        boolean resp = list_usu.get(m).listaEsIgual(lobj_esperado);
        assertTrue(resp);

    }

    @Test
    public void transferirObjetoEntreUsuariosTest(){
        String orig = "pol";
        String dest = "marc";
        nom_obj = "espada";
        int n = list_usu.get(0).list_obj.size();
        int m = list_usu.get(1).list_obj.size();
        miMundo.transferirObjetoEntreUsuarios(list_usu, orig, dest, nom_obj);


        boolean res = false;
        if (list_usu.get(0).list_obj.size() == n-1 && list_usu.get(1).list_obj.size() == m+1){
            res = true;
        }

        assertTrue(res);


    }

    @Test
    public void eliminarObjetosDeUsuarioTest(){

        usu = "pol";
        nom_obj = "espada";
        boolean obj_eliminado = miMundo.eliminarObjetosDeUsuario(list_usu, usu, nom_obj);

        assertTrue(obj_eliminado);
    }




}
