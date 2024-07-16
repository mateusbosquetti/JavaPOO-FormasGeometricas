import java.util.ArrayList;

public class Gerenciamento {
    String tipoInstancia;
    ArrayList<Forma> formas = new ArrayList<>();

    public void addForma(Forma f) {
        formas.add(f);
    }

    public void listarFormas() {
        for (Forma f : formas) {
            if (f instanceof Quadrado) {
                tipoInstancia = "Quadrado";
            } else if (f instanceof Retangulo) {
                tipoInstancia = "Retângulo";
            } else if (f instanceof Circunferencia) {
                tipoInstancia = "Circunferência";
            } else if (f instanceof Triangulo) {
                tipoInstancia = "Triângulo";
            }
            System.out.println("\n" + tipoInstancia + "\n" + f.toString());
        }
    }

    public void listarRetangulo() {
        for (Forma f : formas) {
            if (f instanceof Retangulo) {
                System.out.println(f.toString() + "\n");
            }
        }
    }

    public void listarCircunferencia() {
        for (Forma f : formas) {
            if (f instanceof Circunferencia) {
                System.out.println(f.toString() + "\n");
            }
        }
    }

    public void listarQuadrados() {
        for (Forma f : formas) {
            if (f instanceof Quadrado) {
                System.out.println(f.toString() + "\n");
            }
        }
    }

    public void listarTriangulo() {
        for (Forma f : formas) {
            if (f instanceof Triangulo) {
                System.out.println(f.toString() + "\n");
            }
        }
    }

}
