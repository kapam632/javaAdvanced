package hw04;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Main implements Runnable {
    public Main() {
        new Thread(this).start();
    }

    public static void main(String[] args) throws IOException {
        new Main();
    }

    @Override
    public void run() {
        try {
            new Gui();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class Gui extends JFrame {

        public Gui() throws HeadlessException, IOException {
            super();
            File file = new File("diablo.jpg");

            byte[] buff = new byte[10*1024];
            InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("photo.jpg");
            resourceAsStream.read(buff);

            JLabel jLabelOutImg = new JLabel(new ImageIcon("diablo.jpg"));
            JLabel jLabelImgPath = new JLabel(file.getAbsolutePath());

            JLabel jLabelJarImg = new JLabel(new ImageIcon(buff));
            file = new File("photo.jpg");
            JLabel jLabelJarImgPath = new JLabel(file.getAbsolutePath());



            JPanel jPanel = new JPanel();
            jPanel.setLayout(new GridLayout(2,2));
            jPanel.add(jLabelOutImg);
            jPanel.add(jLabelImgPath);

            jPanel.add(jLabelJarImg);
            jPanel.add(jLabelJarImgPath);

            add(jPanel);
            setSize(300,300);
            setVisible(true);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }

    }
}
