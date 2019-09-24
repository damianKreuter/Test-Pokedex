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
public class eliminar extends operacionesActualizarAniadirEliminar {
    public eliminar(){
        super();
    }
    
    public boolean EliminarHabilidadAPokemon(int id_pokemon_x_user, String nombreHabilidad){
       return realiarProcedure(exe.EliminarHabilidadAPokemon(id_pokemon_x_user, nombreHabilidad));
    }
    
    public boolean EliminarTipoAPokemon(int id_pokemon, int id_tipo){
       return realiarProcedure(exe.EliminarTipoAPokemon(id_pokemon, id_tipo));
    }
    
    public boolean EliminarPokemonDeUsuario(int id_pokemonDeUser){
       return realiarProcedure(exe.EliminarPokemonDeUsuario(id_pokemonDeUser));
    }
    
    public boolean EliminarUsuario(int id_user){
       return realiarProcedure(exe.EliminarUsuario(id_user));
    }

    public boolean EliminarEvolucionAPokemon(int id_pok, int id_evol){
       return realiarProcedure(exe.EliminarEvolucionAPokemon(id_pok, id_evol));
    }
    
}
