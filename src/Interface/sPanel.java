package Interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/*
 *
 * @author marti
 */

public class sPanel extends JPanel implements ActionListener {

    Font letra = new Font("Century Gothic", Font.PLAIN, 12);
    private static final String recaudo = "recaudo";
    private static final String impuestos = "impuestos";
    private static final String total = "total";
    WindowI miventana;

    public sPanel(WindowI ventana) {
        this.miventana = ventana;
        setBorder(new TitledBorder("Opciones"));
        setBackground(Color.WHITE);
        setLayout(new GridLayout(1, 3, 5, 5));

        JButton buttonrecaudo = new JButton("Dar recaudo neto");
        buttonrecaudo.setBackground(Color.CYAN);
        buttonrecaudo.setFont(letra);
        buttonrecaudo.addActionListener(this);
        buttonrecaudo.setActionCommand(recaudo);
        add(buttonrecaudo);

        JButton buttonimpuestos = new JButton("Dar impuestos pagados");
        buttonimpuestos.setBackground(Color.CYAN);
        buttonimpuestos.setFont(letra);
        buttonimpuestos.addActionListener(this);
        buttonimpuestos.setActionCommand(impuestos);
        add(buttonimpuestos);

        JButton buttontotal = new JButton("Dar total recaudo");
        buttontotal.setBackground(Color.CYAN);
        buttontotal.setFont(letra);
        buttontotal.addActionListener(this);
        buttontotal.setActionCommand(total);
        add(buttontotal);
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        String command = ae.getActionCommand();
        switch (command) {
            case recaudo:                
                JOptionPane.showMessageDialog(null, "El total de recaudo es: " + miventana.myinmobiliaria.totalRecaudoPorVentas);
                break;
            case impuestos:                
                JOptionPane.showMessageDialog(null, "El total de impuestos pagados es: " + miventana.myinmobiliaria.totalImpuestosPagados);
                break;
            case total:
                JOptionPane.showMessageDialog(null, "El valor total despues de impuestos es: " + miventana.myinmobiliaria.ventasDespuesdeImpuestos);
                break;            
        }
    }
}


