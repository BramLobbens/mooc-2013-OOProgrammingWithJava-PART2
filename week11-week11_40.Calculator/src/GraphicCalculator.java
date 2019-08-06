
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
        
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }
    
    private void createComponents(Container container) {
        container.add(createPanel());
    }
    
    private JPanel createPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 1));
        
        JTextField output = new JTextField("0");
        output.setEnabled(false);
        
        JTextField input = new JTextField();
        
        panel.add(output);
        panel.add(input);
        panel.add(createButtons(input, output), BorderLayout.SOUTH);
        return panel;
    }
    
    private JPanel createButtons(JTextField input, JTextField output) {
        JPanel panel = new JPanel(new GridLayout(1, 3));
        
        JButton add = new JButton("+");
        JButton sub = new JButton("-");
        JButton reset = new JButton("Z"); //reset to zero
        
        // eventlistener
        AddListener addListener = new AddListener(input, output, calculator);
        add.addActionListener(addListener);
        SubListener subListener = new SubListener(input, output, calculator);
        sub.addActionListener(subListener);
        ResetListener resetListener = new ResetListener(input, output, calculator);
        reset.addActionListener(resetListener);
        
        panel.add(add);
        panel.add(sub);
        panel.add(reset);
        
        return panel;
    }
    
    public JFrame getFrame() {
        return frame;
    }
}
