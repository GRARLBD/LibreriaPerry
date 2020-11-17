/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.libreria.gral.system.dao;

import com.mycompany.libreria.gral.system.model.Codigo;
import com.mycompany.libreria.gral.system.model.Inventario;
import com.mycompany.libreria.gral.system.model.Oferta;
import java.util.List;

/**
 *
 * @author KEVIN
 */
public interface InventarioDao {
    
    public void guardar(Inventario i);

    public List<Inventario> obtenerTodos();

    /**
     * EN USO
     * @param codigo
     * @return 
     */
    public boolean consultarPorCodigo(String codigo);
    
    public boolean consultarPorCodigoLote(String codigo);
    
    public boolean consultarPorDescripcion(String value);
    
    public List<Inventario> obtenerPorDescripcion(String value);
    
    public void eliminar(String codigo);
    
    /**
     * EN USO
     * @param value
     * @return 
     */
    public List<Inventario> obtenerListaPorCodigoCoincidentes(String value);

    public List<Inventario> obtenerListaPorCodigo(String value);
    
    public List<Inventario> obtenerPorCodigoLote(String value);

    public List<Inventario> obtenerPorCodigo(List<String> l);
    
    /**
     * EN USO
     * @param value
     * @return 
     */
    public Inventario obtenerInvPorCodigo(String value);

    public List<Inventario> obtenerPorCantMin(int cantMin);

    public void eliminarOfertas(List<Oferta> lOfertas);
            
    public boolean consultarPorCodBusqP1(String value);
    
    public List<Inventario> obtenerPorCodBusqP1(String value);

    public boolean consultarInvSinCodigoBusq();
    
    public List<Inventario>  obtenerInvSinCodigoBusq();

    public void eliminarCodigos(List<Codigo> lCodigo);
}
