package com.company;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {

    private JFrame window;
    public Main(){
       window = new JFrame("2экран");
       window.setSize(250, 310);
       window.setLocationRelativeTo(null);
       window.add(new Panel());
       window.setResizable(false);
       window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       window.setVisible(true);
  }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });

    }
}
