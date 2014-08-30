/**
 * Created by alex on 8/28/14.
 *
 * This is the projects main (and only) layout file.
 */

package View;

import Controller.MainController;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class MainLayout extends JFrame implements ActionListener
{
    private static final String[] buttonNames = {
            "Clear", "Drop", "Swap", "Bcksp",
            "π", "Sin", "Cos", "Tan",
            "Y^x", "Sqrt", "1/x", "/",
            "7", "8", "9", "*",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "0", ".", "+/-", "Enter"
    };
    private static final String[] validInputBufferKeys = {
            "0", "1", "2", "3", "4",
            "5", "6", "7", "8", "9",
            ".", "π"
    };
    private static final String[] validOperatorKeys = {
            "Drop", "Swap", "Clear", "Sin",
            "Cos", "Tan", "+/-", "1/x",
            "Sqrt", "Y^x", "/", "*",
            "-", "+"
    };

    private MainController ctrl;
    private KeyBindings kb;

    private int visibleStackCount = 7;

    private JPanel screenPanel;
    private JPanel buttonPanel;
    private JTextPane stackPane;
    private JTextPane bufferPane;
    private Color paneBg = new Color(242,255,194);
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

        pack();
        setResizable(false);

        kb = new KeyBindings(this);
    }

    private void initScreens()
    {
        MutableAttributeSet attr = new SimpleAttributeSet();
        StyleConstants.setAlignment(attr, StyleConstants.ALIGN_RIGHT);
        StyleConstants.setFontSize(attr, 16);
        StyleConstants.setFontFamily(attr, "SansSerif");

        stackPane = new JTextPane();
        stackPane.setBackground(paneBg);
        stackPane.setDisabledTextColor(Color.DARK_GRAY);
        stackPane.setEnabled(false);
        stackPane.setParagraphAttributes(attr, true);

        StyleConstants.setBold(attr, true);

        bufferPane = new JTextPane();
        bufferPane.setBackground(paneBg);
        bufferPane.setDisabledTextColor(Color.BLACK);
        bufferPane.setEnabled(false);
        bufferPane.setParagraphAttributes(attr, true);

        /**
         * screenPanel is a wrapper panel for stackPane
         * and bufferPane.
         */
        screenPanel = new JPanel();
        screenPanel.setLayout(new BorderLayout(1, 2));
        screenPanel.add(stackPane, BorderLayout.NORTH);
        screenPanel.add(bufferPane, BorderLayout.SOUTH);
    }

    private void initButtons()
    {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(7,4,5,5));

        buttons = new JButton[buttonNames.length];
        for (int c=0; c<buttonNames.length; c++) {
            buttons[c] = new JButton(buttonNames[c]);
            buttons[c].addActionListener(this);
            buttons[c].setPreferredSize(new Dimension(20, 25));
            //buttons[c].setForeground(Color.BLACK);
            //buttons[c].setBackground(Color.WHITE);
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

        setContentPane(mainPanel);
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
            output.append(" : "+(i+1)+" ");
            if (i != 0) output.append("\n");
        }
        stackPane.setText(output.toString());
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
            if (eKey == "π")
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
        bufferPane.setText(inputBuffer.toString());
    }
}
