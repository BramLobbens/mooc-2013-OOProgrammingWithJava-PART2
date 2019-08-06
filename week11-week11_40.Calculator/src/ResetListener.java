
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;


public class ResetListener implements ActionListener {

    private Calculator calculator;
    private JTextField src;
    private JTextField dst;

    public ResetListener(JTextField src, JTextField dst, Calculator calculator) {
        this.src = src;
        this.dst = dst;
        this.calculator = calculator;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        calculator.reset();
        dst.setText(Integer.toString(calculator.getValue()));
        src.setText("");
    }

}
