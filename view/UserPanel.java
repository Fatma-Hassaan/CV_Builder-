package cvbuilder.view;

import javax.swing.*;
import java.awt.*;

public class UserPanel extends JPanel {
    private JTabbedPane tabbedPane;

    public UserPanel() {
        tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Name", new JPanel()); // You will implement these panels
        tabbedPane.addTab("Title", new JPanel());
        tabbedPane.addTab("Email", new JPanel());

        setLayout(new BorderLayout());
        add(tabbedPane, BorderLayout.CENTER);
    }
}
