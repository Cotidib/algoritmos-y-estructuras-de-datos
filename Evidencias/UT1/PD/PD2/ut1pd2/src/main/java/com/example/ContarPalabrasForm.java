package com.example;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class ContarPalabrasForm extends JFrame implements ActionListener {
    static JFrame f;
    static JLabel l;
    static JTextField t;
    static JButton b;
    static JRadioButton rb1, rb2, rb3;
    static ButtonGroup buttonGroup;

    public static void main(String[] args) {
        f = new JFrame("Frame");

        JPanel innerPanel = new JPanel();
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));

        l = new JLabel("Cantidad de palabras:");
        b = new JButton("OK");
        ContarPalabrasForm te = new ContarPalabrasForm();
        b.addActionListener(te);

        t = new JTextField(16);
        t.setMaximumSize(new Dimension(Integer.MAX_VALUE, t.getPreferredSize().height));

        rb1 = new JRadioButton("Opción 1");
        rb2 = new JRadioButton("Opción 2");
        rb3 = new JRadioButton("Opción 3");
        buttonGroup = new ButtonGroup();
        buttonGroup.add(rb1);
        buttonGroup.add(rb2);
        buttonGroup.add(rb3);

        innerPanel.add(t);
        innerPanel.add(Box.createVerticalStrut(10));
        innerPanel.add(b);
        innerPanel.add(Box.createVerticalStrut(10));
        innerPanel.add(l);
        innerPanel.add(Box.createVerticalStrut(10));
        innerPanel.add(rb1);
        innerPanel.add(rb2);
        innerPanel.add(rb3);

        // Creo un otuter panel para generar padding
        JPanel outerPanel = new JPanel();
        outerPanel.setLayout(new BorderLayout());
        outerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        outerPanel.add(innerPanel, BorderLayout.CENTER);

        f.add(outerPanel);

        f.setSize(300, 300);
        f.setVisible(true);

        // Agrego action listeners a los radio buttons
        rb1.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              JOptionPane.showMessageDialog(f, "Selecciono: " + rb1.getText(), "Selección", JOptionPane.INFORMATION_MESSAGE);
          }
        });

        rb2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(f, "Selecciono: " + rb2.getText(), "Selección", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        rb3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(f, "Selecciono: " + rb3.getText(), "Selección", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("OK")) {
					String text = t.getText();
          int total = ContadorPalabras.contarPalabras(text);
					l.setText("Cantidad de palabras: " + total);
			} else if(e.getActionCommand().equals("Opcion 1")) {

      }
		}
}
