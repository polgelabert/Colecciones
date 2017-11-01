import Exceptions.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;


public class Test2 {

    final static Logger log = Logger.getLogger(Test2.class.getName());          // test2.class.getname indica el nombre de la clase.

    Mundo miMundo;
    HashMap<String, Usuario> Map;
    Usuario player, userEsperado;
    Objeto o, objeto, objetoEsperado, objetoReturned;
    ArrayList<Objeto>  lobj, lobj_esperado;
    ArrayList<Usuario> list_usu;
    String u, nombre, nombreObjeto, origen, destino;
    List<Objeto> lista_obj, lista_obj_esp;

    boolean result;

    @Before @After
    public void setUp(){
        Map = new HashMap<>();
        miMundo = new Mundo();
        lobj = new ArrayList<Objeto>();
        lobj_esperado = new ArrayList<Objeto>();
        list_usu = new ArrayList<Usuario>();


        //Se añaden 2 Usuarios con 1 objeto (sólo el primero).
        player = new Usuario("pol", "1234", 10, 20, 30, 40, lobj);
        o = new Objeto("espada", "samurai", "espada para luchar contra los enemigos", 500, 350);
        player.listaObjetos.add(o);
        miMundo.map.put(player.nombre, player);

        lobj = new ArrayList<Objeto>();
        player = new Usuario("marc", "pass_marc", 50, 60, 70, 80, lobj);
        o = new Objeto("espada", "samurai", "espada para luchar contra los enemigos", 500, 350);
        player.listaObjetos.add(o);
        player.listaObjetos.remove(o);
        miMundo.map.put(player.nombre, player);

    }



    @Test
    public void añadirObjetoAUsuarioTest() throws UsuarioNoExisteException, UsuarioSinObjetosException, ObjetoNoEncontradoException{

        nombre = "pol";
        objeto = new Objeto("Arco de madera", "disparo", "Arco de flechas para disparar a los enemigos", 100, 150);

        // Comprueba que se lanza ObjetoNoEncontradoException, UsuarioNoExisteException y UsuarioSinObjetosException.
        Assertions.assertThrows(ObjetoNoEncontradoException.class, () -> { miMundo.consultarObjetoDeUsuario(nombre, objeto.nombreObjeto);});

        Assertions.assertThrows(UsuarioNoExisteException.class, () -> { miMundo.consultarObjetoDeUsuario("BadName", objeto.nombreObjeto);});

        Usuario user = miMundo.consultarUsuario(nombre);
        Objeto espada = user.getObjeto("espada");
        miMundo.eliminarObjetosDeUsuario(nombre);

        Assertions.assertThrows(UsuarioSinObjetosException.class, () -> { miMundo.consultarObjetoDeUsuario(nombre, espada.nombreObjeto);});

        miMundo.añadirObjetoAUsuario(nombre, espada);
        miMundo.añadirObjetoAUsuario(nombre,objeto);


       // miMundo.añadirObjetoAUsuario(u, o);
       // assertNotNull(miMundo.consultarObjetoDeUsuario(u, o.nombreObjeto));
    }

    @Test
    public void consultarUsuarioTest() throws UsuarioNoExisteException{

        nombre = "BadName";
        Assertions.assertThrows(UsuarioNoExisteException.class, () -> {miMundo.consultarUsuario(nombre);});

        nombre = "pol";
        userEsperado = new Usuario("pol", "1234", 10, 20, 30, 40);
        objeto = new Objeto("espada", "samurai", "espada para luchar contra los enemigos", 500, 350);
        userEsperado.listaObjetos.add(objeto);

        Usuario userReturned = miMundo.consultarUsuario(nombre);
        userReturned.usuarioEsIgual(userEsperado);
    }

    @Test
    public void consultarObjetoDeUsuarioTest() throws UsuarioNoExisteException, UsuarioSinObjetosException, ObjetoNoEncontradoException{

        nombre = "BadName";
        Assertions.assertThrows(UsuarioNoExisteException.class, () -> {miMundo.consultarUsuario(nombre);});

        // Falla!!
        Usuario user = miMundo.consultarUsuario("marc");
        Assertions.assertThrows(UsuarioSinObjetosException.class, () -> {miMundo.consultarObjetoDeUsuario(user.nombre, "espada");});

        nombre = "pol";
        Usuario user2 = miMundo.consultarUsuario(nombre);
        Assertions.assertThrows(ObjetoNoEncontradoException.class, () -> {miMundo.consultarObjetoDeUsuario(nombre, "puñal");});

        objetoEsperado = new Objeto("espada", "samurai", "espada para luchar contra los enemigos", 500, 350);
        Objeto objetoReturned = miMundo.consultarObjetoDeUsuario(nombre,user2.listaObjetos.get(0).nombreObjeto);
        assertTrue(objetoEsperado.objetoEsIgual(objetoReturned));

    }

    @Test
    public void consultarObjetosDeUsuarioTest() throws ListaObjetosVaciaException, UsuarioNoExisteException{
        nombre = "BadName";
        Assertions.assertThrows(UsuarioNoExisteException.class, () -> { miMundo.consultarObjetosDeUsuario(nombre);});

        nombre = "marc";
        Assertions.assertThrows(ListaObjetosVaciaException.class, () -> { miMundo.consultarObjetosDeUsuario(nombre);});

        nombre = "pol";
        Usuario user = miMundo.consultarUsuario(nombre);
        List<Objeto> listaObjetosReturned = miMundo.consultarObjetosDeUsuario(nombre);
        assertTrue(user.listaEsIgual(listaObjetosReturned));

    }

    @Test
    public void transferirObjetoEntreUsuariosTest() throws UsuarioNoExisteException, UsuarioSinObjetosException, ObjetoNoEncontradoException{

        origen = "pol";
        destino = "marc";
        nombreObjeto = "espada";

        Assertions.assertThrows(UsuarioNoExisteException.class, () -> {miMundo.transferirObjetoEntreUsuarios("BadName", destino, nombreObjeto);});
        Assertions.assertThrows(UsuarioSinObjetosException.class, () -> {miMundo.transferirObjetoEntreUsuarios("marc", origen, nombreObjeto);});
        Assertions.assertThrows(ObjetoNoEncontradoException.class, () -> {miMundo.transferirObjetoEntreUsuarios("pol", "marc", "Arco");});

        miMundo.transferirObjetoEntreUsuarios(origen, destino, nombreObjeto);
        Usuario user = miMundo.consultarUsuario(origen);
        Usuario user2 = miMundo.consultarUsuario(origen);
        assertTrue(user.listaObjetos.isEmpty());

    }

    @Test
    public void eliminarObjetosDeUsuarioTest() throws UsuarioNoExisteException, UsuarioSinObjetosException {

        nombre = "pol";
        nombreObjeto = "espada";

        Assertions.assertThrows(UsuarioNoExisteException.class, () -> {miMundo.eliminarObjetosDeUsuario("BadName");});
        Assertions.assertThrows(UsuarioSinObjetosException.class, () -> {miMundo.eliminarObjetosDeUsuario("marc");});

        assertTrue(miMundo.eliminarObjetosDeUsuario(nombre));

        Assertions.assertThrows(UsuarioSinObjetosException.class, () -> {miMundo.eliminarObjetosDeUsuario(nombre);});
    }

    @Test
    public void eliminarUsuarioTest() throws UsuarioNoExisteException{

        nombre = "pol";

        Assertions.assertThrows(UsuarioNoExisteException.class, () -> {miMundo.eliminarUsuario("BadName");});

        assertTrue(miMundo.eliminarUsuario(nombre));

        Assertions.assertThrows(UsuarioNoExisteException.class, () -> {miMundo.eliminarObjetosDeUsuario(nombre);});
    }



}
