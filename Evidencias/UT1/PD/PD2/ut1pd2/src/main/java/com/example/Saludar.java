package com.example;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Saludar extends JFrame implements ActionListener {
    static JFrame f;
    static JLabel l;
    static JTextField t;
    static JButton b;

    public static void main(String[] args) {
        f = new JFrame("Frame");

        JPanel innerPanel = new JPanel();
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));

        l = new JLabel("Ingrese su nombre:");
        b = new JButton("Saludar a");
        Saludar te = new Saludar();
        b.addActionListener(te);

        t = new JTextField(16);
        t.setMaximumSize(new Dimension(Integer.MAX_VALUE, t.getPreferredSize().height));

        innerPanel.add(l);
        innerPanel.add(Box.createVerticalStrut(10));
        innerPanel.add(t);
        innerPanel.add(Box.createVerticalStrut(10));
        innerPanel.add(b);

        // Creo un otuter panel para generar padding
        JPanel outerPanel = new JPanel();
        outerPanel.setLayout(new BorderLayout());
        outerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        outerPanel.add(innerPanel, BorderLayout.CENTER);

        f.add(outerPanel);

        f.setSize(300, 300);
        f.setVisible(true);
    }

		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Saludar a")) {
					String name = t.getText();
					if (name.isEmpty()) {
							JOptionPane.showMessageDialog(f, "Por favor ingrese un nombre.", "Mensaje", JOptionPane.WARNING_MESSAGE);
					} else {
							JOptionPane.showMessageDialog(f, "Hola, " + name + "!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
							t.setText("");
					}
			}
		}
}
