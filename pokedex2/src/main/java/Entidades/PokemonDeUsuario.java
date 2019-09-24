/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;

/**
 *
 * @author Propietario
 */
public class PokemonDeUsuario {
    private String pokemon;
    private int idUser;
    private int nivel;

    public PokemonDeUsuario(int id, String nombre, int nivel){
        this.pokemon= new String(nombre);
        this.idUser=id;
        this.nivel=nivel;
    }
    
    public int getNivel(){
        return nivel;
    }

    public String getPokemon() {
        return pokemon;
    }

    public int getIdUser() {
        return idUser;
    }

}
