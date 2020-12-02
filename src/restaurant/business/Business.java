package restaurant.business;

import restaurant.Application;
import restaurant.ui.main_window.Overview;
import restaurant.ui.main_window.TableList;
import restaurant.ui.main_window.TableOverview;

import java.util.ArrayList;

public class Business {
    //One table and its members
    public static class Table {
        boolean open = false;
        ArrayList<Integer> items;
    }

    private static int activeTable=0;
    private static int numberOfTables;
    private static Table[] tableList;

    public static void init(int inputNumberOfTables) {
        numberOfTables = inputNumberOfTables;
        tableList = new Table[inputNumberOfTables];
        for (int i=0;i<inputNumberOfTables;i++) {
            tableList[i] = new Table();
            tableList[i].items = new ArrayList<>();
        }
    }

    public static void setActiveTable(int inputActiveTable) {
        if ((inputActiveTable>-1)&&(inputActiveTable<numberOfTables)) { //validity check of input
            Business.activeTable = inputActiveTable;
        }
    }
    public static int getActiveTable() {
        return activeTable;
    }

    public static int getNumberOfTables() {
        return numberOfTables;
    }

    public static int getNumberOfActiveTables() {
        int result=0;
        for (int i=0;i<numberOfTables;i++)
        {
            if (tableList[i].open) result++;
        }
        return result;
    }

    //Adds item to table item list
    public static void addToItemList(int itemId) {
        if (tableList[activeTable].items==null) {
            tableList[activeTable].items = new ArrayList();
        }
        tableList[activeTable].items.add(itemId);

        refreshTableOpen();
    }

    public static Integer[] getItemList() {
        int numberOfItems;

        if (tableList[activeTable].items!=null) {
            numberOfItems = tableList[activeTable].items.size();
        } else {
            numberOfItems = 0;
        }

        Integer[] result = new Integer[numberOfItems];
        for (int i=0; i<numberOfItems; i++) {
            result[i] = tableList[activeTable].items.get(i);
        }
        return result;
    }

    public static void deleteItemFromList() {
        int selectedItem = TableList.getSelectedListItem();
        if (selectedItem!=-1) {
            if (Application.yesNoDialog("Delete item","Do you really want to delete this item?")) {
                tableList[activeTable].items.remove(selectedItem);
            }
            System.out.println("item removed");
        } else {
            Application.showMessage("Warning", "No item selected.", Application.WARNING_MESSAGE);
        }

        TableList.drawItems();
        TableOverview.refreshTableOverview();

        refreshTableOpen();
    }

    //Decides if there are any items on the table
    private static void refreshTableOpen() {
        tableList[activeTable].open=(tableList[activeTable].items.size()!=0);
    }

    public static boolean isActiveTableOpen() {
        return tableList[activeTable].open;
    }

    public static int getNumberOfItems() {
        if (tableList[activeTable].items==null) {
            return 0;
        } else {
            return tableList[activeTable].items.size();
        }
    }

    public static int getSumOfTableItems() {
        int result = 0;
        if (tableList[activeTable].items==null) {
            return 0;
        } else {
            for (int i=0;i<tableList[activeTable].items.size();i++) {
                result += Catalogue.getPrice(tableList[activeTable].items.get(i));
            }
        }
        return result;
    }

    public static int getSumOfRestaurantItems() {
        int result=0;
        for (int i=0;i<numberOfTables;i++) { //cycle for all tables
            if (tableList[i].open) {
                for (int j=0;j<tableList[i].items.size();j++) { //cycle for all items of the table
                    result += Catalogue.getPrice(tableList[i].items.get(j));
                }
            }
        }
        return result;
    }

    private static void clearTable() {
        tableList[activeTable].items.clear();
        tableList[activeTable].open=false;
    }

    public static void closeTable() {
        if (getNumberOfItems()>0 && Application.yesNoDialog("Close the table","Do you really want to close the table?")) {
            Application.printReceipt();
            clearTable();
            Overview.refreshOverviewInfo();
            TableOverview.refreshTableOverview();
            TableList.drawItems();
            refreshTableOpen();
        }
    }

}
