/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllador;

/**
 *
 * @author Propietario
 */
public class actualizar extends operacionesActualizarAniadirEliminar {
    public actualizar(){
        super();
    }
    
    public boolean ActualizarEvolucionAPokemon(int id_pokemon, int id_evolucion, int nivel){
       return realiarProcedure(exe.ActualizarEvolucionAPokemon(id_pokemon, id_evolucion, nivel));
    }
    
    public boolean AumentarNivelPokemon(int id_pokemon_dE_user, int nuevoNivel){
        return realiarProcedure(exe.AumentarNivelPokemon(id_pokemon_dE_user, nuevoNivel));
    }
}
