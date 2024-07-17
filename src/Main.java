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
                    System.out.println("1 - Adicionar\n2 - Listar\n3 - Atualizar\n4 - Mudar senha\n5 - Logout\n6 - Sair do sistema\nR: ");
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
                        if (g.vazio()) {
                            System.out.println("Nenhum item adicionado!");
                        } else {
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
                        }
                        break;
                    case 3:
                        if (g.vazio()) {
                            System.out.println("Nenhum item adicionado!");
                        } else {
                            atualizarObjeto(g);
                        }
                        break;
                    case 4:
                        System.out.print("digite a senha nova: ");
                        String senhaNova = sc.nextLine();
                        u.mudarSenha(senhaNova);
                        break;
                    case 5:
                        break;
                    case 6:
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
            } while (opcao != 5);
        } while (true);
    }

    public static void adicionarQuadrado(Gerenciamento g) {
        System.out.print("Digite um lado do quadrado: ");
        double lado = sc.nextDouble();

        Forma quadrado = new Quadrado(lado);
        g.addForma(quadrado);
    }

    public static void adicionarRetangulo(Gerenciamento g) {
        int suges;

        System.out.print("Digite o lado 1 do retangulo: ");
        double lado1 = sc.nextDouble();

        System.out.print("Digite o lado 2 do retangulo: ");
        double lado2 = sc.nextDouble();

        if (lado1 == lado2) {
            System.out.print("Lados iguais, deseja\n1 - Adicionar como quadrado\n2 - Adicionar como retangulo\n3 - cancelar\nR: ");
            suges = sc.nextInt();
            sc.nextLine();

            switch (suges) {
                case 1:
                    Forma quadroRet = new Quadrado(lado1);
                    g.addForma(quadroRet);

                    break;
                case 2:
                    Forma retangulo = new Retangulo(lado1, lado2);
                    g.addForma(retangulo);
                    break;
                case 3:
                    System.out.println("Operação cancelada!");
                    break;
                default:
                    System.out.println("Opção inválida, operação cancelada!");
            }
        } else {
            Forma retangulo = new Retangulo(lado1, lado2);
            g.addForma(retangulo);
        }
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

    public static void atualizarObjeto(Gerenciamento g) {
        System.out.println("Forma existentes -->");
        g.listarFormas();
        System.out.print("Digite o indice do objeto que você quer atualizar\nR: ");
        int index = sc.nextInt();
        sc.nextLine();

        if (g.existe(index) == false) {
            System.out.println("Indice inexistente!");
        } else {
            int opcaoAtu = 0;

            try {
                System.out.println("Deseja substituir por um\n1 - Quadrado\n2 - Retangulo\n3 - Circunferência\n4 - Triangulo\nR: ");
                opcaoAtu = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Você digitou uma letra, precisamos de um número");
                sc.next();
            }

            switch (opcaoAtu) {
                case 1:
                    System.out.print("Digite um lado do quadrado: ");
                    double lado = sc.nextDouble();

                    Forma quadrado = new Quadrado(lado);
                    g.atualizarForma(quadrado, index);
                    System.out.println("Atualização feita com sucesso!\nNova lista: ");
                    g.listarFormas();
                    break;
                case 2:
                    int suges;

                    System.out.print("Digite o lado 1 do retangulo: ");
                    double lado1 = sc.nextDouble();

                    System.out.print("Digite o lado 2 do retangulo: ");
                    double lado2 = sc.nextDouble();

                    if (lado1 == lado2) {
                        System.out.print("Lados iguais, deseja\n1 - Adicionar como quadrado\n2 - Adicionar como retangulo\n3 - cancelar\nR: ");
                        suges = sc.nextInt();
                        sc.nextLine();

                        switch (suges) {
                            case 1:
                                Forma quadroRet = new Quadrado(lado1);
                                g.atualizarForma(quadroRet, index);
                                System.out.println("Atualização feita com sucesso!\nNova lista: ");
                                g.listarFormas();
                                break;
                            case 2:
                                Forma retangulo = new Retangulo(lado1, lado2);
                                g.atualizarForma(retangulo, index);
                                System.out.println("Atualização feita com sucesso!\nNova lista: ");
                                g.listarFormas();
                                break;
                            case 3:
                                System.out.println("Operação cancelada!");
                                break;
                            default:
                                System.out.println("Opção inválida, operação cancelada!");
                        }
                    } else {
                        Forma retangulo = new Retangulo(lado1, lado2);
                        g.atualizarForma(retangulo, index);
                        System.out.println("Atualização feita com sucesso!\nNova lista: ");
                        g.listarFormas();
                    }
                    break;
                case 3:
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
                    g.atualizarForma(circunferencia, index);
                    System.out.println("Atualização feita com sucesso!\nNova lista: ");
                    g.listarFormas();
                    break;
                case 4:
                    System.out.print("Digite o lado 1 do triangulo: ");
                    double ladoT1 = sc.nextDouble();

                    System.out.print("Digite o lado 2 do triangulo: ");
                    double ladoT2 = sc.nextDouble();

                    System.out.print("Digite o lado 3 do triangulo: ");
                    double lado3 = sc.nextDouble();

                    if (ladoT1 + ladoT2 > lado3 && ladoT1 + lado3 > ladoT2 && lado3 + ladoT2 > ladoT1) {
                        System.out.println("Triangulo possivel!");
                        Forma triangulo = new Triangulo(ladoT1, ladoT2, lado3);
                        g.atualizarForma(triangulo, index);
                        System.out.println("Atualização feita com sucesso!\nNova lista: ");
                        g.listarFormas();
                    } else {
                        System.out.println("Triangulo impossivel de ser formado!");
                    }
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }
}
