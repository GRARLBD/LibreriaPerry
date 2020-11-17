/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Kevin
 */
public class EvenOddRenderer implements TableCellRenderer {

    public static final DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();


    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        
        DEFAULT_RENDERER.setHorizontalAlignment(JLabel.LEFT);
        Component renderer = DEFAULT_RENDERER.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, column);
        ((JLabel) renderer).setOpaque(true);


        Color foreground, background;
        //Color alternate = new Color(0xC0, 0xC0, 0xF0);
        Color lightBlue = new Color(204, 204, 255);

        if (isSelected) {
            foreground = Color.BLACK;
            background = Color.YELLOW;
        } else {
            if (row % 2 == 0) {
                foreground = Color.black;
                background = Color.white;
            } else {
                foreground = Color.black;
                background = lightBlue;
            }
        }
        renderer.setForeground(foreground);
        renderer.setBackground(background);

        if (column == 6) {
            String cadena = (String) value;

            if (cadena == null || cadena.isEmpty()) {
                // Hacer nada.
            } else {
                if (cadena.equals("CAMPEON")) {
                    ((JLabel) renderer).setHorizontalAlignment(JLabel.CENTER);
                    ((JLabel) renderer).setAlignmentY(JLabel.CENTER);
                    ((JLabel) renderer).setForeground(Color.RED);
                    ((JLabel) renderer).setFont(new Font("Tahoma", Font.BOLD, 18));

                }
                if (cadena.equals("SAN_PABLO")) {
                    ((JLabel) renderer).setHorizontalAlignment(JLabel.CENTER);
                    ((JLabel) renderer).setAlignmentY(JLabel.CENTER);
                    ((JLabel) renderer).setForeground(Color.BLUE);
                    ((JLabel) renderer).setFont(new Font("Tahoma", Font.BOLD, 18));
                }
                if (cadena.equals("PAPA_NOEL")) {
                    ((JLabel) renderer).setHorizontalAlignment(JLabel.CENTER);
                    ((JLabel) renderer).setAlignmentY(JLabel.CENTER);
                    ((JLabel) renderer).setForeground(new Color(102, 0, 153));
                    ((JLabel) renderer).setFont(new Font("Tahoma", Font.BOLD, 18));
                }
            }
        } else {
            // Restaurar los valores por defecto
        }
        return renderer;
    }
}
