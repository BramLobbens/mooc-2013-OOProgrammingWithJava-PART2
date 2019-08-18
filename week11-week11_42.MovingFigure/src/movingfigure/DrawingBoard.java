package movingfigure;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawingBoard extends JPanel {

    private Figure figure;

    public DrawingBoard(Figure figure) {
        super.setBackground(Color.WHITE);
        this.figure = figure;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        figure.draw(g);
    }
    
}
