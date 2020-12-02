package restaurant.ui.receipt_window;

import restaurant.business.Business;
import restaurant.business.Catalogue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReceiptWindow extends JFrame implements ActionListener {

    private String prepareReceipt() {
        String result="";
        Integer[] itemList;
        itemList = Business.getItemList();

        for (int i=0;i<Business.getNumberOfItems();i++) {
            result += Catalogue.getName(itemList[i]);
            result += " "+Catalogue.getPrice(itemList[i])+System.lineSeparator();
        }
        result += System.lineSeparator();
        result += "Total: "+Business.getSumOfTableItems();

        return result;
    }

    public ReceiptWindow() {

        this.setTitle("Receipt for table #"+ (Business.getActiveTable()+1));
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setBounds(1,1,640,800);
        this.setVisible(true);
        JTextArea textField = new JTextArea();
        textField.setEditable(false);
        textField.setBackground(Color.WHITE);
        textField.setFont(new Font(Font.MONOSPACED,Font.PLAIN,16));

        textField.setPreferredSize(new Dimension(630,660));

        JButton button = new JButton("Ok");
        button.setFont(new Font(Font.MONOSPACED,Font.BOLD,60));
        button.addActionListener(this);

        textField.setText(prepareReceipt());
        this.add(textField);
        this.add(button);
        this.setLayout(new FlowLayout());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.dispose();
    }
}
