public class Quadrado extends Forma {
    private double lado;

    public Quadrado(double lado) {
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        return Math.pow(lado, 2);
    }

    @Override
    public double calcularPerimetro() {
        return lado * 4;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Lado: " + lado;
    }
}
