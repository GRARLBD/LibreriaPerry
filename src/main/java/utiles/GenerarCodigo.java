/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

import com.mycompany.libreria.gral.system.model.Inventario;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author KEVIN
 */
public class GenerarCodigo {

    private static Collection<Inventario> lInv = null;

    public GenerarCodigo(Collection<Inventario> list)
    {
        lInv = list;
    }

    public static Collection<Inventario> getInventarios() {

        if (lInv == null) {
            Collection<Inventario> nLista = new ArrayList<>();
            
            final int N = 20;
            long codigo = 500;
            for (int i = 0; i < N; i++)
            {
                codigo++;
                
                Inventario inv = new Inventario();
                inv.getProducto().setCodigo(String.valueOf(codigo));
                nLista.add(inv);
            }
            
            lInv = nLista;
        }
        
        return lInv;
    }


    public static void toViewReport() throws JRException {

    /*    JasperReport jr = JasperCompileManager.compileReport("C:\\Users\\KEVIN\\Documents\\NetBeansProjects\\Libreria-GRAL-SYSTEM\\src\\main\\java\\utiles\\CodigoBarras.jrxml");
        Map<String, Object> parametros = new HashMap();

        parametros.put("LISTA_CODIGO_PRODUCTO", getProductos());

        JasperPrint jp = JasperFillManager.fillReport(jr, parametros, new JREmptyDataSource());
        JasperViewer.viewReport(jp, false);*/

        //
        final String tittle = "Generador de códigos";
        // Definimos cual sera nuestra fuente de datos
        JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(getInventarios());
        
        // Recuperamos el fichero fuente 
        String dir = Path.PATH_ROOT_IMPRESION.getNombre() + "\\CodigoBarras.jrxml";
        JasperDesign jd = JRXmlLoader.load(dir);
        // Compilamos el informe jrxml
        JasperReport report = JasperCompileManager.compileReport(jd);
        Map<String, Object> parametros = new HashMap();
        JasperPrint jp = JasperFillManager.fillReport(report, parametros, ds);

        JasperViewer jv = new JasperViewer(jp, false);
        jv.setTitle(tittle);
        jv.setVisible(true);
        // Guarda el reporte.
        //JasperExportManager.exportReportToPdfFile( jasperPrint, "E:/temporal/reporte.pdf");
    }
    
    public static void toViewReportM2() throws JRException {

        final String tittle = "Generador de códigos";
        // Definimos cual sera nuestra fuente de datos
        JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(getInventarios());
        // Recuperamos el fichero fuente 
        String dir = Path.PATH_ROOT_IMPRESION.getNombre() + "\\CodigoBarras_1.jrxml";
        JasperDesign jd = JRXmlLoader.load(dir);
        // Compilamos el informe jrxml
        JasperReport report = JasperCompileManager.compileReport(jd);
        Map<String, Object> parametros = new HashMap();
        JasperPrint jp = JasperFillManager.fillReport(report, parametros, ds);

        JasperViewer jv = new JasperViewer(jp, false);
        jv.setTitle(tittle);
        jv.setVisible(true);
    }
    
    public static void toViewReportM3() throws JRException {

        final String tittle = "Generador de códigos";
        // Definimos cual sera nuestra fuente de datos
        JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(getInventarios());
        // Recuperamos el fichero fuente 
        String dir = Path.PATH_ROOT_IMPRESION.getNombre() + "\\CodigoBarras_2.jrxml";
        JasperDesign jd = JRXmlLoader.load(dir);
        // Compilamos el informe jrxml
        JasperReport report = JasperCompileManager.compileReport(jd);
        Map<String, Object> parametros = new HashMap();
        JasperPrint jp = JasperFillManager.fillReport(report, parametros, ds);

        JasperViewer jv = new JasperViewer(jp, false);
        jv.setTitle(tittle);
        jv.setVisible(true);
    }
    
/*
    public void toPDFGuardar(String reportName) throws JRException {

        JasperReport jr = JasperCompileManager.compileReport("C:\\Users\\KEVIN\\Documents\\NetBeansProjects\\Libreria-GRAL-SYSTEM\\src\\main\\java\\utiles\\Report.jrxml");
        Map<String, Object> parametros = new HashMap();

        parametros.put("LISTA_UTILES", getSalidas());
        parametros.put("TOTAL_LISTA", getTotal());

        Date tiempo = Calendar.getInstance().getTime();
        SimpleDateFormat formatterFec = new SimpleDateFormat("dd-MM-yyyy", new Locale("es_AR"));
        SimpleDateFormat formatterTiempo = new SimpleDateFormat("HH:mm:ss", new Locale("es_AR"));
        String strDate = formatterFec.format(tiempo) + "  -  " + formatterTiempo.format(tiempo);
        parametros.put("TIEMPO", strDate);

        JasperPrint jp = JasperFillManager.fillReport(jr, parametros, new JREmptyDataSource());
        String dirBase = "C:\\Users\\KEVIN\\Documents\\Facturas LIBRERIA PERRY";
        String dirNuevo = formatterFec.format(tiempo);
        
        String ft = formatterTiempo.format(tiempo);
        String CADENA_FT = ft.replace(":", "h").substring(0, 5) + "m" + ft.substring(6, 8) + "s";
        String nomRep = "Factura " + CADENA_FT + ".pdf";

        try {
            File directorio = new File(dirBase + "\\" + dirNuevo);
            directorio.mkdir();
            //Guarda el reporte.
            JasperExportManager.exportReportToPdfFile(jp, directorio.getAbsolutePath() + "//" + nomRep);
        } catch (JRException e) 
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al crear directorio y guardar la factura!!, reinicie el programa.");
        }
    }*/

    public void viewReport() throws JRException {
        toViewReport();
    }
    
    public void viewReportM2() throws JRException {
        toViewReportM2();
    }
    
    public void viewReportM3() throws JRException {
        toViewReportM3();
    }
}
