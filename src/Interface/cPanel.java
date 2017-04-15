package Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import inmobiliariak.Inmueble;
import inmobiliariak.*;
import javax.swing.JOptionPane;

/**
 *
 * @author marti
 */
public class cPanel extends JPanel implements ActionListener {

    private static final String siguiente = "siguiente";
    private static final String anterior = "anterior";
    private JLabel imagen = new JLabel();
    
    ImageIcon imagencasa = new ImageIcon("casa.jpg");
    ImageIcon imagenoficina = new ImageIcon("oficina.jpg");
    ImageIcon imagenapto = new ImageIcon("apto.jpg");
    WindowI miventana;
    JTextField idx = new JTextField("");
    JTextField tipox = new JTextField("");
    JTextField areax = new JTextField("");
    JTextField valorx = new JTextField("");
    JTextField estratox = new JTextField("");
    JTextField parqueaderox = new JTextField("");
    public int contador = 0;

    public cPanel(WindowI ventana) {
        this.miventana = ventana;
        setBorder(new TitledBorder("Detalle inmueble"));
        Font letra = new Font("Century Gothic", Font.PLAIN, 12);
        setBackground(Color.WHITE);
        setForeground(Color.BLACK);
        setLayout(new BorderLayout(10, 10));
        JPanel panelx = new JPanel(new GridLayout(1, 2, 5, 5));

        JPanel panellist = new JPanel();
        panellist.setForeground(Color.BLACK);
        panellist.setBackground(Color.WHITE);
        panellist.setLayout(new GridLayout(6, 2, 20, 10));

        JLabel id = new JLabel("ID");
        id.setForeground(Color.BLACK);
        id.setFont(letra);
        panellist.add(id);

        idx.setFont(letra);
        panellist.add(idx);

        JLabel tipo = new JLabel("Tipo");
        tipo.setForeground(Color.BLACK);
        tipo.setFont(letra);
        panellist.add(tipo);

        tipox.setFont(letra);
        panellist.add(tipox);

        JLabel area = new JLabel("Area");
        area.setForeground(Color.BLACK);
        area.setFont(letra);
        panellist.add(area);

        areax.setFont(letra);
        panellist.add(areax);

        JLabel valor = new JLabel("Valor");
        valor.setForeground(Color.BLACK);
        valor.setFont(letra);
        panellist.add(valor);

        valorx.setFont(letra);
        panellist.add(valorx);

        JLabel estrato = new JLabel("Estrato");
        estrato.setForeground(Color.BLACK);
        estrato.setFont(letra);
        panellist.add(estrato);

        estratox.setFont(letra);
        panellist.add(estratox);

        JLabel parqueadero = new JLabel("Parqueadero");
        parqueadero.setForeground(Color.BLACK);
        parqueadero.setFont(letra);
        panellist.add(parqueadero);

        parqueaderox.setFont(letra);
        panellist.add(parqueaderox);

        JPanel pbuttons = new JPanel(new GridLayout(1, 2, 5, 5));
        pbuttons.setBackground(Color.WHITE);

        JButton buttono1 = new JButton("Anterior");
        buttono1.setBackground(Color.CYAN);
        buttono1.setFont(letra);
        buttono1.addActionListener(this);
        buttono1.setActionCommand(siguiente);
        pbuttons.add(buttono1);

        JButton buttono2 = new JButton("Siguiente");
        buttono2.setBackground(Color.CYAN);
        buttono2.setFont(letra);
        buttono2.addActionListener(this);
        buttono2.setActionCommand(anterior);
        pbuttons.add(buttono2);

        panelx.add(imagen);
        panelx.add(panellist);
        add(panelx, BorderLayout.CENTER);
        add(pbuttons, BorderLayout.SOUTH);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();                    
        if (contador < miventana.myinmobiliaria.listaInmuebles.size() && 0 <= contador);
        {
            if (contador < miventana.myinmobiliaria.listaInmuebles.size() - 1 && command.equals(anterior)) {
                contador++;
            } else if (command.equals(siguiente) && contador > 0) {
                contador--;
            }
        }
        if (contador >= 0) {
            detallesInmuebles(contador);
        }
    }

    public void detallesInmuebles(int number) {
        if (number >= 0 && number < miventana.myinmobiliaria.listaInmuebles.size()) {
            Inmueble myInmueble = miventana.myinmobiliaria.listaInmuebles.get(number);
            if (myInmueble instanceof Vivienda && myInmueble instanceof Casa) {
                Casa myCasa = (Casa) myInmueble;
                idx.setText(myCasa.id + "");
                tipox.setText(myCasa.tipo + "");
                areax.setText(myCasa.metrosCuadradosConstruidos + "");
                valorx.setText(myCasa.valorMetroCuadrado + "");
                estratox.setText(myCasa.estrato + "");
                parqueaderox.setText(myCasa.numeroParqueaderos + "");
            } else if (myInmueble instanceof Vivienda && myInmueble instanceof Apartamento) {
                Apartamento myApartamento = (Apartamento) myInmueble;
                idx.setText(myApartamento.id + "");
                tipox.setText(myApartamento.tipo + "");
                areax.setText(myApartamento.metrosCuadradosConstruidos + "");
                valorx.setText(myApartamento.valorMetroCuadrado + "");
                estratox.setText(myApartamento.estrato + "");
                parqueaderox.setText(myApartamento.numeroParqueaderos + "");
            } else {
                Oficina myOficina = (Oficina) myInmueble;
                idx.setText(myOficina.id + "");
                tipox.setText(myOficina.tipo + "");
                areax.setText(myOficina.metrosCuadradosConstruidos + "");
                valorx.setText(myOficina.valorMetroCuadrado + "");
                estratox.setText(myOficina.estrato + "");
                parqueaderox.setText(myOficina.tieneParqueaderoVisitantes + "");
            }
        }
        image();
    }

    public void image() {
        switch (tipox.getText()) {
            case "1":
                imagen.setIcon(imagenoficina);
                break;
            case "2":
                imagen.setIcon(imagencasa);
                break;
            case "3":
                imagen.setIcon(imagenapto);
                break;
            default:
                imagen.setIcon(new ImageIcon(""));
                break;
        }
    }

}
