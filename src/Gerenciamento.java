import java.util.ArrayList;

public class Gerenciamento {
    String tipoInstancia;
    ArrayList<Forma> formas = new ArrayList<>();

    public void addForma(Forma f) {
        formas.add(f);
    }

    public void listarFormas() {
        int contador = 0;
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
            System.out.println(contador + ". " + tipoInstancia + "\n" + f.toString() + "\n");
            contador++;
        }
    }

    public void atualizarForma(Forma f, int index) {
        formas.set(index, f);
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

    public Boolean vazio() { //True vazio
        if (formas.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean existe(int index) { //False não existe
        if (index >= formas.size()) {
            return false;
        }
        return true;
    }


}
