/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.libreria.gral.system.dao;

import com.mycompany.libreria.gral.system.model.Salida;
import java.util.Date;
import java.util.List;

/**
 *
 * @author KEVIN
 */
public interface SalidaDao {

    public void guardar(Salida s);

    public void guardar(List<Salida> lista);

    public List<Salida> obtenerTodos();

    public List<Salida> obtenerTodosAZ();

    public List<Salida> obtenerM2(String codigo);

    public boolean consultarPorDescripcion(String nombre);

    public List<Salida> obtenerPorDescripcion(String nombre);

    public List<Salida> obtenerPorDescripcion(String nombre, Date f);

    public void eliminarTodos(String codigo);

    public List<Salida> obteterTodos(String dia, String mes, String anio);

}
