package survey;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

public class UserInterface implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Survey");
        frame.setPreferredSize(new Dimension(200, 300));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }
    
    private void createComponents(Container container) {
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        
        container.add(new JLabel("Are you?"));
        container.add(new JCheckBox("Yes!"));
        container.add(new JCheckBox("No!"));
        
        container.add(new JLabel("Why?"));
        JRadioButton answ1 = new JRadioButton("No reason.");
        JRadioButton answ2 = new JRadioButton("Because it is fun!");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(answ1);
        buttonGroup.add(answ2);
        container.add(answ1);
        container.add(answ2);
        
        JButton closeButton = new JButton("Done!");
        container.add(closeButton);
    }


    public JFrame getFrame() {
        return frame;
    }
}
