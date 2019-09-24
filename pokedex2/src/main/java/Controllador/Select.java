/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllador;

import DAO.conexionbd;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Propietario
 */
public class Select {
    Connection en;
    Statement st;
    conexionbd conn;
    public Select(){}
    
    public ResultSet obtenerUltimoPokemonCreado(){
        return ejecutarSQL("SELECT TOP 1 p.pok_id FROM [pokedexSchema].Pokemones p ORDER BY 1 DESC");
    }
    
    public ResultSet todosLosUser(){
        return ejecutarSQL("SELECT u.usuario_id, u.usuario_nombre FROM [pokedexSchema].User_Pokemon u");
    }
    
    public ResultSet existeNombreDeUser(String nombre){
        return ejecutarSQL("SELECT CASE WHEN COUNT(*)>0 THEN '1' ELSE '0'  FROM [pokedexSchema].Pokemones u"
                + " WHERE u.pok_name LIKE '"+nombre+"'");
    }
    
    public ResultSet getNombreUser(int id){
        return ejecutarSQL("SELECT u.usuario_nombre FROM [pokedexSchema].User_Pokemon u"
                + " WHERE usuario_id="+id);
    }
    
    public ResultSet todosLosPokemones(){
        return ejecutarSQL("SELECT p.pok_id, p.pok_name FROM [pokedexSchema].Pokemones p ORDER BY 1");
    }
    
     public ResultSet obtenerDatoDe1PokemonDe1User(int pok_x_user_ID){
        return ejecutarSQL("SELECT p.pok_name, pu.pok_x_user_nivel FROM [pokedexSchema].Pokemones p\n" +
"	JOIN [pokedexSchema].Pokemon_x_users pu ON pu.pok_x_user_pokemonID = p.pok_id \n" +
                "WHERE pu.pok_x_user_ID="+pok_x_user_ID+
"							ORDER BY p.pok_id asc");
    }
    
    public ResultSet todosLosPokemonesConSuTipo(){
        return ejecutarSQL("SELECT p.pok_id, p.pok_name, ObtenerTodosLosTiposDe1Pokemon(p.pol_id)"
                + " FROM [pokedexSchema].Pokemones p");
    }
    
    public ResultSet todosLosTipos(){
        return ejecutarSQL("SELECT tipo_id, tipo_nombre FROM [pokedexSchema].Tipos order by 1");
    }
    
    public ResultSet todasLasHabilidades(){
        return ejecutarSQL("SELECT hab_id, hab_nombre FROM [pokedexSchema].Habilidades");
    }
    
    public ResultSet todosLosPokemonesDe1User(int user){
        return ejecutarSQL("SELECT pu.pok_x_user_ID ,p.pok_name, pu.pok_x_user_nivel FROM [pokedexSchema].Pokemones p\n" +
"	JOIN [pokedexSchema].Pokemon_x_users pu ON pu.pok_x_user_pokemonID = p.pok_id \n" +
"	AND pu.pok_x_user_userID="+user+"\n" +
"							ORDER BY 1");
    }
    
    public ResultSet todosLosTipoDe1Pokemon(int pokemon){
        return ejecutarSQL("SELECT t.tipo_id, t.tipo_nombre FROM [pokedexSchema].Tipos t\n" +
"	JOIN [pokedexSchema].Tipos_x_pokemones tt ON tt.tipo_x_pok_tipoID=t.tipo_id\n" +
"	JOIN [pokedexSchema].Pokemones p ON p.pok_id=tt.tipo_x_pok_pokemonID\n" +
"				AND p.pok_id="+pokemon);
    }
    
    public ResultSet todasLasHabilidadesDe1PokemonDeUser(int pokemonDeUser){
        return ejecutarSQL(
                "SELECT hh.hab_nombre FROM [pokedexSchema].Habilidad_x_pokemones h\n" +
"	JOIN [pokedexSchema].Habilidades hh ON h.hab_X_pok_habilidad_id=hh.hab_id\n" +
"		WHERE h.hab_x_pok_pokemon_de_user_id="+pokemonDeUser);
    }
    
    public ResultSet obtenerPokemonSegunIDPokemon_x_user(int pokemon_x_user){
        return ejecutarSQL("SELECT pok_x_user_pokemonID FROM "
                + "[pokedexSchema].Pokemon_x_users where pok_x_user_ID = "+pokemon_x_user);
    }
    
    
    public ResultSet obtenerTodasLasEvolucionesDe1PokemonXNombre(String nombre){
        return ejecutarSQL("SELECT p.pok_id FROM [pokedexSchema].Pokemones p"
                + " WHERE p.pok_name LIKE '"+nombre+"'");
    }
    
    public ResultSet obtenerTodasLasEvolucionesDe1Pokemon(int pokemon_id){
        return ejecutarSQL("SELECT evol_pok_siguiente_evolucion, p.pok_name, evol_pok_nivel_requerido\n" +
"  FROM [pokedexSchema].Evolucion_Pokemones \n" +
"	JOIN [pokedexSchema].Pokemones p ON p.pok_id=evol_pok_siguiente_evolucion\n" +
"	WHERE evol_pok_pokemonID ="+pokemon_id);
    }
    
    public ResultSet ejecutarSQL(String sql){
        conn = new conexionbd();
        return conn.ejecutarSQLQuery(sql, en, st);
    }
    
    public void cerrarConsulta() throws SQLException{
        conn.cerrarCosa(en, st);
    }
}
