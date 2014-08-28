/**
 * Created by alex on 8/28/14.
 */

import javax.swing.JFrame;

public class App {

    public static void main(String[] args)
    {
        View.MainLayout mw = new View.MainLayout();

        mw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mw.setSize(300,320);
        mw.setVisible(true);
    }
}
