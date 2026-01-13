package app;

import ui.VentanaSumaSerie;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new VentanaSumaSerie().setVisible(true);
        });
    }
}