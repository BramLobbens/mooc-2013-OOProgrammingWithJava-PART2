package clicker.ui;

import clicker.applicationlogic.Calculator;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

public class UserInterface implements Runnable {

    private JFrame frame;
    private Calculator calculator;

    public UserInterface(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void run() {
        frame = new JFrame("Click Effect");
        frame.setPreferredSize(new Dimension(200, 100));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        container.setLayout(new BorderLayout());
        
        JLabel numberField = new JLabel(Integer.toString(calculator.giveValue()));
        JButton button = new JButton("Click!");
        
        //eventlistener
        ClickListener listener = new ClickListener(calculator, numberField);
        button.addActionListener(listener);
        
        container.add(numberField, BorderLayout.NORTH);
        container.add(button, BorderLayout.SOUTH);
    }

    public JFrame getFrame() {
        return frame;
    }
}
