package gui;

import model.CVData;
import model.Position;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ExperiencePanel extends JPanel {
    private CVData cvData;
    private JTabbedPane experienceTabs;

    public ExperiencePanel(CVData cvData) {
        this.cvData = cvData;
        setLayout(new BorderLayout());

        experienceTabs = new JTabbedPane();
        loadExperienceTabs();

        JButton addPositionButton = new JButton("Add Position");
        addPositionButton.addActionListener(e -> addNewPosition());

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.add(addPositionButton);

        add(experienceTabs, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void loadExperienceTabs() {
        for (int i = 1; i <= cvData.getExperiences().size() + 1; i++) {
            if (!cvData.getExperiences().containsKey(i)) continue;
            JPanel panel = createPositionPanel(i);
            experienceTabs.addTab("Position " + i, panel);
        }
    }

    private JPanel createPositionPanel(int positionNumber) {
        JPanel panel = new JPanel(new BorderLayout());

        DefaultListModel<String> model = new DefaultListModel<>();
        for (Position p : cvData.getExperiences().get(positionNumber)) {
            model.addElement(p.toString());
        }

        JList<String> list = new JList<>(model);
        JScrollPane scrollPane = new JScrollPane(list);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton addButton = new JButton("Add");
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Delete");

        addButton.addActionListener(e -> {
            PositionEditor editor = new PositionEditor();
            if (editor.showDialog(this, "Add New Position")) {
                Position p = editor.getPosition();
                cvData.addExperience(positionNumber, p);
                model.addElement(p.toString());
            }
        });

        deleteButton.addActionListener(e -> {
            int index = list.getSelectedIndex();
            if (index != -1) {
                model.remove(index);
            }
        });

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        if (positionNumber > 1) {
            JCheckBox includeBox = new JCheckBox("Include");
            includeBox.setSelected(true);
            buttonPanel.add(includeBox);
        }

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        return panel;
    }

    private void addNewPosition() {
        int newPositionNumber = cvData.getExperiences().size() + 1;
        PositionEditor editor = new PositionEditor();
        if (editor.showDialog(this, "Add New Position")) {
            Position p = editor.getPosition();
            cvData.addExperience(newPositionNumber, p);
            JPanel panel = createPositionPanel(newPositionNumber);
            experienceTabs.addTab("Position " + newPositionNumber, panel);
        }
    }

    private static class PositionEditor {
        private JTextField titleField = new JTextField(20);
        private JTextField companyField = new JTextField(20);
        private JTextField durationField = new JTextField(20);
        private JTextArea descriptionArea = new JTextArea(3, 20);
        private JCheckBox includeBox = new JCheckBox("Include");

        public boolean showDialog(Component parent, String title) {
            JPanel panel = new JPanel(new GridLayout(0, 1));
            panel.add(new JLabel("Title:"));
            panel.add(titleField);
            panel.add(new JLabel("Company:"));
            panel.add(companyField);
            panel.add(new JLabel("Duration:"));
            panel.add(durationField);
            panel.add(new JLabel("Description:"));
            panel.add(new JScrollPane(descriptionArea));
            panel.add(includeBox);

            return JOptionPane.showConfirmDialog(parent, panel, title,
                    JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION;
        }

        public Position getPosition() {
            return new Position(
                    titleField.getText(),
                    companyField.getText(),
                    durationField.getText(),
                    descriptionArea.getText(),
                    includeBox.isSelected()
            );
        }
    }
}