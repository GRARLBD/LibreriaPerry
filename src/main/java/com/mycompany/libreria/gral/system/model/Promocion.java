/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.libreria.gral.system.model;

import java.math.BigDecimal;

/**
 *
 * @author Kevin
 */
public class Promocion{
    private int id;
    private BigDecimal precioVenta;
    private int cantUndProm;

    public Promocion() {
        id = -1;
        precioVenta = new BigDecimal(0);
        cantUndProm = 0;
    }

    public Promocion(int id, BigDecimal precioVenta, int cantUndProm) {
        this.id = id;
        this.precioVenta = precioVenta;
        this.cantUndProm = cantUndProm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getCantUndProm() {
        return cantUndProm;
    }

    public void setCantUndProm(int cantUndProm) {
        this.cantUndProm = cantUndProm;
    }

    @Override
    public String toString() {
        return "Promocion{" + "id=" + id + ", precioVenta=" + precioVenta + ", cantUndProm=" + cantUndProm + '}';
    }
}
