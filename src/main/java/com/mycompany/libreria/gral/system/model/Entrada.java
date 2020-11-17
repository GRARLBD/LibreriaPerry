/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.libreria.gral.system.model;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author KEVIN
 */
public class Entrada{
 
    private Integer id;
    private Inventario inventario;
    private Integer cantidadEntrada;
    private BigDecimal precioCosto;
    private BigDecimal precioVenta;
    private BigDecimal totalCosto;
    private BigDecimal totalVenta;
    private BigDecimal totalGanancia;
    private Date fechaEntrada;
    private boolean estado;

    public Entrada() {
        this.id = -1;
        this.inventario = new Inventario();
        this.cantidadEntrada = 0;
        this.precioCosto = new BigDecimal(0.0);
        this.precioVenta = new BigDecimal(0.0);
        this.totalCosto = new BigDecimal(0.0);
        this.totalVenta = new BigDecimal(0.0);
        this.totalGanancia = new BigDecimal(0.0);
        this.fechaEntrada = null;
        this.estado = false;
    }

    public Entrada(Integer id, Inventario inventario, Integer cantidadEntrada,
            BigDecimal precioCosto, BigDecimal precioVenta,
            BigDecimal totalCosto, BigDecimal totalVenta,
            BigDecimal totalGanancia, Date fechaEntrada, boolean estado) {
        this.id = id;
        this.inventario = inventario;
        this.cantidadEntrada = cantidadEntrada;
        this.precioCosto = precioCosto;
        this.precioVenta = precioVenta;
        this.totalCosto = totalCosto;
        this.totalVenta = totalVenta;
        this.totalGanancia = totalGanancia;
        this.fechaEntrada = fechaEntrada;
        estado = false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public String getCodigo() {
        String codigo = inventario.getProducto().getCodigo();

        return codigo;
    }
    
    public String getDescripcion() {
        String descripcion = inventario.getProducto().getDescripcion();

        return descripcion;
    }
    
    public String getCodigoLote() {
        String codigoLote = inventario.getProducto().getCodigoLote();
        
        return codigoLote;
    }
    
    public Integer getCantidadEntrada() {
        return cantidadEntrada;
    }

    public void setCantidadEntrada(Integer cantidadEntrada) {
        this.cantidadEntrada = cantidadEntrada;
    }

    public BigDecimal getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(BigDecimal precioCosto) {
        this.precioCosto = precioCosto;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    public BigDecimal getTotalCosto() {
        return totalCosto;
    }

    public void setTotalCosto(BigDecimal totalCosto) {
        this.totalCosto = totalCosto;
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

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return "Entrada{" + "id=" + id + ", inventario=" + inventario + ", cantidadEntrada=" + cantidadEntrada + ", precioCosto=" + precioCosto + ", precioVenta=" + precioVenta + ", totalCosto=" + totalCosto + ", totalVenta=" + totalVenta + ", totalGanancia=" + totalGanancia + ", fechaEntrada=" + fechaEntrada + '}';
    }

    public String obtenerFechaFormateada() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm" );
        return dateFormat.format(fechaEntrada);
    }

    public void actualizarDatosEntrada()
    {
        totalCosto = getPrecioCosto().multiply(new BigDecimal(getCantidadEntrada()));
        totalVenta = getPrecioVenta().multiply(new BigDecimal(getCantidadEntrada()));
        totalGanancia = totalVenta.subtract(totalCosto);
    }
}
