
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GraphicCalculator implements Runnable {

    private JFrame frame;
    private Calculator calculator;

    public GraphicCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void run() {
        frame = new JFrame("Calculator");
        frame.setPreferredSize(new Dimension(300, 200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setLayout(new GridLayout(3, 1));

        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {

        JTextField output = new JTextField("0");
        output.setEnabled(false);

        JTextField input = new JTextField();

        container.add(output);
        container.add(input);
        container.add(createButtons(input, output), BorderLayout.SOUTH);

    }

    private JPanel createButtons(JTextField input, JTextField output) {
        JPanel panel = new JPanel(new GridLayout(1, 3));

        JButton add = new JButton("+");
        JButton sub = new JButton("-");
        JButton reset = new JButton("Z"); //reset to zero
        reset.setEnabled(false);

        // eventlistener
        String action = "add";
        add.addActionListener(new ClickListener(input, output, calculator, action, reset));
        action = "subtract";
        sub.addActionListener(new ClickListener(input, output, calculator, action, reset));
        action = "reset";
        reset.addActionListener(new ClickListener(input, output, calculator, action, reset));

        panel.add(add);
        panel.add(sub);
        panel.add(reset);

        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }
}
