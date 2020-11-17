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
public class ProductoDaoHibernateImpl implements ProductoDao {

    private final SessionFactory sessionFactory;

    public ProductoDaoHibernateImpl(SessionFactory sessionFactory) {
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
//
//    @Override
//    public List<Actividad> obtenerTodos() {
//        Session session = sessionFactory.openSession();
//        List<Actividad> listaRetorno = session.createQuery("from Actividad").list();
//        session.close();
//        return listaRetorno;
//    }
//
//    @Override
//    public void eliminar(Actividad actividad) {
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        session.update(actividad);
//        session.getTransaction().commit();
//                      
//    }
//
//    @Override
//    public boolean consultar(Actividad actividad) {
//        Session session = sessionFactory.openSession();
//        Actividad element = (Actividad) session.createQuery(
//                "select actividad.nombre from Actividad as actividad where actividad.nombre = ?")
//                .setEntity(0, actividad.getNombre())
//                .uniqueResult();
//        session.close();
//        if (element!=null){
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public Actividad buscarPorNombre(String nombre) {
//        Session session = sessionFactory.openSession();
//        
//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery<Actividad> query = builder.createQuery(Actividad.class);
//        Root<Actividad> root = query.from(Actividad.class);
//        query.select(root);
//        query.where(builder.equal(root.get("nombre"), nombre));
//        
//        Actividad pelicula = session.createQuery(query).uniqueResult();
//        
//        session.close();
//        
//        return pelicula;
//    }
//
//    @Override
//    public List<Actividad> obtenerActivas() {
//        Session session = sessionFactory.openSession();
//        List<Actividad> listaRetorno = session.createQuery("select actividad from Actividad as actividad where actividad.estado = 'activa'").list();
//        session.close();
//        
//        return listaRetorno;
//    }
//
//    @Override
//    public boolean consultar(String nombre) {
//        Session session = sessionFactory.openSession();
//        Actividad e = (Actividad) session.createQuery("select actividad from Actividad as actividad where actividad.nombre = '"+ nombre +"'")
//                .uniqueResult();
//        session.close();
//        
//        return e != null;
//    }
//
//    @Override
//    public Actividad obtener(String nombre) {
//        Session session = sessionFactory.openSession();
//        Actividad e = (Actividad) session.createQuery("select actividad from Actividad as actividad where actividad.nombre = '" + nombre + "'")
//                .uniqueResult();
//        session.close();
//
//        return e;
//    }
//
//    @Override
//    public void eliminar(String actividadSeleccionada) {
//        Actividad a = obtener(actividadSeleccionada);
//        eliminar(a);
//    }

    @Override
    public List<Producto> obtenerTodos() {
        Session session = sessionFactory.openSession();
        List<Producto> listaRetorno = session.createQuery("from Producto").list();
        session.close();
        return listaRetorno;
    }

}
