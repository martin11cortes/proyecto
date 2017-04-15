package Interface;

import inmobiliariak.Inmobiliaria;
import inmobiliariak.Inmueble;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author marti
 */
public class WindowI extends JFrame {
    
    Inmobiliaria myinmobiliaria = new Inmobiliaria();

    public WindowI() {

        JFrame.setDefaultLookAndFeelDecorated(true);
        setForeground(Color.WHITE);
        setTitle("Inmobiliaria K");
        setSize(900, 520);
        setLocation(200, 200);
        setResizable(false);
        setBackground(Color.WHITE);
        
        JPanel windowpanel = new JPanel();
        windowpanel.setForeground(Color.BLACK);
        windowpanel.setBackground(Color.WHITE);
        windowpanel.setLayout(new BorderLayout(5, 5));
        windowpanel.setSize(1000, 300);

        nPanel paneln = new nPanel();
        windowpanel.add(paneln, BorderLayout.NORTH);

        sPanel panels = new sPanel(this);
        windowpanel.add(panels, BorderLayout.SOUTH);  
        
        cPanel panelc = new cPanel(this);
        windowpanel.add(panelc, BorderLayout.CENTER);   
        
        ePanel panele = new ePanel(this);
        windowpanel.add(panele, BorderLayout.EAST);   
        
        add(windowpanel);
    }
    
    /*@Override
    public void actionPerformed(ActionEvent ae) {

    }*/
}
