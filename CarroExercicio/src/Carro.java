import java.util.Scanner;

public class Carro {
    private boolean estadoCarro;
    private int velocidadeAtual;
    private int marchaAtual;

    public boolean ligarCarro(){
        if (estadoCarro){
            System.out.println("o carro ja esta ligado!");
        }else {
            estadoCarro = true;
            System.out.println("carro ligado!");
        }
            return estadoCarro;
    }

    public boolean desligarCarro(){
        if (!estadoCarro) {
            System.out.println("O carro ja esta desligado!");
        }else if (velocidadeAtual == 0 && marchaAtual ==  0){
            estadoCarro = false;
            System.out.println("Carro desligado");
        }else {
            System.out.println("não é possivel desligar o carro, ele deve estar parado e em ponto morto!");
        }
        return estadoCarro;
    }

    public int acelerar(){
        velocidadeAtual = velocidadeAtual + 1;
        return velocidadeAtual;
    }

    public int diminuirVelocidade() {
        if (velocidadeAtual > 0){
            velocidadeAtual--;
        }
        return velocidadeAtual;
    }

    public void virar(String direcao){
        if (!estadoCarro) {
            System.out.println("o carro não esta ligado!");
            return;
        }
        if(velocidadeAtual < 1 || velocidadeAtual > 40){
            System.out.println("Não é possivel virar nessa velocidade, apenas entre 1km e 40km");
            return;
        }

        if (direcao.equalsIgnoreCase("esquerda")){
            System.out.println("Virando para a esquerda");
        }else if (direcao.equalsIgnoreCase("direita")){
            System.out.println("Virando para a direita");
        }else {
            System.out.println("Direção invalida digite esquerda ou direita");
        }
    }

    public String verifVelocidade(){
        return "km/hora: " + velocidadeAtual;
    }

    public void trocarMarcha(int novaMarcha){
        if (!estadoCarro) {
            System.out.println("Carro está desligado!");
            return;
        }
        if (novaMarcha < 0 || novaMarcha > 6){
            System.out.println("Marcha invalida!");
        }

        switch (novaMarcha){
            case 0: // ponto morto
                if (velocidadeAtual == 0) {
                    marchaAtual = 0;
                    System.out.println("Carro em ponto morto.");
                } else {
                    System.out.println("Não pode colocar ponto morto com o carro em movimento!");
                }
                break;
            case 1:
                if (velocidadeAtual >= 0 && velocidadeAtual <= 20) {
                    marchaAtual = 1;
                    System.out.println("Marcha 1 engatada.");
                } else {
                    System.out.println("Velocidade incompatível com a 1ª marcha!");
                }
                break;
            case 2:
                if (velocidadeAtual >= 21 && velocidadeAtual <= 40) {
                    marchaAtual = 2;
                    System.out.println("Marcha 2 engatada.");
                } else {
                    System.out.println("Velocidade incompatível com a 2ª marcha!");
                }
                break;
            case 3:
                if (velocidadeAtual >= 41 && velocidadeAtual <= 60) {
                    marchaAtual = 3;
                    System.out.println("Marcha 3 engatada.");
                } else {
                    System.out.println("Velocidade incompatível com a 3ª marcha!");
                }
                break;
            case 4:
                if (velocidadeAtual >= 61 && velocidadeAtual <= 80) {
                    marchaAtual = 4;
                    System.out.println("Marcha 4 engatada.");
                } else {
                    System.out.println("Velocidade incompatível com a 4ª marcha!");
                }
                break;
            case 5:
                if (velocidadeAtual >= 81 && velocidadeAtual <= 100) {
                    marchaAtual = 5;
                    System.out.println("Marcha 5 engatada.");
                } else {
                    System.out.println("Velocidade incompatível com a 5ª marcha!");
                }
                break;
            case 6:
                if (velocidadeAtual >= 101 && velocidadeAtual <= 120) {
                    marchaAtual = 6;
                    System.out.println("Marcha 6 engatada.");
                } else {
                    System.out.println("Velocidade incompatível com a 6ª marcha!");
                }
                break;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Carro carro = new Carro();

        int opcao;
        do {
            System.out.println("\n=== MENU DO CARRO ===");
            System.out.println("1 - Ligar carro");
            System.out.println("2 - Desligar carro");
            System.out.println("3 - Acelerar");
            System.out.println("4 - Diminuir velocidade");
            System.out.println("5 - Virar");
            System.out.println("6 - Trocar marcha");
            System.out.println("7 - Ver velocidade");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    carro.ligarCarro();
                    break;
                case 2:
                    carro.desligarCarro();
                    break;
                case 3:
                    System.out.println("Velocidade atual: " + carro.acelerar() + " km/h");
                    break;
                case 4:
                    System.out.println("Velocidade atual: " + carro.diminuirVelocidade() + " km/h");
                    break;
                case 5:
                    System.out.print("Digite a direção (esquerda/direita): ");
                    String direcao = sc.nextLine();
                    carro.virar(direcao);
                    break;
                case 6:
                    System.out.print("Digite a marcha (0 a 6): ");
                    int m = sc.nextInt();
                    carro.trocarMarcha(m);
                    break;
                case 7:
                    System.out.println(carro.verifVelocidade());
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        sc.close();
    }
}