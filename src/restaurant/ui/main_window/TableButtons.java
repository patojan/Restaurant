package restaurant.ui.main_window;

import restaurant.business.Business;
import restaurant.ui.main_window.ActiveTableInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableButtons implements ActionListener {
    private final Color BUTTON_COLOR = Color.LIGHT_GRAY;
    private final Color SELECTED_TABLE_BUTTON_COLOR = Color.YELLOW;
    private final Color OPEN_TABLE_BUTTON_COLOR = Color.PINK;

    public JButton[] tableButton;

    public TableButtons(JPanel panelToPlace, int numberOfTables) {
         tableButton = new JButton[numberOfTables];

        for (int i=0;i<20;i++) {
            tableButton[i] = new JButton(String.valueOf(i+1));
            tableButton[i].setActionCommand(Integer.toString(i));
            tableButton[i].setFont(new Font(Font.MONOSPACED,Font.BOLD,110));
            panelToPlace.add(tableButton[i]);
            tableButton[i].addActionListener(this);
            tableButton[i].setBackground(BUTTON_COLOR);
        }

        tableButton[0].setBackground(SELECTED_TABLE_BUTTON_COLOR);
    }

    //Action for click on the table button
    @Override
    public void actionPerformed(ActionEvent e) {
        if (Business.isActiveTableOpen()) {
            tableButton[Business.getActiveTable()].setBackground(OPEN_TABLE_BUTTON_COLOR);
        } else {
            tableButton[Business.getActiveTable()].setBackground(BUTTON_COLOR);
        }

        Business.setActiveTable(Integer.parseInt(e.getActionCommand()));
        tableButton[Business.getActiveTable()].setBackground(SELECTED_TABLE_BUTTON_COLOR);

        ActiveTableInfo.refreshActiveTableInfo();
        TableOverview.refreshTableOverview();
        TableList.drawItems();
    }
}
