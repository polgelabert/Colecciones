import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;
import static org.junit.Assert.*;


public class Test2 {

    final static Logger log = Logger.getLogger(Test2.class.getName());          // test2.class.getname indica el nombre de la clase.

    Mundo miMundo;
    HashMap<String, Usuario> Map;
    Usuario player, player_esperado;
    Objeto o, obj_esperado;
    ArrayList<Objeto>  lobj, lobj_esperado;
    ArrayList<Usuario> list_usu;
    String u, nom_obj, origen, destino;
    List<Objeto> lista_obj, lista_obj_esp;

    boolean result;

    @Before @After
    public void setUp(){
        Map = new HashMap<>();
        miMundo = new Mundo();
        lobj = new ArrayList<Objeto>();
        lobj_esperado = new ArrayList<Objeto>();
        list_usu = new ArrayList<Usuario>();


        //Se añaden 2 Usuarios con 1 objeto cada uno.
        player = new Usuario("pol", "1234", 10, 20, 30, 40, lobj);
        o = new Objeto("espada", "samurai", "espada para luchar contra los enemigos", 500, 350);
        player.list_obj.add(o);
        miMundo.Map.put(player.nombre, player);

        lobj = new ArrayList<Objeto>();
        player = new Usuario("marc", "pass_marc", 50, 60, 70, 80, lobj);
        o = new Objeto("puñal", "asesinato", "puñal para asesinar a los enemigos", 1000, 750);
        player.list_obj.add(o);
        miMundo.Map.put(player.nombre, player);

    }



    @Test
    public void añadirObjetoAUsuarioTest(){

        u = "pol";
        o = new Objeto("Arco de flechas", "disparo", "Arco de flechas para disparar a los enemigos", 100, 150);

        assertNull(miMundo.consultarObjetoDeUsuario(u, o.nombreobj));

        miMundo.añadirObjetoAUsuario(u, o);

        assertNotNull(miMundo.consultarObjetoDeUsuario(u, o.nombreobj));



    }

    @Test
    public void consultarUsuarioTest(){

        u = "pol";
        player = miMundo.consultarUsuario(u);

        player_esperado = new Usuario("pol", "1234", 10, 20, 30, 40, lobj_esperado);
        o = new Objeto("espada", "samurai", "espada para luchar contra los enemigos", 500, 350);
        player_esperado.list_obj.add(o);

        boolean resp = player_esperado.usuarioEsIgual(player);         //Objects.equals(player_esperado, player);

        assertTrue(resp);
    }

    @Test
    public void consultarObjetoDeUsuarioTest(){

        u = "pol";
        nom_obj = "espada";
        o = miMundo.consultarObjetoDeUsuario(u, nom_obj);
        obj_esperado = new Objeto("espada", "samurai", "espada para luchar contra los enemigos", 500, 350);

        boolean resp = obj_esperado.objetoEsIgual(o);
        assertTrue(resp);
    }

    @Test
    public void consultarObjetosDeUsuarioTest(){

        u = "pol";

        lista_obj = miMundo.consultarObjetosDeUsuario(u);

        o = new Objeto("espada", "samurai", "espada para luchar contra los enemigos", 500, 350);
        lista_obj_esp = new ArrayList<>();
        lista_obj_esp.add(o);

        boolean resp = miMundo.Map.get(u).listaEsIgual(lista_obj_esp);

        assertTrue(resp);

    }

    @Test
    public void transferirObjetoEntreUsuariosTest(){

        origen = "pol";
        destino = "marc";
        nom_obj = "espada";

        miMundo.transferirObjetoEntreUsuarios(origen, destino, nom_obj);

        assertNull(miMundo.consultarObjetoDeUsuario(origen, nom_obj));
        assertNotNull(miMundo.consultarObjetoDeUsuario(destino, nom_obj));

    }

    @Test
    public void eliminarObjetosDeUsuarioTest(){

        u = "pol";
        nom_obj = "espada";
        result = miMundo.eliminarObjetosDeUsuario(u);

        assertTrue(result);
        assertNull(miMundo.consultarObjetoDeUsuario(u,nom_obj));
    }

    @Test
    public void eliminarUsuarioTest(){

        u = "pol";
        result = miMundo.eliminarUsuario(u);
        assertTrue(result);
        assertNull(miMundo.consultarUsuario(u));

    }



}
