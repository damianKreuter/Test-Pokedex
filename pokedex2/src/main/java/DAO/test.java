/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controllador.Select;
import Entidades.Usuarios;
import java.sql.ResultSet;
import Vistas.principal;
import java.sql.SQLException;

/**
 *
 * @author Propietario
 */
public class test {
    public static void main(String[] args) throws SQLException{
       /*
        conexionbd object = new conexionbd();
        String sql = "EXEC [pokedexSchema].crearUsuario 'Brock'";
    
        if(object.ejecutarSQLInsertUpdateDelete(sql)){
            System.out.println("SE REALIZÓ LA OPERACIÓN");
        } else {
            System.out.println("Hubo un erro al intentar realizar la operacion");
        }
        
  //      principal vista = new principal();
//        vista.activar();
        sql = "SELECT * FROM [pokedexSchema].User_pokemon";
        Select select = new Select();
        ResultSet res = select.ejecutarSQL(sql);
         while(res.next()){
             System.out.println("NRO: "+res.getInt(1)+", Nombre: "+ res.getString(2));
     //       comboUsuarios.addItem(new Usuarios(res.getInt(1), res.getString(2)));
        }
        
        res = select.todosLosPokemones();
         while(res.next()){
             System.out.println("NRO: "+res.getInt(1)+", Nombre: "+ res.getString(2));
     //       comboUsuarios.addItem(new Usuarios(res.getInt(1), res.getString(2)));
        }
        select.cerrarConsulta();
        */
        principal vista = new principal();
        vista.activar();
        return;
    }
}
