/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.libreria.gral.system.dao;

import com.mycompany.libreria.gral.system.model.Producto;
import java.util.List;

/**
 *
 * @author KEVIN
 */
public interface ProductoDao {
    
    public void guardar(Producto p);

    public List<Producto> obtenerTodos();
//
//    public boolean consultar(Actividad actividad);
//    
//    public void eliminar(Actividad actividad);
//    
//    public Actividad buscarPorNombre(String nombre);
//
//    public List<Actividad> obtenerActivas();
//
//    public boolean consultar(String nombre);
//
//    public Actividad obtener(String nombre);
//
//    public void eliminar(String actividadSeleccionada);
    
}
