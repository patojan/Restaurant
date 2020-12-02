package restaurant.ui.main_window;

import restaurant.business.Business;

import javax.swing.*;
import java.awt.*;

public class Overview {
    private static JLabel overviewFirstLine;
    private static final String firstLineText = "      Open tables: ";

    private static JLabel overviewSecondLine;
    private static final String secondLineText = "Total open amount: ";

    public static void init(JPanel panelToPlace) {
        Font overviewFont = new Font(Font.MONOSPACED,Font.BOLD,40);

        overviewFirstLine = new JLabel(firstLineText+ Business.getNumberOfActiveTables());
        overviewFirstLine.setFont(overviewFont);
        overviewFirstLine.setForeground(Color.BLACK);
        overviewFirstLine.setPreferredSize(new Dimension(630,50));
        panelToPlace.add(overviewFirstLine);

        overviewSecondLine = new JLabel("");
        overviewSecondLine.setFont(overviewFont);
        overviewSecondLine.setForeground(Color.BLACK);
        overviewSecondLine.setPreferredSize(new Dimension(630,50));
        panelToPlace.add(overviewSecondLine);

        refreshOverviewInfo();
    }

    public static void refreshOverviewInfo() {
        overviewFirstLine.setText(firstLineText+ Business.getNumberOfActiveTables());
        overviewSecondLine.setText(secondLineText+Business.getSumOfRestaurantItems());
    }
}
