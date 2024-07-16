import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        Gerenciamento g = new Gerenciamento();
        Usuario u = new Usuario();
        int opcao = 0;
        int opcaoAdd;
        int opcaoListar;

        do {
            System.out.println("Bem vindo a calculadora de formas geométricas!");
            do {
                System.out.println("Digite a senha (Senha padrão -> 123)");
            } while (!u.setSenha(sc.nextLine()));

            do {
                try {
                    System.out.println("1 - Adicionar\n2 - Listar\n3 - Mudar senha\n4 - Logout\n5 - Sair do sistema\nR: ");
                    opcao = sc.nextInt();
                    sc.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Você digitou uma letra, precisamos de um número");
                    sc.next();
                    continue;
                }

                switch (opcao) {
                    case 1:
                        try {
                            System.out.println("Deseja adicionar\n1 - Quadrado\n2 - Retangulo\n3 - Circunferência\n4 - Triangulo\nR: ");
                            opcaoAdd = sc.nextInt();
                            sc.nextLine();
                        } catch (InputMismatchException e) {
                            System.out.println("Você digitou uma letra, precisamos de um número");
                            sc.next();
                            continue;
                        }

                        switch (opcaoAdd) {
                            case 1:
                                adicionarQuadrado(g);
                                break;
                            case 2:
                                adicionarRetangulo(g);
                                break;
                            case 3:
                                adicionarCircunferencia(g);
                                break;
                            case 4:
                                adicionarTriangulo(g);
                                break;
                            default:
                                System.out.println("Opção inválida");
                        }
                        break;
                    case 2:
                        try {
                            System.out.println("Listar\n1 - Tudo\n2 - Quadrados\n3 - Retangulos\n4 - Circunferência\n5 - Triangulos\nR: ");
                            opcaoListar = sc.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Você digitou uma letra, precisamos de um número");
                            sc.next();
                            continue;
                        }
                        switch (opcaoListar) {

                            case 1:
                                g.listarFormas();
                                break;

                            case 2:
                                g.listarQuadrados();
                                break;

                            case 3:
                                g.listarRetangulo();
                                break;
                            case 4:
                                g.listarCircunferencia();
                                break;
                            case 5:
                                g.listarTriangulo();
                                break;
                        }
                        break;
                    case 3:
                        System.out.print("digite a senha nova: ");
                        String senhaNova = sc.nextLine();
                        u.mudarSenha(senhaNova);
                        break;
                    case 4:
                        break;
                    case 5:
                        System.out.print("Saindo.");
                        Thread.sleep(500);
                        System.out.print(".");
                        Thread.sleep(500);
                        System.out.println(".");
                        Thread.sleep(500);
                        System.out.println("Sistema Finalizado!");
                        System.exit(0);
                        break;
                }
            } while (opcao != 4);
        } while (true);
    }

    public static void adicionarQuadrado(Gerenciamento g) {
        System.out.print("Digite um lado do quadrado: ");
        double lado = sc.nextDouble();

        Forma quadrado = new Quadrado(lado);
        g.addForma(quadrado);
    }

    public static void adicionarRetangulo(Gerenciamento g) {
        System.out.print("Digite o lado 1 do retangulo: ");
        double lado1 = sc.nextDouble();

        System.out.print("Digite o lado 2 do retangulo: ");
        double lado2 = sc.nextDouble();

        Forma retangulo = new Retangulo(lado1, lado2);
        g.addForma(retangulo);
    }

    public static void adicionarCircunferencia(Gerenciamento g) {
        double raio = 0;
        System.out.print("Deseja adicionar com raio ou diametro?\n1 - Diametro\n2 - Raio\nR: ");
        int opcao = sc.nextInt();

        if (opcao == 1) {
            System.out.print("Digite o diametro: ");
            double diametro = sc.nextDouble();
            raio = diametro / 2;
        } else if (opcao == 2) {
            System.out.print("Digite o raio: ");
            raio = sc.nextDouble();
        } else {
            System.out.println("Opção inválida, raio zerado");
        }

        Forma circunferencia = new Circunferencia(raio);
        g.addForma(circunferencia);
    }

    public static void adicionarTriangulo(Gerenciamento g) {
        System.out.print("Digite o lado 1 do triangulo: ");
        double lado1 = sc.nextDouble();

        System.out.print("Digite o lado 2 do triangulo: ");
        double lado2 = sc.nextDouble();

        System.out.print("Digite o lado 3 do triangulo: ");
        double lado3 = sc.nextDouble();

        if (lado1 + lado2 > lado3 && lado1 + lado3 > lado2 && lado3 + lado2 > lado1) {
            System.out.println("Triangulo possivel!");
            Forma triangulo = new Triangulo(lado1, lado2, lado3);
            g.addForma(triangulo);
        } else {
            System.out.println("Triangulo impossivel de ser formado!");
        }
    }
}
