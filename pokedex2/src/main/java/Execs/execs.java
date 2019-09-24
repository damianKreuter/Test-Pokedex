/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Execs;

/**
 *
 * @author Propietario
 */
public class execs {
    public execs(){}
    
    private String exe ="EXEC [pokedexSchema].";
    
    public String AniadirUser(String nombre){
        return exe+"crearUsuario '"+nombre+"'";
    }
    
    public String AniadirPokemonAUser(int idPokemon, int idUser, int nivel){
        return exe+"AniadirNuevoPokemonAUser "+idPokemon+", "+idUser+", "+nivel;
    }
    
    public String AnaidirNuevoTipoAPokemon(int idPokemon, int idTipo){
        return exe+"AnaidirNuevoTipoAPokemon "+idPokemon+", "+idTipo;
    }
    
    public String AniadirNuevoHabilidadAPokemon(int idPokDeUser, int idHabilidad){
        return exe+"AnaidirNuevoHabilidadAPokemon "+idPokDeUser+", "+idHabilidad;
    }
    
    public String AniadirEvolucionAPokemon(int pokemon, int evolucion, int nivel){
        return exe+"AniadirEvolucionAPokemon "+pokemon+", "+evolucion+", "+nivel;
    }
    
    public String EliminarHabilidadAPokemon(int idPokDeUser, String nombreHabilidad){
        return exe+"EliminarHabilidadAPokemon "+idPokDeUser+", '"+ nombreHabilidad+"'";
    }
    
    public String EliminarTipoAPokemon(int idp, int idt){
        return exe+"EliminarTipoAPokemon "+idp+", "+idt;
    }

    public String EliminarPokemonDeUsuario(int idPokemonDeUser){
        return exe+"EliminarPokemonDeUsuario "+idPokemonDeUser;
    }
    
    public String EliminarUsuario(int iduser){
        return exe+"EliminarUsuario "+iduser;
    }
    
    public String EliminarEvolucionAPokemon(int pokemon, int evolucion){
        return exe+"EliminarEvolucionAPokemon "+pokemon+", "+evolucion;
    }
    
    public String ActualizarEvolucionAPokemon(int pokemon, int evolucion, int nivel){
        return exe+"ActualizarEvolucionAPokemon "+pokemon+", "+evolucion+", "+nivel;
    }
    
    public String AumentarNivelPokemon(int pokemon, int nivel){
        return exe+"AumentarNivelPokemon "+pokemon+", "+nivel;
    }

    public String CrearNuevoPokemon(String nombre){
        return exe+"CrearNuevoPokemon "+nombre;
    }
}
