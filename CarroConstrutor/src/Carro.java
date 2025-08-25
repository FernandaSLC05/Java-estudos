//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Carro {
    private String marcaCarro;
    private String modeloCarro;
    private int anoCarro;

    //Construtor padrão
    public Carro() {
        marcaCarro = "Desconhecida";
        modeloCarro = "Desconhecida";
        anoCarro = 0;
    }

    //Contrutor com dois parametros
    public Carro(String marca, String modelo){
        marcaCarro = marca;
        modeloCarro = modelo;
        anoCarro = 0;
    }

    //Construtor com 3 parametros
    public Carro(String marca, String modelo, int ano){
        marcaCarro = marca;
        modeloCarro = modelo;
        anoCarro = 0;
    }

    //Metodo de exibição
    public void exibirDetalhes(){
        System.out.println("Marca: " + marcaCarro);
        System.out.println("Modelo: " + modeloCarro);
        System.out.println("Ano: " + anoCarro);
    }

    public String getMarcaCarro() {
        return marcaCarro;
    }

    public void setMarcaCarro(String marcaCarro) {
        this.marcaCarro = marcaCarro;
    }

    public String getModeloCarro() {
        return modeloCarro;
    }

    public void setModeloCarro(String modeloCarro) {
        this.modeloCarro = modeloCarro;
    }

    public int getAnoCarro() {
        return anoCarro;
    }

    public void setAnoCarro(int anoCarro) {
        this.anoCarro = anoCarro;
    }

    public static void main(String[] args) {
        Carro carro1 = new Carro();

        carro1.exibirDetalhes();
    }
}