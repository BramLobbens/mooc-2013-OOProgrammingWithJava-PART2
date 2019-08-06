

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        SwingUtilities.invokeLater(new GraphicCalculator(calculator));
    }
}
