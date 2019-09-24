/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Propietario
 */
public class conexionbd {
    
    protected Connection conectar(){
        
        String host = "localhost";
        String puerto = "1433";
        String databaseName="testPokedexDB";
        String user = "testPokedex";
        String contra = "1234";
        
                
        try {
        //    host="127.0.0.1";
            String cadenaconexion ="jdbc:sqlserver://"+host+":"+puerto+";databaseName="+databaseName;
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            } catch (ClassNotFoundException e) {
                System.out.println("Problemas con Driver: "+e.getMessage());
            }
            return DriverManager.getConnection(cadenaconexion, user, contra);
        } catch (SQLException e) {
            System.out.println("Problemas para establecer la conexion: "+e.getMessage());
            return null;
        }
    }
    
    public boolean ejecutarSQLInsertUpdateDelete(String sql){
        Connection en;
        Statement st;
            try {
                en=conectar();
                st = en.createStatement();
                st.execute(sql);
                en.close();
                return true;
            } catch (SQLException e) {
                System.out.println("No se pudo realizar la sentencia SQL: "+sql+"\nERROR: "+e.getMessage());
                return false;
            }
    }
    
    public ResultSet ejecutarSQLQuery(String sql, Connection en, Statement st){
            try {
                en=conectar();
                st = en.createStatement();
                ResultSet res = st.executeQuery(sql);
                
                return res;
            } catch (SQLException e) {
                System.out.println("No se pudo realizar la sentencia SQL: "+sql+"\nERROR: "+e.getMessage());
                return null;
            }
    }
    
    public void cerrarCosa(Connection en, Statement st) throws SQLException{
        //     st.close();
//     en.close();
   
    }
}
