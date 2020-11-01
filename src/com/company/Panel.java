package com.company;
import javax.swing.*;
import java.awt.*;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
import java.awt.event.*;

public class Panel extends JPanel {
    private  JButton numbers[] = new JButton[10];
    private Font font = new Font("SanSerif",Font.BOLD,20);
    private JTextField output = new JTextField();

    public Panel(){
        setFocusable(true);
        grabFocus();
       setLayout(null);
       numbers[0] = new JButton("0");
       numbers[0].setBounds(70, 250, 50, 50);
       numbers[0].setFont(font);
       add(numbers[0]);

       for (int x=0;x<3;x++){
         for (int y =0;y<3;y++){
             numbers[x *3+y+1]= new JButton((x *3+y+1)+"");
             numbers[x *3+y+1].setBounds(x*(50+10)+10,y*(50+10)+70,50,50);
             numbers[x *3+y+1].setFont(font);
             add(numbers[x *3+y+1]);
         }
       }

       output.setBounds(10, 10, 230, 50);
       output.setFont(font);
        output.setEditable(false); // Можно редактировать стоку вывода или нет
        add(output);
        ActionListener l = (ActionEvent e) -> {
            JButton b = (JButton)e.getSource();
            output.setText(output.getText()+b.getText());
        };

        for (JButton b : numbers){
            b.addActionListener(l);
        }
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char symbol = e.getKeyChar();

                if(!Character.isDigit(symbol))
                    return;
                output.setText(output.getText() + symbol);
            }
        });
    }
}
