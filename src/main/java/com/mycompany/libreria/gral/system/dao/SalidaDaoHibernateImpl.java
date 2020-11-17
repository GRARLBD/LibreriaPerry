/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.libreria.gral.system.dao;

import com.mycompany.libreria.gral.system.model.Salida;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utiles.Utiles;

/**
 *
 * @author KEVIN
 */
public class SalidaDaoHibernateImpl implements SalidaDao {

    private final SessionFactory sessionFactory;

  
    public SalidaDaoHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void guardar(Salida s) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(s);
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
    @Override
    public boolean consultarPorDescripcion(String value) {
        Session session = sessionFactory.openSession();
        List<Salida> element = null;
        
        try {
            element = session.createQuery(
                "select s from Salida as s where s.inventario.producto.descripcion like '%" + value + "%' OR s.descripcion like '%" + value + "%'")
                .list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        session.close();
        
        if (element == null || element.isEmpty()){
            return false;
        }
        
        return true;
    }
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
    @Override
    public List<Salida> obtenerPorDescripcion(String value) {
        Session session = sessionFactory.openSession();
        List<Salida> l = new ArrayList<>();
        List<String> cadenas = Utiles.separar(value);
        
        for (int i = 0; i < cadenas.size(); i++) {
            String cad = cadenas.get(i);
            
            if (i == 0) {
                try {
                    List<Salida> lRet1 = session.createQuery(
                            "select s from Salida as s where s.descripcion like '%" + cad + "%'")
                            .list();
                    List<Salida> lRet2 = session.createQuery(
                            "select s from Salida as s where s.inventario.producto.descripcion like '%" + cad + "%'")
                            .list();
                    List<Salida> lRet3 = session.createQuery(
                            "select s from Salida as s where s.oferta.descripcion like '%" + cad + "%'")
                            .list();

                    l.addAll(lRet1);
                    l.addAll(lRet2);
                    l.addAll(lRet3);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                Iterator<Salida> iter = l.iterator();
                
                  while (iter.hasNext())
                 {
                     Salida s = iter.next();
                     
                     if (s.getDescripcion().contains(cad))
                     {
                         // Hacer nada.
                     } else
                     {
                         if (s.getOferta() != null && s.getOferta().getDescripcion().contains(cad))
                         {
                             // Hacer nada.
                         } else
                         {
                             if (s.getInventario() != null && s.getInventario().getProducto().getDescripcion().contains(cad)) {
                                 // Hacer nada.
                             } else {
                                 if (s.getOferta() != null && s.getOferta().getDescripcion().contains(cad)) {
                                     // Hacer nada.
                                 } else {
                                     iter.remove();
                                 }
                             }
                         }
                     }
                 }
            }
        }

        session.close();

        return l;
    }
    
    @Override
    public List<Salida> obtenerPorDescripcion(String value, Date f) {
        Session session = sessionFactory.openSession();
        List<Salida> l = null;
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy/MM/dd");
        try {
            l = session.createQuery(
                "select s from Salida as s where s.producto.detalle like '%" + value + "%'"
                        + " and "
                    + "YEAR(" + "'" + formateador.format(f) + "'" + ") = YEAR(fecha_salida)"
                            + " and "
            + "MONTH(" + "'" + formateador.format(f) + "'" + ") = MONTH(fecha_salida)"
                    + " and "
                        + "DAY(" + "'" + formateador.format(f) + "'" + ") = DAY(fecha_salida)")
                .list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        session.close();
        
        if (l == null || l.isEmpty()){
            return null;
        }
        
        return l;
    }

//
//    @Override
//    public void eliminar(String actividadSeleccionada) {
//        Actividad a = obtener(actividadSeleccionada);
//        eliminar(a);
//    }

    @Override
    public List<Salida> obtenerTodos() {
        Session session = sessionFactory.openSession();
        List<Salida> listaRetorno = session.createQuery("from Salida").list();
        session.close();
        
        return listaRetorno;
    }
    
    @Override
    public List<Salida> obtenerTodosAZ() {
        String cadena = "SELECT sal from Salida as sal ORDER BY fecha DESC";
        Session session = sessionFactory.openSession();
        List<Salida> listaRetorno = session.createQuery(cadena).list();
        
        session.close();

        return listaRetorno;
    }
    
    @Override
    public List<Salida> obtenerM2(String codigo) {
        Session session = sessionFactory.openSession();
        List<Salida> l = (List<Salida>)session.createQuery(
                "select salida from Salida as salida where salida.inventario.producto.codigo = '" + codigo + "'")
                .list();
        session.close();

        return l;
    }

    @Override
    public void guardar(List<Salida> lista) {
        Session session = sessionFactory.openSession();

        for (Salida s : lista) {
            session.beginTransaction();
            session.save(s);
            session.getTransaction().commit();
        }
        session.close();
    }

    @Override
    public void eliminarTodos(String codigo) {
        List<Salida> l = obtenerM2(codigo);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        for(Salida ent : l)
        {
            session.delete(ent);
        }
        
        session.getTransaction().commit(); 
    }

    @Override
    public List<Salida> obteterTodos(String dia, String mes, String anio) {
        Session session = sessionFactory.openSession();
        
        String cadena = String.format("SELECT sal FROM Salida as sal WHERE YEAR( sal.fechaSalida ) = '%s' AND MONTH( sal.fechaSalida ) = '%s' AND DAY( sal.fechaSalida ) = '%s' ORDER BY fecha DESC", anio, mes, dia);
        List<Salida> l = (List<Salida>)session.createQuery(cadena)
                .list();
        session.close();
        
        return l;
    }
}
