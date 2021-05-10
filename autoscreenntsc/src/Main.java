

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Main extends JFrame {
    public static String place = "C:/Users/HOME-PC/Desktop/screens";
    public static void main(String[] args) {
        Reader fr = new Reader("автоскринер");
        fr.setSize(150,200);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setResizable(false);
        fr.setLocationRelativeTo(null);
    }
    static BufferedImage grabScreen() {
        try {
            return new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize())) ;
        } catch (SecurityException e) {
        } catch (AWTException e) {
        }
        return null;
    }



}
