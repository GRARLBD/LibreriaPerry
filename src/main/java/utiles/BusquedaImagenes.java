/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.io.File;
import java.io.FileFilter;

/**
 *
 * @author KEVIN
 */
public class BusquedaImagenes {

    /**
     * Ruta donde se encuentran las imagenes
     */
    //
    //private String appPath = System.getProperties().getProperty("user.dir");
    //public File directorio = new File( appPath + "\\imagenes\\" ); 
    //
    private String appPath = "C:\\Users\\KEVIN\\Documents\\NetBeansProjects\\Libreria-GRAL-SYSTEM\\src\\main\\resources\\";
    public File directorio = new File(appPath + "\\db-images\\");

    /**
     * Si la extensión es .JPG retorna TRUE, caso contrario FALSE
     */
    private FileFilter filefilter = new FileFilter() {
        @Override
        public boolean accept(File file) {
            return file.getName().endsWith(".jpg");
        }
    };

    public String getAppPath() {
        return appPath;
    }

    public void setAppPath(String appPath) {
        this.appPath = appPath;
    }

    public File getDirectorio() {
        return directorio;
    }

    public void setDirectorio(File directorio) {
        this.directorio = directorio;
    }

    public FileFilter getFilefilter() {
        return filefilter;
    }

    public void setFilefilter(FileFilter filefilter) {
        this.filefilter = filefilter;
    }

}
