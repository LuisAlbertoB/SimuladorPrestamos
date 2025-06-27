import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InterfazPrestamo extends JFrame {
    private JTextField tfMonto, tfAnticipo, tfTasa, tfPlazo;
    private JTextArea resultado;

    public InterfazPrestamo() {
        setTitle("Simulador de Préstamos MXN");
        setSize(450, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 2));

        tfMonto = new JTextField();
        tfAnticipo = new JTextField();
        tfTasa = new JTextField();
        tfPlazo = new JTextField();
        resultado = new JTextArea(10, 30);
        resultado.setEditable(false);

        add(new JLabel("Monto del préstamo (MXN):"));
        add(tfMonto);

        add(new JLabel("Anticipo (MXN):"));
        add(tfAnticipo);

        add(new JLabel("Tasa de interés anual (%):"));
        add(tfTasa);

        add(new JLabel("Plazo en años (1-30):"));
        add(tfPlazo);

        JButton calcular = new JButton("Calcular préstamo");
        add(calcular);

        calcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularPrestamo();
            }
        });

        add(new JScrollPane(resultado));
        setVisible(true);
    }

    private void calcularPrestamo() {
        try {
            double monto = Double.parseDouble(tfMonto.getText());
            double anticipo = Double.parseDouble(tfAnticipo.getText());
            double tasa = Double.parseDouble(tfTasa.getText());
            int plazo = Integer.parseInt(tfPlazo.getText());

            Prestamo prestamo = new Prestamo(monto, anticipo, tasa, plazo);

            double mensualidad = prestamo.calcularCuotaMensual();
            double total = prestamo.calcularTotalAPagar();
            double intereses = prestamo.calcularInteresesTotales();
            double montoFinanciado = prestamo.getMontoFinanciado();

            double tasaMensual = tasa / 100 / 12;
            double valorPresente = montoFinanciado;
            int n = plazo * 12;
            double cuotaJusta = prestamo.calcularCuotaPagoJusto(valorPresente, tasaMensual, n);

            resultado.setText("Resumen del préstamo:\n");
            resultado.append("Monto financiado: $" + String.format("%.2f", montoFinanciado) + "\n");
            resultado.append("Cuota mensual estándar: $" + String.format("%.2f", mensualidad) + "\n");
            resultado.append("Cuota mensual (pago justo): $" + String.format("%.2f", cuotaJusta) + "\n");
            resultado.append("Total a pagar: $" + String.format("%.2f", total) + "\n");
            resultado.append("Intereses totales: $" + String.format("%.2f", intereses) + "\n");

        } catch (NumberFormatException ex) {
            resultado.setText("Error: Verifica que los datos ingresados sean válidos numéricamente.");
        }
    }

    public static void main(String[] args) {
        new InterfazPrestamo();
    }
}
