package restaurant.ui.add_window;

import restaurant.business.Catalogue;
import restaurant.business.OpenItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ItemsButtons implements ActionListener {
    private final Color BUTTON_COLOR = Color.LIGHT_GRAY;
    private final Color SELECTED_BUTTON_COLOR = Color.YELLOW;
    private final Font buttonFont = new Font(Font.MONOSPACED,Font.BOLD,40);

    private JButton[] itemButtons;
    private final JPanel panel;
    ArrayList<Integer> list;

    public ItemsButtons(JPanel panelToPlace) {
        panel = panelToPlace;

        placeAllButtons();
        filterButtonsByCategory();
    }

    public void placeAllButtons() {

        itemButtons = new JButton[Catalogue.getNumberOfCatalogueItems()];
        for (int i=0; i<itemButtons.length; i++) {
            itemButtons[i] = new JButton(Catalogue.getName(i)+" "+Catalogue.getPrice(i));
            itemButtons[i].setFont(buttonFont);
            panel.add(itemButtons[i]);
            itemButtons[i].addActionListener(this);
            itemButtons[i].setActionCommand(Integer.toString(i));

            //decision on button color
            if (i != OpenItem.getSelectedCategory()) {
                itemButtons[i].setBackground(BUTTON_COLOR);
            } else {
                itemButtons[i].setBackground(SELECTED_BUTTON_COLOR);
            }
        }

    }

    //filter product buttons by category
    public void filterButtonsByCategory() {
        list = Catalogue.getCategoryProducts(OpenItem.getSelectedCategory());
        boolean itemSelected = false;

        for (int i=0; i<itemButtons.length; i++) {
            if (list.contains(Integer.parseInt(itemButtons[i].getActionCommand()))) {
                itemButtons[i].setVisible(true);
                if (!itemSelected) {
                    activateButton(i);
                    itemSelected = true;
                }
            } else {
                itemButtons[i].setVisible(false);
            }
        }
    }

    private void activateButton(int buttonCommand) {
        itemButtons[OpenItem.getSelectedItem()].setBackground(BUTTON_COLOR); //inactivates active button

        OpenItem.selectItem(buttonCommand); //set new active button in business layer
        itemButtons[buttonCommand].setBackground(SELECTED_BUTTON_COLOR); //highlight activated button
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        activateButton(Integer.parseInt(e.getActionCommand()));
    }
}
