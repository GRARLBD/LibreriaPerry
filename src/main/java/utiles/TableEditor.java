/**
 * Esta clase suprime las comillas dentro de un JTable
 */
package utiles;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Kevin
 */
public class TableEditor extends DefaultCellEditor {

    private JTextField textField;

    public TableEditor(final JTextField textField) {
        super(textField);
        this.textField = textField;
        int nroCliks = 2;

        setClickCountToStart(nroCliks);

        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                if (evt.isControlDown()) {
                    // Hacer nada.
                } else
                {
                    Utiles.seleccionarYBorrar(evt, textField);
                }

                Utiles.suprimirComilla(evt);
                Utiles.suprimirComilla(textField);
            }

        });

        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {

            }

        });

        textField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                textField.selectAll();
            }
        });
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected,
            int rowIndex, int vColIndex) {

        textField.setText((String) value);
        textField.setFont(new Font("Thaoma", 0, 20));

        return textField;
    }

    public Object getCellEditorValue() {
        return textField.getText();
    }
}
