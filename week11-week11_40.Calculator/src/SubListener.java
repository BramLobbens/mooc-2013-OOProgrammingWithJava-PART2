
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;


public class SubListener implements ActionListener {

    private Calculator calculator;
    private JTextField src;
    private JTextField dst;

    public SubListener(JTextField src, JTextField dst, Calculator calculator) {
        this.src = src;
        this.dst = dst;
        this.calculator = calculator;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int n = Integer.parseInt(src.getText());
            calculator.subtract(n);
            dst.setText(Integer.toString(calculator.getValue()));
        }
        catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage() + "Please input a number.");
        }
        
        src.setText("");

    }

}
