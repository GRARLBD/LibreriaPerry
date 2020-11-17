/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.libreria.gral.system.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import utiles.Utiles;

/**
 *
 * @author KEVIN
 */
public class Factura {
    
    private Integer id;
    private String codigoFactura;
    private String cliente;
    private Date fecha;
    private List<Salida> listaSalidas;
    private String totalFactura;
    private String vuelto;
    private String pago;
    private boolean estado;

    public Factura() {
        id = -1;
        cliente = "";
        fecha = generarFecha();
        listaSalidas = new ArrayList<>();
        totalFactura = "";
        vuelto = "";
        pago = "";
        estado = false;
        codigoFactura = "";
    }

    public Factura(Integer id, String codigoFactura, String cliente, Date fecha, List<Salida> listaSalidas, String totalFactura, String vuelto, String pago, boolean estado) {
        this.id = id;
        this.codigoFactura = codigoFactura;
        this.cliente = cliente;
        this.fecha = fecha;
        this.listaSalidas = listaSalidas;
        this.totalFactura = totalFactura;
        this.vuelto = vuelto;
        this.pago = pago;
        this.estado = estado;
    }
    
     public Factura(String codigoFactura, String cliente, Date fecha, List<Salida> listaSalidas, String totalFactura, String vuelto, String pago) {
        this.id = -1;
        this.codigoFactura = codigoFactura;
        this.cliente = cliente;
        this.fecha = fecha;
        this.listaSalidas = listaSalidas;
        this.totalFactura = totalFactura;
        this.vuelto = vuelto;
        this.pago = pago;
        this.estado = false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(String codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Salida> getListaSalidas() {
        return listaSalidas;
    }

    public void setListaSalidas(List<Salida> listaSalidas) {
        this.listaSalidas = listaSalidas;
    }

    public String getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(String totalFactura) {
        this.totalFactura = totalFactura;
    }

    public String getVuelto() {
        return vuelto;
    }

    public void setVuelto(String vuelto) {
        this.vuelto = vuelto;
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void generarCodigo() {
        String fecha = Utiles.toStringM1(getFecha());

        codigoFactura = "factura " + fecha;;
    }
        
    private Date generarFecha()
    {
        Date tiempo = Calendar.getInstance().getTime();
        Calendar c = Calendar.getInstance();
        
        c.setTime(tiempo);
        c.set(Calendar.MILLISECOND, 0);
        Date newDate = c.getTime();
        
        return newDate;
    }
    
    @Override
    public String toString() {
        return "Factura{" + "id=" + id + ", codigoFactura=" + codigoFactura + ", cliente=" + cliente + ", fecha=" + fecha + ", listaSalidas=" + listaSalidas + ", totalFactura=" + totalFactura + ", vuelto=" + vuelto + ", pago=" + pago + '}';
    }
}
