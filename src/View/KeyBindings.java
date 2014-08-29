/**
 * Created by alex on 8/29/14.
 */

package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.UUID;

public class KeyBindings {

    private static final String[] validNumKeys = {
        "1", "2", "3", "4",
        "5", "6", "7", "8",
        "9", "0"
    };

    private MainLayout mainLayout;
    private InputMap im;
    private ActionMap am;

    public KeyBindings(MainLayout ml)
    {
        mainLayout = ml;
        im = mainLayout.mainPanel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
        am = mainLayout.mainPanel.getActionMap();

        addNumKeys();
        addCustomKey(KeyEvent.VK_ENTER, 0, "Enter");
        addCustomKey(KeyEvent.VK_BACK_SPACE, 0, "Bcksp");
        addCustomKey(KeyEvent.VK_MINUS, 0, "-");
        addCustomKey(KeyEvent.VK_PLUS, 0, "+");
        addCustomKey(KeyEvent.VK_DIVIDE, 0, "/");
        addCustomKey(KeyEvent.VK_SLASH, 0, "/");
        addCustomKey(KeyEvent.VK_PERIOD, 0, ".");

        /**
         * These keys are for an US layout keyboard.
         */
        addCustomKey(KeyEvent.VK_8, Event.SHIFT_MASK, "*");
        addCustomKey(KeyEvent.VK_EQUALS, Event.SHIFT_MASK, "+");
    }

    private final String genUUID()
    {
        return UUID.randomUUID().toString();
    }

    private void addNumKeys()
    {
        for (int i=0; i<validNumKeys.length; i++) {
            final int y = i;
            final String id = genUUID();
            Action action = new AbstractAction(){
                public void actionPerformed(ActionEvent e){
                    mainLayout.parseInput(validNumKeys[y]);
                }
            };
            im.put(KeyStroke.getKeyStroke(validNumKeys[i]), id);
            am.put(id, action);
        }
    }

    private void addCustomKey(int keyEvent, int mask, String eKey)
    {
        final String id = genUUID();
        final String key = eKey;
        Action action = new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e){
                mainLayout.parseInput(key);
            }
        };
        im.put(KeyStroke.getKeyStroke(keyEvent, mask), id);
        am.put(id, action);
    }
}
