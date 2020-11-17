/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

import java.io.File;

/**
 *
 * @author Kevin
 */
public enum Path {
    PATH1("C:\\Users\\Kevin\\Documents\\NetBeansProjects\\Libreria-GRAL-SYSTEM\\src\\main\\java\\utiles"),
    PATH2("C:\\Users\\CASA\\Documents\\NetBeansProjects\\Libreria-GRAL-SYSTEM\\src\\main\\java\\utiles"),
    PATH_ROOT_IMPRESION("C:\\Libreria"),
    BASE_PATH(new File("").getAbsolutePath()),
    HOME_PATH(System.getProperty("user.home")),
    PATH_LISTAS(Path.HOME_PATH.getNombre() + "\\Documents\\Facturas LIBRERIA PERRY\\listas");
    
    private String nombre;
    
    private Path(String value)
    {
        nombre = value;
    }
    
    public String getNombre()
    {
        return nombre;
    }
}
