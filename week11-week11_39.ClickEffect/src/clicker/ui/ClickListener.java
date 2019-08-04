
package clicker.ui;

import clicker.applicationlogic.Calculator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

public class ClickListener implements ActionListener {

    private Calculator calculator;
    private JLabel valueField;

    public ClickListener(Calculator calculator, JLabel valueField) {
        this.calculator = calculator;
        this.valueField = valueField;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        calculator.increase();
        valueField.setText(Integer.toString(calculator.giveValue()));
    }
    
}
