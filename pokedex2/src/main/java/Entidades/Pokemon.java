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
public class Pokemon {
    private int id;
    private String nombre;
    private String tiposEnString;
    private ArrayList<Tipo>tipos;
    
    public Pokemon(int id, String nombre, String tipoEnString, ArrayList<Tipo>tipos){
        this.id=id;
        this.tiposEnString=tipoEnString;
        this.nombre=nombre;
        this.tipos=tipos;
    }

    public String getTipoEnString(){
        return this.tiposEnString;
    }
    
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the tipos
     */
    public ArrayList<Tipo> getTipos() {
        return tipos;
    }

    /**
     * @param tipos the tipos to set
     */
    public void setTipos(ArrayList<Tipo> tipos) {
        this.tipos = tipos;
    }
    
    
}
