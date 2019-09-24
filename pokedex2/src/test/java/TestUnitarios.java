/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Controllador.Select;
import Controllador.aniadir;
import Controllador.eliminar;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Propietario
 */
public class TestUnitarios {
    
    public TestUnitarios() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    
    /*
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }
*/

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void agregarNuevoPokemonAUser() throws SQLException{
        aniadir a = new aniadir();
        
        a.aniadirNuevoPokemonAUser(1, 15, 50);
        //EL POKEMON CON ID 15 ES Pidgey 
        Select s = new Select();
        ResultSet res = s.todosLosPokemonesDe1User(1);
        String nombrePokemon="";
        boolean resultado = false;
        while(res.next()){
            if(res.getString(2).contains("Pidgey")){
                //ESTO ES CORRECTO
                resultado = true;
                break;
            }
        }
        s.cerrarConsulta();
        assertTrue(resultado);
    }
    
    @Test
    public void quitarNuevoPokemonAUser() throws SQLException{
        //VOY A QUITAR EL ULTIMO POKEMON AGREGADO EN EL TEST ANTERIOR
        
        //EL ULTIMO POKEMON INGRESADO TIENE COMO ID 12 ASI QUE SACO ESE
        eliminar e = new eliminar();
        e.EliminarPokemonDeUsuario(12);
        Select s = new Select();
        ResultSet res = s.todosLosPokemonesDe1User(1);
        boolean resultado = true;
        while(res.next()){
            if(res.getString(2).contains("Pidgey")){
                //ESTO ES CORRECTO
                resultado = false;
                break;
            }
        }
        s.cerrarConsulta();
        assertTrue(resultado);
    }
}
