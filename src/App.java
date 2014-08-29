/**
 * Created by alex on 8/28/14.
 */

import Controller.MainController;
import View.MainLayout;
import javax.swing.JFrame;

public class App {

    public static void main(String[] args)
    {
        Controller.MainController ctrl = new MainController();
        View.MainLayout ml = new MainLayout(ctrl);

        ml.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ml.setSize(350,415);
        ml.setVisible(true);
    }
}
