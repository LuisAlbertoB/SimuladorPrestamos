public class Prestamo {
    private double monto;
    private double anticipo;
    private double tasaInteres;
    private int plazo;

    public Prestamo(double monto, double anticipo, double tasaInteres, int plazo) {
        this.monto = monto;
        this.anticipo = anticipo;
        this.tasaInteres = tasaInteres;
        this.plazo = plazo;
    }

    public double getMontoFinanciado() {
        return monto - anticipo;
    }

    public double calcularCuotaMensual() {
        double montoFinanciado = getMontoFinanciado();
        double tasaMensual = tasaInteres / 100 / 12;
        int meses = plazo * 12;
        return montoFinanciado * (tasaMensual * Math.pow(1 + tasaMensual, meses))
                / (Math.pow(1 + tasaMensual, meses) - 1);
    }

    public double calcularTotalAPagar() {
        return calcularCuotaMensual() * plazo * 12;
    }

    public double calcularInteresesTotales() {
        return calcularTotalAPagar() - getMontoFinanciado();
    }
}
