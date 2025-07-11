package cvbuilder;

import javax.swing.SwingUtilities;

public class CVBuilderApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}
