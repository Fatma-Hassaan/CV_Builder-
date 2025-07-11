package cvbuilder;

import cvbuilder.view.UserPanel;

import javax.swing.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("CV Builder");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTabbedPane mainTabs = new JTabbedPane();
        mainTabs.addTab("User", new UserPanel());

        // Add another tab based on your K-number assignment
        // mainTabs.addTab("Contact Info", new ContactPanel());

        add(mainTabs);
    }
}
