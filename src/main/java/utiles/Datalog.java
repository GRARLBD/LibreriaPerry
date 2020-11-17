/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

import com.mycompany.libreria.gral.system.model.Inventario;

/**
 *
 * @author Kevin
 */
public class Datalog {
    private Inventario inv;
    private int cantidad;

    public Datalog(Inventario inv, int cantidad) {
        this.inv = inv;
        this.cantidad = cantidad;
    }

    public Inventario getInv() {
        return inv;
    }

    public void setInv(Inventario inv) {
        this.inv = inv;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Datalog{" + "inv=" + inv + ", cantidad=" + cantidad + '}';
    }    
}
