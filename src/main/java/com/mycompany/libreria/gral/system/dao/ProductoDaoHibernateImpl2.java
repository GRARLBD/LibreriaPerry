/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.libreria.gral.system.dao;

import com.mycompany.libreria.gral.system.model.Producto;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author KEVIN
 */
public class ProductoDaoHibernateImpl2 implements ProductoDao2{
    private final SessionFactory sessionFactory;

    public ProductoDaoHibernateImpl2(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void guardar(Producto p) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(p);
        session.getTransaction().commit();
        session.close();    
    }
    @Override
    public List<Producto> obtenerTodos() {
        Session session = sessionFactory.openSession();
        List<Producto> listaRetorno = session.createQuery("from Producto").list();
        session.close();
        return listaRetorno;
    }
}
