/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Kevin
 */
public class Mensaje {
    
    /**
     * Muestra un mensaje de : "No se ha encontrado ningún resultado."
     * @param rootPane 
     */
    public static void mostrarMensajeNoEncontrado(Component rootPane, String codigo) {
        JOptionPane.showMessageDialog(rootPane, "No se encontraron resultados para el código: " + codigo);
    }
    
    /**
     * Mensaje : "La lista de archivos se encuentra cargada."
     * @param rootPane 
     */
    public static void mostrarMensaje31(Component rootPane)
    {
        JOptionPane.showMessageDialog(rootPane, "La lista de archivos se encuentra cargada.");
    }
    
    /**
     * Mensaje : "El precio de costo es mayor o igual al precio de venta."
     * @param rootPane 
     */
    public static void mostrarMensaje30(Component rootPane)
    {
        JOptionPane.showMessageDialog(rootPane, "El precio de costo es mayor o igual al precio de venta.");
    }
    
    public static void mostrarMenaje29(Component rootPane)
    {
        JOptionPane.showMessageDialog(rootPane, "No se encontró el archivo.");
    }
    
    /**
     * Muestra un mensaje sobre: "No se encontraron cambios."
     * @param rootPane 
     */
    public static void mostrarMensaje28(Component rootPane)
    {
        JOptionPane.showMessageDialog(rootPane, "No se encontraron cambios.");
    }
    
    /**
     * Mensaje : "El código fué agregado a la lista de impresión."
     * @param rootPane 
     */
    public static void mostrarMensaje27(Component rootPane)
    {
        JOptionPane.showMessageDialog(rootPane, "El código fué agregado a la lista de impresión.");
    }
    
    /**
     * Mensaje : "Seleccione un tamaño de impresión."
     * @param rootPane 
     */
    public static void mostrarMensajeSeleccionTam(Component rootPane)
    {
        JOptionPane.showMessageDialog(rootPane, "Seleccione un tamaño de impresión."); 
    }
    
    /**
     * Mensaje : "No se encontraron los archivos en el directorio."
     * @param rootPane 
     */
    public static void mostrarMensaje26(Component rootPane)
    {
       JOptionPane.showMessageDialog(rootPane, "No se encontraron los archivos en el directorio."); 
    }
    
    /**
     * Mensaje : "Se han cargado correctamente los archivos."
     * @param rootPane 
     */
    public static void mostrarMensaje25(Component rootPane)
    {
       JOptionPane.showMessageDialog(rootPane, "Se han cargado correctamente los archivos."); 
    }
    
    /**
     * Mensaje : "No se pudo abrir el archivo."
     * @param rootPane 
     */
    public static void mostrarMensaje24(Component rootPane)
    {
       JOptionPane.showMessageDialog(rootPane, "No se pudo abrir el archivo."); 
    }
    
    public static void mostrarMensajeNumeroInvalido(Component rootPane, String value) {
        JOptionPane.showMessageDialog(rootPane, "Campo inválido: " + value);
    }

    /**
     * Mensaje : "Ya existe un inventario registrado con ese código."
     * @param rootPane 
     */
    public static void mostrarMensajeExisteProducto(Component rootPane) {
        JOptionPane.showMessageDialog(rootPane, "Ya existe un inventario registrado con ese código.");
    }
    
    public static void mostrarMensajeYaExisteSalida(Component rootPane)
    {
        JOptionPane.showMessageDialog(rootPane, "Ya se encuentra agregado en la lista.");
    }
    
    /**
     * Muestra un mensaje para que seleccione un código y así agregarlo a la lista.
     * @param rootPane 
     */
    public static void mostrarMensajeImp(Component rootPane) {
        JOptionPane.showMessageDialog(rootPane, "Por favor, ingrese un código para agregar a la lista de impresión.");
    }

    /**
     * Mensaje : "Error al gestionar las operaciones en la base de datos, reinicie el programa."
     */
    public static void mostrarMensaje3(Component rootPane) {
        JOptionPane.showMessageDialog(rootPane, "Error al gestionar las operaciones en la base de datos, reinicie el programa.");
    }

    /**
     * Muestra un mensaje de completar correctamente los campos.
     */
    public static void mostrarMensaje2(Component rootPane) {
        JOptionPane.showMessageDialog(rootPane, "Complete los campos correctamente.");
    }
    
    public static void mostrarMensajeNoExisteInventario(Component rootPane) {
        JOptionPane.showMessageDialog(rootPane, "No existe un inventario registrado con ese código.");
    }

    /**
     * Mensaje : "Se produjo un error al procesar la información, reinicie el programa."
     */
    public static void mostrarMensaje5(Component rootPane) {
        JOptionPane.showMessageDialog(rootPane, "Se produjo un error al procesar la información, reinicie el programa.");
    }

    /**
     * Muestra un mensaje de completar correctamente los campos.
     */
    public static void mostrarMensaje7(Component rootPane) {
        JOptionPane.showMessageDialog(rootPane, "Complete correctamente los campos.");
    }
    
    /**
     * Muestra un mensaje de: Ingrese un valor válido.
     */
    public static void mostrarMensaje8(Component rootPane)
    {
        JOptionPane.showMessageDialog(rootPane, "Ingrese un valor válido.");
    }
    
    /**
     * Muestra un mensaje de: Error al generar el código.
     * @param rootPane 
     */
    public static void mostrarMensaje9(Component rootPane)
    {
        JOptionPane.showMessageDialog(rootPane, "Se ha producido un error al generar el código correspondiente. Reincie la operación.");
    }

    /**
     * Muestra un mensaje de : "No se ha encontrado ningún resultado."
     * @param rootPane 
     */
    public static void mostrarMensajeNoEncontrado(Component rootPane) {
        JOptionPane.showMessageDialog(rootPane, "No se encontraron resultados.");
    }

    public static void mostrarMensajeValidacion(Component rootPane) {
        JOptionPane.showMessageDialog(rootPane, "Error, ingrese un valor válido!!");
    }
    
    /**
     * Muestra un mensaje: "Seleccione un elemento de la lista."
     * @param rootPane 
     */
    public static void mostrarMensajeSeleccion(Component rootPane)
    {
        JOptionPane.showMessageDialog(rootPane, "Seleccione un elemento de la lista.");
    }
    
    public static void mostrarMensajeErrorDirectorio(Component rootPane)
    {
        JOptionPane.showMessageDialog(rootPane, "Error al crear el directorio de facturas.");
    }
    
    public static void mostrarMensajeDirectorioCreado(Component rootPane)
    {
        System.out.println("Directorio creado");
    }
    
    public static void mostrarMensajeCantMin(Component rootPane) {
        JOptionPane.showMessageDialog(rootPane, "La cantidad mínima es 1 unidad|.");
    }
    
    /**
     * Muestra un mensaje de: "La lista esta vacía."
     * @param rootPane 
     */
    public static void mostrarMensaje16(Component rootPane)
    {
        JOptionPane.showMessageDialog(rootPane, "La lista se encuentra vacía.");
    }
    
    /**
     * Muestra un mensaje de: "El proceso de impresión ha fallado."
     * @param rootPane 
     */
    public static void mostrarMensaje17(Component rootPane)
    {
        JOptionPane.showMessageDialog(rootPane, "El proceso de impresión ha fallado.");
    }
    
    /**
     * Muestra un mensaje de : "La operación se ha completado con éxito."
     * @param rootPane 
     */
    public static void mostrarMensaje18(Component rootPane)
    {
        JOptionPane.showMessageDialog(rootPane, "La operación se ha completado con éxito.");
    }
    
    /**
     * Mensaje : "Ha ocurrido un problema al obtener la factura. Reinicie el programa."
     * @param rootPane 
     */
    public static void mostrarMensaje19(Component rootPane)
    {
        JOptionPane.showMessageDialog(rootPane, "Ha ocurrido un problema al obtener la factura. Reinicie el programa.");
    }
    
    /**
     * Mensaje : "La factura no existe o ha sido eliminada del directorio."
     * @param rootPane 
     */
    public static void mostrarMensaje20(Component rootPane)
    {
        JOptionPane.showMessageDialog(rootPane, "La factura no existe o ha sido eliminada del directorio.");
    }
    
    /**
     * Mensaje : "Error al generar reporte."
     * @param rootPane 
     */
    public static void mostrarMensajeErrorGenerarReporte(Component rootPane)
    {
        JOptionPane.showMessageDialog(rootPane, "Error al generar reporte.");
    }
    
    public static void mostrarMensaje40(Component rootPane)
    {
        JOptionPane.showMessageDialog(rootPane, "Seleccione un tamaño de impresión.");
    }
}
