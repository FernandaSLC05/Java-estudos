
public class SalaAula {
    static int totalAluno = 0;

    //metodo statico para adicionar alunos
    public static void adcAluno(){
        totalAluno ++;
    }

    //metodo statico que exibe total de alunos
    public static void exibiTotalAluno(){
        System.out.println("Total de alunos na sala: " + totalAluno);
    }

    public static void main(String[] args) {
        //criando intancias da classe
        SalaAula sala1 = new SalaAula();
        SalaAula sala2 = new SalaAula();
        SalaAula sala3 = new SalaAula();

        //Adiciona aulunos
        SalaAula.adcAluno();
        SalaAula.adcAluno();
        SalaAula.adcAluno();

        //Exibi total de alunos
        SalaAula.exibiTotalAluno();

    }
}