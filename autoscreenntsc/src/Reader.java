import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Reader extends JFrame {
    int count = 0;
    JButton button, ok;
    JLabel l1,l2;
    JTextField text1, text2;
    long timer = 500;
    boolean isPressed = false;

    eHandler handler = new eHandler();
    boolean flag = false;
    public Reader(String s){
        super(s);
        setLayout(new FlowLayout());
        button = new JButton("Старт");
        ok = new JButton("принять");
        l1 = new JLabel("период в мс:");
        l2 = new JLabel("место сохранения:");
        text1 = new JTextField(10);
        text2 = new JTextField(10);
        add(button);

        add(l2);
        add(text2);
        add(l1);
        add(text1);
        add(ok);

        button.addActionListener(handler);

        ok.addActionListener(handler);
        text1.addActionListener(handler);
        text2.addActionListener(handler);
    }
    public class eHandler extends Thread implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==button){
                eHandler s = new eHandler();
                s.start();
            }
            if(e.getSource() == ok){
                timer = Integer.parseInt(text1.getText());
                Main.place = text2.getText();
            }
        }
        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("screenshot");
                    ImageIO.write(Main.grabScreen(), "png", new File(Main.place, makerName() ));
                    Thread.sleep(timer);
                } catch (InterruptedException | IOException exception ) {
                    System.out.println("IO exception" + exception);
                    break;
                }
            }
        }
    }
    public String makerName(){

        String add;
        if(!flag){
            count++;
            add = "TV";
            flag = true;
        }
        else{
            add = "IR";
            flag = false;
        }
        String fileName = add + "_" + count + ".jpg";
        return fileName;
    }
}
