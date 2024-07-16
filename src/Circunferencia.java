public class Circunferencia extends Forma {
    private double pi = Math.PI;
    private double raio;

    public Circunferencia(double raio) {
        this.raio = raio;
    }

    @Override
    public double calcularArea() {
        return pi * Math.pow(raio, 2);
    }

    @Override
    public double calcularPerimetro() {
        return pi * (raio * 2);
    }

    @Override
    public String toString() {
        return super.toString() +
                "PI: " + pi + "\n" +
                "Raio: " + raio + "\n" +
                "Diâmetro: " + (raio * 2);
    }
}
