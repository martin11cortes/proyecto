package Interface;

import javax.swing.JFrame;

public class GUI {

    public static void main(String[] args) {
        WindowI myWindow = new WindowI();
        myWindow.setVisible(true);
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
