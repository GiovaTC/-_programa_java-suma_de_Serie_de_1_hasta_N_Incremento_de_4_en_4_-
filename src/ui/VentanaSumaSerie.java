package ui;

import dao.SumaSerieDAO;
import service.SumaSerieService;

import javax.swing.*;
import java.awt.*;

public class VentanaSumaSerie extends JFrame {
    
    private JTextField txtN;
    private JTextArea txtResultado;

    public VentanaSumaSerie() {
        setTitle("Suma de Serie 1 hasta N (de 4 en 4)");
        setSize(500, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponentes();
    }

    private void initComponentes() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        JPanel superior = new JPanel();

        superior.add(new JLabel("Ingrese N:"));
        txtN = new JTextField(10);
        superior.add(txtN);

        JButton btnCalcular = new JButton("Calcular");
        superior.add(btnCalcular);

        txtResultado = new JTextArea();
        txtResultado.setEditable(false);
        txtResultado.setLineWrap(true);
        txtResultado.setWrapStyleWord(true);

        panel.add(superior, BorderLayout.NORTH);
        panel.add(new JScrollPane(txtResultado), BorderLayout.CENTER);

        add(panel);

        btnCalcular.addActionListener(e -> calcular());
    }

    private void calcular() {
        try {
            int n = Integer.parseInt(txtN.getText());

            SumaSerieService service = new SumaSerieService();
            StringBuilder procedimiento = service.generarProcedimiento(n);
            int resultado = service.calcularSuma(n);

            txtResultado.setText("Procedimiento:\n" + procedimiento);

            new SumaSerieDAO().registrarSuma(n, procedimiento.toString(), resultado);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese un número válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
