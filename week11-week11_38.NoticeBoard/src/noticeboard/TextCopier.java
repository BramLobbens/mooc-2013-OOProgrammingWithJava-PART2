
package noticeboard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TextCopier implements ActionListener {

    private JTextField src;
    private JLabel dst;

    public TextCopier(JTextField src, JLabel dst) {
        this.src = src;
        this.dst = dst;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.dst.setText(this.src.getText());
        this.src.setText("");
    }

    
}
