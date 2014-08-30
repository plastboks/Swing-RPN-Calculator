/**
 * Created by alex on 8/28/14.
 */

package View;

import Controller.MainController;
import Controller.StackOperationError;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainLayout extends JFrame implements ActionListener
{
    private MainController ctrl;
    private Buttons buttons = new Buttons();
    private Screens screens = new Screens();
    private KeyBindings kb;
    private StringBuilder inputBuffer;

    public JPanel mainPanel;

    public MainLayout(MainController ctrl)
    {
        super("RPN Calculator");
        this.ctrl = ctrl;

        initStringBuilder();
        buttons.initButtons(this);
        initMainPanel();
        screens.updateStackPane(ctrl.getStack());

        pack();
        setResizable(false);

        kb = new KeyBindings(this);
    }

    private void initMainPanel()
    {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(1,2));
        mainPanel.add(screens.getScreenPanel(), BorderLayout.NORTH);
        mainPanel.add(buttons.getButtonPanel(), BorderLayout.SOUTH);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
        setContentPane(mainPanel);
    }

    private void initStringBuilder()
    {
       inputBuffer = new StringBuilder();
    }

    // -- commit actions -- //
    private void commitInputBuffer()
    {
        if (inputBuffer.length() > 0) {
            /**
             * Test inputbuffer for parse errors.
             */
            try {
                Double.parseDouble(inputBuffer.toString());
            } catch (NumberFormatException e) {
                showErrorMessage(e.getMessage());
                return;
            }
            /**
             * Try to commit inputbuffer to stack.
             */
            try {
                ctrl.pushToStack(inputBuffer.toString());
                initStringBuilder();
                screens.updateStackPane(ctrl.getStack());
            } catch (StackOverflowError e) {
                showErrorMessage(e.getMessage());
            }
        }
    }

    private void commitOperatorKey(String k)
    {
        /**
         * Special case for the clear key
         */
        if (k == "Clear") {
            int q = showQueryMessage(
                    "Are you sure you want to clear the whole stack?"
            );
            if (q == JOptionPane.NO_OPTION)
                return;
        }
        commitInputBuffer();
        try {
            ctrl.operateOnStack(k);
            initStringBuilder();
            screens.updateStackPane(ctrl.getStack());
        } catch (StackOperationError e) {
            showErrorMessage(e.getMessage());
        }
    }

    // --- Input buffers 'CRUD' --- //
    private void addToInputBuffer(String key)
    {
        inputBuffer.append(key);
    }

    private void deleteFromInputBuffer()
    {
        if (inputBuffer.length() > 0)
            inputBuffer.setLength(inputBuffer.length() -1);
    }

    public void actionPerformed(ActionEvent event)
    {
        parseInput(event.getActionCommand());
    }

    public void parseInput(String eKey)
    {
        if (buttons.isValidInputBufferKey(eKey)) {
            addToInputBuffer(eKey);
        } else if (buttons.isValidInputBufferBackspace(eKey)) {
            deleteFromInputBuffer();
        } else if (buttons.isValidInputBufferCommitKey(eKey)) {
            commitInputBuffer();
        } else if (buttons.isValidOperatorKey(eKey)) {
            commitOperatorKey(eKey);
        }
        screens.updateInputBufferArea(inputBuffer.toString());
    }

    public void showErrorMessage(String str)
    {
        JOptionPane.showMessageDialog(this,
                str,
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    public int showQueryMessage(String msg)
    {
        return JOptionPane.showOptionDialog(this,
            msg,
            "Question",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null, null, null
            );
    }
}
