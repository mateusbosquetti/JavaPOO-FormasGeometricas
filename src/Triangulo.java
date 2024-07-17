public class Triangulo extends Forma {

    private double lado1;
    private double lado2;
    private double lado3;

    private String tipo;

    private double ladoDiferente;
    private double ladoIgual;
    private double altura;

    private double semiPerimetro;

    public Triangulo(double lado1, double lado2, double lado3) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    public String setTipo() {
        if (lado1 == lado2 && lado2 == lado3) {
            return tipo = "Equilatero";
        } else if (lado1 == lado2 && lado3 != lado2 || lado1 == lado3 && lado2 != lado1 || lado3 == lado2 && lado1 != lado2) {
            return tipo = "Isóceles";
        } else {
            return tipo = "Escaleno";
        }
    }

    @Override
    public double calcularArea() {
        if (setTipo().equals("Equilatero")) {
            return ((Math.sqrt(3) / 4) * Math.pow(lado1, 2));

        } else if (setTipo().equals("Isóceles")) {
            if (lado1 == lado2 && lado3 != lado1) {
                ladoDiferente = lado3;
                ladoIgual = lado1;
            } else if (lado1 == lado3 && lado2 != lado1) {
                ladoDiferente = lado2;
                ladoIgual = lado1;
            } else {
                ladoDiferente = lado1;
                ladoIgual = lado2;
            }

            altura = Math.sqrt(Math.pow(ladoIgual, 2) - Math.pow(ladoDiferente, 2) / 4);

            return (ladoDiferente * altura) / 2;

        } else {
            semiPerimetro = calcularPerimetro() / 2;
            return Math.sqrt(semiPerimetro * (semiPerimetro - lado1) * (semiPerimetro - lado2) * (semiPerimetro - lado3));
        }
    }
    @Override
    public double calcularPerimetro() {
        if (setTipo().equals("Equilatero")) {
            return 3 * lado1;

        } else if (setTipo().equals("Isóceles")) {
            if (lado1 == lado2 && lado3 != lado1) {
                ladoDiferente = lado3;
                ladoIgual = lado1;
            } else if (lado1 == lado3 && lado2 != lado1) {
                ladoDiferente = lado2;
                ladoIgual = lado1;
            } else {
                ladoDiferente = lado1;
                ladoIgual = lado2;
            }

            return ladoDiferente + 2 * ladoIgual;

        } else {
            return lado1 + lado2 + lado3;
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "Lado 1 " + lado1 + "\n" +
                "Lado 2 " + lado2 + "\n" +
                "Lado 3 " + lado3 + "\n" +
                "Tipo " + setTipo();
    }

}
