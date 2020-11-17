/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.mycompany.libreria.gral.system.model.Inventario;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Kevin
 */
public class Utiles {

    public static void copiarAPortapapelesConCTRL(java.awt.event.KeyEvent evt, JTable tabla, int COL_OBJ)
    {
        if (evt.isControlDown() && evt.getKeyCode() == java.awt.event.KeyEvent.VK_C)
        {
            copiarAPortapapeles(tabla, COL_OBJ);
        }
    }
    
    public static int obtenerColumnaSeleccionada(JTable tabla, Point p)
    {
        int col = tabla.columnAtPoint(p);
        
        return col;
    }
    
    public static void colorearRojo(JButton comp)
    {
        comp.setBackground(Color.red);
    }
    
    public static void descolorear(JButton comp)
    {
        comp.setBackground(new Color(240, 240, 240));
    }
    
    public static boolean isNumeric(String value)
    {
        long n = -1;
        double d = -1;
        boolean band = false;
        
        try {
            n = new Long(value);
        } catch (Exception e) {          
        }
        
        try {
            d = new Double(value);
        } catch (Exception e) {          
        }
        
        if (n < 0 & d < 0)
        {
            // Hacer nada.
        } else
        {
            band = true;
        }
        
        return band;
    }
    
    public static int indexFinal(String linea, String value) {
        int ret = -1;
        
        for (int i = linea.length(); i >= 0; i--) {
            if (i > 0 && linea.substring(i-1, i).equals(value)) {
                ret = i;
                break;
            }
        }
        return ret;
    }
    
    public static String obtenerValor(JTextField comp) {
        String value = "";

        try {
            value = comp.getText().trim();
        } catch (Exception e) {
        }

        return value;
    }

    public static void modoNumeros(java.awt.event.KeyEvent evt) {
        char car = evt.getKeyChar();

        if (car >= '0' & car <= '9') {
            // Hacer nada.
        } else {
            evt.consume();
        }
    }

    public static String subString(String linea, String cadObj) {
        String cadRet = "";

        try {
            String[] v = linea.split(cadObj);

            cadRet = v[0];
        } catch (Exception e) {
        }

        return cadRet;
    }

    /**
     *
     * @param linea Linea a dividir
     * @param inicCad Indice de inicio de la linea a recortar
     * @param cadSepCortes Caracter o string que serviará para hacer el corte.
     * Ej: " " .
     * @return
     */
    public static String cortarFinalM1(String linea, int inicCad, String... cadSepCortes) {
        String cadFinal = "";
        String cadRet = "";

        try {
            cadRet = linea.substring(inicCad, linea.trim().length());

            for (String cad : cadSepCortes) {
                cadRet = Utiles.subString(cadRet, cad.trim());
            }
        } catch (Exception e) {
        }

        if (cadRet == null || cadRet.trim().isEmpty()) {
            // Hacer nada.
        } else {
            cadFinal = cadRet;
        }

        return cadFinal;
    }

    /**
     *
     * @param linea
     * @param numCortes Indice del corte del final
     * @param cadSepCorte Separador entre los cortes
     * @return
     */
    public static String cortarFinalM2(String linea, String cadSepCorte) {
        String cadRet = "";

        linea = linea.trim();
        try {
            int indFinal = Utiles.indexFinal(linea, cadSepCorte);
            cadRet = linea.substring(indFinal, linea.length());

        } catch (Exception e) {
        }

        return cadRet;
    }

    public static String cortarFinalM3(String linea, int numCortes, String cadSepCorte) {
        String cadFinal = "";
        String cadRet = "";

        try {
            cadRet = linea.trim();

            List<String> lRet = Utiles.limpiar(cadRet.split(cadSepCorte));

            for (int i = 1; i <= numCortes; i++) {
                cadRet = Utiles.subString(cadRet, lRet.get(lRet.size() - numCortes));
            }

        } catch (Exception e) {
        }

        if (cadRet == null || cadRet.trim().isEmpty()) {
            // Hacer nada.
        } else {
            cadFinal = cadRet;
        }

        return cadFinal;
    }

    public static String cortarFinalM4(String linea, int numCortes, String cadSepCorte, int cantPosSup) {
        String cadFinal = "";
        String cadRet = "";

        try {
            cadRet = linea.trim();

            List<String> lRet = Utiles.limpiar(cadRet.split(cadSepCorte));

            for (int i = 1; i <= numCortes; i++) {
                cadRet = Utiles.subString(cadRet, lRet.get(lRet.size() - numCortes));
            }
            cadRet = cadRet.trim();

            cadRet = cadRet.substring(0, cadRet.length() - cantPosSup);
        } catch (Exception e) {
        }

        if (cadRet == null || cadRet.trim().isEmpty()) {
            // Hacer nada.
        } else {
            cadFinal = cadRet;
        }

        return cadFinal;
    }

    /**
     * Corta una cadena en funcion de la cantidad de palabras al inicio de la
     * cadena y la cadena separadora. Ej: cadSepCorte puede ser un "espacio".
     *
     * @param linea
     * @param numCortes
     * @param cadSepCorte
     * @return
     */
    public static String cortarInicioM1(String linea, int numCortes, String cadSepCorte) {
        String cadInicio = "";
        String cadRet = "";

        try {
            List<String> lRet = Utiles.limpiar(linea.trim().split(cadSepCorte));

            cadRet = lRet.get(numCortes);
        } catch (Exception e) {
        }

        if (cadRet == null || cadRet.trim().isEmpty()) {
            // Hacer nada.
        } else {
            cadInicio = cadRet.trim();
        }

        return cadInicio;
    }

    public static String cortarInicioM2(String linea, String cadSepCorte) {
        String cadInicio = "";
        String cadRet = "";

        try {
            cadRet = linea.trim();
            int indexCadCorte = cadRet.indexOf(cadSepCorte);

            cadRet = cadRet.substring(indexCadCorte, cadRet.length()).trim();
        } catch (Exception e) {
        }

        if (cadRet == null || cadRet.trim().isEmpty()) {
            // Hacer nada.
        } else {
            cadInicio = cadRet;
        }

        return cadInicio;
    }

    public static String cortarInicioM3(String linea, String cadSepCorte) {
        String cadInicio = "";
        String cadRet = "";

        try {
            cadRet = linea.trim();
            String[] v = null;
            if (cadSepCorte.isEmpty()) {
                // Hacer nada.
            } else {
                v = cadRet.split(cadSepCorte);
                cadRet = v[1];
            }

        } catch (Exception e) {
        }

        if (cadRet == null || cadRet.trim().isEmpty()) {
            // Hacer nada.
        } else {
            cadInicio = cadRet;
        }

        return cadInicio;
    }

    public static List<String> limpiar(String[] v) {
        List<String> lRet = new ArrayList<>();

        for (String cad : v) {
            try {
                cad = cad.trim();

                if (cad == null || cad.isEmpty()) {
                    // Hacer nada.
                } else {
                    lRet.add(cad);
                }
            } catch (Exception e) {
            }
        }
        return lRet;
    }

    public static void salir(JFrame frame) {
        frame.dispose();
    }

    public static void seleccionar(JTextField componente) {
        componente.selectAll();
        componente.requestFocus();
    }

    public static void seleccionarYBorrar(java.awt.event.KeyEvent evt, JTextField componente) {
        if (evt.getKeyChar() == '\n') {
            // Hacer nada.
            componente.selectAll();
        } else {
            try {
                if (componente.getSelectedText() == null || componente.getSelectedText().isEmpty()) {
                    // Hacer nada.
                } else {
                    componente.setText("");
                }
            } catch (Exception e) {
            }
        }
    }

    public static String limpiar(String cadena, String letra) {
        String ret = "";

        if (cadena == null || cadena.trim().isEmpty()) {
            // Hacer nada.
        } else {
            ret = cadena.replace("'", "").trim();
        }

        return ret;
    }

    public static void suprimirComilla(JTextField comp) {
        String cadena = comp.getText();

        if (cadena == null || cadena.trim().isEmpty()) {
            // Hacer nada.
        } else {
            if (cadena.contains("'")) {
                cadena = cadena.replace("'", "").trim();
                comp.setText(cadena);
            }
        }
    }

    public static void suprimirComilla(JTextArea comp) {
        String cadena = comp.getText();

        if (cadena == null || cadena.trim().isEmpty()) {
            // Hacer nada.
        } else {
            cadena = cadena.replace("'", "").trim();
        }

        comp.setText(cadena);
    }

    public static void modoTabM1(JTable tabla) {
        int rowSel = tabla.getSelectedRow();
        int colSel = tabla.getSelectedColumn();

        tabla.editCellAt(rowSel, colSel);
        if (tabla.isEditing()) {
            tabla.getEditorComponent().requestFocus();
        }
    }

    public static void modoTabM2(JTable tabla) {
        tabla.getInputMap().put(
                KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0), "startEditing");
    }

    public static void suprimirComilla(java.awt.event.KeyEvent evt) {
        // Validaciones
        int comilla = 39;

        if (evt.getKeyChar() == comilla) {
            evt.consume();
        }
    }

    public static void suprimirComilla(JTable tabla) {
        JTextField textField = new JTextField();

        tabla.setDefaultEditor(Object.class, new TableEditor(textField));
    }

    public static void posicionarPrincipio(JTable tabla) {
        tabla.scrollRectToVisible(new Rectangle(tabla.getCellRect(0, 0, true)));
    }

    public static void posicionarPorFilaSel(JTable tabla) {
        if (tabla.getSelectedRow() < 0) {
            // Hacer nada.
        } else {
            if (isRowVisible(tabla)) {
                // Hacer nada.
            } else {
                tabla.scrollRectToVisible(new Rectangle(tabla.getCellRect(tabla.getSelectedRow(), 0, true)));
            }
        }
    }

    public static int getCountRowVisible(JTable tabla) {
        Rectangle vr = tabla.getVisibleRect();
        int first = tabla.rowAtPoint(vr.getLocation());
        vr.translate(0, vr.height);
        int visibleRows = tabla.rowAtPoint(vr.getLocation()) - first;

        return visibleRows;
    }

    public static boolean isRowVisible(JTable table) {
        if (!(table.getParent() instanceof JViewport)) {
            return false;
        }
        int vColIndex = 0;
        JViewport viewport = (JViewport) table.getParent();
        Rectangle rect = table.getCellRect(table.getSelectedRow(), vColIndex, true);
        Point pt = viewport.getViewPosition();
        rect.setLocation(rect.x - pt.x, rect.y - pt.y);
        return new Rectangle(viewport.getExtentSize()).contains(rect);
    }

    public static void siguiente(JTable tabla) {
        int row = tabla.getSelectionModel().getMaxSelectionIndex();

        if (row < 0) {
            row = 0;
        } else {
            // Hacer nada.
        }
        tabla.clearSelection();
        seleccionarFila(tabla, row + 1);
        scrollToVisible(tabla, row, 7);

    }

    public static void anterior(JTable tabla) {
        int row = tabla.getSelectedRow();

        if (row < 0) {
            row = 0;
        } else {
            // Hacer nada.
        }
        tabla.clearSelection();
        seleccionarFilaM2(tabla, row - 1);
        scrollToVisible(tabla, row, 7);
    }

    public static void scrollToVisible(JTable table, int rowIndex, int vColIndex) {
        if (!(table.getParent() instanceof JViewport)) {
            return;
        }
        JViewport viewport = (JViewport) table.getParent();

        // This rectangle is relative to the table where the
        // northwest corner of cell (0,0) is always (0,0).
        Rectangle rect = table.getCellRect(rowIndex, vColIndex, true);

        // The location of the viewport relative to the table
        Point pt = viewport.getViewPosition();

        // Translate the cell location so that it is relative
        // to the view, assuming the northwest corner of the
        // view is (0,0)
        rect.setLocation(rect.x - pt.x, rect.y - pt.y);

        table.scrollRectToVisible(rect);

        // Scroll the area into view
        viewport.scrollRectToVisible(rect);
    }

    public static String formatearM1(int n) {
        String value = String.format("%.1f", (float) n);

        return value;
    }

    public static String formatearM2(int n) {
        String value = String.valueOf(n);

        //value += n <= 1 ? " ud." : " uds.";
        value += " x";

        return value;
    }

    public static List<String> separar(String cadena) {
        List<String> w = new ArrayList<>();
        String[] lista = cadena.split(" ");

        for (String value : lista) {
            if (value == null || value.trim().isEmpty()) {
                continue;
            } else {
                w.add(value);
            }
        }

        return w;
    }

    /**
     * Retorna un tipo Date a string de la froma dd-MM-yyyy
     *
     * @return fecha dd-MM-yyyy
     */
    public static boolean existeCoincidencia(String line, String value) {
        boolean band = false;

        if (line.isEmpty()) {
            // Hacer nada.
        } else {
            String pattern = String.format(".*(%s).*", value);;
            Pattern r = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
            Matcher m = r.matcher(line);

            if (m.find()) {
                band = true;
            }
        }

        return band;
    }

    public static List<String[]> obtenerLista3P(PdfReader reader, int ind0, int d0, String sucursal) throws IOException {
        List<String[]> list = new ArrayList<>();

        for (int i = 1; i <= reader.getNumberOfPages(); i++) {
            String page = PdfTextExtractor.getTextFromPage(reader, i);
            String[] lines = page.split("\n");

            for (String linea : lines) {
                try {
                    String p5 = sucursal;
                    
                    String p4 = Utiles.cortarFinalM2(linea, " ").trim();
                    linea = linea.substring(0, Utiles.indexFinal(linea.trim(), " "));
                    
                    String p3 = Utiles.cortarFinalM2(linea, " ").trim();
                    linea = linea.substring(0, Utiles.indexFinal(linea.trim(), " "));
                    
                    String p2 = Utiles.cortarFinalM2(linea, " ");
                    linea = linea.substring(0, Utiles.indexFinal(linea.trim(), " ")).trim();
                    
                    String p1 = linea.substring(ind0 + d0, linea.length());
                    String p0 = linea.trim().substring(ind0, ind0 + d0).trim();
                    
                    String[] datos = {p0, p1, p2, p3, p4, p5};

                    list.add(datos);
                } catch (Exception e) {
                }
            }
        }

        return list;
    }

    public static List<String[]> obtenerLista2P(PdfReader reader, int ind0, int d0,
            int ind1, int d1, int ind2,
            int dimension, String sucursal) throws IOException {
        List<String[]> list = new ArrayList<>();

        for (int i = 1; i <= reader.getNumberOfPages(); i++) {
            String page = PdfTextExtractor.getTextFromPage(reader, i);
            String[] lines = page.split("\n");

            for (String linea : lines) {
                if (linea.trim().length() > dimension) {
                    try {
                        String[] v1 = linea.trim().split(" ");
                        String[] v2 = linea.substring(6, linea.trim().length()).split(" ");
                        String[] v3 = linea.substring(6, linea.trim().length()).split(v2[v2.length - 1]);
                        String p0 = v1[0].trim();
                        String p1 = v3[0].trim();//linea.substring(ind1, ind1 + d1).trim();
                        String p2 = "";
                        String p3 = ""; //v2[v2.length - 2];
                        String p4 = v2[v2.length - 1].trim();//linea.substring(ind2, ind2 + (linea.length() - ind2));
                        String p5 = sucursal;
                        String[] datos = {p0, p1, p2, p3, p4, p5};

                        list.add(datos);
                    } catch (Exception e) {
                    }
                }
            }
        }

        return list;
    }

    public static List<String[]> obtenerLista5P(PdfReader reader, int d0,int d1, String sucursal) throws IOException {
        List<String[]> list = new ArrayList<>();

        for (int i = 1; i <= reader.getNumberOfPages(); i++) {
            String page = PdfTextExtractor.getTextFromPage(reader, i);
            String[] lines = page.split("\n");

            for (String linea : lines) {
                linea = linea.trim();
                if (linea.isEmpty()) {
                    continue;
                } else {
                    try {
                        linea = linea.substring(0 + d0, linea.length()).trim();
                    } catch (Exception e) {
                        continue;
                    }
                }
                
                String p0 = "";
                String p1 = "";
                String p2 = "";
                String p3 = "";
                String p4 = "";
                String p5 = sucursal;

                // Codigo
                try {
                    linea = linea.trim();
                    String codigo = linea.substring(0, d1).trim();

                    if (isNumeric(codigo)) {
                        p0 = codigo;
                        linea = linea.substring(0 + d1, linea.length()).trim();
                    } else {
                        linea = linea.trim();
                        p0 = "";
                    }
                } catch (Exception e) {
                }
                
                // Precio contado
                try {
                    String pCont = linea.substring(Utiles.indexFinal(linea, " "), linea.length()).trim();
                    linea = linea.substring(0, Utiles.indexFinal(linea, " ")).trim();
                    p4 = pCont;
                } catch (Exception e) {
                }

                try {
                    String pLista = linea.substring(Utiles.indexFinal(linea, " "), linea.length()).trim();
                    linea = linea.substring(0, Utiles.indexFinal(linea, " ")).trim();
                    p3 = pLista;
                } catch (Exception e) {
                }
                
                // Cantidad          
                try {
                    String cant = linea.substring(Utiles.indexFinal(linea, " "), linea.length()).trim();
                    
                    linea = linea.substring(0, Utiles.indexFinal(linea, " ")).trim();
                    p2 = cant;
                } catch (Exception e) {
                }
                
                try {
                    p5 = sucursal;
                } catch (Exception e) {
                }

                try {
                    p1 = linea.trim();
                } catch (Exception e) {
                }

                if (isNumeric(p3) && isNumeric(p4)) {
                    String[] datos = {p0, p1, p2, p3, p4, p5};

                    list.add(datos);
                }

            }
        }
        
        return list;
    }

    /**
     * Retorna un objeto String de la forma "dd-MM-yyyy"
     *
     * @param fecha
     * @return
     */
    public static String toStringM3(Date fecha) {
        String value;

        if (fecha == null) {
            value = "";
        } else {
            Date fechaIngreso = fecha;
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

            value = dateFormat.format(fechaIngreso);
        }

        return value;
    }

    /**
     * Retorna un objeto String de la forma: "dd-MM-yyyy HH-mm-ss"
     *
     * @param tiempo
     * @return
     */
    public static String toStringM1(Date tiempo) {
        SimpleDateFormat formatterFec = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat formatterTiempo = new SimpleDateFormat("HH:mm:ss", new Locale("es", "ES"));

        String part1 = formatterFec.format(tiempo);
        String part2 = formatterTiempo.format(tiempo);

        String CADENA_FT = part1 + " " + part2.replace(":", "h").substring(0, 3) + part2.replace(":", "m").substring(3, 6) + part2.substring(6, part2.length()) + "s";

        return CADENA_FT;
    }

    /**
     * Retorna un objeto String de la forma: "dd-MM-YY HH:mm:ss"
     *
     * @param fecha
     * @return
     */
    public static String toStringM2(Date fecha) {
        String value;

        if (fecha == null) {
            value = "";
        } else {
            SimpleDateFormat formatterFec = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat formatterTiempo = new SimpleDateFormat("HH:mm:ss", new Locale("es", "ES"));

            value = formatterFec.format(fecha) + " " + formatterTiempo.format(fecha);
        }

        return value;
    }

    public static String obtenerTiempoActual() {
        Date fechaTiempo = GregorianCalendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy HH:mm:ss", new Locale("es", "ES"));

        return dateFormat.format(fechaTiempo);
    }

    public static Date obtenerFechaActualM4() {
        Date fecha = Calendar.getInstance().getTime();

        return fecha;
    }

    /**
     * Retorna un fecha del tipo dd-MM-YYYY - HH:mm:ss
     *
     * @return
     */
    public static String obtenerFechaActual() {
        Date tiempo = Calendar.getInstance().getTime();
        SimpleDateFormat formatterFec = new SimpleDateFormat("dd-MM-yyyy", new Locale("es", "ES"));
        SimpleDateFormat formatterTiempo = new SimpleDateFormat("HH:mm:ss", new Locale("es", "ES"));
        String strDate = formatterFec.format(tiempo) + "  -  " + formatterTiempo.format(tiempo);

        return strDate;
    }

    public static String obtenerFechaActualM3() {
        Date tiempo = Calendar.getInstance().getTime();
        SimpleDateFormat formatterFec = new SimpleDateFormat("dd-MM-yyyy", new Locale("es", "ES"));
        String strDate = formatterFec.format(tiempo);

        return strDate;
    }

    public static String obtenerFechaActualM2() {
        Date tiempo = Calendar.getInstance().getTime();
        SimpleDateFormat formatterFec = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat formatterTiempo = new SimpleDateFormat("HH:mm:ss");

        String part1 = formatterFec.format(tiempo);
        String part2 = formatterTiempo.format(tiempo);

        String CADENA_FT = part1 + " " + part2.replace(":", "h").substring(0, 3) + part2.replace(":", "m").substring(3, 6) + part2.substring(6, part2.length()) + "s";

        return CADENA_FT;
    }

    public static void limpiarSeleccion(JTable table) {
        table.clearSelection();
    }

    public static void seleccionarFila0(JTable table) {
        final int F_0 = 0;
        final int F_1 = 0;

        if (F_0 < 0 || F_1 < 0) {
            // Hacer nada. 
        } else {
            table.getSelectionModel().addSelectionInterval(F_0, F_1);
        }
    }

    public static void seleccionarFila(JTable table, int index1, int index2) {
        final int F_0 = index1;
        final int F_1 = index2;

        if (F_0 < 0 || F_1 < 0) {
            // Hacer nada. 
        } else {
            table.getSelectionModel().addSelectionInterval(F_0, F_1);
        }
    }

    public static void seleccionarFila(JTable table, int index1) {
        final int F_0 = index1;
        final int F_1 = index1;

        if (F_0 < 0 || F_1 < 0) {
            // Hacer nada. 
        } else {
            table.getSelectionModel().addSelectionInterval(F_0, F_1);
        }
    }

    public static void seleccionarFilaM2(JTable tabla, int index) {
        final int F_0 = index;

        if (F_0 < 0) {
            // Hacer nada. 
        } else {
            tabla.getSelectionModel().setSelectionInterval(F_0, F_0);
        }
    }

    public static void limpiarTabla(JTable tabla) {
        final int COUNT_ROW = 30;

        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.getDataVector().clear();
        model.setRowCount(COUNT_ROW);

        TableCellRenderer renderer = new EvenOddRenderer();

        tabla.setDefaultRenderer(Object.class, renderer);
        tabla.clearSelection();
        tabla.getTableHeader().setFont(new Font("Tahoma", Font.CENTER_BASELINE, 13));
        Dimension dim = tabla.getTableHeader().getSize();

        tabla.getTableHeader().setPreferredSize(new Dimension((int) dim.getWidth(), 25));
    }

    public static void limpiarTabla(JTable tabla, String[] tittles) {
        final int COUNT_ROW = 30;

        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.getDataVector().clear();
        model.setRowCount(COUNT_ROW);

        TableCellRenderer renderer = new EvenOddRenderer();

        tabla.setDefaultRenderer(Object.class, renderer);
        tabla.clearSelection();

        for (int i = 0; i < tittles.length; i++) {
            JTableHeader th = tabla.getTableHeader();
            TableColumnModel tcm = th.getColumnModel();
            TableColumn tc = tcm.getColumn(i);
            tc.setHeaderValue(tittles[i]);
        }
        tabla.getTableHeader().setFont(new Font("Tahoma", Font.CENTER_BASELINE, 13));
    }
    
    public static void limpiarTabla(JTable tabla, String[] tittles, boolean bold) {
        final int COUNT_ROW = 30;

        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.getDataVector().clear();
        model.setRowCount(COUNT_ROW);

        TableCellRenderer renderer = bold? new EvenOddRendererBold(): new EvenOddRenderer();

        tabla.setDefaultRenderer(Object.class, renderer);
        tabla.clearSelection();

        for (int i = 0; i < tittles.length; i++) {
            JTableHeader th = tabla.getTableHeader();
            TableColumnModel tcm = th.getColumnModel();
            TableColumn tc = tcm.getColumn(i);
            tc.setHeaderValue(tittles[i]);
        }
        tabla.getTableHeader().setFont(new Font("Tahoma", Font.CENTER_BASELINE, 13));
    }

    public static void limpiarTabla(JTable tabla, int countFilas) {
        final int COUNT_ROW = countFilas;

        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.getDataVector().clear();
        model.setRowCount(COUNT_ROW);

        TableCellRenderer renderer = new EvenOddRenderer();

        tabla.setDefaultRenderer(Object.class, renderer);
        tabla.clearSelection();
        tabla.getTableHeader().setFont(new Font("Tahoma", Font.CENTER_BASELINE, 13));

        Dimension dim = tabla.getTableHeader().getSize();

        tabla.getTableHeader().setPreferredSize(new Dimension((int) dim.getWidth(), 25));
    }

    public static void limpiarTabla(JTable tabla, int numFilas, boolean theme) {
        final int COUNT_ROW = numFilas;

        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.getDataVector().clear();
        model.setRowCount(COUNT_ROW);

        if (theme) {
            TableCellRenderer renderer = new EvenOddRenderer();

            tabla.setDefaultRenderer(Object.class, renderer);
        }
        tabla.clearSelection();
        tabla.getTableHeader().setFont(new Font("Tahoma", Font.CENTER_BASELINE, 13));

        Dimension dim = tabla.getTableHeader().getSize();

        tabla.getTableHeader().setPreferredSize(new Dimension((int) dim.getWidth(), 25));
    }

    public static void desplazamientoTecla(JTable table, int sentido) {
        int selRow = table.getSelectedRow();

        if (selRow == -1) {
            int row = selRow + 1 * sentido;

            table.getSelectionModel().setSelectionInterval(row, row);
            table.scrollRectToVisible(
                    new Rectangle(table.getCellRect(row, 0, true)));
        } else {

            int COUNT_FILAS = table.getModel().getRowCount();

            if (selRow >= COUNT_FILAS) {
                selRow = -1;
            }

            int row = selRow + 1 * sentido;

            table.getSelectionModel().setSelectionInterval(row, row);
            table.scrollRectToVisible(
                    new Rectangle(table.getCellRect(row, 0, true)));

        }
    }

    public static void ordenarAZ(List<Inventario> l) {
        Collections.sort(l,
                (Inventario obj1, Inventario obj2)
                -> obj1.getProducto().getDescripcion().compareTo(obj2.getProducto().getDescripcion()));
    }

    public static String formatear(BigDecimal value) {

        DecimalFormat df = new DecimalFormat("###,###,##0.00");

        return df.format(value);
    }

    /**
     * Comparamos las Fechas
     *
     * @author CHENAO
     * @param fecha1
     * @param fechaActual
     * @return
     */
    public static boolean compararFechasConDate(String fecha1, String fechaActual) {

        boolean resultado = false;
        try {
            /**
             * Obtenemos las fechas enviadas en el formato a comparar
             */
            SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaDate1 = formateador.parse(fecha1);
            Date fechaDate2 = formateador.parse(fechaActual);

            if (fechaDate1.before(fechaDate2)) {
                resultado = false;
            } else {
                if (fechaDate2.before(fechaDate1)) {
                    resultado = false;
                } else {
                    resultado = true;
                }
            }
        } catch (ParseException e) {
            System.out.println("Se Produjo un Error!!!  " + e.getMessage());
        }
        return resultado;
    }

    public static void establecerFocusActivoG(JTextField component) {
        component.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
        component.requestFocus();
        component.selectAll();
    }

    public static void establecerFocusActivoGM2(JTextField component) {
        component.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        component.setBackground(new Color(100, 240, 68));
        component.requestFocus();
        component.selectAll();
    }

    public static void establecerFocusActivoB(JTextField component) {
        component.setBorder(BorderFactory.createLineBorder(Color.blue, 3));
        component.requestFocus();
        component.selectAll();

    }

    public static void establecerFocusInactivo(JTextField component) {
        component.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    }

    public static void establecerFocusInactivoM2(JTextField component) {
        component.setBackground(Color.WHITE);
        component.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    }

    public static void limpiarCampo(JTextField component) {
        component.setBackground(Color.white);
        component.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        component.setText("");
    }

    public static void deshabilitarCampo(Component compoenente) {
        compoenente.setEnabled(false);
    }

    /**
     * Establece un fondo de color verde.
     *
     * @param component
     */
    public static void establecerFocus1(JTextField component) {
        component.setBackground(Color.green);
    }

    /**
     * Establece un fondo de color rojo.
     *
     * @param component
     */
    public static void establecerFocus2(JTextField component) {
        component.setBackground(Color.red);
        component.selectAll();
        component.requestFocus();
    }

    public static void requerirFocus(JTextField component) {
        component.requestFocus();
        component.selectAll();
    }

    /**
     * Obtiene los cambios o el valor efectuados sobre la celda de la tabla.
     *
     * @param tabla
     * @return
     */
    public static String obtenerCambios(JTable tabla) {
        String valor = "";
        int row = tabla.getSelectedRow();
        int col = tabla.getSelectedColumn();

        if (row < 0 || col < 0) {
            // Hacer nada.
        } else {
            String retorno = (String) tabla.getValueAt(row, col);

            if (retorno == null || retorno.trim().isEmpty()) {
                // Hacer nada.
            } else {
                valor = retorno.trim();
            }
        }
        return valor;
    }

    public static String obtenerValor(JTable tabla, Point p, int indexColObj, int indexColValor) {
        String valor = "";
        int row = tabla.rowAtPoint(p);
        int col = tabla.columnAtPoint(p);

        if (row < 0 || col < 0) {
            // Hacer nada.
        } else {
            if (col == indexColObj) {
                String retorno = (String) tabla.getValueAt(row, indexColValor);

                if (retorno == null) {
                    // Hacer nada.
                } else {
                    valor = retorno.trim();
                }
            }
        }

        return valor;
    }

    public static String obtenerValor(JTable tabla, int indexColObj) {
        String valor = "";
        int row = tabla.getSelectedRow();

        if (row < 0) {
            // Hacer nada.
        } else {
            String retorno = (String) tabla.getValueAt(row, indexColObj);

            if (retorno == null || retorno.trim().isEmpty()) {
                // Hacer nada.
            } else {
                valor = retorno.trim();
            }
        }

        return valor;
    }

    public static String obtenerValor(JTable tabla, int rowSel, int colSel) {
        String valor = "";

        if (rowSel < 0 || colSel < 0) {
            //Hacer nada.
        } else {
            String retorno = (String) tabla.getValueAt(rowSel, colSel);

            if (retorno == null) {
                // Hacer nada.
            } else {
                valor = retorno.trim();
            }
        }

        return valor;
    }

    public static void pararEdicion(JTable tabla) {
        tabla.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);

        if (tabla.isEditing()) {
            tabla.getCellEditor().cancelCellEditing();
        } else {
            // Hacer nada.
        }
    }

    public static void seleccionarFila(JTable tabla, int colObj, String valueObj) {

        int n = tabla.getRowCount();

        if (n == 0 || colObj < 0 || valueObj == null || valueObj.isEmpty()) {
            // Hacer nada.
        } else {
            Utiles.limpiarSeleccion(tabla);

            for (int i = 0; i < n; i++) {
                String value = Utiles.obtenerValor(tabla, i, colObj);

                if (value == null || value.isEmpty()) {
                    // Hacer nada.
                } else {
                    if (value.equals(valueObj)) {
                        seleccionarFila(tabla, i);
                    }
                }
            }
        }
    }

    public static void seleccionarFilaM2(JTable tabla, int colObj, String valueObj) {

        int n = tabla.getRowCount();

        if (n == 0 || colObj < 0 || valueObj == null || valueObj.isEmpty()) {
            // Hacer nada.
        } else {

            for (int i = 0; i < n; i++) {
                String value = Utiles.obtenerValor(tabla, i, colObj);

                if (value == null || value.isEmpty()) {
                    // Hacer nada.
                } else {
                    if (value.equals(valueObj)) {
                        seleccionarFila(tabla, i);
                    }
                }
            }
        }
    }
    
    /**
     *
     * @param dia
     * @param mes "Enero, Febrero, ..."
     * @param anio
     * @return
     */
    public Date obtenerFecha(String dia, String mes, String anio) {
        String MES;

        switch (mes) {
            case "enero":
                MES = "1";
                break;
            case "febrero":
                MES = "2";
                break;
            case "marzo":
                MES = "3";
                break;
            case "abril":
                MES = "4";
                break;
            case "mayo":
                MES = "5";
                break;
            case "junio":
                MES = "6";
                break;
            case "julio":
                MES = "7";
                break;
            case "agosto":
                MES = "8";
                break;
            case "septiembre":
                MES = "9";
                break;
            case "octubre":
                MES = "10";
                break;
            case "noviembre":
                MES = "11";
                break;
            case "diciembre":
                MES = "12";
                break;
            default:
                MES = "1";
        }
        Date f;

        try {
            String fechaABuscar = dia + "/" + MES + "/" + anio;
            SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");

            f = formateador.parse(fechaABuscar);
        } catch (Exception e) {
            f = null;
        }

        return f;
    }

    public static void copiarAPortapapeles(JTable tabla, int colObj) {
        String value = "";
        int row = tabla.getSelectedRow();

        if (row < 0) {
            // Hacer nada.
        } else {
            String retorno = (String) tabla.getValueAt(row, colObj);

            if (retorno == null) {
                // Hacer nada.
            } else {
                value = retorno.trim();
            }
        }
        StringSelection selection = new StringSelection(value);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

        clipboard.setContents(selection, selection);
    }

    public static String obtenerDePortapapeles() {
        String dato = "";

        try {
            Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
            Transferable t = cb.getContents(null);

            // Construimos el DataFlavor correspondiente al String java
            DataFlavor dataFlavorStringJava = new DataFlavor("application/x-java-serialized-object; class=java.lang.String");

            // Y si el dato se puede conseguir como String java, lo sacamos por pantalla
            if (t.isDataFlavorSupported(dataFlavorStringJava)) {
                dato = (String) t.getTransferData(dataFlavorStringJava);
            }

        } catch (Exception e) {
        }

        return dato;
    }

    public static void establecerFondoError(JTextField comp) {
        comp.setBackground(Color.red);
    }

    public static void establecerFondoCorrecto(JTextField comp) {
        comp.setBackground(Color.YELLOW);
    }

    public static void pararFormulario(Component[] v) {
        for (Component comp : v) {
            comp.setEnabled(false);
        }
    }

    public static String capitalizeString(String string) {
        char[] chars = string.toLowerCase().toCharArray();
        boolean found = false;
        for (int i = 0; i < chars.length; i++) {
            if (!found && Character.isLetter(chars[i])) {
                chars[i] = Character.toUpperCase(chars[i]);
                found = true;
            } else if (Character.isWhitespace(chars[i]) || chars[i] == '.' || chars[i] == '\'') { // You can add other chars here
                found = false;
            }
        }
        return String.valueOf(chars);
    }
}
