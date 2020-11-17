/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.libreria.gral.system.model;

import java.math.BigDecimal;
import java.util.Date;
import utiles.Utiles;

/**
 *
 * @author KEVIN
 */
public class Salida {

    private Integer id;
    private String codigo;
    private String descripcion;
    private Inventario inventario;
    private Oferta oferta;
    private int cant;
    private BigDecimal pCosto;
    private BigDecimal totalCosto;
    private int unidOf;
    private BigDecimal pVenta;
    private BigDecimal totalVenta;
    private BigDecimal totalGanancia;
    private Date fechaSalida;
    private boolean estado;
    private boolean regRap;

    public Salida() {
        id = -1;
        codigo = "";
        descripcion = "";
        inventario = null;
        oferta = null;
        cant = 0;
        pCosto = new BigDecimal(0.0);
        totalCosto = new BigDecimal(0.0);
        unidOf = 0;
        pVenta = new BigDecimal(0.0);
        totalVenta = new BigDecimal(0.0);
        totalGanancia = new BigDecimal(0.0);
        fechaSalida = null;
        estado = false;
        regRap = false;
    }

    public Salida(Integer id, String codigo, String descripcion, Inventario inventario, Oferta oferta, int cant, BigDecimal pCosto, BigDecimal totalCosto, int unidOf, BigDecimal pVenta, BigDecimal totalVenta, BigDecimal totalGanancia, Date fechaSalida, boolean estado, boolean regRap) {
        this.id = id;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.inventario = inventario;
        this.oferta = oferta;
        this.cant = cant;
        this.pCosto = pCosto;
        this.totalCosto = totalCosto;
        this.unidOf = unidOf;
        this.pVenta = pVenta;
        this.totalVenta = totalVenta;
        this.totalGanancia = totalGanancia;
        this.fechaSalida = fechaSalida;
        this.estado = estado;
        this.regRap = false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public Oferta getOferta() {
        return oferta;
    }

    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public BigDecimal getpCosto() {
        return pCosto;
    }

    public void setpCosto(BigDecimal pCosto) {
        this.pCosto = pCosto;
    }

    public BigDecimal getTotalCosto() {
        return totalCosto;
    }

    public void setTotalCosto(BigDecimal totalCosto) {
        this.totalCosto = totalCosto;
    }

    public int getUnidOf() {
        return unidOf;
    }

    public void setUnidOf(int unidOf) {
        this.unidOf = unidOf;
    }

    public BigDecimal getpVenta() {
        return pVenta;
    }

    public void setpVenta(BigDecimal pVenta) {
        this.pVenta = pVenta;
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

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean isRegRap() {
        return regRap;
    }

    public void setRegRap(boolean regRap) {
        this.regRap = regRap;
    }

    @Override
    public String toString() {
        return "Salida{" + "id=" + id + ", inventario=" + inventario + ", oferta=" + oferta + ", cant=" + cant + ", pCosto=" + pCosto + ", totalCosto=" + totalCosto + ", unidOf=" + unidOf + ", pVenta=" + pVenta + ", totalVenta=" + totalVenta + ", totalGanancia=" + totalGanancia + ", fechaSalida=" + fechaSalida + ", estado=" + estado + '}';
    }

    public String getImagen() {
        return "Ver";
    }

    public void calcularTotalVenta(int cant, BigDecimal pVenta) {
        BigDecimal totalV;

        totalV = pVenta.multiply(BigDecimal.valueOf(cant));

        setTotalVenta(totalV);
    }

    public String getCodigoM2() {
        String value;

        if (getInventario() == null) {
            value = getCodigo();
        } else {
            if (getOferta() == null) {
                value = getInventario().getProducto().getCodigo();
            } else {
                value = getOferta().getCodigo();
            }
        }

        return value;
    }

    public String getDescripcionM2() {
        String descripcionRet;

        if (getInventario() == null) {
            descripcionRet = getDescripcion();
        } else {
            if (getOferta() == null) {
                descripcionRet = getInventario().getProducto().getDescripcion();
            } else {
                descripcionRet = getOferta().getDescripcion();
            }
        }

        return descripcionRet;
    }

    public String getpVentaStr() {
        return "$ " + Utiles.formatear(getpVenta());
    }

    public String getpCostoStr() {
        return "$ " + Utiles.formatear(getpVenta());
    }

    public String getpTotalStr() {
        return "$ " + Utiles.formatear(getTotalVenta());
    }

    public void actualizarParametros() {
        totalCosto = pCosto.multiply(BigDecimal.valueOf(cant));
        totalVenta = pVenta.multiply(BigDecimal.valueOf(cant));
        totalGanancia = totalVenta.subtract(totalCosto);
    }
}
