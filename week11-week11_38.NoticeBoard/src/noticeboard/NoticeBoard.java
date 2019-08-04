package noticeboard;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public class NoticeBoard implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Notice Board");
        frame.setPreferredSize(new Dimension(400, 200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        container.setLayout(new GridLayout(3, 1));
        
        JTextField textTop = new JTextField("I was copied here from JTextArea");
        JLabel labelBottom = new JLabel();
        
        TextCopier copier = new TextCopier(textTop, labelBottom);
        
        JButton button = new JButton("Copy!");
        button.addActionListener(copier);
        
        container.add(textTop);
        container.add(button);
        container.add(labelBottom);
    }
}
