/**
 * Created by alex on 8/28/14.o
 *
 * This is the projects main (and only) layout file.
 */

package View;

import Controller.MainController;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;

public class MainLayout extends JFrame implements ActionListener
{
    private static final String[] buttonNames = {
            "Bcksp", "Drop", "Swap", "Clear",
            "PI", "Sin", "Cos", "Tan",
            "+/-", "1/x", "Sqrt", "Y^x",
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "Enter", "+",
    };
    private static final String[] validInputBufferKeys = {
            "0", "1", "2", "3", "4",
            "5", "6", "7", "8", "9",
            ".", "PI"
    };
    private static final String[] validOperatorKeys = {
            "Drop", "Swap", "Clear", "Sin",
            "Cos", "Tan", "+/-", "1/x",
            "Sqrt", "Y^x", "/", "*",
            "-", "+"
    };

    private MainController ctrl;
    private KeyBindings kb;

    private int visibleStackCount = 8;

    private JPanel screenPanel;
    private JPanel buttonPanel;
    private JTextPane stackArea;
    private JTextPane bufferArea;
    private JButton[] buttons;

    public JPanel mainPanel;
    private StringBuilder inputBuffer;

    public MainLayout(MainController ctrl)
    {
        super("RPN Calculator");
        this.ctrl = ctrl;

        initStringBuilder();
        initButtons();
        initScreens();
        initMainPanel();
        updateStackArea();

        kb = new KeyBindings(this);
    }

    private void initScreens()
    {
        stackArea = new JTextPane();
        stackArea.setBackground(Color.WHITE);
        stackArea.setDisabledTextColor(Color.BLACK);
        stackArea.setEnabled(false);

        bufferArea = new JTextPane();
        bufferArea.setBackground(Color.WHITE);
        bufferArea.setDisabledTextColor(Color.BLACK);
        bufferArea.setEnabled(false);

        screenPanel = new JPanel();
        screenPanel.setLayout(new BorderLayout(1, 2));
        screenPanel.add(stackArea, BorderLayout.NORTH);
        screenPanel.add(bufferArea, BorderLayout.SOUTH);
    }

    private void initButtons()
    {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(7,4,5,5));

        buttons = new JButton[buttonNames.length];
        for (int c=0; c<buttonNames.length; c++) {
            buttons[c] = new JButton(buttonNames[c]);
            buttons[c].addActionListener(this);
            buttonPanel.add(buttons[c]);
        }
    }

    private void initMainPanel()
    {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(1,2));
        mainPanel.add(screenPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));

        this.setContentPane(mainPanel);
        this.pack();
        this.setResizable(false);
    }

    private void initStringBuilder()
    {
       inputBuffer = new StringBuilder();
    }

    private void updateStackArea()
    {
        DecimalFormat df = new DecimalFormat("0.00####");
        StringBuilder output = new StringBuilder();
        double[] s = ctrl.getStack();

        int length = visibleStackCount;
        for (int i=length; i>=0; i--) {
            output.append(df.format(s[i]));
            if (i != 0)
                output.append("\n");
        }
        stackArea.setText(output.toString());
    }

    private boolean isValidInputBufferKey(String k)
    {
        for (String valid: validInputBufferKeys)
            if (valid == k)
                return true;
        return false;
    }

    private boolean isValidOperatorKey(String k)
    {
        for (String valid : validOperatorKeys)
            if (valid == k)
                return true;
        return false;
    }

    private boolean isValidInputBufferCommitKey(String k)
    {
        return k == "Enter";
    }

    private boolean isValidInputBufferBackspace(String k)
    {
        return k == "Bcksp";
    }

    public void actionPerformed(ActionEvent event)
    {
        parseInput(event.getActionCommand());
    }

    public void parseInput(String eKey)
    {
        /**
         * Starting to get real ugly this...
         * Consider refactoring.
         */
        if (isValidInputBufferKey(eKey)) {
            if (eKey == "PI")
                inputBuffer.append(Math.PI);
            else
                inputBuffer.append(eKey);
        } else if (isValidInputBufferBackspace(eKey)) {
            if (inputBuffer.length() > 0)
                inputBuffer.setLength(inputBuffer.length() -1);
        } else if (isValidInputBufferCommitKey(eKey)) {
            if (inputBuffer.length() > 0) {
                ctrl.pushToStack(inputBuffer.toString());
                initStringBuilder();
                updateStackArea();
            }
        } else if (isValidOperatorKey(eKey)) {
            ctrl.operateOnStack(eKey);
            initStringBuilder();
            updateStackArea();
        }
        updateInputBufferArea();
    }

    public void updateInputBufferArea()
    {
        bufferArea.setText(inputBuffer.toString());
    }

}
