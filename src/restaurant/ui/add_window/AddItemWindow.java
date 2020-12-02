package restaurant.ui.add_window;

import javax.swing.*;
import java.awt.*;

public class AddItemWindow extends JFrame {
    JPanel categoriesPanel;
    JPanel productsPanel;
    JPanel commandsPanel;
    ItemsButtons itemsButtons;

    private final String WINDOW_TITLE = "Add new item";

    public AddItemWindow() {
        this.setTitle(WINDOW_TITLE);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setBounds(1,1,1920,1080);
        this.setVisible(false);
        this.setLayout(new FlowLayout());

        categoriesPanel = new JPanel();
        categoriesPanel.setPreferredSize(new Dimension(1900,200));

        productsPanel = new JPanel();
        productsPanel.setPreferredSize(new Dimension(1900,700));

        commandsPanel = new JPanel();
        commandsPanel.setPreferredSize(new Dimension(1900,100));

        this.add(categoriesPanel);
        this.add(productsPanel);
        this.add(commandsPanel);

        //Category buttons
        CategoriesButtons categoriesButtons = new CategoriesButtons(categoriesPanel);

        //Items buttons
        itemsButtons = new ItemsButtons(productsPanel);

        //Action buttons
        AddWindowCommands windowCommands = new AddWindowCommands(commandsPanel, this);

    }

    //filter product buttons by category
    public void changeCategory() {
        itemsButtons.filterButtonsByCategory();
    }
}
