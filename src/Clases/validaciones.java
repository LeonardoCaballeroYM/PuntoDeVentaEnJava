package Clases;

import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class validaciones {
    
    public Toolkit getToolkit() {
        return Toolkit.getDefaultToolkit();
    }

    public void SNumeros(JTextField a) {
        a.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (Character.isLetter(c)) {
                    getToolkit().beep();
                    evt.consume();
                    JOptionPane.showMessageDialog(null, "Ingrese solo números");
                } else if ((int) evt.getKeyChar() > 32 && (int) evt.getKeyChar() <= 45
                        || (int) evt.getKeyChar() >=47 && (int) evt.getKeyChar() <= 47
                        || (int) evt.getKeyChar() >= 58 && (int) evt.getKeyChar() <= 64
                        || (int) evt.getKeyChar() >= 91 && (int) evt.getKeyChar() <= 96
                        || (int) evt.getKeyChar() >= 123 && (int) evt.getKeyChar() <= 255) {
                    getToolkit().beep();
                    evt.consume();
                    JOptionPane.showMessageDialog(null, "Ingrese solo números");
                }
            }
        });
    }

    public void SLetras(JTextField a) {
        a.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (Character.isDigit(c)) {
                    getToolkit().beep();
                    evt.consume();
                    JOptionPane.showMessageDialog(null, "Ingrese solo letras");
                }else if ((int) evt.getKeyChar() > 32 && (int) evt.getKeyChar() < 46
                        || (int) evt.getKeyChar() >= 58 && (int) evt.getKeyChar() <= 64
                        || (int) evt.getKeyChar() >= 91 && (int) evt.getKeyChar() <= 96
                        || (int) evt.getKeyChar() >= 123 && (int) evt.getKeyChar() <= 255) {
                    getToolkit().beep();
                    evt.consume();
                    JOptionPane.showMessageDialog(null, "Ingrese solo letras");
                }
            }
        });
    }
}
