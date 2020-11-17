/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.libreria.gral.system.dao;

import com.mycompany.libreria.gral.system.model.Entrada;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author KEVIN
 */
public class EntradaDaoHibernateImpl implements EntradaDao {

    private final SessionFactory sessionFactory;

    public EntradaDaoHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void guardar(Entrada p) {
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

    @Override
    public void eliminar(Entrada entrada) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(entrada);
        session.getTransaction().commit();
    }
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

    @Override
    public boolean consultar(String codigo) {
        Session session = sessionFactory.openSession();
        Entrada e = (Entrada) session.createQuery(
                "select entrada from Entrada as entrada where entrada.producto.codigo = '" + codigo + "'")
                .uniqueResult();
        session.close();

        return e != null;
    }

    @Override
    public Entrada obtener(String codigo) {
        Session session = sessionFactory.openSession();
        Entrada e = (Entrada) session.createQuery(
                "select entrada from Entrada as entrada where entrada.prdducto.codigo = '" + codigo + "'")
                .uniqueResult();
        session.close();

        return e;
    }

    @Override
    public List<Entrada> obtenerTodos() {
        Session session = sessionFactory.openSession();
        List<Entrada> listaRetorno = session.createQuery("from Entrada").list();
        
        session.close();

        return listaRetorno;
    }

    @Override
    public List<Entrada> obtenerTodosAZ() {
        String cadena = "SELECT ent from Entrada as ent ORDER BY fecha DESC";
        Session session = sessionFactory.openSession();
        List<Entrada> listaRetorno = session.createQuery(cadena).list();
        
        session.close();

        return listaRetorno;
    }

    @Override
    public void eliminarTodos(String codigo) {
        List<Entrada> l = obtenerM2(codigo);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        for(Entrada ent : l)
        {
            session.delete(ent);
        }
        
        session.getTransaction().commit(); 
    }

    @Override
    public List<Entrada> obtenerM2(String codigo) {
        Session session = sessionFactory.openSession();
        List<Entrada> l = (List<Entrada>)session.createQuery(
                "select entrada from Entrada as entrada where entrada.inventario.producto.codigo = '" + codigo + "'")
                .list();
        session.close();

        return l;
    }
}
