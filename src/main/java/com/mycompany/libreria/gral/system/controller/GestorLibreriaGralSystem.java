/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.libreria.gral.system.controller;

import com.mycompany.libreria.gral.system.dao.EntradaDao;
import com.mycompany.libreria.gral.system.dao.EntradaDaoHibernateImpl;
import com.mycompany.libreria.gral.system.dao.FacturaDao;
import com.mycompany.libreria.gral.system.dao.FacturaDaoHibernateImpl;
import com.mycompany.libreria.gral.system.dao.InventarioDao;
import com.mycompany.libreria.gral.system.dao.InventarioDaoHibernateImpl;
import com.mycompany.libreria.gral.system.dao.ProductoDao2;
import com.mycompany.libreria.gral.system.dao.ProductoDaoHibernateImpl2;
import com.mycompany.libreria.gral.system.dao.SalidaDao;
import com.mycompany.libreria.gral.system.dao.SalidaDaoHibernateImpl;
import com.mycompany.libreria.gral.system.model.Codigo;
import com.mycompany.libreria.gral.system.model.Entrada;
import com.mycompany.libreria.gral.system.model.Factura;
import com.mycompany.libreria.gral.system.model.Inventario;
import com.mycompany.libreria.gral.system.model.Oferta;
import com.mycompany.libreria.gral.system.model.Producto;
import com.mycompany.libreria.gral.system.model.Salida;
import com.mycompany.libreria.gral.system.ui.FProgressBar;
import com.mycompany.libreria.gral.system.ui.MainFrame;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import net.sf.jasperreports.engine.JRException;
import org.hibernate.SessionFactory;
import utiles.ExceptionBD;
import utiles.ImpresionFactura;
import utiles.Progreso;
import utiles.Utiles;

/**
 *
 * @author joaquinleonelrobles
 */
public class GestorLibreriaGralSystem {

    private FacturaDao facturaDao;
    private ProductoDao2 productoDao;
    private EntradaDao entradaDao;
    private SalidaDao salidaDao;
    private InventarioDao inventarioDao;

    public GestorLibreriaGralSystem(SessionFactory sessionFactory) {
        this.facturaDao = new FacturaDaoHibernateImpl(sessionFactory);
        this.entradaDao = new EntradaDaoHibernateImpl(sessionFactory);
        this.inventarioDao = new InventarioDaoHibernateImpl(sessionFactory);
        this.salidaDao = new SalidaDaoHibernateImpl(sessionFactory);
        this.productoDao = new ProductoDaoHibernateImpl2(sessionFactory);
    }

    public void run() {
        new MainFrame(this).setVisible(true);
    }

    public void guardarProducto(Producto p) {
        productoDao.guardar(p);
    }

    public List<Entrada> obtenerEntradas() {
        return this.entradaDao.obtenerTodos();
    }

    public List<Entrada> obtenerEntradasAZ() {
        return this.entradaDao.obtenerTodosAZ();
    }

    public void guardarEntrada(Entrada entrada) {
        entradaDao.guardar(entrada);
    }

    public void guardarInventario(Inventario i) {
        guardarProducto(i.getProducto());
        inventarioDao.guardar(i);
    }

    public void guardarSalida(Salida salida) {
        salidaDao.guardar(salida);
    }

    public void guardarSalida(List<Salida> lista) {
        salidaDao.guardar(lista);
    }

    public List<Inventario> obtenerInventarios() {
        return inventarioDao.obtenerTodos();
    }

    public List<Inventario> obtenerInventariosAZ() {
        List<Inventario> lRetorno;

        try {
            lRetorno = inventarioDao.obtenerTodos();
        } catch (Exception e) {
            e.printStackTrace();
            lRetorno = null;
        }

        if (lRetorno == null || lRetorno.isEmpty()) {
            // Hacer nada.
        } else {
            Utiles.ordenarAZ(lRetorno);
        }

        return lRetorno;
    }

    public List<Oferta> obtenerOfertasAZ() {
        List<Inventario> lRetorno = null;

        try {
            lRetorno = inventarioDao.obtenerTodos();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (lRetorno == null || lRetorno.isEmpty()) {
            return null;
        }

        List<Oferta> lOferta = new ArrayList<>();

        for (Inventario i : lRetorno) {
            lOferta.addAll(i.getlOferta());
        }

        //Ordena la lista
        Collections.sort(lOferta,
                (Oferta obj1, Oferta obj2)
                -> obj1.getDescripcion().compareTo(obj2.getDescripcion()));

        return lOferta;
    }

    public List<Inventario> obtenerInventarioPropDescripcion(String value) {
        List<String> vector = Utiles.separar(value);
        List<Inventario> listaRet = new ArrayList<>();

        if (vector.isEmpty()) {
            // Hacer nada.
        } else {
            listaRet = inventarioDao.obtenerPorDescripcion(vector.get(0));

            for (String str : Utiles.separar(value)) {
                Iterator<Inventario> iter = listaRet.iterator();

                while (iter.hasNext()) {
                    Inventario inv = iter.next();

                    String desc = inv.getProducto().getDescripcion();

                    if (Utiles.existeCoincidencia(desc, str)) {
                        // Hacer nada.
                    } else {
                        iter.remove();
                    }
                }
            }

        }

        return listaRet;
    }

    /**
     * EN USO
     * @param codigo
     * @return 
     */
    public boolean consultarInvPorCodigo(String codigo) {
        return inventarioDao.consultarPorCodigo(codigo);
    }

    public boolean consultarInventarioPorDescripcion(String value) {
        return inventarioDao.consultarPorDescripcion(value);
    }

    public List<Inventario> obtenerInventariosPorCodigo(String value) {
        return inventarioDao.obtenerListaPorCodigo(value);
    }

    public List<Inventario> obtenerInvPorCodigoM0(String value) {
        return inventarioDao.obtenerListaPorCodigo(value);
    }

    /**
     * EN USO
     * Obtiene un inventario dado su codigo.
     *
     * @param value
     * @return
     */
    public Inventario obtenerInvPorCodigoM2(String value) {
        return inventarioDao.obtenerInvPorCodigo(value);
    }

    /**EN USO
     * Obtiene una lista de inventarios con códigos de acuerdo a las
     * coincidencias del valor.
     *
     * @param value
     * @return
     */
    public List<Inventario> obtenerInvPorCodigoM3(String value) {
        return inventarioDao.obtenerListaPorCodigoCoincidentes(value);
    }

    public List<Inventario> obtenerInvPorCodigoM1(List<String> l) {
        return inventarioDao.obtenerPorCodigo(l);
    }

    public List<Salida> obtenerSalidas() {
        return salidaDao.obtenerTodos();
    }

    public void eliminarInventario(String codigo) {
        Inventario i = null;
        try {
            i = obtenerInventariosPorCodigo(codigo).get(0);
            i.getProducto().setCodigo("ELIMINADO");
            //i.setEstado(false);
            guardarInventario(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminarInventarioM2(String codigo) {
        entradaDao.eliminarTodos(codigo);
        salidaDao.eliminarTodos(codigo);
        inventarioDao.eliminar(codigo);
    }

    public boolean consultarInventarioPorCodigoLote(String codigoLote) {
        return inventarioDao.consultarPorCodigoLote(codigoLote);
    }

    public List<Inventario> obtenerInventariosPorCodigoLote(String codigoLote) {
        return inventarioDao.obtenerPorCodigoLote(codigoLote);
    }

    public boolean consultarSalidasPorDescripcion(String value) {
        return salidaDao.consultarPorDescripcion(value);
    }

    public List<Salida> obtenerSalidasPorDescripcion(String value) {
        return salidaDao.obtenerPorDescripcion(value);
    }

    public List<Salida> obtenerSalidasPorDescripcion(String value, Date f) {
        return salidaDao.obtenerPorDescripcion(value, f);
    }

    public List<Inventario> obtenerInvCantMin(int cantMin) {
        return inventarioDao.obtenerPorCantMin(cantMin);
    }

    public void eliminarOfertasPorEstado(List<Oferta> lOfertas) {
        inventarioDao.eliminarOfertas(lOfertas);
    }

    public void eliminarCodigosPorEstado(List<Codigo> lCodigo) {
        inventarioDao.eliminarCodigos(lCodigo);
    }
    
    public String[] obtenerResumenSalida() {
        List<Salida> l;

        try {
            l = obtenerSalidas();
        } catch (Exception e) {
            e.printStackTrace();
            l = new ArrayList<>();
        }

        String[] CADENA_RESUMEN = new String[4];

        if (l.isEmpty()) {
            CADENA_RESUMEN[0] = null;
            CADENA_RESUMEN[1] = null;
            CADENA_RESUMEN[2] = null;
            CADENA_RESUMEN[3] = null;

        } else {
            Integer n = l.size();
            BigDecimal acumCosto = new BigDecimal("0.0");
            BigDecimal acumVenta = new BigDecimal("0.0");
            BigDecimal acumGanancia = new BigDecimal("0.0");

            for (Salida sal : l) {
                acumCosto = acumCosto.add(sal.getTotalCosto());
                acumVenta = acumVenta.add(sal.getTotalVenta());
                acumGanancia = acumGanancia.add(sal.getTotalGanancia());
            }
            CADENA_RESUMEN[0] = String.valueOf(n);
            CADENA_RESUMEN[1] = Utiles.formatear(acumCosto);
            CADENA_RESUMEN[2] = Utiles.formatear(acumVenta);
            CADENA_RESUMEN[3] = Utiles.formatear(acumGanancia);
        }

        return CADENA_RESUMEN;
    }

    public String[] obtenerResumenInvenarios() {
        List<Inventario> l;

        try {
            l = obtenerInventarios();
        } catch (Exception e) {
            l = new ArrayList<>();
        }

        String[] CADENA_RESUMEN = new String[4];

        if (l.isEmpty()) {
            CADENA_RESUMEN[0] = null;
            CADENA_RESUMEN[1] = null;
            CADENA_RESUMEN[2] = null;
            CADENA_RESUMEN[3] = null;

        } else {
            Integer n = l.size();
            BigDecimal acumCosto = new BigDecimal("0.0");
            BigDecimal acumVenta = new BigDecimal("0.0");
            BigDecimal acumGanancia = new BigDecimal("0.0");

            for (Inventario inv : l) {
                acumCosto = acumCosto.add(inv.getTotalCosto());
                acumVenta = acumVenta.add(inv.getTotalVenta());
                acumGanancia = acumGanancia.add(inv.getTotalGanancia());
            }
            CADENA_RESUMEN[0] = String.valueOf(n);
            CADENA_RESUMEN[1] = Utiles.formatear(acumCosto);
            CADENA_RESUMEN[2] = Utiles.formatear(acumVenta);
            CADENA_RESUMEN[3] = Utiles.formatear(acumGanancia);
        }

        return CADENA_RESUMEN;
    }

    /**
     * EN USO
     * @param codigo
     * @param codigoLote
     * @param descripcion
     * @param stock
     * @param costoUnit
     * @param fechaIng
     * @return
     */
    public void guardarInvNuevo(String codigo, String codigoLote,
            String codBusqCamp,
            String codBusqSP,
            String codBusqOtro,
            String descripcion,
            int stock, BigDecimal costoUnit, List<Oferta> lOfertas,
            BigDecimal pVenta, int unidOfert,List<Codigo> lCodigo, boolean estadoSeguro) throws Exception {

        boolean ESTADO_ACTIVO = true;
        final int ACUM_ENTRADA = stock;
        final int ACUM_SALIDA = 0;

        Inventario inv = new Inventario();

        // Da de alta las ofertas.
        for (Oferta of : lOfertas) {
            of.setEstado(ESTADO_ACTIVO);
        }
        
        // Da de alta los códigos.
        for (Codigo cod : lCodigo)
        {
            cod.setEstado(ESTADO_ACTIVO);
        }

        // Inicializa objeto Inventario
        inv.getProducto().setCodigo(codigo);
        inv.getProducto().setCodigoLote(codigoLote);
        inv.getProducto().setCodigoBusq1(codBusqCamp);
        inv.getProducto().setCodigoBusq2(codBusqSP);
        inv.getProducto().setCodigoBusq3(codBusqOtro);
        inv.getProducto().setDescripcion(descripcion);
        inv.setCostoUnitario(costoUnit);
        inv.setAcumEntrada(ACUM_ENTRADA);
        inv.setAcumSalida(ACUM_SALIDA);
        inv.setUnidOf(unidOfert);
        inv.setpVenta(pVenta);
        inv.setlOferta(lOfertas);
        inv.setEstado(ESTADO_ACTIVO);
        inv.getProducto().setListaCodigo(lCodigo);
        inv.actualizarParametros();
        inv.getProducto().setEstadoSeguro(estadoSeguro);

        guardarInventario(inv);
    }

    /**
     * EN USO
     * @param codigo
     * @param codigoLote
     * @param descripcion
     * @param unidOfert
     * @param stock
     * @param costoUnit
     * @param fechaIng
     * @param acumEnt
     * @param acumSal
     * @param ofertas
     * @param estado
     * @return
     */
    public void guardarInv(String codigoBusq1,
            String codigoBusq2, 
            String codigoBusq3, String codigo, String codigoLote, String descripcion,
            int unidOfert, int stock, BigDecimal costoUnit, BigDecimal precioVenta, int acumEnt, int acumSal,
            List<Oferta> lOfertas, boolean estado, List<Codigo> lCodigo, boolean estadoSeguro) throws Exception {

        Inventario inv = obtenerInvPorCodigoM2(codigo);

        // Inicializa objeto Inventario
        inv.getProducto().setCodigoBusq1(codigoBusq1);
        inv.getProducto().setCodigoBusq2(codigoBusq2);
        inv.getProducto().setCodigoBusq3(codigoBusq3);
        inv.getProducto().setCodigo(codigo);
        inv.getProducto().setCodigoLote(codigoLote);
        inv.getProducto().setDescripcion(descripcion);
        inv.setUnidOf(unidOfert);
        inv.setCostoUnitario(costoUnit);
        inv.getProducto().setStock(stock);
        inv.setpVenta(precioVenta);
        inv.setAcumEntrada(acumEnt);
        inv.setAcumSalida(acumSal);
        inv.setlOferta(lOfertas);
        inv.setEstado(estado);
        inv.setTotalCosto(stock, costoUnit);
        inv.setTotalVenta(stock, precioVenta);
        inv.setTotalGanancia();
        inv.actualizarParametros();
        inv.getProducto().setListaCodigo(lCodigo);
        inv.getProducto().setEstadoSeguro(estadoSeguro);
        
        guardarInventario(inv);
        eliminarOfertasPorEstado(lOfertas);
        eliminarCodigosPorEstado(lCodigo);
    }

    public void guardarEntNueva(Inventario inv) throws Exception {

        Entrada ent = new Entrada();

        boolean ESTADO_ACTIVO = true;
        int cantEnt = inv.getProducto().getStock();
        BigDecimal totCosto = inv.getTotalCosto();
        BigDecimal totVenta = inv.getTotalVenta();
        BigDecimal totGanancia = inv.getTotalGanancia();
        Date fechaIngreso = Utiles.obtenerFechaActualM4();

        // Inicializa objeto Entrada
        ent.setInventario(inv);
        ent.setCantidadEntrada(cantEnt);
        ent.setPrecioCosto(inv.getCostoUnitario());
        ent.setPrecioVenta(inv.getpVenta());
        ent.setTotalCosto(totCosto);
        ent.setTotalVenta(totVenta);
        ent.setTotalGanancia(totGanancia);
        ent.setFechaEntrada(fechaIngreso);
        ent.setEstado(ESTADO_ACTIVO);

        ent.actualizarDatosEntrada();

        guardarEntrada(ent);
    }

    public void guardarEntNueva(List<Inventario> lista) throws Exception {

        for (Inventario inv : lista) {
            Entrada ent = new Entrada();

            boolean ESTADO_ACTIVO = true;
            int cantEnt = inv.getProducto().getStock();
            BigDecimal totCosto = inv.getTotalCosto();
            BigDecimal totVenta = inv.getTotalVenta();
            BigDecimal totGanancia = inv.getTotalGanancia();
            Date fechaIngreso = Utiles.obtenerFechaActualM4();

            // Inicializa objeto Entrada
            ent.setInventario(inv);
            ent.setCantidadEntrada(cantEnt);
            ent.setPrecioCosto(inv.getCostoUnitario());
            ent.setPrecioVenta(inv.getpVenta());
            ent.setTotalCosto(totCosto);
            ent.setTotalVenta(totVenta);
            ent.setTotalGanancia(totGanancia);
            ent.setFechaEntrada(fechaIngreso);
            ent.setEstado(ESTADO_ACTIVO);

            ent.actualizarDatosEntrada();

            guardarEntrada(ent);
        }
    }

    public void actualizarInvenarios(List<Salida> listaSalida) {

        for (Salida s : listaSalida) {
            if (s.getInventario() == null) {
                // Hacer nada.
            } else {
                String codigo = s.getInventario().getProducto().getCodigo();

                if (consultarInvPorCodigo(codigo)) {
                    Inventario inv = obtenerInvPorCodigoM2(codigo);
                    int cantSal = s.getCant() * s.getUnidOf();

                    inv.incrementarAcumuladorSalida(cantSal);
                    inv.actualizarParametros();

                    guardarInventario(inv);
                }
            }
        }
    }

    /*  public void imprimir(String codigoFactura, List<Salida> list, String cliente, String total, String pago, String vuelto) throws JRException {
        Factura fact = new Factura(codigoFactura, cliente, null, list, total, vuelto, pago);
        
        ImpresionFactura i = new ImpresionFactura(fact);

        i.abrirDocumento();
    }
     */
    public void guardarArchivo(Factura factura) throws JRException {
        ImpresionFactura i = new ImpresionFactura(factura);

        i.toPDFGuardar();
    }

    /**
     * Muestra un la factura en archivo pdf.
     *
     * @param fact
     * @throws JRException
     */
    public void imprimir(Factura fact) throws JRException {
        ImpresionFactura i = new ImpresionFactura(fact);

        i.toPDF();
    }

    public String generarCodigo() {
        String pre = "art:";

        String codigo = pre + Utiles.obtenerTiempoActual();

        return codigo;
    }

    public String guardarFactura(String cliente, String pago, String vuelto, List<Salida> lista, String total) throws JRException {

        Factura factura = new Factura();

        factura.generarCodigo();
        factura.setCliente(cliente);
        factura.setPago(pago);
        factura.setVuelto(vuelto);
        factura.setListaSalidas(lista);
        factura.setTotalFactura(total);
        factura.setEstado(true);

        facturaDao.guardar(factura);
        guardarArchivo(factura);

        return factura.getCodigoFactura();
    }

    public List<Salida> obtenerSalidasAZ() {
        return salidaDao.obtenerTodosAZ();
    }

    public List<Salida> obtenerSalidas(String dia, String mes, String anio) {
        return salidaDao.obteterTodos(dia, mes, anio);
    }

    public String[] obtenerResumenSalidas(String dia, String mes, String anio) {
        List<Salida> list = salidaDao.obteterTodos(dia, mes, anio);
        String[] datos = new String[4];

        if (list == null || list.isEmpty()) {
            // Hacer nada.
        } else {
            int n = list.size();
            BigDecimal totCosto = new BigDecimal(0);
            BigDecimal totVenta = new BigDecimal(0);
            BigDecimal totGanancia = new BigDecimal(0);

            for (Salida sal : list) {
                totCosto = totCosto.add(sal.getTotalCosto());
                totVenta = totVenta.add(sal.getTotalVenta());
                totGanancia = totGanancia.add(sal.getTotalGanancia());
            }

            datos[0] = String.valueOf(n);
            datos[1] = Utiles.formatear(totCosto);
            datos[2] = Utiles.formatear(totVenta);
            datos[3] = Utiles.formatear(totGanancia);
        }

        return datos;
    }

    public List<Factura> obtenerFacturas() {
        return facturaDao.obtenerTodos();
    }

    public List<Factura> obtenerFacturasAZ() {
        return facturaDao.obtenerTodosAZ();
    }

    public boolean consultarFactura(String codigoFactura) {
        return facturaDao.consultar(codigoFactura);
    }
    
    public boolean consultarFacturaPorFecha(String dia, String mes, String anio) {
        return facturaDao.consultarPorFecha(dia, mes, anio);
    }

    public Factura obtenerFactura(String codigoFactura) {
        return facturaDao.obtener(codigoFactura);
    }

    public void actualizarFactura(Factura fact) {
        facturaDao.actualizar(fact);
    }

    public boolean abrirDocumento(String codigo) throws JRException {
        boolean result = false;

        if (consultarFactura(codigo)) {
            Factura fact = facturaDao.obtener(codigo);
            ImpresionFactura gestorImpresion = new ImpresionFactura(fact);

            result = gestorImpresion.abrirDocumento();
        }

        return result;
    }

    public void guardarInventario(List<Inventario> listaInventario) {
        for (Inventario inv : listaInventario) {
            guardarInventario(inv);
        }
    }

    public void actulizarInventario(String codigo, String codigoLote, String descripcion, int cantEntrada, BigDecimal costoUnit, BigDecimal precioVenta) {
        // Inicializa objeto Inventario
        Inventario inv = obtenerInvPorCodigoM2(codigo);

        inv.getProducto().setCodigo(codigo);
        inv.getProducto().setCodigoLote(codigoLote);
        inv.getProducto().setDescripcion(descripcion);
        inv.incrementarAcumuladorEntrada(cantEntrada);
        inv.setCostoUnitario(costoUnit);
        inv.setpVenta(precioVenta);

        inv.actualizarParametros();

        guardarInventario(inv);
    }

    public void guardarEntrada(Inventario inv, String descripcion, int cantEntrada, BigDecimal costoUnit, BigDecimal precioVenta) {
        Entrada ent = new Entrada();

        boolean ESTADO_ACTIVO = true;
        BigDecimal totCosto = costoUnit.multiply(new BigDecimal(cantEntrada));
        BigDecimal totVenta = precioVenta.multiply(new BigDecimal(cantEntrada));
        BigDecimal totGanancia = totVenta.subtract(totCosto);
        Date fechaIngreso = Utiles.obtenerFechaActualM4();

        // Inicializa objeto Entrada
        ent.setInventario(inv);
        ent.setCantidadEntrada(cantEntrada);
        ent.setPrecioCosto(costoUnit);
        ent.setPrecioVenta(precioVenta);
        ent.setTotalCosto(totCosto);
        ent.setTotalVenta(totVenta);
        ent.setTotalGanancia(totGanancia);
        ent.setFechaEntrada(fechaIngreso);
        ent.setEstado(ESTADO_ACTIVO);

        ent.actualizarDatosEntrada();

        guardarEntrada(ent);
    }

    public void guardarEntradas(List<Entrada> listaEntradas) {

        for (Entrada ent : listaEntradas) {
            Inventario inv = ent.getInventario();

            inv.incrementarAcumuladorEntrada(ent.getCantidadEntrada());
            inv.actualizarParametros();

            guardarInventario(inv);
            guardarEntrada(ent);
        }
    }

    public List<String[]> obtenerCambios(List<String[]> lista, Progreso progreso) {
        List<String[]> lRet = new ArrayList<>();
        Iterator<String[]> iter = lista.iterator();
        
        while (iter.hasNext()) {
            String[] datos = iter.next();
            String codigo = datos[0];
          
            progreso.incrementar();
            
            if (codigo == null || codigo.trim().isEmpty()) {
                // Hacer nada.
            } else {
                if (consultarPorCodBusqP1(codigo.trim())) {
                    // Hacer nada.
                    List<Inventario> l = obtenerPorCodBusqP1(codigo.trim());

                    for (Inventario inv : l) {
                        BigDecimal costoUnit = new BigDecimal(0);
                        String costoUnit2 = datos[3].trim();

                        try {
                            costoUnit = new BigDecimal(costoUnit2);

                            if (inv.getCostoUnitario().compareTo(costoUnit) == 0) {
                                // Hacer nada.
                            } else {
                                lRet.add(datos);
                            }

                        } catch (Exception e) {
                        }
                    }
                }
            }
        }
        
        return lRet;
    }

    public boolean consultarPorCodBusqP1(String value) {
        boolean band = false;

        if (value == null || value.trim().isEmpty()) {

        } else {
            band = inventarioDao.consultarPorCodBusqP1(value);
        }

        return band;
    }

    public List<Inventario> obtenerPorCodBusqP1(String value) {
        return inventarioDao.obtenerPorCodBusqP1(value);
    }

    public List<Oferta> copiarLista(List<Oferta> lista) {
        List<Oferta> nLista = lista.stream().collect(Collectors.toList());

        return nLista;
    }

    public List<Factura> obtenerFacturaPorFecha(String dia, String mes, String anio) {
        return facturaDao.obtenerPorFecha(dia, mes, anio);
    }

    public boolean consultarInvSinCodigoBusq(){
        return inventarioDao.consultarInvSinCodigoBusq();
    }
    
    public List<Inventario> obtenerInvSinCodigoBusq(){
        return inventarioDao.obtenerInvSinCodigoBusq();
    }
}
