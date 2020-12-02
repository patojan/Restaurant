package restaurant.ui.main_window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import restaurant.Application;
import restaurant.business.Business;

public class CommandButtons implements ActionListener {
    final int BUTTON_WIDTH = 630;
    final int BUTTON_HEIGHT = 90;

    private JButton newItemButton;
    private final String NEW_ITEM_BUTTON_TEXT = "+";

    private JButton deleteItemButton;
    private final String DELETE_ITEM_BUTTON_TEXT = "-";

    private JButton closeTableButton;
    private final String CLOSE_TABLE_BUTTON_TEXT = "Close table";

    public CommandButtons (JPanel panelToPlace) {
        Font font = new Font(Font.MONOSPACED,Font.BOLD,70);

        newItemButton = new JButton(NEW_ITEM_BUTTON_TEXT);
        newItemButton.setFont(font);
        newItemButton.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        panelToPlace.add(newItemButton);
        newItemButton.addActionListener(this);

        deleteItemButton = new JButton(DELETE_ITEM_BUTTON_TEXT);
        deleteItemButton.setFont(font);
        deleteItemButton.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        panelToPlace.add(deleteItemButton);
        deleteItemButton.addActionListener(this);

        closeTableButton = new JButton(CLOSE_TABLE_BUTTON_TEXT);
        closeTableButton.setFont(font);
        closeTableButton.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        panelToPlace.add(closeTableButton);
        closeTableButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(NEW_ITEM_BUTTON_TEXT)) {
            Application.openNewItemWindow();
        }

        if (e.getActionCommand().equals(DELETE_ITEM_BUTTON_TEXT)) {
            Business.deleteItemFromList();
            Overview.refreshOverviewInfo();
        }

        if (e.getActionCommand().equals(CLOSE_TABLE_BUTTON_TEXT)) {
            Business.closeTable();
        }
    }
}
