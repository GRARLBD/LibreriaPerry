/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

import com.mycompany.libreria.gral.system.model.Inventario;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;

/**
 *
 * @author Kevin
 */
public class MyObjectSelection implements Transferable, ClipboardOwner {

        private static DataFlavor dmselFlavor = new DataFlavor(Inventario.class, "Test data flavor");
        private Inventario selection;



        public MyObjectSelection(Inventario selection){
           this.selection = selection;
        }


        // Transferable implementation

        @Override
        public DataFlavor[] getTransferDataFlavors(){
           System.out.println("getTransferDataFlavors");
           DataFlavor[] ret = {dmselFlavor};
           return ret;
        }

        @Override
        public boolean isDataFlavorSupported(DataFlavor flavor){
           return dmselFlavor.equals(flavor);
        }

        @Override
        public synchronized Object getTransferData (DataFlavor flavor)
           throws UnsupportedFlavorException 
        {
           if (isDataFlavorSupported(flavor)){
              return this.selection;
           } else {
              throw new UnsupportedFlavorException(dmselFlavor);
           }
        }



        // ClipboardOwner implementation

        @Override
        public void lostOwnership(Clipboard clipboard, Transferable transferable){
           System.out.println("MyObjectSelection: Lost ownership");
        }

     }

  
