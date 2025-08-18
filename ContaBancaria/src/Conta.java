import java.util.Scanner;

public class Conta {
   private double saldo;
   private double limiteChequeEspecial;
   private boolean usandoChequeEspecial;


   //Define limite do cheque especial
    public Conta(double saldoInicial) {
        this.saldo = saldoInicial;
        if (saldoInicial <= 500){
            this.limiteChequeEspecial = 50;
        }else {
            this.limiteChequeEspecial = saldoInicial * 0.5;
        }
    }

    //consulta saldo
    public double consultarSaldo(){
       return saldo;
    }

    //consulta cheque especial
    public double consultarChequeEspecial(){
        return limiteChequeEspecial;
    }

    public void depositar(double valor){
        if (usandoChequeEspecial && limiteChequeEspecial < consultarChequeEspecial()) {
            double falta = consultarChequeEspecialInicial() - limiteChequeEspecial;

            if (valor <= falta) {
                limiteChequeEspecial += valor;
                valor = 0;
            } else {
                limiteChequeEspecial = consultarChequeEspecial();
                valor -= falta;
            }
            if (limiteChequeEspecial == consultarChequeEspecial()) {
                usandoChequeEspecial = false;
            }
        }
        saldo += valor;
        System.out.println("deposito realizado com sucesso!");
    }

    //sacar dinheiro
    public void sacar(double valor){
        if (valor <= saldo) {
            saldo -=valor;
            System.out.println("Saque realizado com sucesso!");
        }else {
            double totalDisponivel = saldo + limiteChequeEspecial;
            if(valor <= totalDisponivel){
                double usadoCheque = valor - saldo;
                saldo = 0;
                limiteChequeEspecial -= usadoCheque;
                usandoChequeEspecial = true;

                //taxa 20%
                double taxa = usadoCheque * 0.2;
                saldo -= taxa;

                System.out.println("Saque realizado usando cheque especial.");
                System.out.println("Taxa aplicada RS: " + taxa);

            }else {
                System.out.println("Saldo insuficiente!");
            }
        }
    }

    //pagar boleto
    public void pagarBoleto (double valor) {
        sacar(valor);
    }

    //verificar se esta usando cheque especial
    public void verificarUsoChequeEspecial(){
        if (usandoChequeEspecial){
            System.out.println("Esta conta está usando cheque especial!");
        }else {
            System.out.println("Esta conta NÃO esta usando cheque especial!");
        }
    }

    private double consultarChequeEspecialInicial(){
        if (saldo <= 500){
            return 50;
        }else {
            return saldo * 0.5;
        }
    }


    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public void setLimiteChequeEspecial(double limiteChequeEspecial) {
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    public boolean getVeifChequeEspecial() {
        return usandoChequeEspecial;
    }

    public void setVeifChequeEspecial(boolean veifChequeEspecial) {
        this.usandoChequeEspecial = veifChequeEspecial;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o saldo inicial da conta: ");
        double saldoInicial = sc.nextDouble();

        Conta conta = new Conta(saldoInicial);

        int opcao;

        do{
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Consultar cheque especial");
            System.out.println("3 - Depositar dinheiro");
            System.out.println("4 - Sacar dinheiro");
            System.out.println("5 - Pagar boleto");
            System.out.println("6 - Verificar uso do cheque especial");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao){
                case 1:
                    System.out.println("Saldo atual: R$" + conta.consultarSaldo());
                    break;
                case 2:
                    System.out.println("Limite de cheque especial disponível: R$" + conta.consultarChequeEspecial());
                    break;
                case 3:
                    System.out.print("Digite o valor para depósito: ");
                    double dep = sc.nextDouble();
                    conta.depositar(dep);
                    break;
                case 4:
                    System.out.print("Digite o valor para saque: ");
                    double saque = sc.nextDouble();
                    conta.sacar(saque);
                    break;
                case 5:
                    System.out.print("Digite o valor do boleto: ");
                    double boleto = sc.nextDouble();
                    conta.pagarBoleto(boleto);
                    break;
                case 6:
                    conta.verificarUsoChequeEspecial();
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }while (opcao != 0);

        sc.close();
    }
}