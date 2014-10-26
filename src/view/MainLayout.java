/**
 * Created by alex on 8/28/14.
 */

package view;

import controller.MainController;
import controller.StackOperationError;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainLayout extends JFrame implements ActionListener
{
    private MainController ctrl;
    private Buttons buttons = new Buttons();
    private Screens screens = new Screens();
    private StringBuilder inputBuffer;
    private String trigMode = "DEG";

    public JPanel mainPanel;

    public MainLayout(MainController ctrl, String title)
    {
        super(title);
        this.ctrl = ctrl;
        initStringBuilder();
        buttons.initButtons(this);
        initMainPanel();
        screens.updateStackPane(ctrl.getStack());
        new KeyBindings(this);

        pack();
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(425,
                screens.getHeight() + buttons.getHeight() + 45);
        setLocationRelativeTo(null);
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
            ctrl.operateOnStack(k, trigMode);
            initStringBuilder();
            screens.updateStackPane(ctrl.getStack());
        } catch (StackOperationError e) {
            showErrorMessage(e.getMessage());
        }
    }

    // --- Input buffers 'CRUD' --- //
    private void addToInputBuffer(String key)
    {
        if (key == "π")
            inputBuffer.append(Math.PI);
        else if (key == "e")
            inputBuffer.append(Math.E);
        else
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
        } else if (buttons.isValidTrigModeKey(eKey)) {
            trigMode = eKey;
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
