package restaurant.ui.main_window;

import restaurant.business.Business;

import javax.swing.*;
import java.awt.*;

public class TableOverview {
    static String firstLine = " Items: ";
    static String secondLine = "Amount: ";

    private static JLabel firstLabel;
    private static JLabel secondLabel;

    public static void init(JPanel panelToPlace) {
        Font tableOverviewFont = new Font(Font.MONOSPACED,Font.BOLD,40);

        firstLabel = new JLabel(firstLine);
        firstLabel.setFont(tableOverviewFont);
        firstLabel.setForeground(Color.BLACK);
        firstLabel.setPreferredSize(new Dimension(630,80));
        panelToPlace.add(firstLabel);

        secondLabel = new JLabel(secondLine);
        secondLabel.setFont(tableOverviewFont);
        secondLabel.setForeground(Color.BLACK);
        secondLabel.setPreferredSize(new Dimension(630,50));
        panelToPlace.add(secondLabel);

        refreshTableOverview();
    }

    //refreshes number of table items and sum of table items
    public static void refreshTableOverview() {
        firstLabel.setText(firstLine+ Business.getNumberOfItems());
        secondLabel.setText(secondLine+ Business.getSumOfTableItems());
    }
}
