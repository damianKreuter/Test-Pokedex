/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllador;

import Entidades.PokemonDeUsuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Propietario
 */
public class aniadirTest {
    
    /*
        IMPORTANTE!!!!!!
    
        En estos test se analizan 2 cosas, la creación de nuevo elemento y
        luego lo elimino, chequeando si se realizó en ambos casos
    */
    
    public aniadirTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of aniadirNuevoPokemonAUser method, of class aniadir.
     */
    @Test
    public void testAniadirNuevoPokemonAUser() throws SQLException {
        System.out.println("aniadirNuevoPokemonAUser");
        int id_pokemon = 0;
        int id_user = 0;
        int nivel = 0;
        /*TEST:
            Añado el pokemon DRAGONITE (ID:33) a MAESTRO (ID:1)
            Deberia ser el pok_x_user_ID es 12
        */
        
        aniadir instance = new aniadir();
        boolean expResult = false;
        boolean result = instance.aniadirNuevoPokemonAUser(33, 1, 50);
        if(result){
            System.out.println("Se añadió DRAGONITE A MAESTRO (LVL:50)");
            Select s = new Select();
            ResultSet res = s.obtenerPokemonSegunIDPokemon_x_user(12);
            while(res.next()){
                id_pokemon= res.getInt(1);
                System.out.println("ID OBTENIDO: "+ String.valueOf(id_pokemon));
            }
            s.cerrarConsulta();
            if(id_pokemon==33){
                result=false;
            }
        }
        assertFalse(result);
        eliminar e = new eliminar();
        result = e.EliminarPokemonDeUsuario(12);
        boolean seElimino = true;
        if(result){
            Select s = new Select();
            ResultSet res = s.obtenerPokemonSegunIDPokemon_x_user(12);
            while(res.next()){
                if(res.getInt(1)==12){
                    seElimino= false;
                    System.out.println("No se eliminó DRAGONITE A MAESTRO (LVL:50)");
                }
            }
            s.cerrarConsulta();
        }
        assertTrue(seElimino);
                // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of aniadirNuevaTipoAPokemon method, of class aniadir.
     */
    @Test
    public void testAniadirNuevaTipoAPokemon() throws SQLException {
        System.out.println("aniadirNuevaTipoAPokemon");
        int id_pokemon = 0;
        int id_tipo = 0;
        aniadir instance = new aniadir();
        boolean expResult = false;
        //AÑADO A DRAGONITE (33) QUE SEA DE TIPO PLANTA (IDTIPO: 1)
        boolean result = instance.aniadirNuevaTipoAPokemon(33, 1);
        if(result){
            System.out.println("Se añadió nuevo tipo PLANTA a DRAGONITE");
            Select s = new Select();
            ResultSet res = s.todosLosTipoDe1Pokemon(33);
            while(res.next()){
                if(res.getString(2).contains("Planta")) {
                    id_tipo= res.getInt(1);
                    System.out.println("DRAGONITE es de tipo PLANTA");
                }
            }
            s.cerrarConsulta();
        }
        if(id_tipo!=1){
            result= false;
        }
        assertTrue(result);
        eliminar e = new eliminar();
        result = e.EliminarTipoAPokemon(33, 1);
        if(result){
            expResult= true;
            Select s = new Select();
            ResultSet res = s.todosLosTipoDe1Pokemon(33);
            while(res.next()){
                if(res.getInt(1)==1){
                    expResult= false;
                    System.out.println("NO SE ELIMINO el nuevo tipo PLANTA a DRAGONITE");
                }
            }
            s.cerrarConsulta();
        }
        assertTrue(expResult);
    }

    /**
     * Test of AniadirUser method, of class aniadir.
     */
    @Test
    public void testAniadirUser() throws SQLException {
        System.out.println("AniadirUser");
        String nombre = "";
        aniadir instance = new aniadir();
        boolean expResult = true;
        boolean result = instance.AniadirUser("TEST");
        assertEquals(expResult, result);
        if(result){
            System.out.println("Se añadió el user TEST");
            result= false;
            Select s = new Select();
            ResultSet res = s.todosLosUser();
            while(res.next()){
                if(res.getString(2).contains("TEST")){
                    result = true;
                }
            }
            s.cerrarConsulta();
        }
        assertEquals(expResult, result);
        eliminar e = new eliminar();
        result = e.EliminarUsuario(3);
        if(result){
            result = false;
            Select s = new Select();
            ResultSet res = s.todosLosUser();
            while(res.next()){
                if(res.getString(1).contains("TEST")){
                    result = true;
                    System.out.println("No se eliminó el usuario TEST");
                }
            }
            s.cerrarConsulta();
        }
        assertFalse(result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of AniadirNuevoHabilidadAPokemon method, of class aniadir.
     */
    @Test
    public void testAniadirNuevoHabilidadAPokemon() throws SQLException {
        System.out.println("AniadirNuevoHabilidadAPokemon");
        int id_pokemon = 0;
        int id_habilidad = 0;
        aniadir instance = new aniadir();
        boolean expResult = false;
        //AÑADO A PRIMEAPE (25) DEL USER MAESTRO(1) [POKEMON_X_USER=1] LA HABILIDAD TERROR (14)  Y SE LA QUITO
        boolean result = instance.AniadirNuevoHabilidadAPokemon(1, 14);
        assertEquals(true, result);
        if(result){
            
            result= false;
            Select s = new Select();
            ResultSet res = s.todasLasHabilidadesDe1PokemonDeUser(1);
            while(res.next()){
                if(res.getString(1).contains("Terror")){
                    System.out.println("Se agregó a PRIMEAPE la habilidad TERROR");
                    result = true;
                }
            }
            s.cerrarConsulta();
        }
        assertTrue(result);
        eliminar e = new eliminar();
        result = e.EliminarHabilidadAPokemon(1, "Terror");
        if(result){
            result= true;
            Select s = new Select();
            ResultSet res = s.todasLasHabilidadesDe1PokemonDeUser(1);
            while(res.next()){
                if(res.getString(1).contains("Terror")){
                    System.out.println("No se eliminó a PRIMEAPE la habilidad TERROR");
                    result = false;
                }
            }
            s.cerrarConsulta();
        }
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of AniadirEvolucionAPokemon method, of class aniadir.
     */
    @Test
    public void testAniadirEvolucionAPokemon() throws SQLException {
        System.out.println("AniadirEvolucionAPokemon");
        String nombre_pok_a_evolucionar = "/";
        int id_pok_a_evolucionar = 0;
        int nivel = 0;
        aniadir instance = new aniadir();
        boolean expResult = true;
        //BULBASUR (1) SE PODRÁ EVOLUCIONAR A DRAGONITE (33) A NIVEL 80
        boolean result = instance.AniadirEvolucionAPokemon(1, 33, 80);
        assertTrue(result);
        if(result){
            result= false;
            Select s = new Select();
            ResultSet res = s.obtenerTodasLasEvolucionesDe1Pokemon(1);
            while(res.next()){
                if(id_pok_a_evolucionar <res.getInt(1)){
                    nombre_pok_a_evolucionar = res.getString(2);
                    nivel = res.getInt(3);
                    id_pok_a_evolucionar = res.getInt(1);
                }
            }
            s.cerrarConsulta();
            if(id_pok_a_evolucionar==33){
                result=true;
                System.out.println("EXISTE LA EVOLUCION BULBASUR -> DRAGONITE (LVL:80)");
            }
        }
        assertTrue(result);
        eliminar e = new eliminar();
        result = e.EliminarEvolucionAPokemon(1, 33);
        if(result){
            result= false;
            Select s = new Select();
            ResultSet res = s.obtenerTodasLasEvolucionesDe1Pokemon(1);
            id_pok_a_evolucionar=0;
            while(res.next()){
                if(id_pok_a_evolucionar <res.getInt(1)){
                    id_pok_a_evolucionar = res.getInt(1);
                    System.out.println("Siguiente a eolucionar ID: "+ String.valueOf(id_pok_a_evolucionar));
                }
            }
            s.cerrarConsulta();
        }
        if(id_pok_a_evolucionar==2){
            result=true;
        }
        assertTrue(result);
        System.out.println("SE ELIMINO LA EVOLUCION BULBASUR -> DRAGONITE (LVL:80)");
    }

    /**
     * Test of CrearNuevoPokemon method, of class aniadir.
     */
    @Test
    public void testCrearNuevoPokemon() throws SQLException {
        System.out.println("CrearNuevoPokemon");
        String nombre = "";
        aniadir instance = new aniadir();
        boolean expResult = false;
        boolean result = instance.CrearNuevoPokemon("TESPOKEMON");
        assertEquals(true, result);
        if(result){
            result = false;
            int ultimo_id =0;
            System.out.println("Se creó el pokemon TESPOKEMON");
            Select s = new Select();
            ResultSet res = s.obtenerUltimoPokemonCreado();
            while(res.next()){
                    ultimo_id = res.getInt(1);
            }
            s.cerrarConsulta();
            s = new Select();
            res = s.todosLosPokemones();
            while(res.next()){
                if(ultimo_id==res.getInt(1)){
                    if(res.getString(2).contains("TESPOKEMON")){
                        System.out.println("Se creó TESPOKEMON satisfactoriamente");
                        result = true;
                    }
                }
            }
            s.cerrarConsulta();
        }
        assertTrue(result);

        // TODO review the generated test code and remove the default call to fail.
    }
    
}
