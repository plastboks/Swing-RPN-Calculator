/**
 * Created by alex on 8/28/14.
 */

import Controller.MainController;
import View.MainLayout;

public class App {

    public static void main(String[] args)
    {
        Controller.MainController ctrl = new MainController();
        View.MainLayout ml = new MainLayout(ctrl, "RPN Calculator");

        ml.setVisible(true);
    }
}
