
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

public class ClickListener implements ActionListener {

    private Calculator calculator;
    private JTextField src;
    private JTextField dst;
    private JButton add;
    private JButton sub;
    private JButton reset;

    public ClickListener(Calculator calculator, JTextField src, JTextField dst, JButton add, JButton sub, JButton reset) {
        this.calculator = calculator;
        this.src = src;
        this.dst = dst;
        this.add = add;
        this.sub = sub;
        this.reset = reset;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        int n = getInputValue();

        if (ae.getSource() == add) {
            calculator.add(n);
        } else if (ae.getSource() == sub) {
            calculator.subtract(n);
        } else if (ae.getSource() == reset) {
            calculator.reset();
        }
        int result = calculator.getValue();
        
        dst.setText(Integer.toString(result));
        src.setText("");

        if (result == 0) {
            reset.setEnabled(false);
        } else {
            reset.setEnabled(true);

        }
    }

    private int getInputValue() {
        try {
            return Integer.parseInt(src.getText());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

}
