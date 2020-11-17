/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.libreria.gral.system.dao;

import java.util.List;
import com.mycompany.libreria.gral.system.model.Factura;
/**
 *
 * @author KEVIN
 */
public interface FacturaDao {
    
    public void guardar(Factura f);

    public Factura obtener(String codigo);
    
    public boolean consultar(String codigo);
    
    public boolean consultarPorFecha(String dia, String mes, String anio);
    
    public List<Factura> obtenerTodos();
    
    public List<Factura> obtenerTodosAZ();

    public void actualizar(Factura fact);

    public List<Factura> obtenerPorFecha(String dia, String mes, String anio);
}
