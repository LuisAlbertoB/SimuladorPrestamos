import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InterfazPrestamo extends JFrame {
    private JTextField tfMonto, tfAnticipo, tfTasa, tfPlazo;
    private JTextArea resultado;

    public InterfazPrestamo() {
        setTitle("Simulador de Préstamos MXN");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        tfMonto = new JTextField();
        tfAnticipo = new JTextField();
        tfTasa = new JTextField();
        tfPlazo = new JTextField();
        resultado = new JTextArea(6, 30);
        resultado.setEditable(false);

        add(new JLabel("Monto del préstamo (MXN):"));
        add(tfMonto);

        add(new JLabel("Anticipo (MXN):"));
        add(tfAnticipo);

        add(new JLabel("Tasa de interés anual (%):"));
        add(tfTasa);

        add(new JLabel("Plazo en años (1-30):"));
        add(tfPlazo);

        JButton calcular = new JButton("Calcular");
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
        double monto = Double.parseDouble(tfMonto.getText());
        double anticipo = Double.parseDouble(tfAnticipo.getText());
        double tasa = Double.parseDouble(tfTasa.getText());
        int plazo = Integer.parseInt(tfPlazo.getText());

        Prestamo prestamo = new Prestamo(monto, anticipo, tasa, plazo);

        resultado.setText("Monto financiado: $" + String.format("%.2f MXN", prestamo.getMontoFinanciado()) +
                "\nCuota mensual: $" + String.format("%.2f MXN", prestamo.calcularCuotaMensual()) +
                "\nTotal a pagar: $" + String.format("%.2f MXN", prestamo.calcularTotalAPagar()) +
                "\nIntereses totales: $" + String.format("%.2f MXN", prestamo.calcularInteresesTotales()));
    }

    public static void main(String[] args) {
        new InterfazPrestamo();
    }
}
