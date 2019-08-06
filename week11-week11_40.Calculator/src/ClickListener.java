
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

public class ClickListener implements ActionListener {

    private Calculator calculator;
    private JTextField src;
    private JTextField dst;
    private String action;
    private JButton button;

    public ClickListener(JTextField src, JTextField dst, Calculator calculator, String action, JButton button) {
        this.src = src;
        this.dst = dst;
        this.calculator = calculator;
        this.action = action;
        this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int n = getInputValue();

        if (action.equals("add")) {
            calculator.add(n);
            button.setEnabled(true);
        } else if (action.equals("subtract")) {
            calculator.subtract(n);
            button.setEnabled(true);
        } else if (action.equals("reset")) {
            calculator.reset();
            button.setEnabled(false);
        }

        dst.setText(Integer.toString(calculator.getValue()));
        src.setText("");
    }

    private int getInputValue() {
        try {
            return Integer.parseInt(src.getText());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }

}
