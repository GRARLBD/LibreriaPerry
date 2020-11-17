/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

import com.mycompany.libreria.gral.system.model.Factura;
import com.mycompany.libreria.gral.system.model.Salida;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author KEVIN
 */
public class ImpresionFactura {

    private String nombreJasper;
    private Factura factura;

    public ImpresionFactura(Factura fact)
    {
        this.nombreJasper = "Report.jasper";
        this.factura = fact;
    }

    private String getTotal() {
        return "$ " + factura.getTotalFactura();
    }

    private String getApNom()
    {
        return factura.getCliente();
    }
    
    private String getPago()
    {
        return factura.getPago();
    }
    
    private Collection<Salida> getListaSalidas()
    {
        return factura.getListaSalidas();
    }

    public String getNombreJasper() {
        return nombreJasper;
    }

    public void setNombreJasper(String nombreJasper) {
        this.nombreJasper = nombreJasper;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public ImpresionFactura(String nombreJasper, Factura factura) {
        this.nombreJasper = nombreJasper;
        this.factura = factura;
    }
    
    public boolean toPDF() throws JRException {

        boolean band = true;
        
        String dir = Path.PATH_ROOT_IMPRESION.getNombre() + "\\Report.jrxml";
        JasperReport jr = JasperCompileManager.compileReport(dir);
        Map<String, Object> parametros = new HashMap();

        parametros.put("LISTA_UTILES", getListaSalidas());
        parametros.put("TOTAL_LISTA", getTotal());
        parametros.put("APNOM", getApNom());
        parametros.put("PAGO", getPago());

        parametros.put("TIEMPO", Utiles.toStringM2(getFactura().getFecha()));

        JasperPrint jp = JasperFillManager.fillReport(jr, parametros, new JREmptyDataSource());
        
        JasperViewer jv = new JasperViewer(jp, false);
        jv.setTitle(getFactura().getCodigoFactura());
        jv.setVisible(true);
        
       // JasperViewer.viewReport(jp, false);

        // Guarda el reporte.
        //JasperExportManager.exportReportToPdfFile( jasperPrint, "E:/temporal/reporte.pdf");
        return band;
    }

    public void toPDFGuardar() throws JRException {

        String dir = Path.PATH_ROOT_IMPRESION.getNombre() + "\\Report.jrxml";
        JasperReport jr = JasperCompileManager.compileReport(dir);
        Map<String, Object> parametros = new HashMap();

        parametros.put("LISTA_UTILES", getListaSalidas());
        parametros.put("TOTAL_LISTA", getTotal());
        parametros.put("APNOM", getApNom());
        parametros.put("PAGO", getPago());

        parametros.put("TIEMPO", Utiles.toStringM2(getFactura().getFecha()));

        JasperPrint jp = JasperFillManager.fillReport(jr, parametros, new JREmptyDataSource());
        String dirRaiz = Path.HOME_PATH.getNombre() + "\\Documents\\Facturas LIBRERIA PERRY";
        String dirCarp = Utiles.toStringM3(getFactura().getFecha());
        String nomFact = getFactura().getCodigoFactura() + ".pdf";
        try {
            File directorio = new File(dirRaiz + "\\" + dirCarp);
            directorio.mkdir();
            //Guarda el reporte.
            JasperExportManager.exportReportToPdfFile(jp, directorio.getAbsolutePath() + "\\" + nomFact);
        } catch (JRException e) 
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al crear el directorio para guardar la factura., reinicie el programa.");
        }
    }
   
    public boolean abrirDocumento(){
        boolean estado = false;
        String dirBase = Path.HOME_PATH.getNombre() + "\\Documents\\Facturas LIBRERIA PERRY";
        File carpRaiz = new File(dirBase);
        File carpCont = new File(String.format("%s\\%s", carpRaiz.getPath(), Utiles.toStringM3(getFactura().getFecha()) ));
        
        if (carpRaiz.exists())
        {
            if (carpCont.exists()){
                try {
                    File fichero = new File(String.format("%s\\%s.pdf", carpCont.getPath(), getFactura().getCodigoFactura()));

                    if (fichero.exists()) {
                        Desktop.getDesktop().open(fichero);
                        estado = true;
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        
        return estado;
    }
}
