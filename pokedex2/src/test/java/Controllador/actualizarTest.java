/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllador;

import java.sql.ResultSet;
import java.sql.SQLException;
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
public class actualizarTest {
    
    public actualizarTest() {
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
     * Test of ActualizarEvolucionAPokemon method, of class actualizar.
     */
    @Test
    public void testActualizarEvolucionAPokemon() throws SQLException {
        System.out.println("ActualizarEvolucionAPokemon");
        int id_pokemon = 0;
        int id_evolucion = 0;
        int nivel = 0;
        actualizar instance = new actualizar();
        boolean expResult = false;
        //ACTUALIZO EL NIVEL REQUERIDO PARA EVOLUCIONAR DE DRAGONAIR A DRAGONITE A NIVEL 100
        boolean result = instance.ActualizarEvolucionAPokemon(32, 33, 100);
        assertTrue(result);
        int i=0;
        if(result){
            result= false;
            Select s = new Select();
            ResultSet res = s.obtenerTodasLasEvolucionesDe1Pokemon(32);
            while(res.next()){
                i=res.getInt(3);
            }
            s.cerrarConsulta();
        }
        if(i==100){
            result=true;
        }
        assertTrue(result);
    }

    /**
     * Test of AumentarNivelPokemon method, of class actualizar.
     */
    @Test
    public void testAumentarNivelPokemon() throws SQLException {
        System.out.println("AumentarNivelPokemon");
        int id_pokemon_dE_user = 0;
        int nuevoNivel = 0;
        actualizar instance = new actualizar();
        boolean expResult = false;
        boolean result = instance.AumentarNivelPokemon(11, 100);
        assertTrue(result);
        int i=0;
        if(result){
            result= false;
            Select s = new Select();
            ResultSet res = s.obtenerDatoDe1PokemonDe1User(11);
            while(res.next()){
                i=res.getInt(2);
            }
            s.cerrarConsulta();
        }
        if(i==100){
            result=true;
        }
        assertTrue(result);
    }
    
}
