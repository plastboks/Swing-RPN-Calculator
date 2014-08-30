/**
 * Created by alex on 8/30/14.
 */

package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Buttons extends JFrame
{

    private static final String[] mainButtonNames = {
            "sin", "cos", "tan", "sign", "cot",
            "mod", "n!", "sqrt", "1/x", "/",
            "ln", "7", "8", "9", "*",
            "log", "4", "5", "6", "-",
            "y^x", "1", "2", "3", "+",
            "x^2", "0", ".", "+/-", "Enter"
    };
    private static final String[] stackButtonNames = {
            "Clear", "Drop", "Swap", "<-"
    };
    private static final String[] trigModes = {
            "DEG", "RAD", "GRAD"
    };
    private static final String[] validInputBufferKeys = {
            "0", "1", "2", "3", "4",
            "5", "6", "7", "8", "9",
            "."
    };
    private static final String[] validOperatorKeys = {
            "Drop", "Swap", "Clear", "sin",
            "cos", "tan", "+/-", "1/x",
            "sqrt", "y^x", "x^2", "/",
            "*", "-", "+", "ln", "log",
            "n!", "mod", "abs", "sign",
            "cot"
    };
    private JPanel buttonPanel;

    public void initButtons(ActionListener al)
    {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout(1, 2));

        JPanel stackKeys = new JPanel();
        stackKeys.setLayout(new GridLayout(1, 4, 5, 5));
        JButton[] stackButtons = new JButton[mainButtonNames.length];
        for (int c=0; c<stackButtonNames.length; c++) {
            stackButtons[c] = new JButton(stackButtonNames[c]);
            stackButtons[c].addActionListener(al);
            stackButtons[c].setPreferredSize(new Dimension(20, 25));
            stackKeys.add(stackButtons[c]);
        }

        JPanel mainKeys = new JPanel();
        mainKeys.setLayout(new GridLayout(6, 5, 5, 5));
        JButton[] mainButtons = new JButton[mainButtonNames.length];
        for (int c=0; c<mainButtonNames.length; c++) {
            mainButtons[c] = new JButton(mainButtonNames[c]);
            mainButtons[c].addActionListener(al);
            mainButtons[c].setPreferredSize(new Dimension(20, 25));
            mainKeys.add(mainButtons[c]);
        }
        buttonPanel.add(stackKeys, BorderLayout.NORTH);
        buttonPanel.add(mainKeys, BorderLayout.SOUTH);
    }

    public JPanel getButtonPanel()
    {
        return buttonPanel;
    }

    public String[] getValidInputBufferKeys()
    {
        return validInputBufferKeys;
    }

    public String[] getValidOperatorKeys()
    {
        return validOperatorKeys;
    }

    // --- Testers --- //
    public boolean isValidInputBufferKey(String k)
    {
        for (String valid: getValidInputBufferKeys())
            if (valid == k)
                return true;
        return false;
    }

    public boolean isValidOperatorKey(String k)
    {
        for (String valid : getValidOperatorKeys())
            if (valid == k)
                return true;
        return false;
    }

    public boolean isValidInputBufferCommitKey(String k)
    {
        return k == "Enter";
    }

    public boolean isValidInputBufferBackspace(String k)
    {
        return k == "<-";
    }
}
