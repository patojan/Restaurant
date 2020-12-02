package restaurant;

import restaurant.business.Business;
import restaurant.business.Catalogue;
import restaurant.ui.add_window.AddItemWindow;
import restaurant.ui.main_window.*;
import restaurant.ui.receipt_window.ReceiptWindow;

import javax.swing.*;

public class Application {
    public final static int WARNING_MESSAGE = 2;

    private static final int numberOfTables = 20;

    private static MainWindow window;
    private static AddItemWindow addWindow;

    public static void init() {
        window = new MainWindow();

        Business.init(numberOfTables);
        Catalogue.init();

        //Panel 1
        ActiveTableInfo.init(window.panel1);
        TableList.init(window.panel1);
        TableOverview.init(window.panel1);

        //Panel 2
        CommandButtons commandButtons = new CommandButtons(window.panel2);

        //Panel 3
        TableButtons tableButtons = new TableButtons(window.panel3,Business.getNumberOfTables());
        Overview.init(window.panel3);

        addWindow = new AddItemWindow();
    }

    //activates window for selecting products
    public static void openNewItemWindow() {
        addWindow.setVisible(true);
    }
    //refresh products on add item window according to category selection
    public static void refreshProducts() {addWindow.changeCategory();}


    //customized Swing showMessage
    public static void showMessage(String title, String message, int messageType) {
        JOptionPane.showMessageDialog(window, message, title, messageType);
    }

    //customized Yes/No dialog
    public static boolean yesNoDialog(String title, String message) {
        String[] options = {"Yes", "No"};
        int reply = JOptionPane.showOptionDialog(window, message, title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);
        return reply == 0;
    }

    public static void printReceipt() {
        ReceiptWindow receiptWindow = new ReceiptWindow();
    }

}
