/**
 * Created by alex on 8/28/14.
 */

import controller.MainController;
import view.MainLayout;

public class App {

    public static void main(String[] args)
    {
        MainController ctrl = new MainController();
        MainLayout ml = new MainLayout(ctrl, "RPN Calculator");

        ml.setVisible(true);
    }
}
