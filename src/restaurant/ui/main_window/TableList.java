package restaurant.ui.main_window;

import restaurant.business.Business;
import restaurant.business.Catalogue;

import javax.swing.*;
import java.awt.*;

public class TableList {
    private static JList<String> listOfItems;
    private static JScrollPane scrollPane;
    private static String[] items; // = {""}

    public static void init(JPanel panelToPlace) {
        listOfItems = new JList<>();//items
        listOfItems.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listOfItems.setFont(new Font(Font.MONOSPACED,Font.BOLD,40));

        scrollPane = new JScrollPane(listOfItems);
        scrollPane.setPreferredSize(new Dimension(630,800));

        panelToPlace.add(scrollPane);
    }

    //draw items of selected table
    public static void drawItems() {
        Integer[] intList = Business.getItemList();
        int numberOfItems = intList.length;
        items = new String[numberOfItems];

        for (int i=0; i<numberOfItems;i++) {
            items[i] = Catalogue.getName(intList[i])+" "+Catalogue.getPrice(intList[i]);
        }

        listOfItems.setListData(items);
    }

    //returns index of selected item
    public static int getSelectedListItem() {
        return listOfItems.getSelectedIndex();
    }
}
