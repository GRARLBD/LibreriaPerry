/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.libreria.gral.system.dao;

import com.mycompany.libreria.gral.system.model.Entrada;
import java.util.List;

/**
 *
 * @author KEVIN
 */
public interface EntradaDao {
    
    public void guardar(Entrada p);

    public List<Entrada> obtenerTodos();
//
//    public boolean consultar(Actividad actividad);
//    
    public void eliminar(Entrada entrada);
    
    public void eliminarTodos(String entrada);
    
//    public Actividad buscarPorNombre(String nombre);
//
//    public List<Actividad> obtenerActivas();
//
    public boolean consultar(String codigo);

    public Entrada obtener(String codigo);
    
    public List<Entrada> obtenerM2(String codigo);

//    public void eliminar(String actividadSeleccionada);

    public List<Entrada> obtenerTodosAZ();
    
}
