import javax.swing.*;
import java.awt.event.*;


public class DontCareButtonEditor extends ButtonEditor{
  //private boolean isPushed;

  /**
   * This is the editor for the dont care editor.
   * @param checkBox JCheckBox
   */
  public DontCareButtonEditor(JCheckBox checkBox) {
    super(checkBox);
    button = new JButton();
    button.setOpaque(true);
    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        fireEditingStopped();
      }
    });
  }

  /**
   * This gets the cell editor value.
   * @return Object This is the value.
   */
  @Override
  public Object getCellEditorValue() { //update this
    if (isPushed) {
      if (label.equals("N"))
        label = "Y";
      else
        label = "N";
    }
    isPushed = false;
    return label;
  }
}