
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
        if (usandoChequeEspecial && limiteChequeEspecial < consultarChequeEspecial()){
            double falta = consultarChequeEspecialInicial() - limiteChequeEspecial;
        }
        if (valor <= falta){
            limiteChequeEspecial += valor;
            valor = 0;
        }else {
            limiteChequeEspecial = consultarChequeEspecial();
            valor -= falta;
        }
        if (limiteChequeEspecial == consultarChequeEspecial()) {
            usandoChequeEspecial = false;
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

    }
}