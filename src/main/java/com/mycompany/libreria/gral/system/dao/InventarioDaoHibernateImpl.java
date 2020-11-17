/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.libreria.gral.system.dao;

import com.mycompany.libreria.gral.system.model.Codigo;
import com.mycompany.libreria.gral.system.model.Inventario;
import com.mycompany.libreria.gral.system.model.Oferta;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author KEVIN
 */
public class InventarioDaoHibernateImpl implements InventarioDao {

    private final SessionFactory sessionFactory;

  
    public InventarioDaoHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void guardar(Inventario i) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(i);
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
    public void eliminar(String codigo) {
        Inventario i = obtenerListaPorCodigo(codigo).get(0);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(i);
        session.getTransaction().commit();                
    }

    /**
     * EN USO
     * @param codigo
     * @return 
     */
    @Override
    public boolean consultarPorCodigo(String value) {
        boolean respuesta = false;
        
        Session session = sessionFactory.openSession();
        String sql = String.format("SELECT * FROM Inventario inv " +
        "WHERE inv.id_producto IN " +
        "(SELECT id_producto FROM producto WHERE producto.codigo = '%s') " +
        "OR inv.id_producto IN " +
        "(SELECT id_producto FROM codigo " +
        "WHERE codigo.id_producto = inv.id_producto AND codigo.codigo = '%s')", value, value);
        
        List<Inventario> l = session.createSQLQuery(sql).addEntity(Inventario.class).list();
        session.close();
        
        if (l.isEmpty()) {
            // Hacer nada.
        } else
        {
            respuesta = true;
        }
        
        return respuesta;
    }
   
    @Override
    public boolean consultarPorDescripcion(String value) {
        boolean respuesta = false;
        Session session = sessionFactory.openSession();
        List<Inventario> e = session.createQuery("select i from Inventario as i inner join Producto as p ON  i.id = p.id WHERE i.producto.descripcion like '%" + value + "%'")
                .list();
        session.close();
        if (!e.isEmpty()) {
            respuesta = true;
        }
        return respuesta;
    }

    @Override
    public List<Inventario> obtenerTodos() {
        Session session = sessionFactory.openSession();
        List<Inventario> listaRetorno = session.createQuery("FROM Inventario").list();
        session.close();
        
        return listaRetorno;
    }

    @Override
    public List<Inventario> obtenerPorDescripcion(String value) {
        Session session = sessionFactory.openSession();

        List<Inventario> l = session.
                createQuery("select i from Inventario as i WHERE i.producto.descripcion like '%" + value + "%'" )
                .list();

        session.close();

        return l;
    }

    @Override
    public List<Inventario> obtenerListaPorCodigo(String value) {
        Session session = sessionFactory.openSession();
        List<Inventario> list = session.createQuery(
                "select i from Inventario as i where i.producto.codigo = " + "'" + value + "'")
                .list();
        session.close();
        
        return list;
    }

    @Override
    public boolean consultarPorCodigoLote(String codigoLote) {
        boolean respuesta = false;
        Session session = sessionFactory.openSession();
        List<Inventario> lRetorno = session.createQuery(
                "select i from Inventario as i where i.producto.codigoLote = '" + codigoLote +"'")
                .list();
        session.close();
        
        if (lRetorno == null || lRetorno.isEmpty()) {
            /// Hacer nada.
        } else
        {
            respuesta = true;
        }
        return respuesta;
    }

    @Override
    public List<Inventario> obtenerPorCodigoLote(String value) {
        Session session = sessionFactory.openSession();
        List<Inventario> lRetorno = session.createQuery(
                "select i from Inventario as i where i.producto.codigoLote = '" + value +"'")
                .list();
        session.close();

        return lRetorno;
    }

    @Override
    public List<Inventario> obtenerPorCodigo(List<String> l) {
        List<Inventario> lRetorno = new ArrayList<>();
        
        Session session = sessionFactory.openSession();

        for (String value : l) {
            List<Inventario> list = new ArrayList<>();

            try {
                list = session.createQuery(
                        "select i from Inventario as i where i.producto.codigo = " + "'" + value + "'")
                        .list();
            } catch (Exception e) {
                e.printStackTrace();
            }

            lRetorno.addAll(list);
        }
        
        session.close();
        
        return lRetorno;        
    }

    /**
     * EN USO
     * @param value
     * @return 
     */
    @Override
    public Inventario obtenerInvPorCodigo(String value) {
        Session session = sessionFactory.openSession();
        String sql = String.format("SELECT * FROM Inventario inv " +
        "WHERE inv.id_producto IN " +
        "(SELECT id_producto FROM producto WHERE producto.codigo = '%s') " +
        "OR inv.id_producto IN " +
        "(SELECT id_producto FROM codigo " +
        "WHERE codigo.id_producto = inv.id_producto AND codigo.codigo = '%s')", value, value);
        
        Inventario inv = (Inventario)session.createSQLQuery(sql).addEntity(Inventario.class).uniqueResult();
        
        session.close();
        
        return inv;
    }

    /**
     * EN USO
     * @param value
     * @return 
     */
    @Override
    public List<Inventario> obtenerListaPorCodigoCoincidentes(String value) {
        Session session = sessionFactory.openSession();
        
        String sql = String.format("SELECT * FROM Inventario inv " +
        "WHERE inv.id_producto IN " +
        "(SELECT id_producto FROM producto WHERE producto.codigo LIKE '%s%s') " +
        "OR inv.id_producto IN " +
        "(SELECT id_producto FROM codigo " +
        "WHERE codigo.id_producto = inv.id_producto AND codigo.codigo LIKE '%s%s')", value, "%", value, "%");
        
        List<Inventario> list = (List<Inventario>) session.createSQLQuery(sql).addEntity(Inventario.class).list();
        
        session.close();

        return list;
    }

    @Override
    public List<Inventario> obtenerPorCantMin(int cantMin) {
        List<Inventario> lRetorno;
        
        Session session = sessionFactory.openSession();
        
        try {
            lRetorno = session.createQuery(
                    "select i from Inventario as i where i.producto.stock <= " + cantMin + "")
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
            lRetorno = new ArrayList<>();
        }
        
        session.close();
        return lRetorno;
    }

    @Override
    public void eliminarOfertas(List<Oferta> lOfertas) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        for (Oferta of : lOfertas) {
            if (of.getId() > 0) {
                if (of.isEstado())
                {
                    // Hacer nada.
                } else
                {
                    session.delete(of);
                }                
            }
        }
        
        session.getTransaction().commit();
    }

    /**
     * Compara el valor del parámetro con la propiedad codigoBusq.
     * @param value
     * @return 
     */
    @Override
    public boolean consultarPorCodBusqP1(String value) {
        boolean band = false;
        Session session = sessionFactory.openSession();
        String sql = String.format("select i from Inventario as i where i.producto.codigoBusq1 = '%s'"
                + "or i.producto.codigoBusq2 = '%s'"
                + "or i.producto.codigoBusq3 = '%s'", value, value, value);
        List<Inventario> list = session.createQuery(sql)
                .list();
        session.close();
        
        if (list.isEmpty())
        {
            // Hacer nada.
        } else
        {
            band = true;
        }
        
        return band;        
    }

    @Override
    public List<Inventario> obtenerPorCodBusqP1(String value) {
        Session session = sessionFactory.openSession();
        String sql = String.format("select i from Inventario as i where i.producto.codigoBusq1 = '%s'"
                + "or i.producto.codigoBusq2 = '%s'"
                + "or i.producto.codigoBusq3 = '%s'", value, value, value);
        
        List<Inventario> inv = session.createQuery(sql)
                .list();
        session.close();
        
        return inv;
    }

    @Override
    public boolean consultarInvSinCodigoBusq() {
        boolean band = false;
        Session session = sessionFactory.openSession();
        
        List<Inventario> list = session.createQuery(
                "select i from Inventario as i where i.producto.codigoBusq1 = ''")
                .list();
        session.close();
        
        if (list.isEmpty())
        {
            // Hacer nada.
        } else
        {
            band = true;
        }
        
        return band;  
    }

    @Override
    public List<Inventario>  obtenerInvSinCodigoBusq() {
        Session session = sessionFactory.openSession();
        
        List<Inventario> list = session.createQuery(
                "select i from Inventario as i where i.producto.codigoBusq1 = ''")
                .list();
        session.close();
        
        return list;  
    }

    @Override
    public void eliminarCodigos(List<Codigo> lCodigo) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        for (Codigo codigo : lCodigo) {
            if (codigo.getId() > 0) {
                if (codigo.isEstado())
                {
                    // Hacer nada.
                } else
                {
                    session.delete(codigo);
                }                
            }
        }
        
        session.getTransaction().commit();
    }
}
