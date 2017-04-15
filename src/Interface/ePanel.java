/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import excepciones_inmobiliaria.inmuebleRepetidoException;
import excepciones_inmobiliaria.parametrosFaltantesException;
import excepciones_inmobiliaria.parqueaderoOficinaException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import inmobiliariak.*;
/**
 *
 * @author marti
 */
public class ePanel extends JPanel implements ActionListener {

    private static final String agregar = "agregar";
    private static final String vender = "vender";
    WindowI miventana;
    TextArea listaD = new TextArea();
    TextArea listaV = new TextArea();

    public ePanel(WindowI ventana) {

        this.miventana = ventana;
        setBackground(Color.WHITE);
        Font letra = new Font("Century Gothic", Font.PLAIN, 12);
        setLayout(new BorderLayout());
        JPanel panelw = new JPanel(new GridLayout(2, 1));

        JPanel panelx = new JPanel();
        panelx.setBorder(new TitledBorder("Inmuebles disponibles"));
        JPanel panely = new JPanel();
        panely.setBorder(new TitledBorder("Inmuebles vendidos"));
        panelx.setLayout(new GridLayout());
        panely.setLayout(new GridLayout());

        listaD.setFont(letra);
        listaD.setSize(100, 100);
        panelx.add(listaD);

        listaV.setFont(letra);
        listaV.setSize(100, 100);
        panely.add(listaV);

        JPanel pbuttons = new JPanel(new GridLayout(1, 2, 5, 5));
        pbuttons.setBackground(Color.WHITE);
        JButton buttono1 = new JButton("Agregar");
        buttono1.setBackground(Color.CYAN);
        buttono1.setFont(letra);
        buttono1.addActionListener(this);
        buttono1.setActionCommand(agregar);
        pbuttons.add(buttono1);

        JButton buttono2 = new JButton("Vender");
        buttono2.setBackground(Color.CYAN);
        buttono2.setFont(letra);
        buttono2.addActionListener(this);
        buttono2.setActionCommand(vender);
        pbuttons.add(buttono2);

        panelw.add(panelx);
        panelw.add(panely);
        add(pbuttons, BorderLayout.SOUTH);
        add(panelw, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch (command) {
            case agregar:
                String cad = JOptionPane.showInputDialog(null, "Ingrese los datos del inmueble");
                try {
                    miventana.myinmobiliaria.agregarInmueble(cad);//////////////////////////////////gjhfjhfj///////
                    setRefreshAvailable();
                    setRefreshSell();
                } catch (inmuebleRepetidoException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (parametrosFaltantesException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                } catch (parqueaderoOficinaException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
                break;
            case vender:
                int identificador = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID del inmueble a vender"));
                miventana.myinmobiliaria.venderInmueble(identificador);
                setRefreshAvailable();
                setRefreshSell();
                break;
        }

    }

    public void setRefreshAvailable() {
        listaD.setText("");
        for (int i = 0; i < miventana.myinmobiliaria.listaInmuebles.size(); i++) {
            Inmueble myInmueble = miventana.myinmobiliaria.listaInmuebles.get(i);
            listaD.append(myInmueble.toString() + "\n");
        }
    }

    public void setRefreshSell() {
        listaV.setText("");
        for (int i = 0; i < miventana.myinmobiliaria.listaInmueblesVendidos.size(); i++) {
            Inmueble myInmueble = miventana.myinmobiliaria.listaInmueblesVendidos.get(i);
            listaV.append(myInmueble.toString() + "\n");
        }
    }
}
