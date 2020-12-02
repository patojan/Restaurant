package restaurant.ui.main_window;

import restaurant.business.Business;

import javax.swing.*;
import java.awt.*;

public class ActiveTableInfo {
    private static JLabel activeTableInfo;

    public static void init(JPanel panelToPlace) {
        Font overviewFont = new Font(Font.MONOSPACED,Font.BOLD,40);

        activeTableInfo = new JLabel(""+ (Business.getActiveTable()+1));
        activeTableInfo.setFont(overviewFont);
        activeTableInfo.setForeground(Color.BLACK);
        panelToPlace.add(activeTableInfo);
    }

    //refreshes number of selected table
    public static void refreshActiveTableInfo() {
        activeTableInfo.setText(""+(Business.getActiveTable()+1));
    }
}
