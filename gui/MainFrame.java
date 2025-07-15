package gui;

import model.CVData;
import util.CSVHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {
    private CVData cvData;

    public MainFrame() {
        setTitle("CV Builder");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize empty data
        cvData = new CVData();

        // Create tabbed pane
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("User", new UserPanel(cvData));
        tabbedPane.addTab("Experience", new ExperiencePanel(cvData));

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        JMenuItem loadItem = new JMenuItem("Load CV Data");
        loadItem.addActionListener(e -> {
            cvData = CSVHandler.loadCVData("resources/cvbuilder.csv");
            JOptionPane.showMessageDialog(this, "CV data loaded successfully.");
        });

        JMenuItem saveItem = new JMenuItem("Save CV Data");
        saveItem.addActionListener(e -> {
            CSVHandler.saveCVData(cvData, "resources/cvbuilder.csv");
            JOptionPane.showMessageDialog(this, "CV data saved successfully.");
        });

        JMenuItem previewItem = new JMenuItem("Preview Custom CV");
        previewItem.addActionListener(e -> showCustomCV(cvData));

        fileMenu.add(loadItem);
        fileMenu.add(saveItem);
        fileMenu.add(previewItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        add(tabbedPane);
        setVisible(true);
    }

    private void showCustomCV(CVData cvData) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== USER ===\n");
        sb.append("Name: ").append(cvData.getSelectedName()).append("\n");
        sb.append("Title: ").append(cvData.getSelectedTitle()).append("\n");
        sb.append("Email: ").append(cvData.getSelectedEmail()).append("\n\n");

        sb.append("=== EXPERIENCE ===\n");
        for (model.Position p : cvData.getSelectedPositions()) {
            if (p.include) {
                sb.append("- ").append(p.title).append(", ").append(p.company)
                        .append(" (").append(p.duration).append(")\n");
                sb.append(p.description).append("\n\n");
            }
        }

        JTextArea textArea = new JTextArea(sb.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        JOptionPane.showMessageDialog(this, scrollPane, "Custom CV Preview", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame());
    }
}