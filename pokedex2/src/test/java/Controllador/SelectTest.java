/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllador;

import com.sun.xml.bind.v2.model.core.ID;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
public class SelectTest {
    
    public SelectTest() {
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
     * Test of obtenerUltimoPokemonCreado method, of class Select.
     */
    @Test
    public void testObtenerUltimoPokemonCreado() throws SQLException {
        System.out.println("obtenerUltimoPokemonCreado");
        Select instance = new Select();
        ResultSet expResult = null;
        ResultSet result = instance.obtenerUltimoPokemonCreado();
        //OBTENER ULTIMO POKEMON CREADO ES TESTPOKEDEX DE ID: 34
        int id = -1;
        while(result.next()){
            id = result.getInt(1);
            System.out.println("ID: "+ String.valueOf(id));
        }
        assertEquals(34, id);
        instance.cerrarConsulta();
    }

    /**
     * Test of todosLosUser method, of class Select.
     */
    @Test
    public void testTodosLosUser() throws SQLException {
        System.out.println("todosLosUser");
        Select instance = new Select();
        ResultSet expResult = null;
        ResultSet result = instance.todosLosUser();
        
        //SOLO HAY 2 USERS, MAESTRO (ID:1) Y CHICO (ID:2)
        boolean resTotal = false;
        boolean res1 = false;
        boolean res2 = false;
        int i =0;
        while(result.next()){
            if(i==0){
                if(result.getInt(1)==1 && result.getString(2).equals("Maestro")){
                res1=true;
                }
            } else if(i==1){
                if(result.getInt(1)==2 && result.getString(2).equals("Chico")){
                res2=true;
            } else {
                res2 = false;
                }
            }
            i++;
        }
        assertTrue(res1);
        assertTrue(res2);
            if(res1==true && res2==true){
                resTotal= true;
            }
            assertTrue(resTotal);
            instance.cerrarConsulta();
    }

    /**
     * Test of existeNombreDeUser method, of class Select.
     
    @Test
    public void testExisteNombreDeUser() {
        System.out.println("existeNombreDeUser");
        String nombre = "";
        Select instance = new Select();
        ResultSet expResult = null;
        ResultSet result = instance.existeNombreDeUser(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        instance.cerrarConsulta();
    }
*/
    /**
     * Test of getNombreUser method, of class Select.
     */
    @Test
    public void testGetNombreUser() throws SQLException {
        System.out.println("getNombreUser");
        int id = 0;
        Select instance = new Select();
        ResultSet expResult = null;
        ResultSet result = instance.getNombreUser(1);
        String nombre = "|";
        while(result.next()){
            nombre = result.getString(1);
        }
        assertEquals("Maestro", nombre);
        instance.cerrarConsulta();
    }

    /**
     * Test of todosLosPokemones method, of class Select.
     */
    /*
    @Test
    public void testTodosLosPokemones() {
        System.out.println("todosLosPokemones");
        Select instance = new Select();
        ResultSet expResult = null;
        ResultSet result = instance.todosLosPokemones();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of obtenerDatoDe1PokemonDe1User method, of class Select.
     */
    /*
    @Test
    public void testObtenerDatoDe1PokemonDe1User() {
        System.out.println("obtenerDatoDe1PokemonDe1User");
        int pok_x_user_ID = 0;
        Select instance = new Select();
        ResultSet expResult = null;
        ResultSet result = instance.obtenerDatoDe1PokemonDe1User(1);
        while(result.next()){
            nombre = result.getString(1);
        }
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
   
    /*
    @Test
    public void testTodosLosPokemonesConSuTipo() {
        System.out.println("todosLosPokemonesConSuTipo");
        Select instance = new Select();
        ResultSet expResult = null;
        ResultSet result = instance.todosLosPokemonesConSuTipo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
    @Test
    public void testTodosLosTipos() {
        System.out.println("todosLosTipos");
        Select instance = new Select();
        ResultSet expResult = null;
        ResultSet result = instance.todosLosTipos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    @Test
    public void testTodasLasHabilidades() {
        System.out.println("todasLasHabilidades");
        Select instance = new Select();
        ResultSet expResult = null;
        ResultSet result = instance.todasLasHabilidades();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

 
    @Test
    public void testTodosLosPokemonesDe1User() {
        System.out.println("todosLosPokemonesDe1User");
        int user = 0;
        Select instance = new Select();
        ResultSet expResult = null;
        ResultSet result = instance.todosLosPokemonesDe1User(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    @Test
    public void testTodosLosTipoDe1Pokemon() {
        System.out.println("todosLosTipoDe1Pokemon");
        int pokemon = 0;
        Select instance = new Select();
        ResultSet expResult = null;
        ResultSet result = instance.todosLosTipoDe1Pokemon(pokemon);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testTodasLasHabilidadesDe1PokemonDeUser() {
        System.out.println("todasLasHabilidadesDe1PokemonDeUser");
        int pokemonDeUser = 0;
        Select instance = new Select();
        ResultSet expResult = null;
        ResultSet result = instance.todasLasHabilidadesDe1PokemonDeUser(pokemonDeUser);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    @Test
    public void testObtenerPokemonSegunIDPokemon_x_user() {
        System.out.println("obtenerPokemonSegunIDPokemon_x_user");
        int pokemon_x_user = 0;
        Select instance = new Select();
        ResultSet expResult = null;
        ResultSet result = instance.obtenerPokemonSegunIDPokemon_x_user(pokemon_x_user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testObtenerTodasLasEvolucionesDe1PokemonXNombre() {
        System.out.println("obtenerTodasLasEvolucionesDe1PokemonXNombre");
        String nombre = "";
        Select instance = new Select();
        ResultSet expResult = null;
        ResultSet result = instance.obtenerTodasLasEvolucionesDe1PokemonXNombre(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    @Test
    public void testObtenerTodasLasEvolucionesDe1Pokemon() {
        System.out.println("obtenerTodasLasEvolucionesDe1Pokemon");
        int pokemon_id = 0;
        Select instance = new Select();
        ResultSet expResult = null;
        ResultSet result = instance.obtenerTodasLasEvolucionesDe1Pokemon(pokemon_id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    @Test
    public void testEjecutarSQL() {
        System.out.println("ejecutarSQL");
        String sql = "";
        Select instance = new Select();
        ResultSet expResult = null;
        ResultSet result = instance.ejecutarSQL(sql);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testCerrarConsulta() throws Exception {
        System.out.println("cerrarConsulta");
        Select instance = new Select();
        instance.cerrarConsulta();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
}
