public abstract class Forma {
    public Forma() {
    }

    public abstract double calcularArea();

    public abstract double calcularPerimetro();

    @Override
    public String toString() {
        return "Área: " + calcularArea() + "\n" +
                "Perímetro: " + calcularPerimetro() + "\n";
    }
}
