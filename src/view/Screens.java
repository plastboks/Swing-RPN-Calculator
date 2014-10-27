/**
 * Created by alex on 8/30/14.
 */

package view;

import type.RichDouble;

import javax.swing.*;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;

public class Screens
{
    private int visibleStackCount = 7;

    private JPanel screenPanel;
    private JTextPane stackPane;
    private JTextPane bufferPane;
    private Color paneBg = new Color(242,255,194);

    public Screens()
    {
        initScreens();
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
        screenPanel.add(bufferPane, BorderLayout.CENTER);
    }

    public JPanel getScreenPanel()
    {
        return screenPanel;
    }

    public void updateStackPane(RichDouble[] stack)
    {
        StringBuilder output = new StringBuilder();

        int length = visibleStackCount;
        for (int i=length; i>=0; i--) {
            output.append(i < stack.length ? stack[i] : "");
            output.append(" : "+(i+1)+" ");
            if (i != 0) output.append("\n");
        }
        stackPane.setText(output.toString());
    }

    public void updateInputBufferArea(String str)
    {
        bufferPane.setText(str);
    }
}
