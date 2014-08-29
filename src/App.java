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
        View.MainLayout mw = new MainLayout(ctrl);

        mw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mw.setSize(350,385);
        mw.setVisible(true);
    }
}
