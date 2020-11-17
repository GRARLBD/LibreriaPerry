/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.libreria.gral.system.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KEVIN
 */

public class Producto {

    private Integer id;
    private String codigoLote;
    private String codigo;
    private String descripcion;
    private String rutaImagen;
    private String codigoBusq1;
    private String codigoBusq2;
    private String codigoBusq3;
    private List<Codigo> listaCodigo;
    private int stock;
    private boolean estadoSeguro;
    
    public Producto() {
        this.id = -1;
        this.codigo = "-1";
        this.codigoBusq1 = "";
        this.codigoBusq2 = "";
        this.codigoBusq3 = "";
        this.descripcion = "";
        this.rutaImagen = null;
        this.codigoLote = null;
        this.stock = 0;
        this.listaCodigo = new ArrayList<>();
        this.estadoSeguro = false;
    }

    public Producto(Integer id, String codigoLote, String codigo, String descripcion, String rutaImagen, String codigoBusq1, String codigoBusq2, String codigoBusq3, List<Codigo> listaCodigo, int stock, boolean estadoSeguro) {
        this.id = id;
        this.codigoLote = codigoLote;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.rutaImagen = rutaImagen;
        this.codigoBusq1 = codigoBusq1;
        this.codigoBusq2 = codigoBusq2;
        this.codigoBusq3 = codigoBusq3;
        this.listaCodigo = listaCodigo;
        this.stock = stock;
        this.estadoSeguro = estadoSeguro;
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

    public String getCodigoBusq1() {
        return codigoBusq1;
    }

    public void setCodigoBusq1(String codigoBusq1) {
        this.codigoBusq1 = codigoBusq1;
    }

    public String getCodigoBusq2() {
        return codigoBusq2;
    }

    public void setCodigoBusq2(String codigoBusq2) {
        this.codigoBusq2 = codigoBusq2;
    }

    public String getCodigoBusq3() {
        return codigoBusq3;
    }

    public void setCodigoBusq3(String codigoBusq3) {
        this.codigoBusq3 = codigoBusq3;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public String getCodigoLote() {
        return codigoLote;
    }

    public void setCodigoLote(String codigoLote) {
        this.codigoLote = codigoLote;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public List<Codigo> getListaCodigo() {
        return listaCodigo;
    }

    public void setListaCodigo(List<Codigo> listaCodigo) {
        this.listaCodigo = listaCodigo;
    }

    public boolean isEstadoSeguro() {
        return estadoSeguro;
    }

    public void setEstadoSeguro(boolean estadoSeguro) {
        this.estadoSeguro = estadoSeguro;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", codigoLote=" + codigoLote + ", codigo=" + codigo + ", descripcion=" + descripcion + ", rutaImagen=" + rutaImagen + ", codigoBusq1=" + codigoBusq1 + ", codigoBusq2=" + codigoBusq2 + ", codigoBusq3=" + codigoBusq3 + ", listaCodigo=" + listaCodigo + ", stock=" + stock + ", estadoSeguro=" + estadoSeguro + '}';
    }
}
