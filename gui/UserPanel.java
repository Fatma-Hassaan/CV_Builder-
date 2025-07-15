package gui;

import model.CVData;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserPanel extends JPanel {
    private CVData cvData;

    private DefaultListModel<String> nameModel;
    private JList<String> nameList;
    private ButtonGroup nameGroup;

    private DefaultListModel<String> titleModel;
    private JList<String> titleList;
    private ButtonGroup titleGroup;

    private DefaultListModel<String> emailModel;
    private JList<String> emailList;
    private ButtonGroup emailGroup;

    public UserPanel(CVData cvData) {
        this.cvData = cvData;
        setLayout(new BorderLayout());

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Name", createNamePanel());
        tabs.addTab("Title", createTitlePanel());
        tabs.addTab("Email", createEmailPanel());

        add(tabs, BorderLayout.CENTER);
    }

    private JPanel createNamePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        nameModel = new DefaultListModel<>();
        cvData.getNames().forEach(nameModel::addElement);
        nameList = new JList<>(nameModel);
        nameList.setCellRenderer(new RadioButtonListCellRenderer());
        JScrollPane scrollPane = new JScrollPane(nameList);

        nameGroup = new ButtonGroup();
        for (int i = 0; i < nameModel.size(); i++) {
            JRadioButton radioButton = new JRadioButton();
            nameGroup.add(radioButton);
        }

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton addButton = new JButton("Add");
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Delete");

        addButton.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(this, "Enter Name:");
            if (input != null && !input.trim().isEmpty()) {
                nameModel.addElement(input);
                cvData.addName(input);
            }
        });

        deleteButton.addActionListener(e -> {
            int index = nameList.getSelectedIndex();
            if (index != -1) {
                nameModel.remove(index);
            }
        });

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        return panel;
    }

    private JPanel createTitlePanel() {
        // Similar to createNamePanel(), duplicated for brevity
        return new JPanel();
    }

    private JPanel createEmailPanel() {
        // Similar to createNamePanel()
        return new JPanel();
    }

    private static class RadioButtonListCellRenderer implements ListCellRenderer<String> {
        private JRadioButton radioButton = new JRadioButton();

        @Override
        public Component getListCellRendererComponent(JList<? extends String> list, String value, int index, boolean isSelected, boolean cellHasFocus) {
            radioButton.setText(value);
            radioButton.setOpaque(false);
            return radioButton;
        }
    }
}