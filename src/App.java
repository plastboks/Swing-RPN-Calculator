/**
 * Created by alex on 8/28/14.
 */

import controller.MainController;
import view.MainLayout;

public class App {

    public static void main(String[] args)
    {
        new MainLayout(new MainController(), "RPN Calculator");
    }
}
