package greeter.ui;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // invokeLater receives as parameter an object which implements
        // the interface Runnable
        SwingUtilities.invokeLater(new UserInterface());
        
    }
}
