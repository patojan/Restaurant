package restaurant.ui.add_window;

import restaurant.business.Business;
import restaurant.business.OpenItem;
import restaurant.ui.main_window.Overview;
import restaurant.ui.main_window.TableList;
import restaurant.ui.main_window.TableOverview;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddWindowCommands implements ActionListener {
    JButton addButton;
    JButton exitButton;
    JFrame window;

    private final String ADD_BUTTON_TEXT = " Add ";
    private final String EXIT_BUTTON_TEXT = "Exit";

    public AddWindowCommands(JPanel panelToPlace, JFrame frame) {
        window = frame;

        Font font = new Font(Font.MONOSPACED,Font.BOLD,60);

        addButton = new JButton(ADD_BUTTON_TEXT);
        exitButton = new JButton(EXIT_BUTTON_TEXT);

        panelToPlace.add(addButton);
        panelToPlace.add(exitButton);

        addButton.setFont(font);
        exitButton.setFont(font);

        addButton.addActionListener(this);
        exitButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(ADD_BUTTON_TEXT)) {
            Business.addToItemList(OpenItem.getSelectedItem());
            TableList.drawItems();
            TableOverview.refreshTableOverview();
            Overview.refreshOverviewInfo();
            window.setVisible(false);
        }

        if (e.getActionCommand().equals(EXIT_BUTTON_TEXT)) {
            window.setVisible(false);
        }
    }
}
