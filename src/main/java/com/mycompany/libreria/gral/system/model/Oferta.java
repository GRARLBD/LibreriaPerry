/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.libreria.gral.system.model;

import java.math.BigDecimal;
import java.util.Random;

/**
 *
 * @author Kevin
 */
public class Oferta {
    
    private int id;
    private String codigo;
    private String codigoLote;
    private String descripcion;
    private int unidOfert;
    private BigDecimal precioVenta;
    private BigDecimal totalVenta;
    private BigDecimal totalGanancia;
    private boolean estado;

    public Oferta() {
        id = -1;
        codigoLote = "";
        codigo = "";
        descripcion = "";
        unidOfert = 0;
        precioVenta = new BigDecimal(0);
        totalVenta = new BigDecimal(0);
        totalGanancia = new BigDecimal(0);
        estado = false;
    }    

    public Oferta(int id, String codigoLote, String codigo, String descripcion, int unidOfert, BigDecimal precioVenta, BigDecimal totalVenta, BigDecimal totalGanancia, boolean estado) {
        this.id = id;
        this.codigoLote = codigoLote;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.unidOfert = unidOfert;
        this.precioVenta = precioVenta;
        this.totalVenta = totalVenta;
        this.totalGanancia = totalGanancia;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoLote() {
        return codigoLote;
    }

    public void setCodigoLote(String codigoLote) {
        this.codigoLote = codigoLote;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getUnidOfert() {
        return unidOfert;
    }

    public void setUnidOfert(int unidOfert) {
        this.unidOfert = unidOfert;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    public BigDecimal getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(BigDecimal totalVenta) {
        this.totalVenta = totalVenta;
    }

    public BigDecimal getTotalGanancia() {
        return totalGanancia;
    }

    public void setTotalGanancia(BigDecimal totalGanancia) {
        this.totalGanancia = totalGanancia;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Oferta{" + "id=" + id + ", descripcion=" + descripcion + ", unidOfert=" + unidOfert + ", precioVenta=" + precioVenta + ", totalVenta=" + totalVenta + ", estado=" + estado + '}';
    }
    
    public static String generarCodigo(String codigo) {
        Random r = new Random();
        final int NUM_MAX_OF = 1000;

        String nCodigo = codigo + "-OF" + r.nextInt(NUM_MAX_OF);

        return nCodigo;
    }
}
