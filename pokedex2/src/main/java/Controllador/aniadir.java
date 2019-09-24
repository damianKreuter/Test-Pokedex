/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllador;

import DAO.conexionbd;
import Execs.execs;
/**
 *
 * @author Propietario
 */

public class aniadir extends operacionesActualizarAniadirEliminar {
    public aniadir(){
        super();
    }
    
    public boolean aniadirNuevoPokemonAUser(int id_pokemon, int id_user, int nivel){
       return realiarProcedure(exe.AniadirPokemonAUser(id_pokemon, id_user, nivel));
    }
    
    public boolean aniadirNuevaTipoAPokemon(int id_pokemon, int id_tipo){
       return realiarProcedure(exe.AnaidirNuevoTipoAPokemon(id_pokemon, id_tipo));
    }
    
    public boolean AniadirUser(String nombre){
       return realiarProcedure(exe.AniadirUser(nombre));
    }
    
    public boolean AniadirNuevoHabilidadAPokemon(int id_pokemon, int id_habilidad){
       return realiarProcedure(exe.AniadirNuevoHabilidadAPokemon(id_pokemon, id_habilidad));
    }
    
    public boolean AniadirEvolucionAPokemon(int id_pokemon, int id_pok_a_volucionar, int nivel){
        return realiarProcedure(exe.AniadirEvolucionAPokemon(id_pokemon, id_pok_a_volucionar, nivel));
    }
    
    public boolean CrearNuevoPokemon(String nombre){
        return realiarProcedure(exe.CrearNuevoPokemon(nombre));
    }
    
}



