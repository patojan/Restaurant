package restaurant.ui.add_window;

import restaurant.Application;
import restaurant.business.Catalogue;
import restaurant.business.OpenItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CategoriesButtons implements ActionListener {
    private String[] allCategories;
    private final int numberOfButtons;

    private final Color BUTTON_COLOR = Color.LIGHT_GRAY;
    private final Color SELECTED_BUTTON_COLOR = Color.YELLOW;
    private final Font buttonFont = new Font(Font.MONOSPACED,Font.BOLD,60);

    private final JButton[] categoryButtons;

    public CategoriesButtons(JPanel panelToPlace) {
        numberOfButtons = Catalogue.getNumberOfCategories();

        categoryButtons = new JButton[numberOfButtons];
        allCategories = new String[numberOfButtons];
        allCategories = Catalogue.getAllCategories();

        for (int i=0;i<numberOfButtons;i++) {
            categoryButtons[i] = new JButton(allCategories[i]);
            categoryButtons[i].setFont(buttonFont);
            panelToPlace.add(categoryButtons[i]);
            categoryButtons[i].addActionListener(this);
            categoryButtons[i].setActionCommand(Integer.toString(i));
            if (i!=OpenItem.getSelectedCategory()) {
                categoryButtons[i].setBackground(BUTTON_COLOR);
            } else {
                categoryButtons[i].setBackground(SELECTED_BUTTON_COLOR);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        categoryButtons[OpenItem.getSelectedCategory()].setBackground(BUTTON_COLOR);

        OpenItem.selectCategory(Integer.parseInt(e.getActionCommand()));
        categoryButtons[Integer.parseInt(e.getActionCommand())].setBackground(SELECTED_BUTTON_COLOR);

        Application.refreshProducts();
    }
}
