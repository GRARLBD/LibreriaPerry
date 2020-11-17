/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.libreria.gral.system.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import utiles.Utiles;

/**
 *
 * @author KEVIN
 */
public class Inventario {
    
    private Integer id;
    private Producto producto;
    private List<Oferta> lOferta;
    private BigDecimal costoUnitario;
    private BigDecimal totalCosto;
    private Integer acumEntrada;
    private Integer acumSalida;
    private boolean estado;
    private int unidOf;
    private BigDecimal pVenta;
    private BigDecimal totalVenta;
    private BigDecimal totalGanancia;

    public Inventario() {
        this.id = -1;
        this.producto = new Producto();
        this.lOferta = new ArrayList<>();
        this.costoUnitario = new BigDecimal(0.0);
        this.totalCosto = new BigDecimal(0.0);
        this.acumEntrada = 0;
        this.acumSalida = 0;  
        this.estado = false;
        this.unidOf = 0;
        this.pVenta = new BigDecimal(0);
        this.totalVenta = new BigDecimal(0);
        this.totalGanancia = new BigDecimal(0);
    }

    public Inventario(Integer id, Producto producto,
            List<Oferta> lOferta, BigDecimal costoUnitario,
            BigDecimal totalCostoInventario, Integer acumuladorTotalEntrada,
            Integer acumuladorTotalSalida, boolean estado,
            int unidOf, BigDecimal pVenta, BigDecimal totalVenta, BigDecimal totalGanancia) {
        this.id = id;
        this.producto = producto;
        this.lOferta = lOferta;
        this.costoUnitario = costoUnitario;
        this.totalCosto = totalCostoInventario;
        this.acumEntrada = acumuladorTotalEntrada;
        this.acumSalida = acumuladorTotalSalida;
        this.estado = estado;
        this.unidOf = unidOf;
        this.pVenta = pVenta;
        this.totalVenta = totalVenta;
        this.totalGanancia = totalGanancia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Oferta> getlOferta() {
        return lOferta;
    }

    public void setlOferta(List<Oferta> lOferta) {
        this.lOferta = lOferta;
    }

    public BigDecimal getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(BigDecimal costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public BigDecimal getTotalCosto() {
        return totalCosto;
    }

    public void setTotalCosto(BigDecimal totalCosto) {
        this.totalCosto = totalCosto;
    }

    public Integer getAcumEntrada() {
        return acumEntrada;
    }

    public void setAcumEntrada(Integer acumEntrada) {
        this.acumEntrada = acumEntrada;
    }

    public Integer getAcumSalida() {
        return acumSalida;
    }

    public void setAcumSalida(Integer acumSalida) {
        this.acumSalida = acumSalida;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
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

    
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    public void incrementarAcumuladorEntrada(int c){
            acumEntrada += c;
    }
    
    public void incrementarAcumuladorSalida(int c){
            acumSalida += c;
    }
    
    public void actualizarParametros() {   
        int stock = calcularStock(getAcumEntrada(), getAcumSalida());      
        BigDecimal totalCosto = stock >= 0? calcularTotalCosto(stock, getCostoUnitario()) 
                : new BigDecimal(0);        
        BigDecimal totalVenta = stock >= 0? calcularTotalVenta(stock, getpVenta())
                    : new BigDecimal(0);
        BigDecimal totalGanancia = calcularTotalGanancia(totalCosto, totalVenta);
        
        getProducto().setStock(stock);
        setTotalCosto(totalCosto);
        setTotalVenta(totalVenta);
        setTotalGanancia(totalGanancia);
    }
    
    public String obtenerInfoBasica()
    {
        String descripcion = getProducto().getDescripcion();        
        
        return String.format(
                "Código de búsqueda: %s"
                +"\n\nCódigo de lote: %s"
                + "\nLista de códigos: %s"
                + "\nCódigo: %s"
                + "\nDescripción: %s"
                + "\nUnid. ofert.: %s"
                + "\nCosto unit.: $ %s"
                + "\nPrecio unit.: $ %s",
                getCodigosBusquedas(), getProducto().getCodigoLote(),
                getListaCodigos(), getProducto().getCodigo(), descripcion, Utiles.formatearM2(getUnidOf()),
                Utiles.formatear(getCostoUnitario()),
                Utiles.formatear(getpVenta()));
    }
    
    private String getListaCodigos()
    {
        String value = "{";
        
        for (Codigo obj : getProducto().getListaCodigo())
        {
            value += obj.getCodigo() + ", ";
        }
        
        value += Utiles.cortarFinalM2(value, ",") + "}";
        
        return value;
    }
    
    private String getCodigosBusquedas()
    {
        String value = String.format("{ %s - %s - %s }",
                getProducto().getCodigoBusq1(),
                getProducto().getCodigoBusq2(),
                getProducto().getCodigoBusq3());
                
        return value;
    }
    
    private BigDecimal calcularTotalCosto(int stock, BigDecimal pCosto) {
        return pCosto.multiply(BigDecimal.valueOf(stock));
    }
    
    private BigDecimal calcularTotalVenta(int stock, BigDecimal pVenta) {
        return pVenta.multiply(BigDecimal.valueOf(stock));
    }
    
    private BigDecimal calcularTotalGanancia(BigDecimal pCosto, BigDecimal pVenta)
    {
        return pVenta.subtract(pCosto);
    }
    
    private int calcularStock(int acumEnt, int acumSal)
    {
        return acumEnt - acumSal;
    }
    
    public void setTotalCosto(int stock, BigDecimal pCosto)
    {
        BigDecimal value = pCosto.multiply(new BigDecimal(stock));
        
        setTotalCosto(value);
    }
    
    public void setTotalVenta(int stock, BigDecimal pVenta)
    {
        BigDecimal value = pVenta.multiply(new BigDecimal(stock));
        
        setTotalVenta(value);
    }
    
    public void setTotalGanancia()
    {
        BigDecimal value = getTotalVenta().subtract(getTotalCosto());
        
        setTotalGanancia(value);
    }
}
