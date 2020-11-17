/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.libreria.gral.system.dao;

import com.mycompany.libreria.gral.system.model.Factura;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author KEVIN
 */
public class FacturaDaoHibernateImpl implements FacturaDao{
    private final SessionFactory sessionFactory;

    public FacturaDaoHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void guardar(Factura p) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(p);
        session.getTransaction().commit();
        session.close();    
    }
    @Override
    public List<Factura> obtenerTodos() {
        Session session = sessionFactory.openSession();
        List<Factura> listaRetorno = session.createQuery("from Factura").list();
        session.close();
        
        return listaRetorno;
    }
    
    @Override
    public List<Factura> obtenerTodosAZ() {
        String cadena = "SELECT fact from Factura as fact ORDER BY fecha DESC";
        Session session = sessionFactory.openSession();
        List<Factura> listaRetorno = session.createQuery(cadena).list();
        
        session.close();

        return listaRetorno;
    }

    @Override
    public boolean consultar(String codigo) {
        boolean respuesta = false;
        Session session = sessionFactory.openSession();
        List<Factura> l =  session.createQuery(
                "SELECT fact FROM Factura as fact WHERE codigoFactura = '" + codigo +"'")
                .list();
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
    public Factura obtener(String codigo) {
        Session session = sessionFactory.openSession();
        Factura objRet = (Factura) session.createQuery(
                "SELECT fact FROM Factura AS fact WHERE codigoFactura = '" + codigo +"'")
                .uniqueResult();
        session.close();
        
        return objRet;
    }

    @Override
    public void actualizar(Factura fact) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(fact);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public boolean consultarPorFecha(String dia, String mes, String anio) {
        boolean estado = false;
        Session session = sessionFactory.openSession();
        
        String cadena = String.format("SELECT sal FROM Salida as sal WHERE YEAR( sal.fechaSalida ) = '%s' AND MONTH( sal.fechaSalida ) = '%s' AND DAY( sal.fechaSalida ) = '%s' ORDER BY fecha DESC", anio, mes, dia);
        List<Factura> l = (List<Factura>)session.createQuery(cadena)
                .list();
        
        if (l.isEmpty())
        {
            // Hacer nada.
        } else
        {
            estado = true;
        }
        
        session.close();
        
        return estado;
    }

    @Override
    public List<Factura> obtenerPorFecha(String dia, String mes, String anio) {
        boolean estado = false;
        Session session = sessionFactory.openSession();
        
        String cadena = String.format("SELECT fac FROM Factura as fac WHERE YEAR( fac.fecha ) = '%s' AND MONTH( fac.fecha ) = '%s' AND DAY( fac.fecha ) = '%s' ORDER BY fecha DESC", anio, mes, dia);
        List<Factura> l = (List<Factura>)session.createQuery(cadena)
                .list();
        
        session.close();
        
        return l;
    }
}
