package View;

/**
 * Created by alex on 8/28/14.
 */

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class MainLayout extends JFrame implements ActionListener
{
    private JButton[] buttons;
    private static final String[] buttonNames = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "E", "+",
    };
    private JPanel screenPanel;
    private JPanel buttonPanel;
    private JPanel mainPanel;
    private JTextArea textArea;

    public MainLayout()
    {
        super("RPN Calculator");

        initButtons();
        initScreen();

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(1,2));
        mainPanel.add(screenPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        this.setContentPane(mainPanel);
        this.pack();
        this.setResizable(false);
    }

    private void initScreen()
    {
        screenPanel = new JPanel();
        textArea = new JTextArea(10, 26);
        textArea.setBackground(Color.WHITE);
        textArea.setEnabled(false);
        screenPanel.add(textArea);
    }

    private void initButtons()
    {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4,4,5,5));

        buttons = new JButton[buttonNames.length];
        for (int c=0; c<buttonNames.length; c++) {
            buttons[c] = new JButton(buttonNames[c]);
            buttons[c].addActionListener(this);
            buttonPanel.add(buttons[c]);
        }
    }

    public void actionPerformed(ActionEvent event)
    {

    }
}
