public class Retangulo extends Forma {
    private double lado1;
    private double lado2;

    public Retangulo(double lado1, double lado2) {
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    @Override
    public double calcularArea() {
        return lado1 * lado2;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * (lado1 + lado2);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Lado 1: " + lado1 + "\n" +
                "Lado 2: " + lado2;
    }
}
