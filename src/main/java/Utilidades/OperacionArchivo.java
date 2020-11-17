/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import com.mycompany.libreria.gral.system.model.Inventario;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class OperacionArchivo {
	
	//crea el archivo en disco, recibe como parámetro la lista de estudiantes
	public static void crearArchivo(List<Inventario> lista) {
	/*	FileWriter flwriter = null;
		try {
			//crea el flujo para escribir en el archivo
			flwriter = new FileWriter("C:\\Users\\CASA\\Desktop\\inventario.txt");
			//crea un buffer o flujo intermedio antes de escribir directamente en el archivo
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
			for (Inventario i : lista) {
				//escribe los datos en el archivo
				bfwriter.write(i.getProducto().getCodigo() + ";" +
                                        i.getProducto().getDetalle() + ";" + 
                                        i.getCostoUnitario() + ";" +
                                        i.getPrecioVentaUntario() + ";" +
                                        i.getTotalCostoInventario() + ";" +
                                        i.getTotalVentaInventario() + ";" +
                                        i.getTotalGananciaInventario() + ";" +
                                        i.getAcumuladorTotalEntrada() + ";" +
                                        i.getAcumuladorTotalSalida() + ";" +
                                        i.getStockInventario());
                                bfwriter.newLine();
			}
			//cierra el buffer intermedio
			bfwriter.close();
			System.out.println("Archivo creado satisfactoriamente..");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (flwriter != null) {
				try {//cierra el flujo principal
					flwriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}*/
	}
	
	//crea el archivo en disco, retorna la lista de estudiantes
	public static List<Inventario> leerArchivo() {
		// crea el flujo para leer desde el archivo
		/*File file = new File("C:\\Users\\CASA\\Desktop\\inventario.txt");
		List<Inventario> lista= new LinkedList<>();	
		Scanner scanner;
		try {
			//se pasa el flujo al objeto scanner
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				// el objeto scanner lee linea a linea desde el archivo
				String linea = scanner.nextLine();
				Scanner delimitar = new Scanner(linea);
				//se usa una expresión regular
				//que valida que antes o despues de una coma (,) exista cualquier cosa
				//parte la cadena recibida cada vez que encuentre una coma				
				delimitar.useDelimiter("\\s*;\\s*");
				Inventario i= new Inventario();
				i.getProducto().setCodigo(delimitar.next());
                                i.getProducto().setDetalle(delimitar.next());
                                i.setCostoUnitario(new BigDecimal(delimitar.next()));
                                i.setPrecioVentaUntario(new BigDecimal(delimitar.next()));
                                i.setTotalCostoInventario(new BigDecimal(delimitar.next()));
                                i.setTotalVentaInventario(new BigDecimal(delimitar.next()));
                                i.setTotalGananciaInventario(new BigDecimal(delimitar.next()));
                                i.setAcumuladorTotalEntrada(new Integer(delimitar.next()));
                                i.setAcumuladorTotalSalida(new Integer(delimitar.next()));
                                i.setStockInventario(new Integer(delimitar.next()));
                                i.setEstado(true);
				lista.add(i);
			}
			//se cierra el ojeto scanner
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}*/
		return null; //lista;
	}
}
