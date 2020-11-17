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
public interface ProductoDao2 {
    public void guardar(Producto p);

    public List<Producto> obtenerTodos();
}
