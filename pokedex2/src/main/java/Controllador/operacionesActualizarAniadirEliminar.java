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
public class operacionesActualizarAniadirEliminar {
    protected execs exe;
    public operacionesActualizarAniadirEliminar(){
        exe = new execs();
    }
    
    
    protected boolean realiarProcedure(String procedure){
       conexionbd object = new conexionbd();
       if(object.ejecutarSQLInsertUpdateDelete(procedure)){
            System.out.println("SE REALIZÓ LA OPERACIÓN");
        } else {
            System.out.println("Hubo un erro al intentar realizar la operacion");
        }
       return true;
    } 
}
